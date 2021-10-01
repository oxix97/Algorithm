package level61

class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String?> {
        return strings.sortedWith(Comparator<String>{a,b->
            if(a[n]==b[n]) a.compareTo(b)
            else a[n].compareTo(b[n])
        }).toTypedArray()
    }
}

fun main() {
    val s = Solution()
    val arr1 = arrayOf("sun", "bed", "car")
    val arr2 = arrayOf("abce", "abcd", "cdx")
    println(s.solution(arr1,1).asList())
    println(s.solution(arr2,2).asList())

    println(arr1[1].compareTo(arr1[2]))
    println(arr1[2].compareTo(arr1[1]))


}