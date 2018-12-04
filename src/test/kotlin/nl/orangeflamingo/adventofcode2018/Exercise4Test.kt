package nl.orangeflamingo.adventofcode2018

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise4Test {

    @Test
    fun `exercise 4 silver test`() {
        val exc4 = Exercise4("/four/test4.txt")
        assertThat(exc4.silverExercise()).isEqualTo(240)
    }

    @Test
    fun `exercise 4 gold test`() {
        val exc4 = Exercise4("/four/test4.txt")
        assertThat(exc4.goldExercise()).isEqualTo(4455)
    }
}
