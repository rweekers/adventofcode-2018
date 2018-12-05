package nl.orangeflamingo.adventofcode2018

class Exercise6(input: String) {

    private val input: List<String> = resourceAsListOfString(input)

    fun silverExercise(): Int {
        return 0
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
