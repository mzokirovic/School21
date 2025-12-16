package exercise8

fun main() {
    var prev: Int? = null
    var index = 0
    var isOrdered = true

    println("Enter numbers (space-separated): ")
    val input = readlnOrNull() ?: ""

    if (input.isBlank()) {
        println("Input error")
        return
    }

    val numbers = input.split(" ")

    for (numStr in numbers) {
        val num = numStr.toIntOrNull()
        if (num == null) {
            println("Input error")
            return
        }

        index ++
        if (prev != null && num < prev) {
            println("The sequence is not ordered from the ordinal number of the number $index")
            isOrdered = false
            break
        }
        prev = num
    }

    if (isOrdered) {
        println("The sequence is ordered in ascending order")
    }
}