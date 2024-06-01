package com.jillesvangurp.fluentai

data class FluentFile(val name: String, private var _content: String) {
    val content get() = _content

    private val regex = Regex("""^\s*([a-zA-Z0-9_-]+)\s*=\s*(.*(\n\s+.*)*)""", RegexOption.MULTILINE)

    fun get(key: String): String? {
        return asMap().get(key)
    }

    fun put(key: String, newValue: String) {
        if (regex.containsMatchIn(_content)) {
            _content = regex.replace(_content) { matchResult ->
                val id = matchResult.groupValues[1]
                console.log(id)
                if (id == key) {
                    console.log("replacing $newValue on $id")
                    "$key = $newValue"
                } else {
                    matchResult.value
                }
            }
        } else {
            _content += "\n$key = $newValue"
        }
    }

    fun keys(): Set<String> {
        return asMap().keys
    }

    fun asMap(): Map<String, String> {
        return regex.findAll(_content).associate { it.groupValues[1] to it.groupValues[2].trim() }
    }
}
