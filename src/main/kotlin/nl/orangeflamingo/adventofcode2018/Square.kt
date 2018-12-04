package nl.orangeflamingo.adventofcode2018

class Square(width: Int, height: Int) {

    private val total = Array(height) { IntArray(width) { 0 } }

    fun printArray() {
        for (i in 0 until total.size) {
            for (j in 0 until total.get(0).size) {
                print("${total[j][i]}")
            }
            println()
        }
    }

    fun updateValue(x: Int, y: Int, value: Int) {
        total[x][y] = value
    }

    private fun getValue(x: Int, y: Int): Int {
        return total[x][y]
    }

    fun claimSingleUse(claim: Claim): Int? {
        val startX = claim.offSetX
        val startY = claim.offSetY
        val endX = claim.offSetX + claim.width - 1
        val endY = claim.offSetY + claim.height - 1

        (startX..endX).forEach {x ->
            (startY..endY).forEach {y ->
                if (getValue(x, y) > 1) {
                    return null
                }
            }
        }
        return claim.id
    }

    fun getOverlappingFabric(): Int {
        var totalFabric = 0
        (0 until total.size).forEach { x ->
            (0 until total.get(0).size).forEach { y ->
                if(getValue(x, y) > 1) {
                    totalFabric++
                }
            }
        }
        return totalFabric
    }

    fun fillClaim(claim: Claim) {
        val startX = claim.offSetX
        val startY = claim.offSetY
        val endX = claim.offSetX + claim.width - 1
        val endY = claim.offSetY + claim.height - 1

        (startX..endX).forEach {x ->
            (startY..endY).forEach {y ->
                updateValue(x, y, getValue(x, y) + 1)
            }
        }
    }

    data class Claim(val id: Int,
                     val offSetX: Int,
                     val offSetY: Int,
                     val width: Int,
                     val height: Int)
}

fun main(args: Array<String>) {
    val square = Square(3, 3)
    square.updateValue(1, 2, 5)
    square.printArray()
}