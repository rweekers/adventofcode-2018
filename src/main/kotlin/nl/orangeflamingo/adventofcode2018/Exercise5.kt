package nl.orangeflamingo.adventofcode2018

import java.util.*

class Exercise5(input: String) {

    private val input: String = resourceAsListOfString(input)[0]

    fun silverExercise(): Int {
        return reactPolymer(null)
    }

    private fun reactPolymer(charToRemove: Char?): Int {
        var inputAsListOfChars = input.toCharArray().toMutableList()
        if (charToRemove != null) {
            inputAsListOfChars.removeAll(Arrays.asList(charToRemove.toLowerCase(), charToRemove.toUpperCase()))
        }
        var numberOfCharacters = inputAsListOfChars.size
        var w = 0
        while (w < numberOfCharacters - 1) {
            val pair = charArrayOf(inputAsListOfChars[w], inputAsListOfChars[w + 1])
            if (matchingPair(pair)) {
                inputAsListOfChars.removeAt(w)
                inputAsListOfChars.removeAt(w)
                numberOfCharacters = inputAsListOfChars.size
                w = if (w > 0) w - 2 else -1
            }
            w++
        }
        return inputAsListOfChars.size
    }

    private fun matchingPair(input: CharArray): Boolean {
        val identityEqual = input[0].toLowerCase() == input[1].toLowerCase()
        val caseNotEqual = (input[0].isLowerCase() && input[1].isUpperCase()) || (input[0].isUpperCase() && input[1].isLowerCase())
        return identityEqual && caseNotEqual
    }

    fun goldExercise(): Int {
        return ('a'..'z').map { reactPolymer(it) }
                .reduce { acc, i -> if(i < acc) i else acc }
    }
}

fun main(args: Array<String>) {
    // check Erik's program (900 ms)
    val start = System.currentTimeMillis()
    val exc5Erik = Exercise5("/input5-2.txt")
    println("The answer to the input of Erik is ${exc5Erik.silverExercise()}")
    val end = System.currentTimeMillis()
    println("Processing took ${end - start}")

    val exc5 = Exercise5("input5.txt")
    println("The answer to the silver exercise is ${exc5.silverExercise()}")
    println("The answer to the gold exercise is ${exc5.goldExercise()}")
}
