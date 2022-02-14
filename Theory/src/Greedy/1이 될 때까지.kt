package Greedy

var count = 0
fun main() {
    var N = 125
    var K = 5
    var result = 0

    while (N >= K) {
        while (N % K != 0) {
            N -= 1
            result += 1
        }
        N /= K
        result += 1
    }

    while (N > 1) {
        N -= 1
        result += 1
    }

    println(result)
}
