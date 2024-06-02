package components

import com.tryformation.localization.Translatable
import dev.fritz2.core.HtmlTag
import dev.fritz2.core.RenderContext
import dev.fritz2.core.ScopeContext
import dev.fritz2.core.Store
import dev.fritz2.core.placeholder
import dev.fritz2.headless.components.TextArea
import dev.fritz2.headless.components.inputField
import dev.fritz2.headless.components.textArea
import localization.translate
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLInputElement
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

fun TextArea<HTMLDivElement>.twThreeLineTextareaTextfield(
    scope: (ScopeContext.() -> Unit) = {},
    content: HtmlTag<HTMLTextAreaElement>.() -> Unit

) {
    textareaTextfield("h-32 w-full border-1 border-blueBright-100 focus:border-2 " +
        "focus:border-blueBright-300 focus:bg-blueBright-100 hover:bg-blueBright-50 " +
        "placeholder:text-gray-300", scope=scope) {
        content(this)
    }
}

fun RenderContext.twInputField(store: Store<String>, label: Translatable?=null, placeholder: String?=null) {
    inputField("flex flex-col gap-2") {
        label?.let {
            label {
                translate(label)
            }
        }

        value(store)

        inputs handledBy {
            val element = it.target as HTMLInputElement
            store.update(element.value)
        }
        inputTextfield("w-full border-1 border-blueBright-100 focus:border-2 " +
            "focus:border-blueBright-300 focus:bg-blueBright-100 hover:bg-blueBright-50 " +
            "placeholder:text-gray-300") {
            placeholder?.let {
                placeholder(placeholder)
            }
        }
    }
}

