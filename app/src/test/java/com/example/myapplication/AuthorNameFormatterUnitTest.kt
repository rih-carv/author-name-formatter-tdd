package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test

class AuthorNameFormatterUnitTest {
    private val formatter = AuthorNameFormatter()

    @Test
    fun `test surname should be the last name part and be uppercase and comma separated`() {
        assertEquals("CARVALHO, Ricardo", formatter.formatted("Ricardo Carvalho"))
        assertEquals("ANDRADE, Jeremias dos Santos", formatter.formatted("Jeremias dos Santos Andrade"))
    }

    @Test
    fun `test empty or blank input`() {
        assertEquals("", formatter.formatted(""))
        assertEquals("", formatter.formatted(" "))
    }

    @Test
    fun `test single name should be uppercase`() {
        val formattedName = formatter.formatted("Carvalho")
        assertEquals("CARVALHO", formattedName)
    }

    // _TDD: surname should be the last name part and be uppercase and comma separated
        // _TDD: empty
        // _TDD: blank
        // TDD: all underscore
        // TDD: all upperscore
    // _TDD: single name should be uppercase
    // TDD: compound surname if contains at least three parts and last is kinship
    // TDD: surname prepositions should be lowercase
}