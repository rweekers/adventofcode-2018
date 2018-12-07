package nl.orangeflamingo.adventofcode2018

class Exercise7(input: String) {

    private val inputList: List<String> = resourceAsListOfString(input)

    fun silverExercise(): Int {
        inputList.forEach { println(it) }
        return 0
    }

    fun goldExercise(): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val exc7 = Exercise7("/input7.txt")
    println("The answer to the silver exercise is ${exc7.silverExercise()}")
    println("The answer to the gold exercise is ${exc7.goldExercise()}")
}
