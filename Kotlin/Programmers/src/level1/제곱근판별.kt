package level16

import java.util.*
import java.math.*
class Solution {
    fun solution(n: Long): Long {
        val number = Math.sqrt(n.toDouble()).toInt()
        if(Math.pow(number.toDouble(), 2.0)==n.toDouble()) {
            println(number)
            println(Math.pow(number.toDouble(),2.0))
            return Math.pow((number+1).toDouble(),2.0).toLong()
        }
        return -1
    }
}

fun main() {
    val s = Solution()
    println(s.solution(34))
}