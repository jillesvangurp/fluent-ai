package com.jillesvangurp.fluentai

import kotlin.test.Test

class FluentParserTest {
    val sample ="""
        # Deutsch
        -brand = Fluent AI
        
        # Some comment
        
        # Comment continues
        a-key-bb = value
        a-key-aa = value
        
        # multi line
        general-you = { ${'$'}case ->
            *[nominative] du
             [genitive] deiner
             [dative] dir
             [accusative] dich
        }
        
        # it continues
        foo = bar
        
        # trailing comment should be omitted
    """.trimIndent()

    @Test
    fun shouldParseSomeFluent() {
        val chunks = sample.parseFluent()
        chunks.forEachIndexed { index, chunk ->
            println("""
-----------------
chunk $index

comment: 
${chunk.comment}
id: ${chunk.id}
definition: ${chunk.definition}
""".trimIndent())
        }
    }
}
