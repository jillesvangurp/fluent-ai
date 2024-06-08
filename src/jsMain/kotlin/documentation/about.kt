package documentation

import dev.fritz2.core.RenderContext
import localization.TL
import markdown.markdownDiv

fun RenderContext.about() {
    div("w-9/12 mx-auto bg-white p-5 my-2 overflow-y-auto h-full") {
        markdownDiv(TL.Docs.About)
    }
}
