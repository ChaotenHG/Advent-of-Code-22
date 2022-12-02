import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src/inputs", "Day$name.txt")
    .readLines()

fun readTestInput(name: String) = File("src/inputs", "Day${name}_test.txt")
    .readLines()


/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

// https://github.com/edgars-supe/advent-of-code/blob/master/src/main/kotlin/lv/esupe/aoc/utils/ListUtil.kt
fun <T> List<T>.chunkedBy(selector: (T) -> Boolean): List<List<T>> =
    fold(mutableListOf(mutableListOf<T>())) { acc, item ->
        if (selector(item)) acc.add(mutableListOf())
        else acc.last().add(item)
        acc
    }