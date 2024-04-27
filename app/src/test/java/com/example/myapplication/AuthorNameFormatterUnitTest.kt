package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test

class AuthorNameFormatterUnitTest {
    private val formatter = AuthorNameFormatter()

    @Test
    fun `test surname should be the last name part and be uppercase and comma separated`() {
        assertEquals(
            "CARVALHO, Ricardo",
            formatter.formatted("Ricardo Carvalho")
        )
        assertEquals(
            "ANDRADE, Jeremias dos Santos",
            formatter.formatted("Jeremias dos Santos Andrade")
        )
    }

    @Test
    fun `test empty or blank input`() {
        assertEquals("", formatter.formatted(""))
        assertEquals("", formatter.formatted(" "))
    }

    @Test
    fun `test single name should be uppercase`() {
        assertEquals(
            "CARVALHO",
            formatter.formatted("Carvalho")
        )
    }

    @Test
    fun `test compound surname if contains at least three parts and last is kinship`() {
        assertEquals(
            "CARVALHO FILHO, Ricardo",
            formatter.formatted("Ricardo Carvalho Filho")
        )
        assertEquals(
            "FILHO, Ricardo",
            formatter.formatted("Ricardo Filho")
        )
        assertEquals(
            "FILHO",
            formatter.formatted("Filho")
        )
    }

    @Test
    fun `test surname prepositions should be lowercase`() {
        assertEquals(
            "CARVALHO, Ricardo de",
            formatter.formatted("Ricardo De Carvalho")
        )
        assertEquals(
            "DOS, Ricardo",
            formatter.formatted("Ricardo Dos")
        )
        assertEquals(
            "DAS",
            formatter.formatted("Das")
        )
        assertEquals(
            "FILHO, Das",
            formatter.formatted("Das Filho")
        )
        assertEquals(
            "NEVES FILHO, Das",
            formatter.formatted("Das Neves Filho")
        )
        assertEquals(
            "DE FILHO, José",
            formatter.formatted("José de Filho")
        )
    }

    // _TDD: surname should be the last name part and be uppercase and comma separated
        // _TDD: empty
        // _TDD: blank
        // TDD: all lowercase
        // TDD: all uppercase
    // _TDD: single name should be uppercase
    // _TDD: compound surname if contains at least three parts and last is kinship
        // _TDD: only two parts
        // _TDD: single
        // _TDD: two parts with preposition
        // _TDD: three parts with preposition
    // _TDD: surname prepositions should be lowercase
        // _TDD: single
}