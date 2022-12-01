package mytechtoday.aoc

import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import java.util.Objects

/**
 * Reads lines from the given input txt file.
 */
//fun readInput(fileName: String) = this::class.java.getResourceAsStream(fileName).bufferedReader().readLines()
fun readInput(name: String) = File("src/main/resources", "$name.txt")
    .readLines()
/**
 * Converts string to mytechtoday.aoc.md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
