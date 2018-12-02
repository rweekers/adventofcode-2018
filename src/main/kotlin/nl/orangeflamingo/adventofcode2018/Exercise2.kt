package nl.orangeflamingo.adventofcode2018

class Exercise2(input: String) {

    private val inputList: List<String> = resourceAsListOfString(input)

    fun silverExercise(): Int {
        var occurTwoTimes = 0
        var occurThreeTimes = 0
        inputList.forEach {
            countTotalOccurrencesOfCharacterInString(it).forEach {
                when (it) {
                    2 -> occurTwoTimes++
                    3 -> occurThreeTimes++
                }
            }
        }
        return occurTwoTimes * occurThreeTimes
    }

    fun goldExercise(): String {
        return findDifferenceOfOne()
    }

    private fun countTotalOccurrencesOfCharacterInString(input: String): List<Int> =
            input.toCharArray().distinct()
                    .map { input.count { occ -> it == occ } }
                    .distinct()

    private fun findDifferenceOfOne(): String {
        inputList.forEach { input1 ->
            inputList
                    .filter { it2 -> it2 != input1 }
                    .forEach { input2 ->

                        (1..input1.length)
                                .forEach {
                                    (1..input2.length)
                                            .forEach { counter ->
                                                if (removeNthCharacterFromString(input1, it) == removeNthCharacterFromString(input2, counter)) {
                                                    return removeNthCharacterFromString(input2, counter)
                                                }
                                            }
                                }
                    }
        }
        return ""
    }

    private fun removeNthCharacterFromString(input: String, n: Int): String {
        return "${input.substring(0, n - 1)}${input.substring(n, n)}${input.substring(n)}"
    }

}

fun main(args: Array<String>) {
    val exc2 = Exercise2("/input2.txt")
    println("The answer to the silver exercise is ${exc2.silverExercise()}")
    println("The answer to the gold exercise is ${exc2.goldExercise()}")
}
