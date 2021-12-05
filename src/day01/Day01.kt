package day01

import readInputAsInt

fun main() {

    val input1 = readInputAsInt("/day01", "Part1")
    fun part1(input: List<Int>) = input.windowed(2).count { (a, b) -> a < b }
    println(part1(input1))

    val input2 = readInputAsInt("/day01", "Part2")
    fun part2(input: List<Int>) = input.windowed(3).windowed(2).count { (a, b) -> a.sum() < b.sum() }
    println(part2(input2))
}
