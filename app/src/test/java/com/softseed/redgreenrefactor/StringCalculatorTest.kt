package com.softseed.redgreenrefactor

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
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

    @Test
    fun `음수가 입력되면 예외처리를 한다`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            calculator.add("-1,-2")
        }
        assertTrue("예외 메시지에 -2가 없습니다. 실제 메시지: ${exception.message}",
            exception.message.orEmpty().contains("-2"))
    }
}
