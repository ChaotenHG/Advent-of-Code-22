@file:Suppress("DuplicatedCode")

fun main() {
    fun part1(input: List<String>): Int {

        var overlaping = 0

        input.forEach { line ->

            val (elfOne, elfTwo) = line.split(",").map { it.split("-") }.map { it -> it.map { it.toInt() } }

            val (elfOneStart, elfOneEnd) = elfOne
            val (elfTwoStart, elfTwoEnd) = elfTwo

            if(elfOneStart >= elfTwoStart && elfOneEnd <= elfTwoEnd || elfTwoStart >= elfOneStart && elfTwoEnd <= elfOneEnd ) {
               overlaping++
            }
        }

        return overlaping
    }

    fun part2(input: List<String>): Int {

        var overlaping = 0

        input.forEach { line ->

            val (elfOne, elfTwo) = line.split(",").map { it.split("-") }.map { it -> it[0].toInt()..it[1].toInt() }

            overlaping += if(elfOne.any { it in elfTwo }) 1 else 0
        }

        return overlaping
    }

    val testInput = readTestInput("04")
    check(part1(testInput) == 2)

    val input = readInput("04")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 4)
    println("Part 2: ${part2(input)}")
}
