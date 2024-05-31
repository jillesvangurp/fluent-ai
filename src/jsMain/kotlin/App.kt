import components.selectComponent
import dev.fritz2.core.RenderContext
import dev.fritz2.core.render
import dev.fritz2.core.selected
import dev.fritz2.headless.components.toastContainer
import dev.fritz2.headless.foundation.portalRoot
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import localization.Locales
import localization.TL
import localization.TranslationStore
import org.koin.core.Koin
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.w3c.dom.HTMLSelectElement
import utils.JsLogLevel
import utils.setJsLogLevel

inline fun <T> withKoin(block: Koin.() -> T): T = with(GlobalContext.get()) {
    block(this)
}

val handlerScope = CoroutineScope(CoroutineName("handler"))

fun koinInit() {
    startKoin {
        modules(
            // add modules here
        )
    }
}

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    setJsLogLevel(JsLogLevel.INFO)
    // little hack to get this to load in a co-routine scope because resource loading is suspending
    GlobalScope.launch {
        koinInit()
        withKoin {
            declare(TranslationStore.load(fallback = "en-US"))
        }

        ui()
    }
}

private fun ui() {
    render("#target") {
        h1 {
            +"Fluent AI"
        }
        languageSelector()

        //
        toastContainer(
            "messages", // name
            "absolute bottom-5 left-1/2 -translate-x-48 mx-auto flex flex-col gap-2 place-items-center w-96",
        )
        portalRoot()
    }
}

private fun RenderContext.languageSelector() {
    withKoin {
        val translationStore = get<TranslationStore>()
        p {
            translationStore[TL.LanguageSelector.SelectLanguage].renderText()
        }
        translationStore.data.render { bundleSequence ->
            selectComponent {
                changes handledBy { selected ->
                    val t = selected.target as HTMLSelectElement
                    translationStore.updateLocale(t.value)
                }
                Locales.entries.sorted().forEach { locale ->
                    option {
                        +locale.title
                        val current = bundleSequence.bundles.first().locale.first()
                        if (current.equals(locale.title, true)) {
                            selected(true)
                        }
                    }
                }
            }
        }
    }
}
