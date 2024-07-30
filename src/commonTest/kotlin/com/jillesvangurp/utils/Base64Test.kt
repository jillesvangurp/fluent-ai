package com.jillesvangurp.utils

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class Base64EncoderDecoderTest {

    @Test
    fun testEncodeBase64() {
        val input = "Hello, World!"
        val expectedEncoded = "SGVsbG8sIFdvcmxkIQ=="
        val actualEncoded = input.encodeBase64()
        actualEncoded shouldBe expectedEncoded
    }

    @Test
    fun testDecodeBase64() {
        val encoded = "SGVsbG8sIFdvcmxkIQ=="
        val expectedDecoded = "Hello, World!"
        val actualDecoded = encoded.decodeBase64()
        actualDecoded shouldBe expectedDecoded
    }

    @Test
    fun testEncodeDecodeBase64() {
        val input = "Kotlin Multiplatform"
        val encoded = input.encodeBase64()
        val decoded = encoded.decodeBase64()
        decoded shouldBe input
    }

    @Test
    fun testEmptyString() {
        val input = ""
        val encoded = input.encodeBase64()
        val decoded = encoded.decodeBase64()
        encoded shouldBe ""
        decoded shouldBe ""
    }

    @Test
    fun testPadding() {
        val input1 = "A"
        val encoded1 = input1.encodeBase64()
        val decoded1 = encoded1.decodeBase64()
        encoded1 shouldBe "QQ=="
        decoded1 shouldBe input1

        val input2 = "AB"
        val encoded2 = input2.encodeBase64()
        val decoded2 = encoded2.decodeBase64()
        encoded2 shouldBe "QUI="
        decoded2 shouldBe input2
    }

    @Test
    fun test4ByteEmojis() {
        val emojiString = "\uD83D\uDCA9\uD83D\uDE00\uD83D\uDE02"  // poo emoji, grinning face, and face with tears of joy
        val encoded = emojiString.encodeBase64()
        encoded shouldBe "8J+SqfCfmIDwn5iC"
        val decoded = encoded.decodeBase64()
        decoded shouldBe emojiString
    }
}
