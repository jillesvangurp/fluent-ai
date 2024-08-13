package com.jillesvangurp.fluentai

import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldEndWith
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
        # card secondary menu
        cardsecondarymenu-duplicate = Duplizieren
        cardsecondarymenu-duplicate-this = { ${'$'}case ->
           *[masculine] Dupliziere diesen {${'$'}objectType}
            [feminine] Dupliziere diese {${'$'}objectType}
            [other] Dupliziere dieses {${'$'}objectType}
        }
        cardsecondarymenu-details = Informationen
        cardsecondarymenu-show-details = { ${'$'}case ->
            *[masculine] Details zu diesem {${'$'}objectType}
             [feminine] Datails zu dieser {${'$'}objectType}
             [other] Details zu diesem {${'$'}objectType}
        }
        cardsecondarymenu-share = Teilen
        cardsecondarymenu-share-this = { ${'$'}case ->
           *[masculine] Teile diesen {${'$'}objectType}
            [feminine] Teile diese {${'$'}objectType}
            [other] Teile dieses {${'$'}objectType}
        }
        
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

        val chunkMap = chunks.associateBy { it.id }
        val definition = chunkMap["general-you"]?.definition!!.trim('\n')
        definition.shouldEndWith("}")


    }

    @Test
    fun shouldParseChunkUsingRegex() {
        val sample = """
cardsecondarymenu-duplicate-this = { ${'$'}case ->
   *[masculine] Dupliziere diesen {${'$'}objectType}
    [feminine] Dupliziere diese {${'$'}objectType}
    [other] Dupliziere dieses {${'$'}objectType}
}
cardsecondarymenu-share-this = { ${'$'}case ->
   *[masculine] Teile diesen {${'$'}objectType}
    [feminine] Teile diese {${'$'}objectType}
    [other] Teile dieses {${'$'}objectType}
}

# trailing comment should be omitted
            
        """

        val chunk = sample.parseFluent().first()

        chunk.definition shouldBe """{ ${'$'}case ->
   *[masculine] Dupliziere diesen {${'$'}objectType}
    [feminine] Dupliziere diese {${'$'}objectType}
    [other] Dupliziere dieses {${'$'}objectType}
}
"""
    }
}
