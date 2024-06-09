package com.jillesvangurp.fluentai

import kotlinx.serialization.Serializable

private val fluentDefinitionRegex =
    Regex("""^\s*([a-zA-Z0-9_-]+)\s*=\s*(.*(\n[^#]\s+.*)*)""", RegexOption.MULTILINE)

data class FluentChunk( val comment: String?, val id: String, val definition: String) {
    override fun toString(): String {
        return "$comment\n$id = $definition\n"
    }
}

@Serializable
data class FluentFile(val name: String, val content: String) {

    val chunks by lazy {
        content.parseFluent()
    }

    operator fun get(key: String): FluentChunk? {
        return asMap()[key]
    }

    fun put(key: String, newValue: String, comment: String? = null): FluentFile {
        val map = asMap().toMutableMap()

        map[key] = FluentChunk(comment.orEmpty(),key,newValue)

        return FluentFile(name, map.sortedContent())
    }

    fun delete(key: String): FluentFile {
        return FluentFile(name, asMap().filter { it.key != key }.sortedContent())
    }

    fun keys(): Set<String> {
        return asMap().keys
    }

    fun asMap(): Map<String, FluentChunk> {
        return chunks.associateBy { it.id }
    }

    fun matches(language: String): Boolean {
        val normalized = name.lowercase().replace(".ftl", "").replace("_", "-")
        return normalized.contains(language.lowercase().replace(".ftl", "").replace("_", "-"))
    }
}

fun Map<String,FluentChunk>.sortedContent(): String {
    val grouped = groupByLargestPrefix()
    val newContent = grouped.entries.sortedBy { it.key }.map { (_,group) ->
        group.values.map {
            "${it.comment.orEmpty()}${it.id} = ${it.definition}"
        }.joinToString("\n")
    }.joinToString("\n\n")

    return newContent
}

fun Map<String, FluentChunk>.groupByLargestPrefix(): Map<String, Map<String, FluentChunk>> {
    val prefixes = keys.groupIdsByLargestPrefix()

    return prefixes.map { (p, idList) ->
        val es = entries.filter { (id, value) -> id in idList }
        p to es.associate { (k, v) -> k to v }
    }.toMap()
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
                prefix = found.first()
            }
            if (prefix !in prefixes) {
                prefixes[prefix] = mutableListOf()
            }
            prefixes[prefix]!!.addAll(found)
        }
    }
    return prefixes
}

fun String.parseFluent(): List<FluentChunk> {
    val chunks = mutableListOf<String>()
    val chunkLines = mutableListOf<String>()
    var inDefinition = true
    lines().forEach {line ->
        if(inDefinition && line.startsWith("#")) {
            // end of current definition
            if(chunkLines.isNotEmpty()) {
                chunks.add(chunkLines.joinToString("\n"))
                chunkLines.clear()
            }
            inDefinition = false
        }
        if(line.matches(Regex("^\\s*([a-zA-Z0-9_-]+)\\s*=.*"))) {
            if(inDefinition) {
                chunks.add(chunkLines.joinToString("\n"))
                chunkLines.clear()
            }
            inDefinition = true
        }
        chunkLines.add(line)
    }
    if(chunkLines.isNotEmpty()) {
        chunks.add(chunkLines.joinToString("\n"))
    }

    return chunks.mapNotNull { chunk ->
        fluentDefinitionRegex.find(chunk)?.let {match ->
            match.groups[1]?.let {idMatch ->
                val start = match.range.first
                val comment = chunk.substring(0,start).takeIf { it.isNotBlank() }
                val id = idMatch.value
                val definition = match.groups[2]?.value
                FluentChunk(comment=comment,id=id,definition=definition.orEmpty())
            }
        }
    }
}

fun List<FluentFile>.missingTranslations(preferred: FluentFile): Map<String, Int> {
    val others = filter { it.name != preferred.name }
    return preferred.keys().map { key ->
        val source = preferred[key]?: error("key should have definition")
        key to others.mapNotNull {
            it[key]?.takeIf { it.definition != source.definition }
        }.size.let { others.size - it }
    }.toMap()
}

fun List<FluentFile>.master(masterLanguage: String) = firstOrNull { it.matches(masterLanguage) }

fun List<FluentFile>.cleanupTranslations(masterLanguage: String): List<FluentFile> {
    return master(masterLanguage)?.let { master ->
        (filter { it.name != master.name }.map { file ->
            val cleaned = file.asMap().entries.filter {(id,chunk) ->
                master[id]?.definition != chunk.definition && chunk.definition.isNotBlank()
            }.map { it.value }
            FluentFile(file.name, cleaned.associateBy { it.id }.sortedContent())
        } + master).sortedBy { it.name }
    }?: this
}
