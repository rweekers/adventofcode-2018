package nl.orangeflamingo.adventofcode2018

class Exercise8(input: String) {

    private val inputString: String = resourceAsListOfString(input)[0]

    // split into single numbers
    private val inputList = inputString.split(" ").map { it.trim().toInt() }
    private val tree = parseNodes(inputList).first

    fun silverExercise(): Int {
        return tree.getTotalMetaData()
    }

    private fun parseNodes(numberList: List<Int>, initialPosition: Int = 0): Pair<Node, Int> {
        var position = initialPosition

        val node = Node()

        var numberOfSubNodes = numberList[position++]
        var numberOfMetaData = numberList[position++]

        while (numberOfSubNodes-- > 0) {
            val (subNode, newPos) = parseNodes(numberList, position)
            position = newPos
            node.addSubNode(subNode)
        }

        while (numberOfMetaData-- > 0) {
            node.addMetaData(numberList[position++])
        }

        return node to position
    }

    fun goldExercise(): Int {
        return tree.getNodeValue()
    }

    data class Node(val metaData: MutableList<Int> = mutableListOf(), val subNodes: MutableList<Node> = mutableListOf()) {

        fun getTotalMetaData(): Int {
            val metadataTotal = metaData.sum()
            val metaDataSubNodes = subNodes.sumBy { it.getTotalMetaData() }
            return metadataTotal + metaDataSubNodes
        }

        fun getNodeValue(): Int {
            return if (subNodes.isEmpty()) {
                metaData.sum()
            } else metaData.sumBy { subNodes.getOrNull(it - 1)?.getNodeValue() ?: 0 }
        }

        fun addSubNode(subNode: Node) {
            subNodes.add(subNode)
        }

        fun addMetaData(newMetaData: Int) {
            metaData.add(newMetaData)
        }
    }
}

fun main(args: Array<String>) {
    val exc8 = Exercise8("/input8.txt")
    println("The answer to the silver exercise is ${exc8.silverExercise()}")
    println("The answer to the gold exercise is ${exc8.goldExercise()}")
}
