package nl.orangeflamingo.adventofcode2018

class Exercise6(input: String) {

    private val inputList: List<String> = resourceAsListOfString(input)
    private val coordinates = parseInput(inputList)
    private val gridSizePerCoordinate = mutableMapOf<Coordinate, Int>()


    fun silverExercise(): Int {
        // Check boundaries
        val smallestX = coordinates.map { it.x }.min()!!
        val smallestY = coordinates.map { it.y }.min()!!
        val biggestX = coordinates.map { it.x }.max()!!
        val biggestY = coordinates.map { it.y }.max()!!

        // loop over a virtual grid of coordinates between boundaries
        (smallestX + 1..biggestX).forEach { x ->
            (smallestY + 1..biggestY).forEach { y ->
                val gridCoordinate = Coordinate(x, y)
                val mapOfDistances = mutableMapOf<Coordinate, Int>()
                coordinates.forEach {
                    val distance = it.manhattanDistance(gridCoordinate)
                    mapOfDistances[it] = distance
                }
                // check if single smallest distance is there
                val smallestDistance = mapOfDistances.entries.reduce { acc, curr -> if (curr.value < acc.value) curr else acc }
                if (mapOfDistances.values.filter { it == smallestDistance.value }.size > 1) {
                    // Multiple coordinates are close, skip this
                } else {
                    val valueToSet = gridSizePerCoordinate.getOrDefault(smallestDistance.key, 0) + 1
                    gridSizePerCoordinate.put(smallestDistance.key, valueToSet)
                }
            }
        }

        return gridSizePerCoordinate.maxBy { it.value }!!.value
    }

    private fun parseInput(input: List<String>): List<Coordinate> =
            input.map {
                it.split(",")
                        .let { input -> Coordinate(input[0].trim().toInt(), input[1].trim().toInt()) }
            }

    fun goldExercise(boundary: Int): Int {
        // Check boundaries
        val smallestX = coordinates.map { it.x }.min()!!
        val smallestY = coordinates.map { it.y }.min()!!
        val biggestX = coordinates.map { it.x }.max()!!
        val biggestY = coordinates.map { it.y }.max()!!

        var bla = 0

        // loop over a virtual grid of coordinates between boundaries
        (smallestX + 1..biggestX).forEach { x ->
            (smallestY + 1..biggestY).forEach { y ->
                val totalDistance = coordinates.map { Coordinate(x, y).manhattanDistance(it) }.reduce { acc, curr ->
                    acc + curr
                }
                if (totalDistance < boundary) {//32) {
                    bla++
                }
            }
        }
        return bla
    }
}

fun main(args: Array<String>) {
    val exc6 = Exercise6("/input6.txt")
    println("The answer to the silver exercise is ${exc6.silverExercise()}")
    println("The answer to the gold exercise is ${exc6.goldExercise(10000)}")
}
