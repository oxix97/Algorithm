package level145

class Solution {
    fun solution(s: String): String {
        var index = 0
        val answer = s.toCharArray().map {
            index++
            if(it == ' ') index = 0
            else {
                when (index % 2) {
                    1 -> it.toUpperCase()
                    else -> it.toLowerCase()
                }
            }
        }
        return answer.joinToString("").replace("kotlin.Unit"," ")
    }
}

fun main() {
    val s = Solution()
    println(s.solution("try hello world"))
}