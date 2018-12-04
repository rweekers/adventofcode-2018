package nl.orangeflamingo.adventofcode2018

class Exercise5(input: String) {

    private val inputList: List<String> = resourceAsListOfString(input).sorted()

    fun silverExercise(): Int {
        inputList.forEach { println(it) }
        return 0
    }

    fun goldExercise(): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val exc5 = Exercise5("/input5.txt")
    println("The answer to the silver exercise is ${exc5.silverExercise()}")
    println("The answer to the gold exercise is ${exc5.goldExercise()}")
}
