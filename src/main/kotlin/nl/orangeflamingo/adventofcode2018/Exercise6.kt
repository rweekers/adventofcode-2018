package nl.orangeflamingo.adventofcode2018

class Exercise6(input: String) {

    private val inputList: List<String> = resourceAsListOfString(input)
    private val coordinates = parseInput(inputList)


    fun silverExercise(): Int {
        coordinates.forEach { println(it) }

        // Check boundaries
        val smallestX = coordinates.map { it.x }.min()!!
        val smallestY = coordinates.map { it.y }.min()!!
        val biggestX = coordinates.map { it.x }.max()!!
        val biggestY = coordinates.map { it.y }.max()!!

        // generate a list of coordinates between boundaries
        val grid = mutableListOf<Coordinate>()
        (smallestX..biggestX).forEach { x -> (smallestY..biggestY).forEach { y -> grid.add(Coordinate(x, y)) } }

        return 0
    }

    private fun parseInput(input: List<String>): List<Coordinate> =
            input.map {
                it.split(",")
                        .let { input -> Coordinate(input[0].trim().toInt(), input[1].trim().toInt()) }
            }

    fun goldExercise(): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val exc6 = Exercise6("/input6.txt")
    println("The answer to the silver exercise is ${exc6.silverExercise()}")
    println("The answer to the gold exercise is ${exc6.goldExercise()}")
}
