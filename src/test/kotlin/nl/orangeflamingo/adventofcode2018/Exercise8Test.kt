package nl.orangeflamingo.adventofcode2018

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise8Test {

    @Test
    fun `exercise 8 silver test`() {
        val exc8 = Exercise8("/eight/test8.txt")
        assertThat(exc8.silverExercise()).isEqualTo(138)
    }

    @Test
    fun `exercise 8 gold test`() {
        val exc8 = Exercise8("/eight/test8.txt")
        assertThat(exc8.goldExercise()).isEqualTo(66)
    }
}
