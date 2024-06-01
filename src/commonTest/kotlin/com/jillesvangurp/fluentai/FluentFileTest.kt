package com.jillesvangurp.fluentai

import kotlin.test.Test
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldEndWith
import io.kotest.matchers.string.shouldStartWith

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
        fluentFile.put("foo", "Updated value\n    Continued value")
        fluentFile.content shouldBe """
            # This is a comment
            foo = Updated value
                Continued value
            # Another comment
            bar = Another value
        """.trimIndent()

//        fluentFile.put("baz", "New value")
//        fluentFile.content shouldBe """
//            # This is a comment
//            foo = Updated value
//                Continued value
//            # Another comment
//            bar = Another value
//            baz = New value
//        """.trimIndent()
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
}
