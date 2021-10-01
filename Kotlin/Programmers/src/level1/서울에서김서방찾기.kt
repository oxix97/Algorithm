package level21

class Solution {
    fun solution(seoul: Array<String>): String =
        "김서방은 " + seoul.indexOf("Kim") + "에 있다"

}


fun main() {
    val s = Solution()
    val arr = arrayOf("Jane", "Kim")
    println(s.solution(arr))
}