package nl.orangeflamingo.adventofcode2018

class Exercise1(private val input: String) {

    private val inputList: List<String> = resourceAsListOfString(input)

    fun silverExercise(): Int {
        inputList.forEach { println(it) }
        return 0
    }

}


fun main(args: Array<String>) {
    val exc1 = Exercise1("/input1.txt")
    exc1.silverExercise()
}
