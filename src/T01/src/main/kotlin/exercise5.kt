package exercise5

fun main() {
    val size = readInt("Enter size: ")
    if (size <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val result = mutableListOf<Int>()
    var i = 0

    while (i < size) {
        val num = readInt("Enter number ${i + 1}:")
        if (hasSameFirstLastDigit(num)) {
            result.add(num)
        }
        i++
    }

    if (result.isEmpty()) {
        println("There are no such elements")
    } else {
        println(result.joinToString(" "))
    }
}

fun readInt(prompt: String): Int {
    while (true) {
        println(prompt)
        val input = readln()
        val n = input.toIntOrNull()
        if (n == null) {
            println("Couldn't parse a number. Please, try again")
        } else {
            return n
        }
    }
}

fun hasSameFirstLastDigit(n: Int): Boolean {
    val s = n.toString()
    return s.first() == s.last()
}
