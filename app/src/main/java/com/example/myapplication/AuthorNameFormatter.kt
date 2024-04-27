package com.example.myapplication

class AuthorNameFormatter {
    fun formatted(name: String) =
        name.split(" ")
            .reversed()
            .mapIndexed { index, namePart ->
                if (index == 0) namePart.uppercase()
                else namePart
            }.joinToString()
}