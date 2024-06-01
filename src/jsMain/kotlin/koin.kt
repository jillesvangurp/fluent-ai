import dev.fritz2.core.RenderContext
import dev.fritz2.core.render
import files.fileLoaderModule
import localization.TranslationStore
import org.koin.core.Koin
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import routing.routingModule

inline fun <T> withKoin(block: Koin.() -> T): T = with(GlobalContext.get()) {
    block(this)
}

suspend fun startAppWithKoin(ui: RenderContext.()->Unit) {
    startKoin {
        modules(
            routingModule,
            fileLoaderModule,
        )
    }
    withKoin {
        // load is a suspend function
        // so we declare this component last
        declare(TranslationStore.load(fallback = "en-US"))
    }

    render("#target", content=ui)
}
