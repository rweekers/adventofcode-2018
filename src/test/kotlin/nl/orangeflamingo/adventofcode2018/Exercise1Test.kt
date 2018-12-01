package nl.orangeflamingo.adventofcode2018

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise1Test {

    @Test
    fun `exercise 1-1 silver test`() {
        val exc1 = Exercise1("/one/test1-1.txt")
        assertThat(exc1.silverExercise()).isEqualTo(3)
    }

    @Test
    fun `exercise 1-2 silver test`() {
        val exc1 = Exercise1("/one/test1-2.txt")
        assertThat(exc1.silverExercise()).isEqualTo(3)
    }

    @Test
    fun `exercise 1-3 silver test`() {
        val exc1 = Exercise1("/one/test1-3.txt")
        assertThat(exc1.silverExercise()).isEqualTo(0)
    }

    @Test
    fun `exercise 1-4 silver test`() {
        val exc1 = Exercise1("/one/test1-4.txt")
        assertThat(exc1.silverExercise()).isEqualTo(-6)
    }
}