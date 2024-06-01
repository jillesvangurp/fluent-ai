package files

import com.jillesvangurp.fluentai.FluentFile
import components.LocalStoringStore
import kotlinx.serialization.builtins.ListSerializer

class FluentFilesStore : LocalStoringStore<List<FluentFile>>(emptyList(),"fluentfiles",
    ListSerializer(FluentFile.serializer())
)  {
    fun addOrReplace(file: FluentFile) {
        val new = current?.filter { it.name != file.name }.orEmpty() + file
        update(new)
        persist()
    }
}
