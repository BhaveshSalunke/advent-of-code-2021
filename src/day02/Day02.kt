package day02

import readInput

fun main() {

    // given
    val input1 = readInput("/day02", "Part1")

    // when
    fun part1(input: List<String>): Int {
        var hp = 0
        var depth = 0

        input.forEach { it ->
            val s1 = it.split(" ").first()
            val s2 = it.split(" ").last().toInt()
            when (s1) {
                "forward" -> hp += s2
                "up" -> depth -= s2
                "down" -> depth += s2
            }
        }
        return hp * depth
    }

    // then
    println(part1(input1))

    // given
    val input2 = readInput("/day02", "Part2")

    // when
    fun part2(input: List<String>): Int {
        var hp = 0
        var depth = 0
        var aim = 0

        input.forEach { it ->
            val s1 = it.split(" ").first()
            val s2 = it.split(" ").last().toInt()
            when (s1) {
                "forward" -> {
                    hp += s2
                    depth += aim * s2
                }
                "up" -> aim -= s2
                "down" -> aim += s2
            }
        }
        return hp * depth
    }

    // then
    println(part2(input2))
}
