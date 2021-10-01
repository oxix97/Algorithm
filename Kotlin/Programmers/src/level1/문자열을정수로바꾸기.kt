package level15555

class Solution {
    fun solution(s: String): Int = when (s.substring(0, 1)) {
        "-" -> 0 - s.substring(1).toInt()
        else -> s.substring(1).toInt()
    }// 이건 왜 안돼??

    fun sol(s: String): Int = Integer.parseInt(s)
}

fun main() {
    val s = Solution()
    println(s.solution("-1"))
    println(s.solution("+1234"))
    println(s.solution("-100"))

}