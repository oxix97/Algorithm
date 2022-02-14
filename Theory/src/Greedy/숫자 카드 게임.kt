package Greedy

fun main() {
    val N = 2
    val M = 4
    var result = 0

    val cards1 = listOf(listOf(3, 1, 2), listOf(4, 1, 4), listOf(2, 2, 2))
    val cards2 = listOf(listOf(7, 3, 1, 8), listOf(3, 3, 3, 4))

    for (card in cards2) {
        if (result < card.min()!!)
            result = card.min()!!
    }

    println(result)

}