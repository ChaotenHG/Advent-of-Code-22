@file:Suppress("DuplicatedCode")

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 45000)
    println("Part 2: ${part2(input)}")
}
