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
        div {
            router.select("page")
                .map { (p,pp) ->
                    (p?.let { Page.valueOf(p) } ?: Page.default) to pp
                }.render {(page, params) ->
                    div("flex flex-row gap-5") {
                        Page.entries.forEach { p ->
                            a {
                                translate(p)
                                clicks.map { p.route } handledBy router.navTo
                            }
                        }
                    }

                    when(page) {
                        Page.Editor -> listFiles()
                        Page.Files -> fileLoader()
                        Page.Settings -> languageSelector()
                    }

            }
        }
    }
}
