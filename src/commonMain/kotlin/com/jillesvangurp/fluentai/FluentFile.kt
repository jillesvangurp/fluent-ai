package com.jillesvangurp.fluentai

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class FluentFile(val name: String, private var _content: String) {
    val content get() = _content

    @Transient
    private val fluentDefinitionRegex = Regex("""^\s*([a-zA-Z0-9_-]+)\s*=\s*(.*(\n[^#]\s+.*)*)""", RegexOption.MULTILINE)

    operator fun get(key: String): String? {
        return asMap()[key]
    }

    fun put(key: String, newValue: String) {
        asMap()[key]
        if (keys().contains(key)) {
            _content = fluentDefinitionRegex.replace(_content) { matchResult ->
                val id = matchResult.groupValues[1].trim()
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
        return fluentDefinitionRegex.findAll(_content).associate { it.groupValues[1].trim() to it.groupValues[2].trim() }
    }
}
