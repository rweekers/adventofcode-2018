package nl.orangeflamingo.adventofcode2018

import java.lang.StringBuilder

class Exercise7(input: String) {

    private val inputList: List<String> = resourceAsListOfString(input)
    private val steps: Steps = Steps()

    private fun initSteps() {
        val regExp = """\w+""".toRegex()
        inputList.forEach { line ->
            val parts = regExp.findAll(line).toList().map { it.value }
            val requiredStepName = parts[1]
            val stepName = parts[7]

            // find or create steps
            val requiredStep = steps.stepSet.filter { it.name == requiredStepName }.firstOrNull()
                    ?: Step(requiredStepName)
            val step = steps.stepSet.filter { it.name == stepName }.firstOrNull() ?: Step(stepName)

            // add required step to step
            step.addRequiredStep(requiredStep)

            // add steps to set
            steps.addSteps(step, requiredStep)
        }
    }

    fun silverExercise(): String {
        initSteps()
        return steps.traverseThroughSteps()
    }

    private fun letterToNumber(letter: String): Int {
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        return alphabet.indexOf(letter) + 1
    }

    fun goldExercise(offSet: Int = 0, availableWorkers: Int = 2): Int {
        initSteps()

        // Update steps with processingtime
        steps.stepSet.forEach { it.stepsToProcessRemaining = letterToNumber(it.name) + offSet }

        var secondsNeeded = 1
        val workers = Workers(availableWorkers)

        val processableSteps = steps.processableSteps().toList().sortedBy { it.name }
        processableSteps.forEach { workers.assignStep(it) }

        // loop with time ticks over list
        while (!steps.finished()) {
            // assign unassigned steps to available workers
            val unassignedSteps = steps.getUnassignedSteps(workers)
            unassignedSteps.forEach { workers.assignStep(it) }

            // process all steps in the workers
            workers.stepsInProgress().forEach {
                steps.processStep(it!!, workers)
            }

            secondsNeeded++
        }

        return secondsNeeded
    }

    data class Workers(val numberOfWorkers: Int = 2) {
        val workers = mutableMapOf<Int, Step?>()

        init {
            (0 until numberOfWorkers).forEach { workers[it] = null }
        }

        fun stepsInProgress(): List<Step?> {
            return workers.values.filter { it != null }.toList()
        }

        fun freeWorker(step: Step) {
            val key = workers.filter{ it.value != null }.filter { it.value == step }.keys.firstOrNull()
            if (key != null) {
                workers[key] = null
            }
        }

        fun assignStep(step: Step) {
            // get first available worker
            val availableKeys = workers.filter { it.value == null }.keys.sorted()
            if (!availableKeys.isEmpty()) {
                workers[availableKeys.first()] = step
            }
        }

    }

    data class Steps(val stepSet: MutableSet<Step> = mutableSetOf()) {

        fun addSteps(vararg steps: Step) {
            steps.forEach { stepSet.add(it) }
        }

        fun processableSteps(): Set<Step> {
            return stepSet.filter { it.requiredSteps.size == 0 }.toSet()
        }

        fun finished(): Boolean {
            return stepSet.none { it.stepsToProcessRemaining > 1 }
        }

        fun processStep(step: Step, workers: Workers = Workers()) {
            if (step.stepsToProcessRemaining == 1) {
                stepSet.forEach { it.removeRequiredStep(step) }
                stepSet.remove(step)
                workers.freeWorker(step)
            } else {
                step.stepsToProcessRemaining--
            }
        }

        fun getUnassignedSteps(workers: Workers): List<Step> {
            return this.stepSet.filter { !workers.workers.values.contains(it) }.filter { it.requiredSteps.size == 0 }.sortedBy { it.name }
        }

        tailrec fun traverseThroughSteps(stepList: StringBuilder = StringBuilder(),
                                         step: Step = stepSet.filter { it.requiredSteps.size == 0 }.sortedBy { it.name }.first()): String {
            stepList.append(step.name)

            processStep(step)

            val rootStep = stepSet.filter { it.requiredSteps.size == 0 }.sortedBy { it.name }.firstOrNull()
            return if (rootStep == null) stepList.toString() else traverseThroughSteps(stepList, rootStep)
        }

    }

    data class Step(val name: String, var stepsToProcessRemaining: Int = 1) {
        val requiredSteps = mutableSetOf<Step>()

        fun addRequiredStep(step: Step) {
            requiredSteps.add(step)
        }

        fun removeRequiredStep(step: Step) {
            requiredSteps.remove(step)
        }
    }
}

fun main(args: Array<String>) {
    val exc7 = Exercise7("/input7.txt")
    println("The answer to the silver exercise is ${exc7.silverExercise()}")
    println("The answer to the gold exercise is ${exc7.goldExercise(60, 5)}")
}
