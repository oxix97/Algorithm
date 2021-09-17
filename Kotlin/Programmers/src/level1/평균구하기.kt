package lev

import java.util.stream.IntStream

class Solution {
    fun solution(arr: IntArray): Double {
        var answer : Double = 0.0
        for(i in arr) answer+=i
        return (answer/arr.size)
    }
}

fun main() {
    val s = Solution()
    println(s.solution(intArrayOf(1,2,3,4)))
}