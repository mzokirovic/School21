package exercise7

import java.io.File

fun main() {
    val resultFile = File("src/main/kotlin/ex7_text_files/result.txt")

    while (true) {
        println("Enter filename (or 'exit' to quit):")
        val filename = readln()
        if (filename.lowercase() == "exit") break

        val file = File("src/main/kotlin/ex7_text_files/$filename")
        if (!file.exists()) {
            println("$filename: File isn't exist")
            continue
        }

        val lines = file.readLines()
        if (lines.isEmpty()) {
            println("$filename: File is empty")
            continue
        }

        val size = lines[0].toIntOrNull()
        if (size == null || size <= 0) {
            println("$filename: Size <= 0")
            continue
        }

        val numbers = lines.getOrNull(1)?.split(" ")?.mapNotNull { it.toDoubleOrNull() } ?: emptyList()
        if (numbers.size < size) {
            println("$filename: Insufficient number of elements")
            continue
        }

        val minVal = numbers.minOrNull()
        val maxVal = numbers.maxOrNull()

        println("$filename: Min = $minVal, Max = $maxVal")

        resultFile.appendText("$filename: $minVal $maxVal\n")
        println("$filename: Saved min and max values in result.txt")
    }
}


