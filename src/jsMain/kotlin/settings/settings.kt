package settings

import components.LocalStoringStore
import dev.fritz2.core.RenderContext
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import localization.Locales
import localization.languageSelector
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val settingsModule = module {
    singleOf(::SettingsStore)
}

@Serializable
data class Settings(
    val uiLanguage: Locales?=null,
    val fallBack: String?=null,
    val openAIKey: String?=null,
)

class SettingsStore : LocalStoringStore<Settings>(Settings(), "settings", Settings.serializer()) {
    fun setLocale(locale: Locales) {
        persistAndUpdate(
            (current ?: Settings()).copy(
                uiLanguage = locale
            )
        )
    }
}

fun RenderContext.settingsScreen() {
    div("grow m-5 bg-white flex flex-col") {
        languageSelector()
    }
}
