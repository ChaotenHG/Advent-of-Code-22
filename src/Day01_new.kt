@file:Suppress("DuplicatedCode")

// inproved version credits to https://github.com/edgars-supe/

fun main() {
    fun part1(input: List<String>) =
        input.chunkedBy { it.isBlank() }.maxOfOrNull { elfCalories -> elfCalories.sumOf { it.toInt() } } ?: 0

    fun part2(input: List<String>) =
        input.chunkedBy { it.isBlank() }.map { elfCalories -> elfCalories.sumOf { it.toInt() } }.sortedDescending().take(3).sum()

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 45000)
    println("Part 2: ${part2(input)}")
}