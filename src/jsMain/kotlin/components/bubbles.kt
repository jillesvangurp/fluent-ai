package components

import com.tryformation.localization.Translatable
import dev.fritz2.headless.components.toast
import kotlin.time.Duration.Companion.seconds
import localization.translate

fun infoBubble(text: Translatable) {
    toast("messages", duration = 3.seconds.inWholeMilliseconds, ) {
        div("bg-blueBright-200 p-5 rounded-lg border-2 border-blueBright-400 text-center w-96") {
            translate(text)
        }
    }
}

fun warningBubble(text: Translatable) {
    toast("messages", duration = 6.seconds.inWholeMilliseconds, ) {
        div("bg-yellow-200 p-5 rounded-lg border-2 border-yellow-400 text-center w-96") {
            translate(text)
        }
    }
}

fun errorBubble(text: Translatable, e: Throwable?=null) {
    if(e!=null) {
        console.error(e)
    }
    toast("messages", duration = 10.seconds.inWholeMilliseconds, ) {
        div("bg-red-200 p-5 rounded-lg border-2 border-red-400 text-center w-96") {
            translate(text)
            e?.let {
                +": ${e.message}"
            }
        }
    }
}
