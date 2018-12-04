package nl.orangeflamingo.adventofcode2018

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise5Test {

    @Test
    fun `exercise 5 silver test`() {
        val exc5 = Exercise5("/five/test5.txt")
        assertThat(exc5.silverExercise()).isEqualTo(0)
    }

    @Test
    fun `exercise 5 gold test`() {
        val exc5 = Exercise5("/five/test5.txt")
        assertThat(exc5.goldExercise()).isEqualTo(0)
    }
}
