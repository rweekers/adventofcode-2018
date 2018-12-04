package nl.orangeflamingo.adventofcode2018

class Exercise4(input: String) {

    private val inputList: List<String> = resourceAsListOfString(input).sorted()
    private val sleeps = mutableMapOf<Int, List<Int>>()

    init {
        fillSleeps()
    }

    private fun fillSleeps() {
        var sleep = 0
        var guardId = 0

        inputList.forEach {
            // Split input into sensible inputs
            val split = it.split("]")
            val minutes = split[0].replace("]", "").split(" ")[1].split(":")[1].toInt()
            val text = split[1]

            val found = "#[0-9]+".toRegex().find(text)?.value
            val id = if (found != null) {
                found.replace("#", "").toInt()
            } else {
                null
            }

            when {
                id != null -> guardId = id
                text.contains("falls asleep") -> sleep = minutes
                else -> {
                    val sleepPeriod = (sleep until minutes).toList()
                    sleeps.merge(guardId, sleepPeriod) { a, b -> a + b }
                }
            }
        }
    }

    fun silverExercise(): Int {
        return sleeps.maxBy { it.value.size }.run { this!!.key * this.value.groupBy { it }.maxBy { it.value.size }?.key!! }
    }

    fun goldExercise(): Int {
        return sleeps.flatMap { it ->
            it.value.map { minute ->
                it.key to minute
            }
        }
                .groupBy { it }.maxBy { it.value.size }?.key!!
                .run { first * second }
    }
}

fun main(args: Array<String>) {
    val exc4 = Exercise4("/input4.txt")
    println("The answer to the silver exercise is ${exc4.silverExercise()}")
    println("The answer to the gold exercise is ${exc4.goldExercise()}")
}
