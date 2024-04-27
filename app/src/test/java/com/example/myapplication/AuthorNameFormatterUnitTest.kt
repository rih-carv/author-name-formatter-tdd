package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test

class AuthorNameFormatterUnitTest {
    @Test
    fun testSurnameShouldBeTheLastNamePartAndBeUppercaseAndCommaSeparated() {
        val formatter = AuthorNameFormatter()
        val formattedName = formatter.formatted("Ricardo Carvalho")
        assertEquals("CARVALHO, Ricardo", formattedName)
    }

    // _TDD: surname should be the last name part and be uppercase and comma separated
        // TDD: empty
        // TDD: all underscore
        // TDD: all upperscore
    // TDD: single name should be uppercase
    // TDD: compound surname if contains at least three parts and last is kinship
    // TDD: surname prepositions should be lowercase
}