package day03

import readInput

fun main() {

    val input1 = readInput("/day03", "Part1")
    fun inverse(gamma: String): String {
        var output = ""
        for (i in gamma) when (i) {
            '0' -> output += 1
            '1' -> output += 0
        }
        return output
    }

    fun part1(input: List<String>): Int {
        var gamma = ""
        for (i in 0 until input.first().length) {
            var zero = 0
            var one = 0
            for (number in input)
                when (number[i]) {
                    '0' -> zero++
                    '1' -> one++
                }
            gamma += if (zero > one) 0
            else 1
        }
        val epsilon = inverse(gamma)
        return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
    }
    println(part1(input1))

    val input2 = readInput("/day03", "Part2")
    fun countZeroAndOne(msbList: List<String>, i: Int): Pair<Int, Int> {
        val oneCount = msbList.count { it[i] == '1' }
        return Pair(oneCount, msbList.size - oneCount)
    }

    fun significantBit(significantBit: Int, input: List<String>): List<String> {
        var list = input
        for (i in 0 until 4) {
            if (list.size == 1) break
            val (oneCount, zeroCount) = countZeroAndOne(list, i)
            list = if ((significantBit == 0 && zeroCount <= oneCount) || (significantBit == 1 && zeroCount > oneCount))
                list.filter { it[i] == '0' } else list.filter { it[i] == '1' }
        }
        return list
    }

    fun part2(input: List<String>): Int {

        val oxygenGeneratorRating = Integer.parseInt(significantBit(1, input).first(), 2)
        val co2ScrubberRating = Integer.parseInt((significantBit(0, input).first()), 2)

        return oxygenGeneratorRating * co2ScrubberRating
    }
    println(part2(input2))
}
