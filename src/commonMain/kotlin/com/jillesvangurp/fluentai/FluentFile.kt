package com.jillesvangurp.fluentai

import kotlin.math.max
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class FluentFile(val name: String, private var _content: String) {
    val content get() = _content

    @Transient
    private val fluentDefinitionRegex =
        Regex("""^\s*([a-zA-Z0-9_-]+)\s*=\s*(.*(\n[^#]\s+.*)*)""", RegexOption.MULTILINE)

    operator fun get(key: String): String? {
        return asMap()[key]
    }

    fun put(key: String, newValue: String) {
        asMap()[key]
        if (keys().contains(key)) {
            _content = fluentDefinitionRegex.replace(_content) { matchResult ->
                val id = matchResult.groupValues[1].trim()
                if (id == key) {
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
        return fluentDefinitionRegex.findAll(_content)
            .associate { it.groupValues[1].trim() to it.groupValues[2].trim() }
    }

    fun matches(language: String): Boolean {
        val normalized = name.lowercase().replace(".ftl", "").replace("_", "-")
        return normalized.contains(language.lowercase().replace(".ftl", "").replace("_", "-"))
    }

    fun groupByLargestPrefix(): Map<String, Map<String, String>> {
        val map = asMap()

        val prefixes = map.keys.groupIdsByLargestPrefix()

        return prefixes.map { (p, idList) ->
            val es = map.entries.filter { (id, value) -> id in idList }
            p to es.associate { (k, v) -> k to v }
        }.toMap()
    }

}

fun Iterable<String>.groupIdsByLargestPrefix(): MutableMap<String, MutableList<String>> {
    val keys = this.toMutableSet()

    val prefixes = mutableMapOf<String, MutableList<String>>()
    while (keys.isNotEmpty()) {
        val current = keys.first()
        if (current.startsWith("-")) {
            if ("" !in prefixes) {
                prefixes[""] = mutableListOf()
            }
            prefixes[""]!!.add(current)
            keys.remove(current)
        } else {
            val splitted = current.split("-")
            var end = splitted.size - 1
            var prefix = ""
            var found = if (splitted.size == 1) {
                listOf(current)
            } else {
                emptyList()
            }
            while (end > 0 && found.size <= 1) {
                prefix = splitted.subList(0, end).joinToString("-")
                found = keys.filter {
                    if (prefix.isBlank()) {
                        it == current
                    } else {
                        it.startsWith(prefix)
                    }
                }
                end--
            }
            keys -= found.toSet()
            if (found.size == 1) {
                prefix = ""
            }
            if (prefix !in prefixes) {
                prefixes[prefix] = mutableListOf()
            }
            prefixes[prefix]!!.addAll(found)
        }
    }
    return prefixes
}
