package l1evel1

class Solution {
    fun solution(n: Int): Int {
        var sum = 0
        n.toString().map{
            sum += it.toString().toInt()
        }
        return sum
    }
}

fun main() {
    val s = Solution()
    println(s.solution(123))
}