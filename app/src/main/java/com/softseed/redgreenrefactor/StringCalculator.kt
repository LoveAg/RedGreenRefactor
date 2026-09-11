package com.softseed.redgreenrefactor

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0
        val parsed = parseNumbers(numbers)

        val negatives = parsed.filter { it < 0 }
        require(negatives.isEmpty()) { "음수는 허용되지 않습니다: $negatives" }
        return parsed.sum()
    }

    private fun parseNumbers(numbers: String): List<Int> =
        numbers.split(*DELIMITERS).map { it.toInt() }

    private companion object {
        val DELIMITERS = arrayOf(",", "\n")
    }
}
