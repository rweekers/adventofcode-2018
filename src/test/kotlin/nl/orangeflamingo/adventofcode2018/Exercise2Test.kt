package nl.orangeflamingo.adventofcode2018

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise2Test {

    @Test
    fun `exercise 2 silver test`() {
        val exc2 = Exercise2("/two/test2-silver.txt")
        assertThat(exc2.silverExercise()).isEqualTo(12)
    }

    @Test
    fun `exercise 2 gold test`() {
        val exc2 = Exercise2("/two/test2-gold.txt")
        assertThat(exc2.goldExercise()).isEqualTo("fgij")
    }
}