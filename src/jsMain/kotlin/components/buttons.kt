package components

import com.tryformation.localization.Translatable
import dev.fritz2.core.HtmlTag
import dev.fritz2.core.RenderContext
import dev.fritz2.core.ScopeContext
import dev.fritz2.core.disabled
import dev.fritz2.core.download
import dev.fritz2.core.href
import icons.SvgIconSource
import icons.iconImage
import kotlin.random.Random
import kotlin.random.nextULong
import kotlinx.browser.document
import localization.TL
import localization.translate
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.events.MouseEvent

fun RenderContext.primaryButton(
    id: String? = null,
    scope: (ScopeContext.() -> Unit) = {},
    iconSource: SvgIconSource? = null,
    text: Translatable? = null,
    content: HtmlTag<HTMLButtonElement>.() -> Unit
) = button(
    baseClass = """h-10 my-2 w-fit text-white bg-blueBright-600 hover:bg-blueBright-700 disabled:bg-gray-300 
        |focus:ring-button-300 focus:ring-4 font-medium rounded-lg 
        |text-sm px-6 py-2 focus:outline-none 
        |drop-shadow-md hover:drop-shadow-xl""".trimMargin(),
    id = id,
    scope = scope,
    content = {
        if (iconSource != null || text != null) {
            div("flex flex-row gap-2 flex-nowrap align-middle") {
                iconSource?.let {
                    iconImage(iconSource, baseClass = "h-5 w-5 fill-white place-items-center")
                }
                text?.let {
                    div {
                        translate(text)
                    }
                }
            }
        }
        content.invoke(this)
    }
)

fun RenderContext.secondaryButton(
    id: String? = null,
    scope: (ScopeContext.() -> Unit) = {},
    iconSource: SvgIconSource? = null,
    text: Translatable? = null,
    content: HtmlTag<HTMLButtonElement>.() -> Unit
) = button(
    baseClass = """h-10 my-2 w-fit text-white bg-blueMuted-600 hover:bg-blueMuted-700 disabled:bg-gray-300 
        |focus:ring-buttonSecondary-300 focus:ring-4 font-medium rounded-lg 
        |text-sm px-6 py-2 focus:outline-none
        |drop-shadow-md hover:drop-shadow-xl""".trimMargin(),
    id = id,
    scope = scope,
    content = {
        if (iconSource != null || text != null) {
            div("flex flex-row gap-2 place-items-center") {
                iconSource?.let {
                    iconImage(iconSource, baseClass = "h-5 w-5 fill-white place-items-center")
                }
                text?.let {
                    span {
                        translate(text)
                    }
                }
            }
        }
        content.invoke(this)
    }
)


fun RenderContext.downloadButton(
    downloadContent: String,
    fileName: String,
    buttonText: Translatable = TL.Common.Download,
    mimeType: String = "plain/text"
) {
    val downloadLinkId = "link-${Random.nextULong()}"
        a("hidden", id = downloadLinkId) {
            +"invisible"

            href("data:${mimeType},$downloadContent")
            val f =if(fileName.endsWith(".ftl")) fileName else "${fileName}.ftl"
            download(if (fileName.endsWith(".ftl")) fileName else "${fileName}.ftl")
        }
    primaryButton {
        // invisible link that we simulate a click on
        div("flex flex-row gap-2 place-items-center") {
            iconImage(SvgIconSource.Download, baseClass = "h-5 w-5 fill-white place-items-center")
            span {
                translate(buttonText)
            }
        }
        disabled(downloadContent.isBlank())
        clicks handledBy {
            val e = document.createEvent("MouseEvents") as MouseEvent
            e.initEvent("click", bubbles = true, cancelable = true)
            // issue a click on the link to cause the download to happen
            document.getElementById(downloadLinkId)?.dispatchEvent(e)
                ?: console.log("could not find link to click")
            infoBubble(TL.Common.Downloaded)
        }
    }
}
