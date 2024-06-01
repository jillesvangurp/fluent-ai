package fluenteditor

import ai.TranslationService
import components.primaryButton
import components.secondaryButton
import components.twFullWidthTextArea
import components.twThreeLineTextareaTextfield
import dev.fritz2.core.RenderContext
import dev.fritz2.core.disabled
import dev.fritz2.core.placeholder
import dev.fritz2.core.storeOf
import dev.fritz2.headless.components.inputField
import files.FluentFilesStore
import icons.SvgIconSource
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import localization.TL
import localization.getTranslationString
import org.w3c.dom.HTMLInputElement
import settings.SettingsStore
import withKoin

fun RenderContext.fluentBrowser() {
    withKoin {
        val fluentFilesStore = get<FluentFilesStore>()

        val selectedIdStore = storeOf("")
        val translationService = get<TranslationService>()
        val settingsStore = get<SettingsStore>()

        div("grow m-5 bg-white flex flex-row") {
            fluentFilesStore.data.filterNotNull().render { files ->

                val keys = files.flatMap { it.keys() }.distinct().sorted()

                div("max-w-96 flex flex-col gap-2 p-5") {
                    val searchStore = storeOf("")
                    inputField() {
                        value(searchStore)

                        inputs handledBy {
                            val element = it.target as HTMLInputElement
                            searchStore.update(element.value)
                        }

                        inputTextfield {
                            placeholder(getTranslationString(TL.Common.FilterPlaceholder))
                        }
                    }

                    div("grow overflow-y-auto") {

                        div("max-h-0") {
                            searchStore.data.render { query ->
                                keys.filter { translationId ->
                                    if (query.isBlank()) true
                                    else {
                                        translationId.lowercase().contains(query.lowercase())
                                    }
                                }.forEach { translationId ->
                                    div {
                                        a {
                                            +translationId
                                            clicks.map { translationId } handledBy selectedIdStore.update
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                div("grow p-5") {
                    selectedIdStore.data.filter { it.isNotBlank() }.render { translationId ->
                        p {
                            +translationId
                        }
                        files.sortedBy { it.name }.map { file ->
                            val translation = file[translationId] ?: ""
                            file to translation
                        }.forEach { (file, translation) ->
                            div("w-full") {
                                p {
                                    +file.name
                                }
                                val translationEditor = storeOf(translation)

                                twFullWidthTextArea(translationEditor) {
                                    twThreeLineTextareaTextfield {

                                    }
                                }

                                div("flex flex-row gap-3") {
                                    translationEditor.data.render { t ->
                                        secondaryButton(
                                            text = TL.Common.Cancel,
                                            iconSource = SvgIconSource.Cross,
                                        ) {
                                            disabled(t == file[translationId].orEmpty())

                                            clicks.map {
                                                file[translationId].orEmpty()
                                            } handledBy translationEditor.update
                                        }
                                        val originalText = files.first {
                                            it.matches(settingsStore.current?.translationSourceLanguage ?: "en-US")
                                        }[translationId].orEmpty()
                                        secondaryButton(
                                            text = TL.FluentEditor.AiTranslate,
                                            iconSource = SvgIconSource.Check,
                                        ) {
                                            disabled(originalText.isBlank())

                                            clicks handledBy {
                                                val translated = translationService.translate(
                                                    translationId,
                                                    originalText, file.name
                                                )
                                                translationEditor.update(translated ?: ":-(")
                                                if(translated!=null) {
                                                    file.put(translationId, translated)
                                                    fluentFilesStore.addOrReplace(file)
                                                    translationEditor.update(file[translationId].orEmpty())
                                                }
                                            }
                                        }
                                        primaryButton(
                                            text = TL.Common.Save,
                                            iconSource = SvgIconSource.Check,
                                        ) {
                                            val original = file[translationId]
                                            disabled(t == original.orEmpty())

                                            clicks handledBy {
                                                file.put(translationId, t)
                                                fluentFilesStore.addOrReplace(file)
                                                translationEditor.update(file[translationId].orEmpty())
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
