package nl.orangeflamingo.adventofcode2018

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise9Test {

    @Test
    fun `exercise 9 silver test`() {
        val exc9 = Exercise9("/nine/test9.txt")
        assertThat(exc9.silverExercise()).isEqualTo(0)
    }

    @Test
    fun `exercise 9 gold test`() {
        val exc9 = Exercise9("/nine/test9.txt")
        assertThat(exc9.goldExercise()).isEqualTo(0)
    }
}
