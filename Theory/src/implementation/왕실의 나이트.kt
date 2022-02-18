package implementation

fun main() {
    val input1 = "a1"
    val input2 = "c2"
    val result1 = knight(input1)
    val result2 = knight(input2)
    println(result1)
    println(result2)
}


fun knight(input: String): Int {
    var count = 0
    var position = findPosition(input)
    val steps = arrayOf(
        arrayOf(-2, -1), arrayOf(-2, 1),
        arrayOf(-1, -2), arrayOf(-1, 2),
        arrayOf(1, -2), arrayOf(1, 2),
        arrayOf(2, -1), arrayOf(2, 1)
    )
    for (step in steps) {
        val temp = position.copyOf()

        temp[0] += step[0]
        temp[1] += step[1]

        if (rangeChecker(temp)) ++count
    }
    return count
}

fun rangeChecker(position: Array<Int>): Boolean {
    return position[0] in 1..8 && position[1] in 1..8
}

fun findPosition(input: String): Array<Int> {
    val position = arrayOf(1, 1)
    position[0] = Integer.parseInt(input[1].toString())
    when (input[0]) {
        'a' -> position[1] = 1
        'b' -> position[1] = 2
        'c' -> position[1] = 3
        'd' -> position[1] = 4
        'e' -> position[1] = 5
        'f' -> position[1] = 6
        'g' -> position[1] = 7
        'h' -> position[1] = 8
    }
    return position
}
