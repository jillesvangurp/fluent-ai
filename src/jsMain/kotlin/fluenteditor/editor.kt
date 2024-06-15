package fluenteditor

import ai.TranslationService
import com.jillesvangurp.fluentai.FluentFile
import com.jillesvangurp.fluentai.groupIdsByLargestPrefix
import com.jillesvangurp.fluentai.missingTranslations
import components.confirm
import components.fadeInFadeoutTransition
import components.primaryButton
import components.runWithBusy
import components.secondaryButton
import components.twFullWidthTextArea
import components.twInputField
import components.twThreeLineTextareaTextfield
import dev.fritz2.core.RenderContext
import dev.fritz2.core.Store
import dev.fritz2.core.disabled
import dev.fritz2.core.placeholder
import dev.fritz2.core.storeOf
import dev.fritz2.core.title
import files.FluentFilesStore
import icons.SvgIconSource
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import localization.TL
import localization.getTranslationString
import localization.translate
import settings.SettingsStore
import settings.preferredTranslationLanguage
import withKoin

fun RenderContext.fluentBrowser() {
    div("flex flex-col grow m-2") {
        fadeInFadeoutTransition()
        val selectedIdStore = storeOf("")

        div("grow m-2 flex flex-row") {
            idsListComponent(selectedIdStore)
            selectedTranslationEditor(selectedIdStore)
        }
    }
}

fun RenderContext.idsListComponent(selectedIdStore: Store<String>) {
    withKoin {
        val fluentFilesStore = get<FluentFilesStore>()
        val settingsStore = get<SettingsStore>()


        val keysData = fluentFilesStore.data.filterNotNull().map { files ->
            files.flatMap { it.keys() }.distinct().sorted()
        }
        settingsStore.data.render { settings ->
            val missingTranslationsData = fluentFilesStore.data.filterNotNull().map { files ->
                files.firstOrNull { it.matches(settings.preferredTranslationLanguage) }
                    ?.let { preferred ->
                        files.missingTranslations(preferred)
                    }.orEmpty()
            }

            keysData.distinctUntilChanged().render { keys ->

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
                                        translationId.lowercase().contains(query.lowercase())
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
                                                            "$prefix-".takeIf { it != "-" } ?: "",
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
                                                                    translationId,
                                                                )
                                                            }
                                                        }
                                                    }
                                                    missingTranslationsData.distinctUntilChanged()
                                                        .render { missingTranslations ->
                                                            missingTranslations[translationId]?.let { missing ->
                                                                if (missing > 0) {
                                                                    span {
                                                                        +" missing $missing"
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
        }
    }
}

fun RenderContext.selectedTranslationEditor(
    selectedIdStore: Store<String>
) {
    withKoin {
        val fluentFilesStore = get<FluentFilesStore>()
        val translationService = get<TranslationService>()
        val settingsStore = get<SettingsStore>()
        fluentFilesStore.data.filterNotNull().render { files ->

            div("grow p-5 bg-white shadow-lg m-2 overflow-y-auto") {
                div("max-h-0") {
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
                            secondaryButton {
                                translate(TL.FluentEditor.DeleteThisId)

                                clicks handledBy {
                                    confirm(
                                        description = TL.FluentEditor.DeleteThisIdConfirmation,
                                        job = job,
                                    ) {
                                        selectedIdStore.update("")
                                        fluentFilesStore.deleteKey(translationId)
                                    }
                                }
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
                                            secondaryButton(
                                                text = TL.FluentEditor.AiTranslate,
                                                iconSource = SvgIconSource.OpenAI,
                                            ) {
                                                val originalText = files.first {
                                                    it.matches(
                                                        settingsStore.current.preferredTranslationLanguage,
                                                    )
                                                }[translationId]?.definition.orEmpty()
                                                val isDisabled = !translationService.enabled()
                                                disabled(originalText.isBlank() || isDisabled)
                                                if (isDisabled) {
                                                    title(getTranslationString(TL.FluentEditor.ConfigureKey))
                                                } else {
                                                    title(getTranslationString(TL.FluentEditor.TranslateUsingOpenAi))
                                                }

                                                clicks handledBy {
                                                    translateWithOpenAI(
                                                        translationId,
                                                        originalText,
                                                        file,
                                                        translationEditor,
                                                    )
                                                }
                                            }
                                            primaryButton(
                                                text = TL.Common.Save,
                                                iconSource = SvgIconSource.Check,
                                            ) {
                                                val original = file[translationId]
                                                disabled(t == original?.definition.orEmpty())

                                                clicks handledBy {
                                                    val newFile =
                                                        file.put(translationId, t, chunk?.comment)
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

private suspend fun translateWithOpenAI(
    translationId: String,
    originalText: String,
    file: FluentFile,
    translationEditor: Store<String>
) {
    withKoin {
        val fluentFilesStore = get<FluentFilesStore>()
        val translationService = get<TranslationService>()

        runWithBusy(
            {
                translationService.translate(
                    originalText,
                    file.name,
                )
            },
            translationArgs = mapOf("language" to file.name),
        ) { translated ->
            translationEditor.update(
                translated ?: ":-(",
            )
            if (translated != null) {
                val newFile =
                    file.put(translationId, translated)
                fluentFilesStore.addOrReplace(newFile)
                translationEditor.update(newFile[translationId]?.definition.orEmpty())
            } else {
                console.error("no translation")
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
                            newTranslationStore.data.render { newTranslation ->
                                disabled(
                                    files.isNullOrEmpty()
                                        || newTranslation.isBlank()
                                        || newId.isBlank()
                                        || files.flatMap { it.keys() }.contains(newId),
                                )
                            }
                        }

                        clicks handledBy {
                            val newId = newIdStore.current
                            val preferred = settings.preferredTranslationLanguage
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
