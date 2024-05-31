package components

import dev.fritz2.core.HtmlTag
import dev.fritz2.core.RenderContext
import dev.fritz2.core.ScopeContext
import org.w3c.dom.HTMLSelectElement

fun RenderContext.selectComponent(
    id: String? = null,
    scope: (ScopeContext.() -> Unit) = {},
    content: HtmlTag<HTMLSelectElement>.() -> Unit
) {
    select(
        "block appearance-none w-min-content bg-white border border-gray-300 hover:border-gray-400 focus:border-2 focus:border-gray-500 text-gray-700 py-2 px-3 pr-8 rounded leading-tight focus:outline-none transition ease-in-out duration-150",
        id = id,
        scope = scope,
        content = content,
    )
}
