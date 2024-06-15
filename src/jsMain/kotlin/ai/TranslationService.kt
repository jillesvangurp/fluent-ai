package ai

import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.http.Timeout
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import com.jillesvangurp.fluentai.FluentChunk
import com.jillesvangurp.fluentai.FluentFile
import com.jillesvangurp.fluentai.parseFluent
import com.jillesvangurp.fluentai.sortedContent
import components.Progress
import components.ProgressStore
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import localization.TL
import localization.getTranslationString
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import settings.SettingsStore

val translationServiceModule = module {
    singleOf(::TranslationService)
}

private val translationScope = CoroutineScope(CoroutineName("translation-service"))

class TranslationService(settingsStore: SettingsStore) {
    private var _openAI: OpenAI? = null
    private var model = "gpt-4o"

    init {
        translationScope.launch {
            settingsStore.data.onEach {
                _openAI = it?.openAIKey?.let { key ->
                    OpenAI(
                        token = key,
                        timeout = Timeout(socket = 60.seconds),
                    )
                }
                model = it?.model ?: "gpt-4o"
                console.log("reconfigure translation service; using $model")
            }.collect()
        }
    }
    val openAI: OpenAI get() = _openAI?: error("configure OpenAI API key")

    fun enabled() = _openAI != null

    suspend fun translate(existingText: String, target: String): String? {
        console.log("using $model")
        val ccr = ChatCompletionRequest(
            model = ModelId(model),
            messages = listOf(
                ChatMessage(
                    role = ChatRole.System,
                    content = """
                            You are a professional UI translator. Provide accurate and complete translations for the texts that you are provided with.
                            
                            The texts are project fluent format and you are to preserve the variable names and other fluent syntax. 
                            
                            But don't include the id = part; we only want the part after the =
                            
                            The target language can be inferred from the locale name in the .ftl file name.
                            
                            Respond in plain text, preserve any markdown formatting but do not surround with ```
                            """.trimIndent(),
                ),
                ChatMessage(
                    role = ChatRole.User,
                    content = """
Translate this to $target:

$existingText
""".trimIndent(),
                ),
            ),
        )

        val result = openAI.chatCompletion(ccr)
        return result.choices.last().message.content

    }

    suspend fun batchTranslate(
        sourceFile: FluentFile,
        targetFile: FluentFile,
        skipExistingTranslations: Boolean = true,
        chunkSize: Int = 15,
        progressStore: ProgressStore?,
    ): FluentFile {
        val existingTranslations = targetFile.asMap()
        val toTranslate = sourceFile.chunks.mapNotNull { t ->
            if (skipExistingTranslations) {
                val existing = existingTranslations[t.id]
                if (existing?.definition.isNullOrBlank() || existing?.definition?.lowercase()
                        ?.trim() == t.definition) {
                    t
                } else {
                    null
                }

            } else {
                t
            }
        }
        val start = Clock.System.now()
        var stepCount=1
        var apiCalls=0
        val translation = toTranslate.chunked(chunkSize).flatMap { chunk ->
            val progressText = getTranslationString(TL.TranslationLogic.Progress, mapOf(
                "current" to chunk.size,
                "total" to toTranslate.size,
                "model" to model,
                "completed" to stepCount,
                "apicalls" to apiCalls++,
                "duration" to (Clock.System.now() - start).toIsoString()
            ))
            progressStore?.update?.invoke(Progress(progressText, stepCount, toTranslate.size))
            translateChunks(chunk, targetFile.name).also {
                // don't overload OpenAI with a lot of requests
                delay(500.milliseconds)
            }.also { translated ->
                stepCount+=chunk.size
            }
        }
        val progressText = getTranslationString(TL.TranslationLogic.Completed, mapOf(
            "total" to toTranslate.size,
            "model" to model,
            "completed" to stepCount,
            "apicalls" to apiCalls,
            "duration" to (Clock.System.now() - start).toIsoString()
        ))

        progressStore?.update?.invoke(Progress(progressText, stepCount, toTranslate.size))

        val translationMap = translation.associateBy { it.id }.toMutableMap()
        val chunks = targetFile.chunks
        chunks.forEach {
            // add existing translations back
            if(!translationMap.containsKey(it.id)) {
                translationMap[it.id] = it
            }
        }
        delay(1.seconds)
        return FluentFile(targetFile.name, translationMap.sortedContent())
    }

    private suspend fun translateChunks(source: List<FluentChunk>, targetLanguage: String): List<FluentChunk> {
        val content = FluentFile("", source.associateBy { it.id }.sortedContent()).content

        val ccr = ChatCompletionRequest(
            model = ModelId(model),
            messages = listOf(
                ChatMessage(
                    role = ChatRole.System,
                    content = """
                            You are a professional UI translator. Provide accurate translations for the texts that you are provided with.
                            
                            The texts are project fluent format and you are to preserve the variable names and other fluent syntax. 
                                                        
                            Infer the target language from the provided locale or .ftl file name.
                            
                            Respond in plain text, preserve any markdown formatting but do not surround with ```

                            The output should be a valid project fluent file
                            """.trimIndent(),
                ),
                ChatMessage(
                    role = ChatRole.User,
                    content = """
Translate these fluent translations to $targetLanguage:

$content
""".trimIndent(),
                ),
            ),
        )

        val result = openAI.chatCompletion(ccr)
        val translated = result.choices.last().message.content ?: error("empty response")
        return translated.parseFluent()
    }
}
