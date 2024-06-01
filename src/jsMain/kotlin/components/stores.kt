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
    private var loaded = false

    suspend fun awaitLoaded() {
        while (!loaded) delay(50.milliseconds)
    }

    fun persist() {
        val toStore = current
        if(toStore != null) {
            val value = DEFAULT_JSON.encodeToString(serializer, toStore)
            window.localStorage.setItem(key, value)
        }
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
            }
            loaded = true
        } catch (e: Exception) {
            console.log(e)
            console.log(key)
        }
    }
}
