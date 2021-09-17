package level15

import java.util.*
import kotlin.collections.ArrayList

class Solution {
    fun solution(arr: IntArray): IntArray {
        var number = Integer.MAX_VALUE
        if(arr.size==1) return intArrayOf(-1)
        for (i in arr) {
            if(number>i) number = i
        }
        val list : MutableList<Int> = arr.toMutableList()
        list.remove(number)
        return list.toIntArray()
    }
}

fun main() {
    val arr = intArrayOf(4,1,2,3)
    val s = Solution()
    val result = s.solution(arr)
    for (i in result) {
        println(i)
    }
}