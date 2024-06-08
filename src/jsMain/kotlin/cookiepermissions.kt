import components.*
import dev.fritz2.core.RenderContext
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import localization.TL
import localization.translate
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val cookiePermissionModule = module {
    singleOf(::CookiePermissionStore)
}

@Serializable
data class CookiePermission(val ok: Boolean = true, val dateAgreed: Instant = Clock.System.now())

class CookiePermissionStore() : LocalStoringStore<CookiePermission>(null, "cookie-permissions", CookiePermission.serializer())

fun RenderContext.cookiePopup() {
    withKoin {
        val cookiePermissionStore = get<CookiePermissionStore>()
        cookiePermissionStore.data.distinctUntilChanged().render { permissions ->
            if (permissions?.ok != true) {
                overlay(
                    content = {
                        h1 {
                            translate(TL.Cookies.Header)
                        }
                        p {
                            translate(TL.Cookies.Disclaimer)
                        }
                        primaryButton {
                            +"Agreed"

                            clicks handledBy {
                                cookiePermissionStore.persistAndUpdate(CookiePermission())
                            }
                            clicks handledBy { infoBubble(TL.Cookies.Welcome) }
                        }
                    },
                    closeHandler = null
                )
            }
        }
    }
}
