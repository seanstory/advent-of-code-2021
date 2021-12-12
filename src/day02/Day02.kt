package day02

import readInput

fun main() {
    val Day: String = "day02/Day02"

    fun part1(input: List<String>): Int {
        val parts = input.map { s -> s.split(" ")}
        var x = 0
        var y = 0
        parts.forEach { instruction ->
            val command = instruction[0]
            val value = instruction[1].toInt()
            when(command) {
                "forward" -> x += value
                "up" -> y -= value
                "down" -> y += value
            }
        }
        return x * y
    }

    fun part2(input: List<String>): Int {
        val parts = input.map { s -> s.split(" ")}
        var x = 0
        var y = 0
        var aim = 0
        parts.forEach { instruction ->
            val command = instruction[0]
            val value = instruction[1].toInt()
            when(command) {
                "forward" -> {
                    x += value
                    y += (aim * value)
                }
                "up" -> aim -= value
                "down" -> aim += value
            }
        }
        return x * y
    }



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("${Day}_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput(Day)
    println("Part 1 answer:")
    println(part1(input))
    println("\nPart 2 answer:")
    println(part2(input))
}