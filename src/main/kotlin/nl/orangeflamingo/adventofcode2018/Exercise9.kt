package nl.orangeflamingo.adventofcode2018

class Exercise9(input: String) {

    private val inputString: List<String> = resourceAsListOfString(input)

    fun silverExercise(): Int {
        inputString.forEach { println(it) }
        return 0
    }

    fun goldExercise(): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val exc9 = Exercise9("/input9.txt")
    println("The answer to the silver exercise is ${exc9.silverExercise()}")
    println("The answer to the gold exercise is ${exc9.goldExercise()}")
}
