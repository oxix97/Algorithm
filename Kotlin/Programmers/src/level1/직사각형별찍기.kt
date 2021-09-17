package level1

fun main() {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    val str : String = "*".repeat(b)
    for(i in 1..a){
        println(str)
    }
}
