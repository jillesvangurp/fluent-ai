package components

import com.tryformation.localization.Translatable
import dev.fritz2.core.storeOf
import dev.fritz2.core.transition
import dev.fritz2.headless.components.modal
import dev.fritz2.headless.foundation.setInitialFocus
import kotlinx.coroutines.Job
import localization.TL
import localization.translate

suspend fun confirm(
    question: Translatable = TL.ConfirmDialog.DefaultQuestion,
    description: Translatable = TL.ConfirmDialog.DefaultDescription,
    yes: Translatable = TL.ConfirmDialog.Yes,
    no: Translatable = TL.ConfirmDialog.No,
    translationArgs: Map<String,Any>?=null,
    job: Job,
    conditionalBlock: suspend () -> Unit,
) {
    val openStateStore = storeOf(true, job)
    modal {
        openState(openStateStore)
        modalPanel("w-full fixed inset-0 overflow-y-auto") {
            div("flex items-end justify-center min-h-screen pt-4 px-4 pb-20 text-center sm:block sm:p-0") {
                modalOverlay("fixed inset-0 bg-blueMuted-300 bg-opacity-75 transition-opacity") {
                    transition(
                        "ease-out duration-300",
                        "opacity-0",
                        "opacity-100",
                        "ease-in duration-200",
                        "opacity-100",
                        "opacity-0"
                    )
                }
                /* <!-- This element is to trick the browser into centering the modal contents. --> */
                span("hidden sm:inline-block sm:align-middle sm:h-screen") {
                    attr("aria-hidden", "true")
                    +" "
                }
                div(
                    """inline-block align-bottom sm:align-middle w-full sm:max-w-4xl px-6 py-5 sm:p-14 
                    | bg-white rounded-lg
                    | shadow-xl transform transition-all 
                    | text-left overflow-hidden""".trimMargin()
                ) {
                    fadeInFadeoutTransition()
                    div("mt-3 text-center sm:mt-0 sm:text-left") {
                        modalTitle("text-white bg-blueBright-700 p-2 items-center") {
                            p("text-center") {
                                translate(question, translationArgs)
                            }
                        }
                        div("mt-2") {
                            p {
                                translate(description, translationArgs)
                            }
                            flexRowCentered {
                                secondaryButton {
                                    translate(TL.ConfirmDialog.No, translationArgs)
                                    clicks handledBy {
                                        openStateStore.update(false)
                                    }
                                }
                                primaryButton {
                                    translate(TL.ConfirmDialog.Yes, translationArgs)
                                    clicks handledBy {
                                        conditionalBlock.invoke()
                                        openStateStore.update(false)
                                    }
                                    setInitialFocus()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
