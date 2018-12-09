package nl.orangeflamingo.adventofcode2018

import java.util.*

class Exercise9(private val circularList: CircularList = CircularList()) {

    fun exercise(highestMarble: Int = 25, numberOfPlayers: Int = 9): Long {
        val scores = LongArray(numberOfPlayers)

        (1..highestMarble).forEach {
            val player = it % numberOfPlayers
            val score = circularList.addMarble(it)

            scores[player] += score
        }
        return scores.max()!!
    }

    data class CircularList(val theList: ArrayDeque<Int> = ArrayDeque()) {
        init {
            theList.addFirst(0)
        }

        fun addMarble(marbleValue: Int): Long {
            return if (marbleValue % 23 == 0) {
                (0 until 7 - 1).forEach { _ ->
                    theList.addLast(theList.remove())
                }
                theList.pop().toLong() + marbleValue
            } else {
                // move two ahead
                (0 until 2).forEach { _ ->
                    theList.addFirst(theList.removeLast())
                }
                theList.addLast(marbleValue)
                0
            }
        }
    }
}

fun main(args: Array<String>) {
    val exc9 = Exercise9()
    println("The answer to the silver exercise is ${exc9.exercise(71975, 416)}")
    println("The answer to the gold exercise is ${exc9.exercise(71975 * 100, 416)}")
}
