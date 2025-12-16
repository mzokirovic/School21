package exercise3

fun main() {
    println("Enter a number: ")
    val n = readInt() ?: return

    // Check for large n
    if (n > 50) {
        println("Too large n")
        return
    }

    val fibNumber = fibonacci(n)
    println(fibNumber)
}

fun fibonacci(n: Int): Long {
    return when(n) {
        0 -> 0
        1 -> 1
        else -> fibonacci(n-1) + fibonacci(n-2)
    }
}

fun readInt(): Int? {
    while (true) {
        val line = readln()
        val value = line.toIntOrNull()
        if (value == null) {
            println("Couldn't parse a number. Please, try again")
            continue
        }
        if (value < 0) {
            println("Too small n")
            return null
        }
        return value
    }
}
