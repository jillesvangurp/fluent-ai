package components

import com.jillesvangurp.serializationext.DEFAULT_JSON
import dev.fritz2.core.RootStore
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.browser.window
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.serialization.KSerializer

open class LocalStoringStore<T>(
    initialData: T?,
    val key: String,
    val serializer: KSerializer<T>

) :
    RootStore<T?>(initialData, Job()) {
    private var latest: T? = null
    private var loaded: T? = null

    suspend fun awaitLoaded() {
        // flows are updating async so we need to poll for the loaded item to appear in the flow after update
        while (current != loaded) delay(10.milliseconds)
    }

    fun persistAndUpdate(value: T) {
        val serialized = DEFAULT_JSON.encodeToString(serializer, value)
        window.localStorage.setItem(key, serialized)
        update(value)
    }

    init {
        try {
            window.localStorage.getItem(key)?.let { content ->
                DEFAULT_JSON.decodeFromString(serializer, content).also { v ->
                    console.log("INIT $key")
                    latest = v
                }
            }?.let { item ->
                update(item)
                loaded = item
            }
        } catch (e: Exception) {
            console.log("error initializing store",key,e)
        }
    }
}
