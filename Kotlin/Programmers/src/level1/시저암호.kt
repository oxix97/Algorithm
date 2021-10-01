package level155

class Solution {
    fun solution(s: String, n: Int): String {
        val answer = s.toCharArray()
        for ((i, ans) in answer.withIndex()) {
            if (ans in 'A'..'Z')
                answer[i] = ((ans - 'A' + n) % 26 + 'A'.toInt()).toChar()
            else if (ans in 'a'..'z')
                answer[i] = ((ans - 'a' + n) % 26 + 'a'.toInt()).toChar()
        }

        return String(answer)
    }
    //대문자 아스키 코드 범위 65 ~ 90
    // 공백 아스키 코드확인 32
    // 소문자 아스키 코드 확인 97 122
}


fun main() {
    val s = Solution()
//    println("A : ${'A'.toInt()}")
//    println("Z : ${'Z'.toInt()}")
//    println("a : ${'a'.toInt()}")
//    println("z : ${'z'.toInt()}")
//    println("blank : ${' '.toInt()}")
    println(s.solution("ABC", 3))
}
