package com.example.myapplication

class AuthorNameFormatter {
    fun format(fullName: String): String =
        fullName.split(" ")
            .reversed()
            .mapIndexed { index, namePart ->
                if (index == 0) namePart.uppercase()
                else namePart
            }
            .joinToString()
}
