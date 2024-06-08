package fluenteditor

import ai.TranslationService
import com.jillesvangurp.fluentai.groupIdsByLargestPrefix
import components.primaryButton
import components.secondaryButton
import components.twFullWidthTextArea
import components.twInputField
import components.twThreeLineTextareaTextfield
import dev.fritz2.core.RenderContext
import dev.fritz2.core.disabled
import dev.fritz2.core.placeholder
import dev.fritz2.core.storeOf
import files.FluentFilesStore
import icons.SvgIconSource
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import localization.TL
import localization.getTranslationString
import localization.translate
import settings.SettingsStore
import withKoin

fun RenderContext.fluentBrowser() {
        div("flex flex-col grow m-2") {

            withKoin {
                val fluentFilesStore = get<FluentFilesStore>()

                val selectedIdStore = storeOf("")
                val translationService = get<TranslationService>()
                val settingsStore = get<SettingsStore>()

                div("grow m-2 flex flex-row") {
                    fluentFilesStore.data.filterNotNull().render { files ->

                        val keys = files.flatMap { it.keys() }.distinct().sorted()

                        div("w-96 flex flex-col gap-2 p-5 bg-white shadow-lg m-2") {
                            secondaryButton(text = TL.Common.Add, iconSource = SvgIconSource.Plus) {
                                clicks handledBy {
                                    selectedIdStore.update("")
                                }
                            }
                            val searchStore = storeOf("")

                            twInputField(
                                searchStore,
                                null,
                                getTranslationString(TL.Common.FilterPlaceholder),
                            )

                            div("grow overflow-y-auto") {

                                div("max-h-0") {
                                    searchStore.data.render { query ->
                                        keys.filter { translationId ->
                                            if (query.isBlank()) true
                                            else {
                                                translationId.lowercase()
                                                    .contains(query.lowercase())
                                            }
                                        }.also {
                                            p {
                                                +"Total ${it.size}"
                                            }
                                        }.groupIdsByLargestPrefix().forEach { (prefix, ids) ->
                                            val showIdsStore = storeOf(true)
                                            showIdsStore.data.render { show ->
                                                div {
                                                    a {
                                                        +"${prefix.takeIf { it.isNotBlank() } ?: "-terms"} (${ids.size})"

                                                        clicks handledBy {
                                                            showIdsStore.update(!showIdsStore.current)
                                                        }
                                                    }
                                                }
                                                if (show) {
                                                    ids.forEach { translationId ->
                                                        div("ml-5") {
                                                            a {
                                                                +translationId.replace(
                                                                    "$prefix-".takeIf { it != "-" }
                                                                        ?: "",
                                                                    "",
                                                                )
                                                                selectedIdStore.data.render {
                                                                    if (selectedIdStore.current == translationId) {
                                                                        +" *"
                                                                    }
                                                                }
                                                                clicks handledBy {
                                                                    if (selectedIdStore.current == translationId) {
                                                                        selectedIdStore.update("")
                                                                    } else {
                                                                        selectedIdStore.update(
                                                                            translationId
                                                                        )
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
                        div("grow p-5 bg-white shadow-lg m-2") {
                            selectedIdStore.data.render { translationId ->
                                if (translationId.isBlank()) {
                                    p("text-center") {
                                        translate(TL.FluentEditor.NoTranslationIdSelected)
                                    }


                                    createNewTranslationId()

                                } else {
                                    h3 {
                                        +translationId
                                    }
                                    files.sortedBy { it.name }.map { file ->
                                        val translation = file[translationId]
                                        file to translation
                                    }.forEach { (file, chunk) ->
                                        div("w-full") {
                                            p {
                                                +file.name
                                            }
                                            val translationEditor = storeOf(chunk?.definition.orEmpty())

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
                                                        disabled(t == file[translationId]?.definition.orEmpty())

                                                        clicks.map {
                                                            file[translationId]?.definition.orEmpty()
                                                        } handledBy translationEditor.update
                                                    }
                                                    val originalText = files.first {
                                                        it.matches(
                                                            settingsStore.current?.translationSourceLanguage
                                                                ?: "en-US",
                                                        )
                                                    }[translationId]?.definition.orEmpty()
                                                    secondaryButton(
                                                        text = TL.FluentEditor.AiTranslate,
                                                        iconSource = SvgIconSource.Check,
                                                    ) {
                                                        disabled(originalText.isBlank())

                                                        clicks handledBy {
                                                            val translated =
                                                                translationService.translate(
                                                                    translationId,
                                                                    originalText, file.name,
                                                                )
                                                            translationEditor.update(
                                                                translated ?: ":-("
                                                            )
                                                            if (translated != null) {
                                                                val newFile = file.put(translationId, translated,)
                                                                fluentFilesStore.addOrReplace(newFile)
                                                                translationEditor.update(newFile[translationId]?.definition.orEmpty())
                                                            }
                                                        }
                                                    }
                                                    primaryButton(
                                                        text = TL.Common.Save,
                                                        iconSource = SvgIconSource.Check,
                                                    ) {
                                                        val original = file[translationId]
                                                        disabled(t == original?.definition.orEmpty())

                                                        clicks handledBy {
                                                            val newFile = file.put(translationId, t, chunk?.comment)
                                                            fluentFilesStore.addOrReplace(newFile)
                                                            translationEditor.update(newFile[translationId]?.definition.orEmpty())
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
        }
}

private fun RenderContext.createNewTranslationId() {
    withKoin {
        val fluentFilesStore = get<FluentFilesStore>()
        val settingsStore = get<SettingsStore>()
        val selectedIdStore = storeOf("")

        div("flex flex-col gap-2 w-96") {
            val newIdStore = storeOf("")
            val newTranslationStore = storeOf("")
            h2 {
                translate(TL.FluentEditor.NewTranslationIdHeader)
            }
            twInputField(
                newIdStore,
                TL.FluentEditor.NewTranslationId,
                "component-inputfield-placeholder",
            )
            twFullWidthTextArea(newTranslationStore) {
                label {
                    translate(TL.FluentEditor.NewTranslation)
                }
                twThreeLineTextareaTextfield {
                    placeholder("")
                }
            }

            fluentFilesStore.data.render { files ->
                settingsStore.data.render { settings ->
                    primaryButton(
                        text = TL.Common.Add,
                        iconSource = SvgIconSource.Plus,
                    ) {

                        newIdStore.data.render { newId ->
                            newTranslationStore.data.render {newTranslation ->
                                disabled(
                                    files.isNullOrEmpty() || newTranslation.isBlank() ||
                                        newId.isBlank() || files.orEmpty().flatMap { it.keys() }
                                        .contains(newId),
                                )
                            }
                        }

                        clicks handledBy {
                            val newId = newIdStore.current
                            val preferred = settings?.translationSourceLanguage ?: "en"
                            console.log(preferred)
                            val fluentFile =
                                files?.firstOrNull { it.matches(preferred) } ?: files?.first()
                            console
                            val newFile = fluentFile?.put(newId, newTranslationStore.current)
                                ?: error("file not found")
                            fluentFilesStore.addOrReplace(newFile)
                            selectedIdStore.update(newId)
                        }
                    }
                }
            }
        }
    }
}
