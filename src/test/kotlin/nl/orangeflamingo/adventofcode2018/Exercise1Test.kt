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
        val exc1 = Exercise1("/one/test1-2-silver.txt")
        assertThat(exc1.silverExercise()).isEqualTo(3)
    }

    @Test
    fun `exercise 1-3 silver test`() {
        val exc1 = Exercise1("/one/test1-3-silver.txt")
        assertThat(exc1.silverExercise()).isEqualTo(0)
    }

    @Test
    fun `exercise 1-4 silver test`() {
        val exc1 = Exercise1("/one/test1-4-silver.txt")
        assertThat(exc1.silverExercise()).isEqualTo(-6)
    }

    @Test
    fun `exercise 1-1 gold test`() {
        val exc1 = Exercise1("/one/test1-1.txt")
        assertThat(exc1.goldExercise()).isEqualTo(2)
    }

    @Test
    fun `exercise 1-2 gold test`() {
        val exc1 = Exercise1("/one/test1-2-gold.txt")
        assertThat(exc1.goldExercise()).isEqualTo(0)
    }

    @Test
    fun `exercise 1-3 gold test`() {
        val exc1 = Exercise1("/one/test1-3-gold.txt")
        assertThat(exc1.goldExercise()).isEqualTo(10)
    }

    @Test
    fun `exercise 1-4 gold test`() {
        val exc1 = Exercise1("/one/test1-4-gold.txt")
        assertThat(exc1.goldExercise()).isEqualTo(5)
    }

    @Test
    fun `exercise 1-5 gold test`() {
        val exc1 = Exercise1("/one/test1-5-gold.txt")
        assertThat(exc1.goldExercise()).isEqualTo(14)
    }
}