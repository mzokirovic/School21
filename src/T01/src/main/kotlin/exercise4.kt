package exercise4

fun main() {
    val size = readInt("Enter the number of elements: ")
    if (size == null || size <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val negatives = mutableListOf<Int>()

    for (i in 1..size) {
        val num = readInt("Enter number $i:") ?: continue
        if (num < 0) {
            negatives.add(num)
        }
    }

    if (negatives.isEmpty()) {
        println("There are no negative elements")
    } else {
        val average = negatives.sum().toDouble() / negatives.size
        println(average.toInt())
    }
}

fun readInt(prompt: String): Int? {
    while (true) {
        println(prompt)
        val line = readln()
        val value = line.toIntOrNull()
        if (value == null) {
            println("Couldn't parse a number. Please, try again")
            continue
        }
        return value
    }
}