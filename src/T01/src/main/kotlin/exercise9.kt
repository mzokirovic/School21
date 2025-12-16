package exercise9

fun main() {
    println("Enter number of strings: ")
    val n = readln().toIntOrNull()
    if (n == null || n <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val strings = mutableListOf<String>()
    for (i in 1..n) {
        println("Enter string $i: ")
        strings.add(readln())
    }

    println("Enter substring to filter: ")
    val substring = readln()

    val filtered = filterString(strings, substring)

    if (filtered.isEmpty()) {
        println("No matches found")
    } else {
        println(filtered.joinToString(", "))
    }
}

fun filterString(list: List<String>, sub: String): List<String> {
    val result = mutableListOf<String>()
    for (s in list) {
        if (s.contains(sub)) {
            result.add(s)
        }
    }
    return result
}