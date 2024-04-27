package com.example.myapplication

class AuthorNameFormatter {
    companion object {
        private val KINSHIP_NAME_PARTS = listOf(
            "filho",
            "filha",
            "neto",
            "neta",
            "sobrinho",
            "sobrinha",
            "junior",
        )
    }

    fun formatted(name: String) =
        name.trim()
            .split(" ")
            .run {
                var stopOnNext = false
                val lastNames = takeLastWhile {
                    !stopOnNext.also { _ ->
                        if (it.lowercase() !in KINSHIP_NAME_PARTS) stopOnNext = true
                    }
                }
                listOfNotNull(
                    lastNames
                        .joinToString(" ")
                        .takeUnless(String::isEmpty),
                    dropLast(lastNames.count())
                        .joinToString(" ")
                        .takeUnless(String::isEmpty)
                )
            }
            .mapIndexed { index, namePart ->
                if (index == 0) namePart.uppercase()
                else namePart
            }.joinToString()
}