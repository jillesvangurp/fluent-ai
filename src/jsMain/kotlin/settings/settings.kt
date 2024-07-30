package settings

import com.tryformation.localization.Translatable
import components.LocalStoringStore
import components.fadeInFadeoutTransition
import components.flexRow
import components.primaryButton
import components.secondaryButton
import components.selectComponent
import components.twInputField
import dev.fritz2.core.RenderContext
import dev.fritz2.core.disabled
import dev.fritz2.core.selected
import dev.fritz2.core.storeOf
import dev.fritz2.core.value
import icons.SvgIconSource
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable
import localization.Locales
import localization.TL
import localization.translate
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.w3c.dom.HTMLSelectElement
import withKoin

val settingsModule = module {
    singleOf(::SettingsStore)
}

@Serializable
data class Settings(
    val uiLanguage: Locales? = null,
    val translationSourceLanguage: String? = null,
    val openAIKey: String? = null,
    val model: String = "gpt-4o"
)

val Settings?.preferredTranslationLanguage get() = this?.translationSourceLanguage ?: "en-US"

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
        fadeInFadeoutTransition()

        openAiKeyEditor()
        modelPicker()

        translationLanguageEditor()
    }
}

private fun RenderContext.openAiKeyEditor(
) {
    withKoin {
        val settingsStore = get<SettingsStore>()

        val editingStore = storeOf(false)
        div {
            settingsStore.data.render { settings ->
                val openAiKeyStore = storeOf(settings?.openAIKey.orEmpty())

                editingStore.data.render { editing ->
                    if (editing) {
                        twInputField(openAiKeyStore, TL.Settings.OpenAiKey, "XXXXXXXXXXXXXXXX")
                        openAiKeyStore.data.render { newKey ->
                            flexRow {
                                secondaryButton {
                                    translate(TL.Common.Cancel)
                                    clicks.map { false } handledBy editingStore.update
                                }
                                primaryButton(
                                    text = TL.Common.Confirm,
                                    iconSource = SvgIconSource.Check,
                                ) {
                                    disabled(newKey == settings?.openAIKey.orEmpty())

                                    clicks handledBy {
                                        settingsStore.persistAndUpdate(
                                            (settings ?: Settings()).copy(openAIKey = newKey),
                                        )
                                        editingStore.update(false)
                                    }
                                }
                            }
                        }
                    } else {
                        a {
                            translate(TL.Settings.EditOpenAiKey)
                        }
                        clicks.map { true } handledBy editingStore.update
                    }
                }
            }
        }
    }
}

enum class SupportedModels(val id: String, val title: String, val preferred: Boolean=false): Translatable {
    GPT_4_O("gpt-4o", "GPT 4o"),
    GPT_4_O_MINI("gpt-4o-mini", "GPT 4o Mini", preferred = true),
    GPT_35_TURBO("gpt-3.5-turbo", "GPT 3.5 Turbo"),
    ;

    override val prefix = "supported-models"
}

private fun RenderContext.modelPicker() {
    withKoin {
        val settingsStore = get<SettingsStore>()

        div {
            p {
                +"Select a model"
            }
            selectComponent {
                changes handledBy { selected ->
                    val element = selected.target as HTMLSelectElement
                    val selectedModel = element.value
                    val fixed = (settingsStore.current ?: Settings()).copy(model = selectedModel)
                    console.log("updating model $fixed")
                    settingsStore.persistAndUpdate(fixed)
                }
                SupportedModels.entries.sorted().forEach { model ->
                    option {
                        +model.title
                        +" - "
                        translate(model)
                        value(model.id)
                        val current = settingsStore.current?.model
                        if (current.equals(model.id, true) || (current==null && model.preferred)) {
                            selected(true)
                        }
                    }
                }
            }
        }
    }
}

private fun RenderContext.translationLanguageEditor() {
    withKoin {
        val settingsStore = get<SettingsStore>()

        div {
            settingsStore.data.render { settings ->
                val translationLanugageStore =
                    storeOf(settings?.translationSourceLanguage.orEmpty())

                twInputField(translationLanugageStore, TL.Settings.TranslationLanguage, "en-US")

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
