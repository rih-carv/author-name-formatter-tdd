package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test

class AuthorNameFormatterUnitTest {
    private val formatter = AuthorNameFormatter()

    @Test
    fun testSurnameShouldBeTheLastNamePartAndBeUppercaseAndCommaSeparated() {
        val formattedName = formatter.formatted("Ricardo Carvalho")
        assertEquals("CARVALHO, Ricardo", formattedName)
    }

    @Test
    fun testEmptyOrBlankInput() {
        assertEquals("", formatter.formatted(""))
        assertEquals("", formatter.formatted(" "))
    }

    @Test
    fun testSingleNameShouldBeUppercase() {
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