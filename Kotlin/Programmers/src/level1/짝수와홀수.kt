package level14


class Solution {
    fun solution(num: Int): String = when(num%2){
        0 -> "Even"
        else -> "Odd"
    }
}