package nl.orangeflamingo.adventofcode2018

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise7Test {

    @Test
    fun `exercise 7 silver test`() {
        val exc7 = Exercise7("/seven/test7.txt")
        assertThat(exc7.silverExercise()).isEqualTo("CABDFE")
    }

    @Test
    fun `exercise 7 gold test`() {
        val exc7 = Exercise7("/seven/test7.txt")
        assertThat(exc7.goldExercise()).isEqualTo(15)
    }
}
