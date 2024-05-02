package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test

class AuthorNameFormatterTest {
    private val formatter = AuthorNameFormatter()

    @Test
    fun `test surname should be uppercase and comma separated from name`() {
        assertEquals(
            "CARVALHO, Ricardo",
            formatter.format("Ricardo Carvalho")
        )
        assertEquals(
            "CARVALHO, José",
            formatter.format("José Carvalho")
        )
    }

    @Test
    fun `test single word should be uppercase`() {
        assertEquals(
            "CARVALHO",
            formatter.format("Carvalho")
        )
    }

    @Test
    fun `test empty input should result in empty`() {
        assertEquals("", formatter.format(""))
    }

    // _TDD: surname should be uppercase and comma separated from name
        // TDD: remover reversed
        // _TDD: empty
    // _TDD: single word should be uppercase
    // TDD: kinship like should be compound when at least three words
    // TDD: name remainder words should be capitalized
    // TDD: surname prepositions should be lowercase
}