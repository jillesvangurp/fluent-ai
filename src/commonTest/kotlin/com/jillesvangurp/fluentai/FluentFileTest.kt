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
    fun testGet() {
        val fluentFile = FluentFile("example.ftl", content)
        fluentFile.get("foo") shouldStartWith  "First line"
        fluentFile.get("foo") shouldEndWith   "Second line"
        fluentFile.get("bar") shouldBe "Another value"
        fluentFile.get("baz") shouldBe null
    }

    @Test
    fun testPut() {
        val fluentFile = FluentFile("example.ftl", content)
        val original = fluentFile.copy()
        listOf(fluentFile) shouldBe listOf(original)
        fluentFile.put("foo", "Updated value\n    Continued value")
        listOf(fluentFile) shouldNotBe listOf(original)
        fluentFile.content shouldBe """
            # This is a comment
            foo = Updated value
                Continued value
            # Another comment
            bar = Another value
        """.trimIndent()

        fluentFile.put("baz", "New value")
        fluentFile.content shouldBe """
            # This is a comment
            foo = Updated value
                Continued value
            # Another comment
            bar = Another value
            baz = New value
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
        fluentFile["-brand"] shouldBe "FORMATION"

    }

    @Test
    fun testKeys() {
        val fluentFile = FluentFile("example.ftl", content)
        fluentFile.keys() shouldBe setOf("foo", "bar")
    }

    @Test
    fun testEntries() {
        val fluentFile = FluentFile("example.ftl", content)
        fluentFile.asMap() shouldBe mapOf(
            "foo" to "First line\n     Second line",
            "bar" to "Another value"
        )
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
        val grouped = fluentFile.groupByLargestPrefix()
//        console.log(grouped.keys.joinToString(","))

//        grouped.forEach {(pre,map) ->
//            map.forEach { (id,  value) ->
//                println("$pre: $id")
//            }
//        }

        grouped.keys shouldHaveAtLeastSize 5
        grouped[""]!!.entries shouldHaveSize 3
        grouped["file-loader"]!!.entries shouldHaveSize 2
        grouped["pages"]!!.entries shouldHaveSize 3
        grouped.forEach { (prefix,map) ->
            map.keys.forEach {
                it shouldStartWith prefix
            }
        }
    }
}
