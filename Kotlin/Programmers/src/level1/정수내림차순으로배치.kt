package level123
import java.util.*
class Solution {
    fun solution(n: Long) : Long {
        return n.toString().toCharArray().sortedDescending().joinToString("").toLong()
    }
}

fun main() {
    val s = Solution()
    println(s.solution(12348822))
}