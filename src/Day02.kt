@file:Suppress("DuplicatedCode")

enum class Move(val losesTo : String) {
    ROCK("PAPER"),
    PAPER("SCISSORS"),
    SCISSORS("ROCK")
}
fun main() {

    fun part1(input: List<String>): Int {

        var score = 0

        for (line in input) {
            val (opponentMoveString, yourMoveString) = line.split(" ")

            val yourMove = when(yourMoveString) {
                "X" -> Move.ROCK
                "Y" -> Move.PAPER
                "Z" -> Move.SCISSORS
                else -> {
                    throw IllegalArgumentException("Invalid move: $yourMoveString")
                }
            }

            val opponentMove = when(opponentMoveString) {
                "A" -> Move.ROCK
                "B" -> Move.PAPER
                "C" -> Move.SCISSORS
                else -> {
                    throw IllegalArgumentException("Invalid move: $opponentMoveString")
                }
            }

            score += when(yourMove) {
                Move.ROCK -> 1
                Move.PAPER -> 2
                Move.SCISSORS -> 3
            }

            score += if(yourMove == opponentMove) {
                3
            } else if(opponentMove.losesTo == yourMove.toString()) {
                6
            }else {
                0
            }

        }

        return score
    }

    fun part2(input: List<String>): Int {
        var score = 0

        for (line in input) {
            val (opponentMoveString, yourMoveString) = line.split(" ")

            val opponentMove = when(opponentMoveString) {
                "A" -> Move.ROCK
                "B" -> Move.PAPER
                "C" -> Move.SCISSORS
                else -> {
                    throw IllegalArgumentException("Invalid move: $opponentMoveString")
                }
            }

            val yourMove = when(yourMoveString) {
                "X" -> Move.valueOf(Move.valueOf(opponentMove.losesTo).losesTo)
                "Y" -> opponentMove
                "Z" -> Move.valueOf(opponentMove.losesTo)
                else -> {
                    throw IllegalArgumentException("Invalid move: $yourMoveString")
                }
            }

            score += when(yourMove) {
                Move.ROCK -> 1
                Move.PAPER -> 2
                Move.SCISSORS -> 3
            }

            score += if(yourMove == opponentMove) {
                3
            } else if(opponentMove.losesTo == yourMove.toString()) {
                6
            }else {
                0
            }

        }

        return score
    }

    val testInput = readTestInput("02")
    check(part1(testInput) == 15)

    val input = readInput("02")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 12)
    println("Part 2: ${part2(input)}")
}