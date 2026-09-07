package com.softseed.redgreenrefactor

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0
        return parseNumbers(numbers).sum()
    }

    private fun parseNumbers(numbers: String): List<Int> =
        numbers.split(*DELIMITERS).map { it.toInt() }

    private companion object {
        val DELIMITERS = arrayOf(",", "\n")
    }
}
