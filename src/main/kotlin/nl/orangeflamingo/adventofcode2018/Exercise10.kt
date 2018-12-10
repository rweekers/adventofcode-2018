package nl.orangeflamingo.adventofcode2018

import kotlin.math.absoluteValue

class Exercise10(input: String) {

    private val inputList: List<String> = resourceAsListOfString(input)
    private val lightPointList: MutableList<LightPoint> = mutableListOf()

    fun exercise(secondsToRun: Int = 3): Int {
        val regExp = """[-]?\d+""".toRegex()
        inputList.forEach { line ->
            val parts = regExp.findAll(line).toList().map { it.value }
            val coordinate = Coordinate(parts[0].toInt(), parts[1].toInt())
            val velocity = Velocity(parts[2].toInt(), parts[3].toInt())
            val lightPoint = LightPoint(coordinate, velocity)
            lightPointList.add(lightPoint)
        }
        printLightPoints(0)
        (1..secondsToRun).forEach { seconds ->
            lightPointList.forEach { it.move() }
            printLightPoints(seconds)
        }
        return 0
    }

    private fun printLightPoints(seconds: Int) {

        val smallestX = lightPointList.minBy { it.coordinate.x }!!.coordinate.x
        val smallestY = lightPointList.minBy { it.coordinate.y }!!.coordinate.y

        val biggestX = lightPointList.maxBy { it.coordinate.x }!!.coordinate.x
        val biggestY = lightPointList.maxBy { it.coordinate.y }!!.coordinate.y

        // stop when points are too far apart
        val totalWidth = (biggestX - smallestX).absoluteValue
        val totalHeight = (biggestY - smallestY).absoluteValue

        if (totalWidth > 64) return
        if (totalHeight > 64) return

        // keep an edge of one around for readability
        (smallestY - 1..biggestY + 1).forEach { y ->
            (smallestX - 1..biggestX + 1).forEach { x ->
                if (lightPointList.map { it.coordinate.x to it.coordinate.y }.contains(x to y)) {
                    print("#")
                } else {
                    print(".")
                }
            }
            println("")
        }
        println("")
        println("This text appeared after $seconds seconds")
        println("")
    }

    fun goldExercise(): Int {
        return 0
    }

    data class Velocity(val x: Int, val y: Int)

    data class LightPoint(var coordinate: Coordinate, val velocity: Velocity) {
        fun move() {
            coordinate = Coordinate(coordinate.x + velocity.x, coordinate.y + velocity.y)
        }
    }

}

fun main(args: Array<String>) {
    val exc10Silver = Exercise10("/input10.txt")
    exc10Silver.exercise(50000)
}
