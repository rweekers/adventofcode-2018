package nl.orangeflamingo.adventofcode2018

class Exercise3(input: String) {

    private val inputList: List<String> = resourceAsListOfString(input)

    fun silverExercise(): Int {
        inputList.forEach {
            val split = it.replace("@", "").replace(":", "").replace("  ", " ").split(" ")
            println(it)
        }
        return 0
    }

    fun goldExercise(): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val exc3 = Exercise3("/input3.txt")
    println("The answer to the silver exercise is ${exc3.silverExercise()}")
    println("The answer to the gold exercise is ${exc3.goldExercise()}")
}
