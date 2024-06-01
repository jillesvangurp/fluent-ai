package routing

import com.tryformation.localization.Translatable
import dev.fritz2.core.RenderContext
import dev.fritz2.routing.MapRouter
import dev.fritz2.routing.routerOf
import files.fileLoader
import files.listFiles
import kotlinx.coroutines.flow.map
import localization.languageSelector
import localization.translate
import org.koin.dsl.module
import withKoin

enum class Page(_title: String?=null) : Translatable {
    Editor,
    Files,
    Settings,
    ;
    val title = _title?:name
    val route = mapOf("page" to name)
    override val prefix = "pages"
    companion object {
        val default = Page.Editor
    }
}

val routingModule = module {
    single { routerOf(Page.Editor.route) }
}

fun RenderContext.mainScreen() {
    withKoin {
        val router = get<MapRouter>()
        div("w-screen h-screen bg-gray-100 flex flex-col") {
            router.select("page")
                .map { (p,pp) ->
                    (p?.let { Page.valueOf(p) } ?: Page.default) to pp
                }.render {(page, params) ->
                    div("flex flex-row gap-5 bg-white p-5") {
                        Page.entries.forEach { p ->
                            a {
                                translate(p)
                                clicks.map { p.route } handledBy router.navTo
                            }
                        }
                    }

                    when(page) {
                        Page.Editor -> div("grow m-5 bg-white") {
                            +"TODO"
                        }
                        Page.Files -> div("flex flex-col grow m-5 bg-white") {
                            fileLoader()
                            listFiles()
                        }
                        Page.Settings -> languageSelector()
                    }

            }
        }
    }
}
