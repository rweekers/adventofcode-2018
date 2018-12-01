package nl.orangeflamingo.adventofcode2018

class Exercise1(input: String) {

    private val inputList: List<String> = resourceAsListOfString(input)

    fun silverExercise(): Int {
        return inputList.map { it.toInt() }.reduce { acc, curr -> acc + curr }
    }

    fun goldExercise(): Int {
        var currentFreq = 0
        var frequencies = mutableSetOf<Int>()
        frequencies.add(currentFreq)
        while (true) {
            inputList.map { it.toInt() }
                    .forEach {
                        currentFreq += it
                        if (frequencies.contains(currentFreq)) {
                            return currentFreq
                        }
                        frequencies.add(currentFreq)
                    }
        }
        return 0
    }

}


fun main(args: Array<String>) {
    val exc1 = Exercise1("/input1.txt")
    println("The answer to the silver exercise is ${exc1.silverExercise()}")
    println("The answer to the gold exercise is ${exc1.goldExercise()}")
}
