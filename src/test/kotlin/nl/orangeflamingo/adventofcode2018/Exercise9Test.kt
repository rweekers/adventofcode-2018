package nl.orangeflamingo.adventofcode2018

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise9Test {

    private val exc9 = Exercise9()

    @Test
    fun `exercise 9-1 silver test`() {
        assertThat(exc9.exercise()).isEqualTo(32)
    }

    @Test
    fun `exercise 9-2 silver test`() {
        assertThat(exc9.exercise(1618, 10)).isEqualTo(8317)
    }

    @Test
    fun `exercise 9-3 silver test`() {
        assertThat(exc9.exercise(7999, 13)).isEqualTo(146373)
    }

    @Test
    fun `exercise 9-4 silver test`() {
        assertThat(exc9.exercise(1104, 17)).isEqualTo(2764)
    }

    @Test
    fun `exercise 9-5 silver test`() {
        assertThat(exc9.exercise(6111, 21)).isEqualTo(54718)
    }

    @Test
    fun `exercise 9-6 silver test`() {
        assertThat(exc9.exercise(5807, 30)).isEqualTo(37305)
    }
}
