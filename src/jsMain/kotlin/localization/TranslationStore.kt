@file:Suppress("unused")

package localization

import com.tryformation.localization.LocalizedTranslationBundleSequence
import com.tryformation.localization.LocalizedTranslationBundleSequenceProvider
import com.tryformation.localization.Translatable
import dev.fritz2.core.HtmlTag
import dev.fritz2.core.RootStore

import dev.fritz2.remote.http
import kotlinx.browser.window
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import org.w3c.dom.HTMLElement
import settings.SettingsStore
import withKoin

private val translationStore by lazy {
    withKoin {
        get<TranslationStore>()
    }
}

fun HtmlTag<HTMLElement>.translate(translatable: Translatable,args: Map<String, Any>? = null) =
    translationStore[translatable,args].renderText()

fun getTranslationString(translatable: Translatable,args: Map<String, Any>? = null) =
    translationStore.getString(translatable,args)

fun getTranslationFlow(translatable: Translatable,args: Map<String, Any>? = null) =
    translationStore[translatable, args]


class TranslationStore(
    val settingsStore: SettingsStore,
    bundleSequence: LocalizedTranslationBundleSequence,
    private val defaultLanguage: String = Locales.EN_US.id
) : RootStore<LocalizedTranslationBundleSequence>(bundleSequence, Job()) {

    operator fun get(translatable: Translatable, args: Map<String, Any>? = null): Flow<String> {
        return data.map { bundleSequence ->
            bundleSequence.format(translatable, args = args)
        }.map { it.also {
            if(it.noTranslationFound) {
                console.warn("No translation found for ${translatable.messageId}")
            }
        }.message }
    }

    operator fun get(translatable: Translatable, argsFlow: Flow<Map<String, Any>>): Flow<String> {
        return data.combine(argsFlow) { bundleSeq, json ->
            bundleSeq.format(translatable, args = json).also {
                if(it.noTranslationFound) {
                    console.warn("No translation found for ${translatable.messageId}")
                }
            }.message
        }
    }

    fun getString(translatable: Translatable, args: Map<String, Any>? = null): String {
        return current.format(translatable, args = args).also {
            if(it.noTranslationFound) {
                console.warn("No translation found for ${translatable.messageId}")
            }
        }.message
    }


    val updateLocale = handle<String> { _, newLocale ->
        provider.loadBundleSequence(listOf(newLocale), defaultLanguage, Companion::fetchFtl).also {
            Locales.getByIdOrNull(newLocale)?.let {
                settingsStore.setLocale(it)
            }
        }
    }

    private val setLocale = handle<Locales?> { current, locale ->
        if (locale != null) {
            provider.loadBundleSequence(listOf(locale.id), defaultLanguage, Companion::fetchFtl)
        } else {
            current
        }
    }

    companion object {
        internal val provider = LocalizedTranslationBundleSequenceProvider()

        private val baseUrl = window.location.let { l ->
            if (l.protocol == "file:") {
                error("wrong protocol")
            } else {
                l.protocol + "//" + l.host + "/lang"
            }
        }

        suspend fun fetchFtl(newLocale: String) = try {
            val response = http("$baseUrl/${newLocale}.ftl").get()
            if(response.ok) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }

        suspend fun load(settingsStore: SettingsStore, fallback: String): TranslationStore {
            settingsStore.awaitLoaded()
            val preferred = settingsStore.current?.uiLanguage
            val languages =
                (window.navigator.language.let { listOf(it) } + window.navigator.languages.toList()).distinct()
            console.log("browser languages: ${languages.joinToString(",")}")

            val best = languages.firstOrNull {
                Locales.getByIdOrNull(it) != null
            }
            val initWith = listOfNotNull(preferred?.id, best)
            console.log(preferred?.id,initWith.joinToString(", "))
            return TranslationStore(settingsStore,provider.loadBundleSequence(initWith, fallback, Companion::fetchFtl))
        }
    }
}
