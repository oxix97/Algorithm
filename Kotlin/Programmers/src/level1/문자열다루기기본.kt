package level31

import java.lang.Exception

class Solution {
    fun solution(s: String): Boolean{
        if (s.length == 4 || s.length == 6) {
            return try {
                s.toInt()
                true
            } catch (e: Exception) {
                false
            }
        }
        return false
    }
}

fun main() {
    val s = Solution()
    println(s.solution("123f4"))
    println(s.solution("4444"))
}