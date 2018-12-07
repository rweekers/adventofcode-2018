package nl.orangeflamingo.adventofcode2018

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise6Test {

    @Test
    fun `exercise 6 silver test`() {
        val exc6 = Exercise6("/six/test6.txt")
        assertThat(exc6.silverExercise()).isEqualTo(17)
    }

    @Test
    fun `exercise 6 gold test`() {
        val exc6 = Exercise6("/six/test6.txt")
        assertThat(exc6.goldExercise(32)).isEqualTo(16)
    }
}
