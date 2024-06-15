package components

import com.tryformation.localization.Translatable
import dev.fritz2.core.RootStore
import dev.fritz2.core.storeOf
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import localization.TL
import localization.getTranslationString
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import withKoin

val busyPopupModule = module {
    singleOf(::BusyStore)
}

private val busyScope = CoroutineScope(CoroutineName("busy"))

data class Progress(val text: String, val step: Int, val total: Int)

class ProgressStore : RootStore<Progress?>(null, Job())

suspend fun <T> runWithBusy(
    supplier: suspend (ProgressStore?) -> T,
    successMessage: Translatable = TL.Busy.Success,
    initialTitle: Translatable = TL.Busy.InitialTitle,
    initialMessage: Translatable = TL.Busy.InitialMessage,
    translationArgs: Map<String, Any>? = null,
    progressStore: ProgressStore? = null,
    errorResult: suspend (Result<T>) -> Unit = {},
    processResult: suspend (T) -> Unit = { }
) {
    busyResult(
        suspend {
            try {
                Result.success(supplier.invoke(progressStore))
            } catch (e: Exception) {
                Result.failure(e)
            }
        },
        successMessage,
        initialTitle,
        initialMessage,
        translationArgs,
        progressStore,
        errorResult,
        processResult,
    )
}

suspend fun <R> busyResult(
    supplier: suspend () -> Result<R>,
    successMessage: Translatable = TL.Busy.Success,
    initialTitle: Translatable = TL.Busy.InitialTitle,
    initialMessage: Translatable = TL.Busy.InitialMessage,
    translationArgs: Map<String, Any>? = null,
    progressStore: ProgressStore? = null,
    errorResult: suspend (Result<R>) -> Unit = {},
    processResult: suspend (R) -> Unit = { }
) {
    withKoin {
        val busyStore = get<BusyStore>()
        busyStore.withBusyState(
            supplier,
            successMessage,
            initialTitle,
            initialMessage,
            translationArgs,
            progressStore,
            errorResult,
            processResult,
        )
    }
}

class BusyStore() : RootStore<Boolean>(false, Job()) {
    val titleStore = storeOf("", job)
    val messageStore = storeOf("", job)

    suspend fun <T> withBusyState(
        supplier: suspend () -> Result<T>,
        successMessage: Translatable = TL.Busy.Success,
        initialTitle: Translatable = TL.Busy.InitialTitle,
        initialMessage: Translatable = TL.Busy.InitialMessage,
        translationArgs: Map<String, Any>? = null,
        progressStore: ProgressStore? = null,
        errorResult: suspend (Result<T>) -> Unit = {},
        processResult: suspend (T) -> Unit = {}
    ) {
        titleStore.update(getTranslationString(initialTitle, translationArgs))
        messageStore.update(getTranslationString(initialMessage, translationArgs))
        progressStore?.let {
            it.data.map { it?.text.orEmpty() } handledBy messageStore.update
        }
        update(true)
        busyScope.launch {
            val result = try {
                supplier.invoke()
            } catch (e: Exception) {
                Result.failure(e)
            }
            result.fold(
                {
                    processResult.invoke(it)
                    titleStore.update(getTranslationString(successMessage, translationArgs))
                    delay(30.milliseconds)
                    update(false) // not busy anymore & close
                },
                {
                    titleStore.update("Error: ${it::class.simpleName}")
                    messageStore.update(
                            it.message ?: getTranslationString(
                                    TL.Busy.Failure,
                                    translationArgs,
                            ),
                    )
                    errorResult.invoke(result)
                    console.warn("Failed with ${it::class.simpleName}: ${it.message}")
                    delay(2.seconds)
                    update(false) // not busy anymore & close
                },
            )
        }
    }
}
