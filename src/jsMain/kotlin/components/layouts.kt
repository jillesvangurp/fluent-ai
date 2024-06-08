package components

import dev.fritz2.core.HtmlTag
import dev.fritz2.core.RenderContext
import org.w3c.dom.HTMLDivElement

fun RenderContext.flexCol(content: HtmlTag<HTMLDivElement>.() -> Unit) {
    div("flex flex-col flex-wrap", content = content)
}

fun RenderContext.flexRow(content: HtmlTag<HTMLDivElement>.() -> Unit) {
    div("flex flex-row flex-wrap gap-2 align-middle place-items-center", content = content)
}
fun RenderContext.flexRowCentered(content: HtmlTag<HTMLDivElement>.() -> Unit) {
    div("flex flex-row flex-wrap gap-2 align-middle place-items-center mx-auto w-fit", content = content)
}
fun RenderContext.leftRightRow(content: HtmlTag<HTMLDivElement>.() -> Unit) {
    div("flex flex-row w-full place-items-center justify-between", content = content)
}
