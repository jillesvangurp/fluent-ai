import dev.fritz2.headless.components.toastContainer
import dev.fritz2.headless.foundation.portalRoot
import routing.mainScreen
import utils.JsLogLevel
import utils.setJsLogLevel

suspend fun main() {
    setJsLogLevel(JsLogLevel.INFO)
    // little hack to get this to load in a co-routine scope because resource loading is suspending
    startAppWithKoin {
        mainScreen()

        // mount points for fritz2 stuff
        toastContainer(
            "messages", // name
            "absolute bottom-5 left-1/2 -translate-x-48 mx-auto flex flex-col gap-2 place-items-center w-96",
        )
        portalRoot()
    }
}

