import dev.fritz2.headless.components.toastContainer
import dev.fritz2.headless.foundation.portalRoot
import routing.mainScreen

suspend fun main() {
    try {
        startAppWithKoin {
            mainScreen()

            // mount points for fritz2 stuff
            toastContainer(
                "messages", // name
                "absolute bottom-5 left-1/2 -translate-x-48 mx-auto flex flex-col gap-2 place-items-center w-96",
            )
            portalRoot()
        }
    } catch (e: Exception) {
        console.error("Error loading the app", e)
    }
}

