package exercise1
import kotlin.math.sqrt

fun main() {
    println("Enter coordinates: ")
    while (true) {
        val x1 = readDouble() ?: continue
        val y1 = readDouble() ?: continue
        val x2 = readDouble() ?: continue
        val y2 = readDouble() ?: continue
        val x3 = readDouble() ?: continue
        val y3 = readDouble() ?: continue

        val ab = distance(x1, y1, x2, y2)
        val bc = distance(x2, y2, x3, y3)
        val ca = distance(x3, y3, x1, y1)

        if (!isTriangle(ab, bc, ca)) {
            println("It's not a triangle")
            return
        }

        val perimeter = ab + bc + ca
        println("Perimeter: %.3f".format(perimeter))
        return
    }
}

fun readDouble(): Double? {
    val input = readln()
    return input.toDoubleOrNull() ?: run {
        println("Couldn't parse a number. Please, try again")
        null
    }
}

fun distance(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    return sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1))
}

fun isTriangle(a: Double, b: Double, c: Double): Boolean {
    return a + b > c && b + c > a && a + c > b
}
