package components

import dev.fritz2.core.HtmlTag
import dev.fritz2.core.transition
import org.w3c.dom.HTMLDivElement

fun HtmlTag<HTMLDivElement>.fadeInFadeoutTransition() {
    transition(
        "ease-out duration-100",
        "opacity-0",
        "opacity-100",
        "ease-in duration-100",
        "opacity-100",
        "opacity-0"
    )
}
