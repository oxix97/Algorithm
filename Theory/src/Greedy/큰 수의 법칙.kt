package Greedy

import java.util.*

fun main() {
    val M = 8
    val K = 3
    val list = listOf(2, 4, 5, 4, 6)

    var limit = 0
    var result = 0

    val temp = list.sorted().reversed()

    for (i in 0 until M) {
        if (limit == K) {
            result += temp[1]
            limit = 0
        } else {
            result += temp[0]
            limit += 1
        }
    }
    println(result)
}