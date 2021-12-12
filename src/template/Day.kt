package template

import readInput

fun main() {
    val Day: String = "day01/Day01"

    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("${Day}_test")
    check(part1(testInput) == 1)
    check(part2(testInput) == 1)

    val input = readInput(Day)
    println("Part 1 answer:")
    println(part1(input))
    println("\nPart 2 answer:")
    println(part2(input))
}