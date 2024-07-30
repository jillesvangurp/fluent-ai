package files

import com.jillesvangurp.fluentai.FluentFile
import components.LocalStoringStore
import kotlinx.serialization.builtins.ListSerializer
import localization.Locales
import settings.SettingsStore
import settings.preferredTranslationLanguage
import withKoin

class FluentFilesStore : LocalStoringStore<List<FluentFile>>(emptyList(),"fluentfiles",
    ListSerializer(FluentFile.serializer())
) {
    fun addOrReplace(file: FluentFile) {
        val new = current?.filter { it.name != file.name }.orEmpty() + file
        persistAndUpdate(new.sortedBy { it.name })
    }

    fun deleteKey(key:String) {
        val updatedFiles = current?.map {
            it.delete(key)
        }
        persistAndUpdate(updatedFiles.orEmpty())
    }

    fun delete(fileName: String) {
        val new = current?.filter { it.name != fileName }.orEmpty()
        persistAndUpdate(new.sortedBy { it.name })
    }

    fun clear() {
        persistAndUpdate(emptyList())
    }

    fun getDefaultTranslation(): FluentFile? {
        withKoin {
            val settingsStore = get<SettingsStore>()
            return current?.firstOrNull() {
                it.matches(
                    settingsStore.current.preferredTranslationLanguage,
                )
            }
        }
    }
}
