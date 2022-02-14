package Greedy

fun main() {
    setCharge()
}

fun setCharge() {
    var n = 1260
    var count = 0

    var coin_types = arrayOf(500, 100, 50, 10)

    for (coin in coin_types) {
        count += n / coin
        n %= coin
    }
    println(count)
}