@file:Suppress("DuplicatedCode")

fun main() {

    val chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    fun part1(input: List<String>): Int {

        var priority = 0

        input.forEach { line ->

            val chunks = line.chunked(line.length / 2)

            val first = chunks[0]
            val second = chunks[1]

            val common = first.first { it in second }

            priority += (chars.indexOf(common) + 1)
        }

        return priority
    }

    fun part2(input: List<String>): Int {

        var priority = 0

        val elfGroup = input.chunked(3)

        elfGroup.forEach { group ->

            val first = group[0]
            val second = group[1]
            val third = group[2]

            val common = first.first { it in second && it in third }

            priority += (chars.indexOf(common) + 1)
        }

        return priority
    }

    val testInput = readTestInput("03")
    check(part1(testInput) == 157)

    val input = readInput("03")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 70)
    println("Part 2: ${part2(input)}")
}
