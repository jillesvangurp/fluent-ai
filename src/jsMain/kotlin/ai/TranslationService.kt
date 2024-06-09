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
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import settings.SettingsStore

val translationServiceModule = module {
    singleOf(::TranslationService)
}

class TranslationService(settingsStore: SettingsStore) {
    private var _openAI: OpenAI? = null
    init {
        GlobalScope.launch {
            settingsStore.data.onEach {
                _openAI = it?.openAIKey?.let { key ->
                    OpenAI(
                        token = key,
                        timeout = Timeout(socket = 60.seconds),
                    )
                }
            }.collect()
        }
    }
    val openAI: OpenAI get() = _openAI?: error("configure OpenAI API key")

    fun enabled() = _openAI != null

    suspend fun translate(existingText: String, target: String): String? {

        val ccr = ChatCompletionRequest(
            model = ModelId("gpt-4o"),
            messages = listOf(
                ChatMessage(
                    role = ChatRole.System,
                    content = """
                            You are a professional UI translator. Provide accurate translations for the texts that you are provided with.
                            
                            The texts are project fluent format and you are to preserve the variable names and other fluent syntax. 
                            
                            But don't include the id = part; we only want the part after the =
                            
                            The target language can be inferred from the locale name in the .ftl file name.
                            
                            Respond in plain text without the markdown ```
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
        chunkSize: Int = 20,
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
        val translation = toTranslate.chunked(chunkSize).flatMap {
            translateChunks(it, targetFile.name).also {
                // don't overload OpenAI with a lot of requests
                delay(500.milliseconds)
            }
        }

        val translationMap = translation.associateBy { it.id }.toMutableMap()
        targetFile.chunks.forEach {
            // add existing translations back
            if(!translationMap.containsKey(it.id)) {
                translationMap[it.id] = it
            }
        }
        return FluentFile(targetFile.name, translationMap.sortedContent())
    }

    private suspend fun translateChunks(source: List<FluentChunk>, targetLanguage: String): List<FluentChunk> {
        val content = FluentFile("", source.associateBy { it.id }.sortedContent()).content

        val ccr = ChatCompletionRequest(
            model = ModelId("gpt-4o"),
            messages = listOf(
                ChatMessage(
                    role = ChatRole.System,
                    content = """
                            You are a professional UI translator. Provide accurate translations for the texts that you are provided with.
                            
                            The texts are project fluent format and you are to preserve the variable names and other fluent syntax. 
                                                        
                            Infer the target language from the provided locale or .ftl file name.
                            
                            Respond in plain text without the markdown ```, the output should be a valid fluent file
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
