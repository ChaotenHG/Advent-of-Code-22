@file:Suppress("DuplicatedCode")

fun main() {
    fun part1(input: List<String>): Int {

        var current = 0
        val seen = arrayListOf<Int>()

        input.forEach {

            if(it.isBlank()) {
                seen.add(current)
                current = 0

                return@forEach
            }

            current += it.toInt()

            if(it === input.last()) {
                seen.add(current)
            }

        }

        return seen.max()
    }

    fun part2(input: List<String>): Int {

        var current = 0
        val seen = arrayListOf<Int>()

        input.forEach {

            if(it.isBlank()) {
                seen.add(current)
                current = 0

                return@forEach
            }

            current += it.toInt()

            if(it === input.last()) {
                seen.add(current)
            }

        }

        seen.sortByDescending { it }

        return (seen[0] + seen[1] + seen[2])
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 45000)
    println("Part 2: ${part2(input)}")
}
