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
        assert(x > 1)
        assert(y > 1)
        total[x - 1][y - 1] = value
    }
}

fun main(args: Array<String>) {
    val square = Square(3, 3)
    square.updateValue(1, 2, 5)
    square.printArray()
}