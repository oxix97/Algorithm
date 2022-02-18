package implementation

fun main() {
    val list = listOf("L", "R", "R", "R", "U", "D", "D")
    val range = 5
    val result: Array<Int> = travel(list, range)
    for (i in result) {
        print("$i ")
    }
}

fun travel(list: List<String>, range: Int): Array<Int> {
    var position = arrayOf(1, 1)
    for (i in list) {
        var temp = position.copyOf()
        when (i) {
            "L" -> --temp[1]
            "R" -> ++temp[1]
            "U" -> --temp[0]
            "D" -> ++temp[0]
        }
        if (temp[0] < 1 || temp[0] > range) {
            temp[0] = position[0]
        }
        if (temp[1] < 1 || temp[1] > range) {
            temp[1] = position[1]
        }
        position = temp
    }
    return position
}
