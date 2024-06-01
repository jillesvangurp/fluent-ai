package components

import dev.fritz2.core.HtmlTag
import dev.fritz2.core.RenderContext
import dev.fritz2.core.ScopeContext
import dev.fritz2.core.Store
import dev.fritz2.headless.components.TextArea
import dev.fritz2.headless.components.textArea
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.HTMLTextAreaElement

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

/**
 * Simple full width text area (headless component).
 */
fun RenderContext.twFullWidthTextArea(
    valueStore: Store<String>,
    id: String? = null,
    scope: (ScopeContext.() -> Unit) = {},
    initialize: TextArea<HTMLDivElement>.() -> Unit,

    ) {
    textArea("flex-grow", id = id, scope=scope) {
        value(valueStore)

        inputs handledBy {
            val element = it.target as HTMLTextAreaElement
            valueStore.update(element.value)
        }

        initialize(this)
    }
}

/**
 * textareaTextfield for use in a twFullWidthTextArea. Has sensible default styling.
 */
fun TextArea<HTMLDivElement>.twOneLineTextareaTextfield(
    scope: (ScopeContext.() -> Unit) = {},
    content: HtmlTag<HTMLTextAreaElement>.() -> Unit

) {
    textareaTextfield("w-full h-10 focus:h-48 flex-1 p-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-primary bg-gray-100", scope=scope) {
        content(this)
    }
}

fun TextArea<HTMLDivElement>.twThreeLineTextareaTextfield(
    scope: (ScopeContext.() -> Unit) = {},
    content: HtmlTag<HTMLTextAreaElement>.() -> Unit

) {
    textareaTextfield("w-full h-32 flex-1 p-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-primary bg-gray-100", scope=scope) {
        content(this)
    }
}
