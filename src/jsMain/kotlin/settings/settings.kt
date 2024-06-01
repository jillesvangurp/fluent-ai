package settings

import components.LocalStoringStore
import components.primaryButton
import components.twInputField
import dev.fritz2.core.RenderContext
import dev.fritz2.core.disabled
import dev.fritz2.core.placeholder
import dev.fritz2.core.storeOf
import dev.fritz2.headless.components.inputField
import icons.SvgIconSource
import kotlinx.serialization.Serializable
import localization.Locales
import localization.TL
import localization.languageSelector
import localization.translate
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.w3c.dom.HTMLInputElement
import withKoin

val settingsModule = module {
    singleOf(::SettingsStore)
}

@Serializable
data class Settings(
    val uiLanguage: Locales? = null,
    val translationSourceLanguage: String? = null,
    val openAIKey: String? = null,
)

class SettingsStore : LocalStoringStore<Settings>(Settings(), "settings", Settings.serializer()) {
    fun setLocale(locale: Locales) {
        persistAndUpdate(
            (current ?: Settings()).copy(
                uiLanguage = locale,
            ),
        )
    }
}

fun RenderContext.settingsScreen() {

    div("grow m-5 bg-white flex flex-col gap-2 p-5") {

        languageSelector()

        openAiKeyEditor()

        translationLanguageEditor()
    }
}

private fun RenderContext.openAiKeyEditor(
) {
    withKoin {
        val settingsStore = get<SettingsStore>()

        div {
            settingsStore.data.render { settings ->
                val openAiKeyStore = storeOf(settings?.openAIKey.orEmpty())

                twInputField(openAiKeyStore,TL.Settings.OpenAiKey, "XXXXXXXXXXXXXXXX")
                openAiKeyStore.data.render { newKey ->

                    primaryButton(
                        text = TL.Common.Confirm,
                        iconSource = SvgIconSource.Check,
                    ) {
                        disabled(newKey == settings?.openAIKey.orEmpty())

                        clicks handledBy {
                            settingsStore.persistAndUpdate(
                                (settings ?: Settings()).copy(openAIKey = newKey),
                            )
                        }
                    }
                }
            }
        }
    }
}
private fun RenderContext.translationLanguageEditor(
) {
    withKoin {
        val settingsStore = get<SettingsStore>()

        div {
            settingsStore.data.render { settings ->
                val translationLanugageStore = storeOf(settings?.translationSourceLanguage.orEmpty())

                twInputField(translationLanugageStore,TL.Settings.TranslationLanguage, "en-US")

                translationLanugageStore.data.render { newValue ->

                    primaryButton(
                        text = TL.Common.Confirm,
                        iconSource = SvgIconSource.Check,
                    ) {
                        disabled(newValue == settings?.translationSourceLanguage.orEmpty())

                        clicks handledBy {
                            settingsStore.persistAndUpdate(
                                (settings ?: Settings()).copy(translationSourceLanguage = newValue),
                            )
                        }
                    }
                }
            }
        }
    }
}
