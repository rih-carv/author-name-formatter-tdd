package com.example.myapplication

class AuthorNameFormatter {
    companion object {
        private val KINSHIP_LIKE = listOf(
            "filho",
            "filha",
            "neto",
            "neta",
            "sobrinho",
            "sobrinha",
            "junior",
        )

        private val PREPOSITIONS = listOf(
            "da",
            "de",
            "do",
            "das",
            "dos"
        )
    }

    fun formatted(name: String) =
        name.trim()
            .split(" ")
            .run {
                var stopOnNext = false
                val lastNames = takeLastWhile {
                    !stopOnNext.also { _ ->
                        if (count() < 3) stopOnNext = true
                        if (it.lowercase() !in KINSHIP_LIKE) stopOnNext = true
                    }
                }
                listOfNotNull(
                    lastNames
                        .joinToString(" ")
                        .takeUnless(String::isEmpty),
                    dropLast(lastNames.count())
                        .joinToString(" ") { nameWord ->
                            nameWord.lowercase().takeIf {
                                it in PREPOSITIONS
                            } ?: nameWord
                        }
                        .takeUnless(String::isEmpty)
                )
            }
            .mapIndexed { index, namePart ->
                if (index == 0) namePart.uppercase()
                else namePart
            }.joinToString()
}