package com.softseed.redgreenrefactor

import org.junit.Assert.assertEquals
import org.junit.Test

class StringCalculatorTest {

    private val calculator = StringCalculator()

    @Test
    fun `빈 문자열은 0을 반환한다`() {
        assertEquals(0, calculator.add(""))
    }

    @Test
    fun `숫자가 하나면 그 숫자를 반환한다`() {
        assertEquals(1, calculator.add("1"))
    }

    @Test
    fun `쉼표로 구분된 두 숫자의 합을 반환한다`() {
        assertEquals(3, calculator.add("1,2"))
    }

    @Test
    fun `숫자 개수에 제한이 없다`() {
        assertEquals(15, calculator.add("1,2,3,4,5"))
    }

    @Test
    fun `줄바꿈도 구분자로 사용할 수 있다`() {
        assertEquals(6, calculator.add("1\n2,3"))
    }
}
