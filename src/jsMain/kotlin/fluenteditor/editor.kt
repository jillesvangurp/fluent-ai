package fluenteditor

import dev.fritz2.core.RenderContext
import dev.fritz2.core.placeholder
import dev.fritz2.core.storeOf
import dev.fritz2.headless.components.inputField
import dev.fritz2.headless.components.textArea
import files.FluentFilesStore
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import localization.TL
import localization.getTranslationString
import org.w3c.dom.HTMLInputElement
import withKoin

fun RenderContext.fluentBrowser() {
    withKoin {
        val fluentFilesStore = get<FluentFilesStore>()

        val selectedIdStore = storeOf("")

        div("grow m-5 bg-white flex flex-row") {
            fluentFilesStore.data.filterNotNull().render {files ->

                val keys = files.flatMap { it.keys() }.distinct().sorted()

                div("max-w-96") {
                    val searchStore = storeOf("")
                    inputField {
                        value(searchStore)

                        inputs handledBy {
                            val element = it.target as HTMLInputElement
                            searchStore.update(element.value)
                        }

                        inputTextfield {
                            placeholder(getTranslationString(TL.Common.FilterPlaceholder))
                        }
                    }

                    searchStore.data.render {query->
                        keys.filter { translationId ->
                            if(query.isBlank()) true
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
                div("grow") {
                    selectedIdStore.data.filter { it.isNotBlank() }.render { translationId ->
                        p {
                            +translationId
                        }
                        files.map { file ->
                            val translation = file[translationId] ?: ""
                            file to translation
                        }.forEach { (file,translation) ->
                            div("w-full") {
                                p {
                                    +file.name
                                }
                                val translationEditor = storeOf(translation)
                                textArea("w-full") {
                                    value(translationEditor)
                                    textareaTextfield("w-full") {

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
