package nl.orangeflamingo.adventofcode2018

class Exercise3(input: String) {

    private val inputList: List<String> = resourceAsListOfString(input)
    private var square: Square
    private val claims: MutableList<Square.Claim> = mutableListOf<Square.Claim>()

    init {
        inputList.forEach { row ->
            val claim = row.replace("@", "").replace(":", "").replace("  ", " ").split(" ")
                    .let {
                        val offset = it[1].split(",")
                        val dimensions = it[2].split("x")
                        Square.Claim(it[0].replace("#", "").toInt(), offset[0].toInt(), offset[1].toInt(), dimensions[0].toInt(), dimensions[1].toInt())
                    }
            claims.add(claim)
        }
        val largestWidth = largestWidth(claims) ?: 0
        val largestHeight = largestHeight(claims) ?: 0
        square = Square(largestWidth, largestHeight)
        claims.forEach {
            println("Claim is $it")
            square.fillClaim(it)
        }
    }

    fun silverExercise(): Int {
        return square.getOverlappingFabric()
    }

    private fun largestWidth(claims: List<Square.Claim>): Int? =
        claims
                .map { it.offSetX + it.width }
                .max()

    private fun largestHeight(claims: List<Square.Claim>): Int? =
            claims
                    .map { it.offSetY + it.height }
                    .max()

    fun goldExercise(): Int {
        return claims.mapNotNull { square.claimSingleUse(it) }.first()
    }
}

fun main(args: Array<String>) {
    val exc3 = Exercise3("/input3.txt")
    println("The answer to the silver exercise is ${exc3.silverExercise()}")
//    println("The answer to the gold exercise is ${exc3.goldExercise()}")
}
