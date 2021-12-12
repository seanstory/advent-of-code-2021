package day03

import readInput

fun main() {
    val Day: String = "day03/Day03"

    fun intArrBinaryToBase10(ints: List<Int>): Int {
        return Integer.parseInt( ints.joinToString("") { i -> i.toString() },2)
    }

    fun binaryStrToIntArr(str: String): List<Int>{
        return str.toCharArray().map{ c -> c.toString().toInt() }
    }

    fun gammaAndEpsilon(bits: List<List<Int>>, size: Int): List<List<Int>> {
        val sums = bits.reduce { a, b ->
            a.zip(b) { abit, bbit ->
                abit + bbit
            }
        }
        val gammaList = sums.map{ sum ->
            if (sum >= size/2) {
                1
            } else {
                0
            }
        }
        val epsilonList = gammaList.map { bit ->
            when (bit) {
                0 -> 1
                1 -> 0
                else -> throw IllegalStateException("$bit is not binary!")
            }
        }
        return listOf(gammaList, epsilonList)
    }

    fun part1(input: List<String>): Int {
        val bits = input.map { s -> binaryStrToIntArr(s) }
        val values = gammaAndEpsilon(bits, input.size)
        return intArrBinaryToBase10(values[0]) * intArrBinaryToBase10(values[1])
    }

    fun part2(input: List<String>): Int {
        TODO()
//        val bits = input.map { s -> binaryStrToIntArr(s) }
//        val strSize = bits[0].size
//        var oxygenOpts: List<List<Int>> = ArrayList(bits)
//        var co2Opts: List<List<Int>> = ArrayList(bits)
//        repeat(strSize) { i ->
//            if (oxygenOpts.size == 1 && co2Opts.size ==1){
//                return intArrBinaryToBase10(oxygenOpts[0]) * intArrBinaryToBase10(co2Opts[0])
//            }
//            val gamma = gammaAndEpsilon(oxygenOpts, oxygenOpts.size)[0]
//            val epsilon = gammaAndEpsilon(co2Opts, co2Opts.size)[1]
//            if (oxygenOpts.size > 1){
//                oxygenOpts = oxygenOpts.filter { arr -> arr[i] == gamma[i] }
//            }
//            if (co2Opts.size > 1){
//                co2Opts = co2Opts.filter { arr -> arr[i] == epsilon[i] }
//            }
//        }
//        if (oxygenOpts.size == 1 && co2Opts.size ==1){
//            return intArrBinaryToBase10(oxygenOpts[0]) * intArrBinaryToBase10(co2Opts[0])
//        }
//        throw IllegalStateException("We should not get here")
    }



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("${Day}_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput(Day)
    println("Part 1 answer:")
    println(part1(input))
    println("\nPart 2 answer:")
    println(part2(input))
}