package level13

class Solution {
    fun solution(n: Int, m: Int): IntArray {
        val min = Math.min(n,m)
        val max = Math.max(n,m)
        var mini = 0
        var maxi = 0

        for (i in 1..min) {
            if(min%i==0 && max%i==0) {
                mini= i
                maxi = mini * min/i * max/i
            }
        }
        return intArrayOf(mini,maxi)
    }
}

fun main() {
    val s = Solution()
    val result : IntArray = s.solution(4,10)
    for(i in result){
        println(i)
    }

}