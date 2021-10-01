package lev1el1

class Solution {
    fun solution(n: Long): IntArray = n.toString().reversed().map{
            it.toString().toInt()
        }.toIntArray()
}

fun main() {
    val s = Solution()
    println(s.solution(2143218724913789).joinToString(""))
}