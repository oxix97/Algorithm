# 🔥그리디 알고리즘

그리디 알고리즘은 탐욕법으로도 소개되며 탐욕적으로 문제를 푸는 알고리즘이다. 탐욕적이라는 것은 현재 상황에서 지금 당장 좋은 것만 고르는 방법을 의미한다. 현재의 선택이 나중에 미칠 영향에 대해서는 고려하지 않는다.

### ✅ 코딩테스트의 그리디 알고리즘

사전에 외우고 있지 않아도 풀 수 있을 가능성이 높은 문제 유형이다. 반면에 정렬, 최단 경로의 경우에는 사용방법을 정확히 알고 있어야한다. 그리디는 유형이 매우 다양하여 많은 유형을 접해보고 문제를 풀어야하며, 훈련해야한다. 보통 코테에 출제되는 그리디 알고리즘 유형은 문제를 풀기 위한 최소한의 아이디어를 떠올릴 수 있는 능력을 요구한다. 단순히 현재 상황에서 가장 좋아 보이는 것을 선택해도 문제를 풀 수 있는지를 파악할 수 있어야 한다.

### ✅ 그리디 알고리즘의 정당성

대부분의 문제는 그리디 알고리즘을 이용했을 경우 최적의 해를 찾을 수 없는 가능성이 크다. 그리디 알고리즘으로 문제의 해법을 찾았을 경우 해당 해법이 정당한지 검토해야 한다.

---

### ✅ 거스름돈

~~~kotlin
fun main() {
    var n = 1260
    var count = 0

    var coin_types = arrayOf(500, 100, 50, 10)

    for (coin in coin_types) {
        count += n / coin
        n %= coin
    }
    println(count)
}
~~~

---

### ✅ 큰 수의 법칙

~~~kotlin
fun main() {
    val M = 8
    val K = 3
    val list = listOf(2, 4, 5, 4, 6)

    var limit = 0
    var result = 0

    val temp = list.sorted().reversed()

    for (i in 0 until M) {
        if (limit == K) {
            result += temp[1]
            limit = 0
        } else {
            result += temp[0]
            limit += 1
        }
    }
    println(result)
}
~~~

