@file:Suppress("DuplicatedCode")

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = readTestInput("02")
    check(part1(testInput) == 0)

    val input = readInput("02")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 0)
    println("Part 2: ${part2(input)}")
}
