package com.jillesvangurp.fluentai

import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldEndWith
import io.kotest.matchers.string.shouldStartWith
import kotlin.test.Test

class FluentFileTest {

    private val content = """
        # This is a comment
        foo = First line
             Second line
        # Another comment
        bar = Another value
    """.trimIndent()

    @Test
    fun shouldCorrectlyGetChunks() {
        val fluentFile = FluentFile("example.ftl", content)
        fluentFile["foo"]?.definition shouldStartWith  "First line"
        fluentFile["foo"]?.definition shouldEndWith   "Second line"
        fluentFile["bar"]?.definition shouldBe "Another value"
        fluentFile["baz"]?.definition shouldBe null
    }

    @Test
    fun shouldModifyWithPutAndDelete() {
        var fluentFile = FluentFile("example.ftl", content)
        val original = fluentFile.copy()
        listOf(fluentFile) shouldBe listOf(original)
        fluentFile = fluentFile.put("foo", "Updated value\n    Continued value", fluentFile["foo"]?.comment)
        listOf(fluentFile) shouldNotBe listOf(original)
        fluentFile.content shouldBe """
# Another comment
bar = Another value

# This is a comment
foo = Updated value
    Continued value
""".trimIndent()

        fluentFile = fluentFile.put("baz", "New value")
        fluentFile.content shouldBe """
# Another comment
bar = Another value

baz = New value

# This is a comment
foo = Updated value
    Continued value
""".trimIndent()

        fluentFile = fluentFile.delete("baz")
        fluentFile.content shouldBe """
# Another comment
bar = Another value

# This is a comment
foo = Updated value
    Continued value
""".trimIndent()

    }

    @Test
    fun shouldCorrectlyHandleComments() {
        val sample = """
            # Deutsch
            -brand = FORMATION

            # general

            general-back = ZURÜCK
            general-cancel = ABBRECHEN

        """.trimIndent()
        val fluentFile = FluentFile("example.ftl", sample)
        fluentFile["-brand"]?.comment shouldBe "# Deutsch\n"
        fluentFile["-brand"]?.definition shouldBe "FORMATION"
        fluentFile["general-back"]?.comment shouldBe "# general\n"
        fluentFile["general-back"]?.definition shouldBe "ZURÜCK"
        fluentFile["general-cancel"]?.definition shouldBe "ABBRECHEN"

    }

    @Test
    fun shouldListKeys() {
        val fluentFile = FluentFile("example.ftl", content)
        fluentFile.keys() shouldBe setOf("foo", "bar")
    }

    @Test
    fun shouldGroupByCommonPrefix() {
        val content ="""
            -brand = Fluent Translations AI

            # edge case with no -
            foo = bar
            common-cancel = Cancel
            common-clear = Clear
            common-confirm = OK
            common-filter-placeholder = Filter the list
            common-save = Save

            file-loader-drag-and-drop = Drag ftl files here to load them
            file-loader-load-own-ftls = Load ftl files for { -brand }

            language-select-select-language = Pick a language

            pages-editor = Edit Fluent Definitions
            pages-files = Manage Fluent Files
            pages-settings = Settings

            settings-open-ai-key = Set your OpenAI API Key (needed for translations)
            settings-translation-language = Configure source language for AI translations. Note, the language is matched against your ftl file name with some normalization. Defaults to en-US.

        """.trimIndent()
        val fluentFile = FluentFile("example.ftl", content)
        val grouped = fluentFile.asMap().groupByLargestPrefix()

        grouped.keys shouldHaveAtLeastSize 5
        grouped[""]!!.entries shouldHaveSize 1
        grouped["file-loader"]!!.entries shouldHaveSize 2
        grouped["pages"]!!.entries shouldHaveSize 3
        grouped.forEach { (prefix,map) ->
            map.keys.forEach {
                it shouldStartWith prefix
            }
        }
    }
}
