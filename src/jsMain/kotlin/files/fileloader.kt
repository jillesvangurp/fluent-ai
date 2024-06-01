package files

import com.jillesvangurp.fluentai.FluentFile
import components.LocalStoringStore
import dev.fritz2.core.RenderContext
import kotlinx.serialization.builtins.ListSerializer
import localization.TL
import localization.translate
import org.koin.dsl.module
import org.w3c.files.FileReader
import org.w3c.files.get
import withKoin


class FilesStore : LocalStoringStore<List<FluentFile>>(emptyList(),"fluentfiles", ListSerializer(FluentFile.serializer()))  {
    val add = handle<FluentFile> { old, file ->
        old?.filter { it.name != file.name }.orEmpty() + file
    }
}

val fileLoaderModule = module {
    single { FilesStore() }
}

fun RenderContext.fileLoader() {
    withKoin {
        // Drag target store
        val fileContentStore = get<FilesStore>()

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

                                fileContentStore.add(FluentFile(
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
        val fileContentStore = get<FilesStore>()
        fileContentStore.data.render { files ->
            files?.forEach { file ->
                div {
                    h2 { +file.name }
                    pre {
                        +file.content
                    }

                }
            }?: div {
                +"-"
            }
        }
    }
}