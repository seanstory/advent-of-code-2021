package day01

import readInput

fun main() {

    fun countIncrease(input: List<Int>): Int {
        var times: Int = 0
        input.map{s -> s.toInt()}.reduce { s1, s2 ->
            if(s2>s1){times++}; s2
        }
        return times
    }

    fun part1(input: List<String>): Int {
        val depths = input.map{s -> s.toInt()}
        return countIncrease(depths)
    }

    fun part2(input: List<String>): Int {
        val windows: List<Int> = input.map{s -> s.toInt()}.windowed(3) {l -> l.sum()}
        return countIncrease(windows)
    }



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day01/Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("day01/Day01")
    println("Part 1 answer:")
    println(part1(input))
    println("\nPart 2 answer:")
    println(part2(input))
}
