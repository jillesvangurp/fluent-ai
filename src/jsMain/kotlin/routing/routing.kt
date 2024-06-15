package routing

import com.tryformation.localization.Translatable
import components.flexRow
import dev.fritz2.core.RenderContext
import dev.fritz2.routing.MapRouter
import dev.fritz2.routing.routerOf
import documentation.about
import files.fileManager
import fluenteditor.fluentBrowser
import kotlinx.coroutines.flow.map
import localization.TL
import localization.languageSelector
import localization.translate
import org.koin.dsl.module
import settings.settingsScreen
import withKoin

enum class Page(_title: String? = null) : Translatable {
    Editor,
    Files,
    Settings,
    About,
    ;

    val title = _title ?: name
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
                .map { (p, pp) ->
                    (p?.let {
                        try {
                            Page.valueOf(p)
                        } catch (e: Exception) {
                            console.warn("No such page $p")
                        }
                    } ?: Page.default) to pp
                }.render { (page, params) ->
                    div("flex flex-row w-full gap-2 bg-white place-items-center justify-between") {
                        h1("text-blueBright-500 font-bold my-0 pl-5") {
                            translate(TL.Common.AppName)
                        }
                        div("flex flex-row gap-2 bg-white py-2 border-b border-gray-300") {
                            Page.entries.forEach { p ->
                                if (page == p) {
                                    a("px-4 py-2 text-gray-600 hover:text-gray-800 border-b-2 border-blueBright-500 text-blueBright-500") {
                                        translate(p)
                                        clicks.map { p.route } handledBy router.navTo
                                    }

                                } else {
                                    a("px-4 py-2 text-gray-600 hover:text-gray-800 border-b-2 border-transparent") {
                                        translate(p)
                                        clicks.map { p.route } handledBy router.navTo
                                    }

                                }
                            }
                        }
                        flexRow {
                            languageSelector()
                        }
                    }

                    when (page) {
                        Page.Editor -> fluentBrowser()
                        Page.Files -> fileManager()
                        Page.Settings -> settingsScreen()
                        Page.About -> about()
                    }

                }
        }
    }
}



