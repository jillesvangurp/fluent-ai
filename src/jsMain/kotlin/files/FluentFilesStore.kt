package files

import com.jillesvangurp.fluentai.FluentFile
import components.LocalStoringStore
import kotlinx.serialization.builtins.ListSerializer

class FluentFilesStore : LocalStoringStore<List<FluentFile>>(emptyList(),"fluentfiles",
    ListSerializer(FluentFile.serializer())
)  {
    val add = handle<FluentFile> { old, file ->
        old?.filter { it.name != file.name }.orEmpty() + file
    }
}
