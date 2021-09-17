package level1

class Solution {
    fun solution(x:Int, n : Int) : LongArray = LongArray(n){
        x.toLong() * (it+1)
    }
}

fun main() {
    val s = Solution()
    val x = 2
    val n = 5
    val result = s.solution(x,n)
    for (element in result) {
        println(element)
    }

}
