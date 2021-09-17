package dd
class Solution {
    fun solution(num: Int): Int {
        var number : Long = num.toLong()

        for(i in 0..499){
            if(number==1L) return i
            if(number%2==0L) number/=2
            else number = 1 + number * 3
        }
        return -1
    }
}

fun main() {
    val s = Solution()
    println(s.solution(1))
}