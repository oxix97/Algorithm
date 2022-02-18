package implementation

fun main() {
    val N = 5
    val result = setCount(N)
    println(result)
}

fun setCount(n: Int): Int {
    var count = 0
    for (hour in 0..n) {
        for (minute in 0..59) {
            for (second in 0..59) {
                val time = hour.toString() + minute.toString() + second.toString()
                if (time.contains("3")) ++count
            }
        }
    }
    return count
}
