package level41

class Solution {
    fun solution(s: String): String =
        s.toCharArray().sortedDescending().joinToString("")

}

fun main() {
    val s = Solution()
    println(s.solution("Zbcdefg"))
}