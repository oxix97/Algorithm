package l

import java.util.stream.IntStream

class Solution {
    fun solution(x: Int): Boolean {
        var sum : Int = 0
        val xArray = x.toString().toCharArray()
        for(i in xArray) {
            sum += Integer.parseInt(i.toString())
        }
        return x%sum == 0
    }
}

fun main() {
    val s = Solution()
    println(s.solution(17))
}