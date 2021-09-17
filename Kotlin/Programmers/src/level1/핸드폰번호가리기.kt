package level11

class Solution {
//    fun solution(phone_number: String): String = "*".repeat(phone_number.length-4) + phone_number.substring(phone_number.length-4,phone_number.length)
    fun solution(phone_number: String) = "${"".padStart(phone_number.length - 4, '*')}${phone_number.takeLast(4)}"
}

fun main() {
    val s = Solution()
    val number = "12345677770"
    println(s.solution(number))

}