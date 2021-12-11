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

    fun filterChar(msbList: List<String>, i: Int, bit: Char) = msbList.filter { it[i] == bit }

    fun commonBit(input: List<String>, common: Int): List<String> {
        var msbList = input
        for (i in 0 until input.first().length) {
            val (oneCount, zeroCount) = countZeroAndOne(msbList, i)
            msbList = if (common == 0) {
                if (zeroCount <= oneCount) {
                    filterChar(msbList, i, '0')
                } else {
                    filterChar(msbList, i, '1')
                }
            } else if (zeroCount > oneCount) {
                filterChar(msbList, i, '0')
            } else {
                filterChar(msbList, i, '1')
            }
            if (msbList.size == 1) break
        }
        return msbList
    }

    fun part2(input: List<String>): Int {
        var msbList = commonBit(input, 1)
        val oxygenGeneratorRating = Integer.parseInt(msbList.first(), 2)

        msbList = commonBit(input, 0)
        val co2ScrubberRating = Integer.parseInt((msbList.first()), 2)
        return oxygenGeneratorRating * co2ScrubberRating
    }
    println(part2(input2))
}
