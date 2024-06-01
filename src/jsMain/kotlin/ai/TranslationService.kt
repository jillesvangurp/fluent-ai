package ai

import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.http.Timeout
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import kotlin.time.Duration.Companion.seconds
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import settings.SettingsStore

val translationServiceModule = module {
    singleOf(::TranslationService)
}

class TranslationService(val settingsStore: SettingsStore) {

    suspend fun translate(id: String, existingText: String, target: String): String? {
        val key = settingsStore.current?.openAIKey?: error("no key")
        return settingsStore.current?.openAIKey?.let {
            val openai = OpenAI(
                token = key,
                timeout = Timeout(socket = 60.seconds),
                // additional configurations...
            )

            val ccr = ChatCompletionRequest(
                model = ModelId("gpt-3.5-turbo"),
                messages = listOf(
                    ChatMessage(
                        role = ChatRole.System,
                        content = """
                            You are a professional UI translator. Provide accurate translations for the texts that you are provided with.
                            
                            The texts are project fluent format and you are to preserve the variable names and other fluent syntax.
                            
                            The target language can be inferred from the locale name in the .ftl file name.
                            
                            Respond in plain text without the markdown ```
                            """.trimIndent()
                    ),
                    ChatMessage(
                        role = ChatRole.User,
                        content = """
Translate this to $target:

$existingText
""".trimIndent()
                    )
                )
            )

            val result = openai.chatCompletion(ccr)
            console.log(result)
            result.choices.forEach {
                console.log("message", it.message)
            }
            result.choices.last().message.content
        }
    }
}
