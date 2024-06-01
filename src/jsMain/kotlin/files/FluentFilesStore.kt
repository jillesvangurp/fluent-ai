package files

import com.jillesvangurp.fluentai.FluentFile
import components.LocalStoringStore
import kotlinx.serialization.builtins.ListSerializer

class FluentFilesStore : LocalStoringStore<List<FluentFile>>(emptyList(),"fluentfiles",
    ListSerializer(FluentFile.serializer())
)  {
    val addOrReplace = handle<FluentFile> { old, file ->
//        console.log("adding ${file.name}")
        old?.filter { it.name != file.name }.orEmpty() + file
    }
}
