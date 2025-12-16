package exercise6

import exercise1.readDouble
import kotlin.math.min

fun main() {
    val size = readDouble("Enter the number of elements: ").toInt()
    if (size <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val numbers = mutableListOf<Double>()
    var count = 0

    while (count < size) {
        val value = readDouble("Enter number ${count + 1}")
        numbers.add(value)
        count++
    }
    selectionSort(numbers)
    println(numbers.joinToString (" "))
}

fun readDouble(text: String): Double {
    while (true) {
        println(text)
        val line = readln()
        val value = line.toDoubleOrNull()
        if (value != null) return value
        println("Couldn't parse a number. Please, try again")
    }
}
fun selectionSort(list: MutableList<Double>) {
    val n = list.size
    for (i in 0 until n - 1) {
        var minIndex = i

        for (j in i + 1 until n) {
            if (list[j] < list[minIndex]) {
                minIndex = j
            }
        }
        if (minIndex != i) {
            val temp = list[i]
            list[i] = list[minIndex]
            list[minIndex] = temp
        }
    }
}