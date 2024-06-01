package files

import com.jillesvangurp.fluentai.FluentFile
import components.downloadButton
import components.secondaryButton
import components.twInputField
import dev.fritz2.core.RenderContext
import dev.fritz2.core.disabled
import dev.fritz2.core.readOnly
import dev.fritz2.core.storeOf
import dev.fritz2.headless.components.textArea
import icons.SvgIconSource
import localization.Locales
import localization.TL
import localization.TranslationStore
import localization.translate
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.files.FileReader
import org.w3c.files.get
import withKoin


val fileLoaderModule = module {
    singleOf(::FluentFilesStore)
}

fun RenderContext.fileManager() {
    withKoin {
        val fluentFilesStore = get<FluentFilesStore>()

        div("flex flex-col grow m-5 bg-white") {
            fileLoader()
            div("flex flex-row gap-2") {
                secondaryButton(
                    text = TL.Common.Clear,
                    iconSource = SvgIconSource.Cross
                ) {
                    clicks handledBy {
                        fluentFilesStore.clear()
                    }
                }
                secondaryButton(
                    text = TL.FileLoader.LoadOwnFtls,
                    iconSource = SvgIconSource.Upload
                ) {
                    clicks handledBy {
                        fluentFilesStore.loadOwnFtls()
                    }
                }

                val newFileStore = storeOf("")
                twInputField(newFileStore,null,"en-PR.ftl")
                fluentFilesStore.data.render {files ->
                    newFileStore.data.render { name ->
                        secondaryButton(
                            text = TL.FileLoader.AddNewFile,
                            iconSource = SvgIconSource.Plus
                        ) {
                            disabled(name.isBlank() || files.orEmpty().map { it.name }.contains(name))

                            clicks handledBy {
                                fluentFilesStore.addOrReplace(FluentFile(name, ""))
                            }
                        }
                    }
                }
            }
            listFiles()
        }
    }
}

suspend fun FluentFilesStore.loadOwnFtls() {
    val files = Locales.entries.mapNotNull { locale ->
        TranslationStore.fetchFtl(locale.id )?.let {
            FluentFile(locale.id,it)
        }
    }.sortedBy { it.name }
    persistAndUpdate(files)
}

fun RenderContext.fileLoader() {
    withKoin {
        // Drag target store
        val fileContentStore = get<FluentFilesStore>()

        // Drag target
        div(
            "border-2 border-dashed border-gray-300 p-4 text-center hover:bg-gray-100 rounded mt-4"
        ) {
//            +"Drag and drop translation files here"
            translate(TL.FileLoader.DragAndDrop)
        }.apply {
            domNode.ondragover = { it.preventDefault() }
            domNode.ondrop = { event ->
                event.preventDefault()
                event.dataTransfer?.files?.let { files ->
                    for (index in 0 until files.length) {
                        val file = files[index] ?: error("file should be there")
                        if (file.type == "text/plain") {
                            val reader = FileReader()
                            reader.onload = {
                                val content = reader.result as String
                                console.log("loaded ${file.name}")

                                fileContentStore.addOrReplace(FluentFile(
                                    file.name,
                                    content
                                ))
                            }
                            reader.readAsText(file)
                        } else {
                            console.warn("unsupported content of type ${file.type} in file ${file.name}")
                        }
                    }
                }
            }
        }
    }
}

fun RenderContext.listFiles() {
    withKoin {
        val fileContentStore = get<FluentFilesStore>()
        val currentFileStore = storeOf<FluentFile?>(null)

        div("flex flex-row gap-10 grow") {
            div("flex flex-col gap-2 w-96") {
                fileContentStore.data.render { files ->
                    files?.forEach { file ->
                        div {
                            a {
                                +file.name
                                clicks handledBy {
                                    currentFileStore.update(file)
                                }
                            }
                        }
                    }?: div {
                        +"-"
                    }
                }
            }
            div("w-full grow my-5 p-5 flex flex-col") {
                currentFileStore.data.render { file->
                    p {
                        +(file?.name ?: "-")
                    }
                    if(file !=null) {
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
                        div("flex flex-row gap-2") {
                            secondaryButton(text = TL.Common.Delete, iconSource = SvgIconSource.Delete) {
                                clicks handledBy {
                                    fileContentStore.delete(file.name)
                                    currentFileStore.update(null)
                                }
                            }
                            downloadButton(file.content,file.name)
                        }
                    }
                }
            }
        }
    }
}
