package files

import com.jillesvangurp.fluentai.FluentFile
import dev.fritz2.core.RenderContext
import dev.fritz2.core.readOnly
import dev.fritz2.core.storeOf
import dev.fritz2.headless.components.textArea
import localization.TL
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
    div("flex flex-col grow m-5 bg-white") {
        fileLoader()
        listFiles()
    }
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
        val currentFile = storeOf<FluentFile?>(null)

        div("flex flex-row gap-10 grow") {
            div("flex flex-col gap-2 w-96") {
                fileContentStore.data.render { files ->
                    files?.forEach { file ->
                        div {
                            a {
                                +file.name
                                clicks handledBy {
                                    currentFile.update(file)
                                }
                            }
                        }
                    }?: div {
                        +"-"
                    }
                }
            }
            div("w-full grow my-5 p-5 flex flex-col") {
                currentFile.data.render {file->
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
                    }
                }
            }
        }
    }
}
