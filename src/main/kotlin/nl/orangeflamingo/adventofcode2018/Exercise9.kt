package nl.orangeflamingo.adventofcode2018

class Exercise9(private val circularList: CircularList = CircularList()) {

    fun exercise(highestMarble: Int = 25, numberOfPlayers: Int = 9, scoresPerPlayer: MutableMap<Int, Long> = mutableMapOf()): Long {
        (1..highestMarble).forEach {
            val player = if (it % numberOfPlayers == 0) numberOfPlayers else it % numberOfPlayers

            val score = circularList.addMarble(it)

            val oldScore = scoresPerPlayer.getOrDefault(player, 0)

            scoresPerPlayer[player] = oldScore + score
        }

        val playerWithHighestScore = scoresPerPlayer.maxBy { it.value }

        return playerWithHighestScore!!.value
    }

    fun goldExercise(): Int {
        return 0
    }

    data class CircularList(val theList: MutableList<Int> = mutableListOf(0)) {

        private var currentIndex = 0

        fun addMarble(marbleValue: Int): Int {
            if (marbleValue % 23 == 0) {
                val indexMarbleToTake = getCircularIndex(currentIndex - 7)
                currentIndex = indexMarbleToTake
                val marbleToTake = theList[indexMarbleToTake]
                theList.removeAt(indexMarbleToTake)
                return marbleToTake + marbleValue
            }

            when {
                theList.size < 2 -> theList.add(marbleValue)
                theList.size == 2 -> {
                    currentIndex = 1
                    theList.add(currentIndex, marbleValue)
                }
                else -> {
                    // get index to insert
                    currentIndex += 2

                    currentIndex = getCircularIndex(currentIndex)

                    theList.add(currentIndex, marbleValue)
                }
            }
            return 0
        }

        private fun getCircularIndex(newIndex: Int): Int {
            if (newIndex >= 0) {
                if (newIndex >= theList.size) {
                    return newIndex % theList.size
                }
                return newIndex
            } else {
                return theList.size + newIndex
            }
        }
    }
}

fun main(args: Array<String>) {
    val exc9 = Exercise9()
    println("The answer to the silver exercise is ${exc9.exercise(71975, 416)}")
    println("The answer to the gold exercise is ${exc9.exercise(71975 * 100, 416)}")
}
