package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test

class AuthorNameFormatterTest {
    @Test
    fun `test surname should be uppercase and comma separated from name`() {
        val formatter = AuthorNameFormatter()
        val formattedName = formatter.format("Ricardo Carvalho")
        assertEquals("CARVALHO, Ricardo", formattedName)

        val formattedName2 = formatter.format("José Carvalho")
        assertEquals("CARVALHO, José", formattedName2)
    }

    @Test
    fun `test single word should be uppercase`() {
        val formatter = AuthorNameFormatter()
        val formattedName = formatter.format("Carvalho")
        assertEquals("CARVALHO", formattedName)
    }

    // _TDD: surname should be uppercase and comma separated from name
        // TDD: remover reversed
    // _TDD: single word should be uppercase
    // TDD: kinship like should be compound when at least three words
    // TDD: name remainder words should be capitalized
    // TDD: surname prepositions should be lowercase
}