package exercise11

import com.sun.jdi.Value

fun main() {
    val cars = mutableListOf<Car>()

    println("Enter number of cars: ")
    val n = readInt() ?: return

    for (i in 1..n) {
        println("Enter model of car $i:")
        val model = readLine() ?: ""

        val passengers = readPassengerCount(i) ?: continue

        val car = Car(model, passengers, calculateMaxSpeed(passengers))
        car.maxSpeed = calculateMaxSpeed(passengers)

        cars.add(car)
    }

    val speeds = cars.map { it.maxSpeed }
    println(speeds.joinToString(", "))
}

fun calculateMaxSpeed(passengers: Int): Int {
    return when {
        passengers == 1 -> 110
        passengers in 2..5 -> 90
        passengers >= 6 -> 60
        else -> 0
    }
}

fun readPassengerCount(index: Int): Int? {
    while (true) {
        println("Enter passenger count for car $index:")
        val line = readLine() ?: return null
        val value = line.toIntOrNull()
        if (value == null) {
            println("Couldn't parse a number. Please try again")
            continue
        }
        if (value <= 0) {
            println("Incorrect input. Passenger count <= 0")
            return null
        }
            return value
    }
}

    fun readInt(): Int? {
        val line = readLine() ?: return null
        return line.toIntOrNull()
    }