package exercise2
fun main() {
    val seconds = readInt("Enter seconds: ")

    if (seconds < 0) {
        println("Incorrect time")
        return
    }

    val (h , m, s) = convert(seconds)
    printTime(h, m, s)
}

fun readInt(text: String): Int {
    while (true) {
        print("$text")
        val input = readLine()
        val number = input?.toIntOrNull()
        if (number != null) return number

        println("Couldn't parse a number. Please, try again.")
    }
}
fun convert(seconds: Int): Triple<Int, Int, Int> {
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60
    val seconds = seconds % 60
    return Triple(hours, minutes, seconds)
}
fun printTime(h: Int, m: Int, s: Int) {
    val hh = "%02d".format(h)
    val mm = "%02d".format(m)
    val ss = "%02d".format(s)
    println("$hh:$mm:$ss")
}