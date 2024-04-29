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
                val lastNames = takeLast(lastNameAmountConsideringKinshipLike())
                listOfNotNull(
                    lastNames.rejoinNameWords()?.uppercase(),
                    dropLast(lastNames.count()).ensureCorrectCases().rejoinNameWords()
                )
            }
            .joinToString()

    private fun List<String>.lastNameAmountConsideringKinshipLike() =
        if (count() < 3) 1
        else foldRight(1) { nameWord, amount ->
            if (nameWord.lowercase() in KINSHIP_LIKE) amount + 1
            else return amount
        }

    private fun List<String>.rejoinNameWords() = joinToString(" ").takeUnless(String::isEmpty)

    private fun List<String>.ensureCorrectCases(): List<String> = mapIndexed { index, nameWord ->
        nameWord.lowercase().takeIf {
            index != 0 && it in PREPOSITIONS
        } ?: nameWord.lowercase().replaceFirstChar {
            it.titlecase()
        }
    }
}