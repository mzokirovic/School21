package exercise10


fun main() {
    println("Enter numbers of users: ")
    val n = readLine()?.toIntOrNull()
    if (n == null || n <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val users = mutableListOf<User>()

    for (i in 1..n) {
        println("Enter name for user $i")
        val name = readLine() ?: ""

        val age = readAge("Enter age for $name: ") ?: continue
        if (age <= 0) {
            println("Incorrect input. Age <= 0")
            continue
        }

        users.add(User(name, age))
    }

    val adults = users
        .filter { it.age >= 18 }
        .map { it.name }

    if (adults.isEmpty()) {
        println("No adults user")
    } else {
        println(adults.joinToString(", "))
    }
}

fun readAge(prompt: String): Int? {
    while (true) {
        println(prompt)
        val input = readLine()
        val age = input?.toIntOrNull()
        if (age == null) {
            println("Couldn't parse a number. Please try again.")
            continue
        }
        return age
    }
}