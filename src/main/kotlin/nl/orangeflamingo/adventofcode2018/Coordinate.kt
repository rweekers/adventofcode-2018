package nl.orangeflamingo.adventofcode2018

import kotlin.math.absoluteValue

data class Coordinate(val x: Int, val y: Int) {

    fun manhattanDistance(coordinate: Coordinate): Int {
        return (this.x - coordinate.x).absoluteValue + (this.y - coordinate.y).absoluteValue
    }
}