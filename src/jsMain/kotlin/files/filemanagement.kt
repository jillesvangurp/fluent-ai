package files

import com.jillesvangurp.fluentai.FluentFile
import com.jillesvangurp.fluentai.cleanupTranslations
import com.jillesvangurp.fluentai.sortedContent
import components.confirm
import components.downloadButton
import components.fadeInFadeoutTransition
import components.primaryButton
import components.secondaryButton
import components.twInputField
import dev.fritz2.core.RenderContext
import dev.fritz2.core.RootStore
import dev.fritz2.core.disabled
import dev.fritz2.core.readOnly
import dev.fritz2.core.storeOf
import dev.fritz2.core.transition
import dev.fritz2.headless.components.textArea
import icons.SvgIconSource
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import localization.Locales
import localization.TL
import localization.TranslationStore
import localization.translate
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.files.FileReader
import org.w3c.files.get
import settings.SettingsStore
import settings.preferredTranslationLanguage
import utils.handlerScope
import withKoin

class CurrentFluentFileStore : RootStore<FluentFile?>(null, Job())

val fileLoaderModule = module {
    singleOf(::FluentFilesStore)
    singleOf(::CurrentFluentFileStore)
}

fun RenderContext.fileManager() {
    withKoin {
        val fluentFilesStore = get<FluentFilesStore>()
        val currentFileStore = get<CurrentFluentFileStore>()


        div("flex flex-col grow m-2") {
            fadeInFadeoutTransition()
            div("flex flex-row gap-2 p-5 bg-white shadow-lg m-2") {
                secondaryButton(
                    text = TL.Common.Clear,
                    iconSource = SvgIconSource.Cross,
                ) {
                    clicks handledBy {
                        confirm(description = TL.FileLoader.ClearConfirmation, job = job) {
                            fluentFilesStore.clear()
                            currentFileStore.update(null)
                        }
                    }
                }
                secondaryButton(
                    text = TL.FileLoader.LoadOwnFtls,
                    iconSource = SvgIconSource.Upload,
                ) {
                    clicks handledBy {
                        confirm(description = TL.FileLoader.LoadOwnFtlsConfirmation, job = job) {
                            fluentFilesStore.clear()
                            fluentFilesStore.loadOwnFtls()
                            currentFileStore.update(null)
                        }
                    }
                }
                primaryButton(
                    text = TL.FileLoader.AddNew,
                    iconSource = SvgIconSource.Plus,
                ) {
                    currentFileStore.data.render { current ->
                        disabled(current == null)
                    }
                    clicks handledBy {
                        currentFileStore.update(null)
                    }
                }
            }
            listFiles()


        }
    }
}

suspend fun FluentFilesStore.loadOwnFtls() {
    withKoin {
        val settingsStore = get<SettingsStore>()
        val files = Locales.entries.mapNotNull { locale ->
            TranslationStore.fetchFtl(locale.id)?.let {
                FluentFile(locale.id, it)
            }
        }.sortedBy { it.name }
        persistAndUpdate(files.cleanupTranslations(settingsStore.current.preferredTranslationLanguage))
    }
}

fun RenderContext.fileLoader() {
    withKoin {
        // Drag target store
        val fileContentStore = get<FluentFilesStore>()
        val settingsStore = get<SettingsStore>()

        // Drag target
        div(
            "flex flex-col border-2 border-dashed border-blueMuted-400 p-2 place-content-center hover:bg-blueBright-100 rounded grow",
        ) {
            div("text-center") {
                translate(TL.FileLoader.DragAndDrop)
            }
        }.apply {
            domNode.ondragover = { it.preventDefault() }
            domNode.ondrop = { event ->
                event.preventDefault()
                event.dataTransfer?.files?.let { files ->
                    val loadedFiles = mutableListOf<FluentFile>()
                    var processedFiles = files.length
                    for (index in 0 until files.length) {
                        val file = files[index] ?: error("file should be there")
                        if (file.type == "text/plain") {
                            val reader = FileReader()
                            reader.onload = {
                                val content = reader.result as String
                                console.log("loaded ${file.name}")

                                loadedFiles.add(
                                    FluentFile(
                                        file.name,
                                        content,
                                    ),
                                )
                                processedFiles--
                            }
                            reader.readAsText(file)
                        } else {
                            console.warn("unsupported content of type ${file.type} in file ${file.name}")
                            processedFiles--
                        }
                    }
                    // we can't do rapid writes because they'll overlap
                    // so gather everything and wait for that to finish
                    // asynchronously and then store
                    handlerScope.launch {
                        while (processedFiles > 0) {
                            delay(5.milliseconds)
                        }
                        val pl = settingsStore.current.preferredTranslationLanguage

                        fileContentStore.persistAndUpdate(
                            loadedFiles.map {
                                // sort on load
                                FluentFile(it.name, it.asMap().sortedContent())
                            }.cleanupTranslations(settingsStore.current.preferredTranslationLanguage),
                        )
                    }

                }
            }
        }
    }
}

fun RenderContext.listFiles() {
    withKoin {
        val fluentFilesStore = get<FluentFilesStore>()
        val currentFileStore = get<CurrentFluentFileStore>()

        div("flex flex-row gap-2 grow") {
            div("flex flex-col gap-2 w-96 bg-white shadow-lg m-2 p-5") {
                fluentFilesStore.data.render { files ->
                    h3 {
                        translate(TL.FileLoader.FilesHeader)
                    }
                    if (files.isNullOrEmpty()) {
                        div("grow h-full") {
                            p {
                                translate(TL.FileLoader.NoFilesYetCta)
                            }
                        }
                    } else {
                        files.forEach { file ->
                            div {
                                a {
                                    +file.name
                                    currentFileStore.data.render {
                                        if (currentFileStore.current == file) {
                                            +" *"
                                        }
                                    }
                                    clicks handledBy {
                                        if (currentFileStore.current == file) {
                                            currentFileStore.update(null)
                                        } else {
                                            currentFileStore.update(file)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            div("w-full grow p-5 flex flex-col bg-white shadow-lg m-2 p-5") {
                currentFileStore.data.render { file ->
                    if (file == null) {
                        createNewFile()
                        fileLoader()
                    } else {
                        h3 {
                            +file.name
                        }
                        fileStats(file)

                        div("flex flex-row gap-2") {
                            secondaryButton(
                                text = TL.Common.Delete,
                                iconSource = SvgIconSource.Delete,
                            ) {
                                clicks handledBy {
                                    confirm(
                                        description = TL.FileLoader.DeleteFileConfirmation,
                                        translationArgs = mapOf(
                                            "file" to file.name,
                                        ),
                                        job = job,
                                    ) {
                                        fluentFilesStore.delete(file.name)
                                        currentFileStore.update(null)
                                    }
                                }
                            }
                            downloadButton(file.content, file.name)
                        }
                        val showContentStore = storeOf(false)
                        showContentStore.data.render { show ->
                            a {
                                if (show) {
                                    translate(TL.Common.Hide, mapOf("content" to file.name))
                                } else {
                                    translate(TL.Common.Show, mapOf("content" to file.name))
                                }
                            }
                            clicks handledBy {
                                showContentStore.update(!showContentStore.current)
                            }
                            if (show) {
                                showContent(file)
                            }
                        }
                    }
                }
            }
        }
    }
}

fun RenderContext.fileStats(file: FluentFile) {
    withKoin {
        val settingsStore = get<SettingsStore>()
        val fileStore = get<FluentFilesStore>()
        fileStore.data.filterNotNull().render { files ->
            settingsStore.data.render { settings ->
                val preferredLanguage = settings.preferredTranslationLanguage
                val source = files.firstOrNull { it.matches(preferredLanguage) }
                ul {
                    val numberOfTranslations = file.chunks.size
                    li {
                        +"$numberOfTranslations translations"
                    }
                    if (source != null && source.name != file.name) {
                        val numberOfTranslationsInSource = source.chunks.size
                        li {
                            +"${numberOfTranslationsInSource - numberOfTranslations } missing translations"
                        }
                    }
                }
            }
        }
    }
}

fun RenderContext.showContent(file: FluentFile) {
    val contentStore = storeOf(file.content)

    textArea("grow") {
        inputs handledBy {
            val element = it.target as HTMLTextAreaElement
            contentStore.update(element.value)
        }

        value(contentStore)
        textareaTextfield("w-full h-full") {
            // FIXME we need some confirmation before wiping out any edits
            readOnly(true)
        }
    }

}

fun RenderContext.createNewFile() {
    withKoin {
        val fluentFilesStore = get<FluentFilesStore>()
        val currentFileStore = get<CurrentFluentFileStore>()

        div("flex flex-row gap-2 my-2 place-items-center") {
            val newFileStore = storeOf("")
            twInputField(newFileStore, null, "en-PR.ftl")
            fluentFilesStore.data.render { files ->
                newFileStore.data.render { name ->
                    secondaryButton(
                        text = TL.FileLoader.CreateNewFile,
                        iconSource = SvgIconSource.Plus,
                    ) {
                        disabled(
                            name.isBlank() || files.orEmpty().map { it.name }
                                .contains(name),
                        )

                        clicks handledBy {
                            val file = FluentFile(name, "")
                            fluentFilesStore.addOrReplace(file)
                            currentFileStore.update(file)
                        }
                    }
                }
            }
        }
    }
}
