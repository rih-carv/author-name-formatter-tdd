package com.example.myapplication

class AuthorNameFormatter {
    fun formatted(name: String) =
        name.trim()
            .split(" ")
            .let {
                listOfNotNull(
                    it.lastOrNull(),
                    it.dropLast(1)
                        .joinToString(" ")
                        .takeUnless(String::isEmpty)
                )
            }
            .mapIndexed { index, namePart ->
                if (index == 0) namePart.uppercase()
                else namePart
            }.joinToString()
}