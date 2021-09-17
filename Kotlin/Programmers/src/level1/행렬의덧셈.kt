class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer = Array(arr1.size) { index -> IntArray(arr1[index].size) };
        for (i: Int in arr1.indices) {
            for (j: Int in arr1[i].indices) {
                answer[i][j] = arr1[i][j] + arr2[i][j]
            }
        }
        return answer
    }
}

fun main() {
    val arr1 = arrayOf(intArrayOf(1,2), intArrayOf(2, 3))
    val arr2 = arrayOf(intArrayOf(3, 4), intArrayOf(5, 6))
    val s = Solution()
    val result = s.solution(arr1,arr2)
    for (i in result.indices) {
        for (j in result[i]) {
            print(j)
        }
        println()
    }
}
