package nl.orangeflamingo.adventofcode2018

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise3Test {

    @Test
    fun `exercise 3 silver test`() {
        val exc3 = Exercise3("/three/test3.txt")
        assertThat(exc3.silverExercise()).isEqualTo(4)
    }

    @Test
    fun `exercise 3 gold test`() {
        val exc3 = Exercise3("/three/test3.txt")
        assertThat(exc3.goldExercise()).isEqualTo(3)
    }
}