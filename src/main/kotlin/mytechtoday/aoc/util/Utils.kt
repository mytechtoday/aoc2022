package mytechtoday.aoc.util

import mytechtoday.aoc.model.Move
import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
//fun readInput(fileName: String) = this::class.java.getResourceAsStream(fileName).bufferedReader().readLines()
fun readInput(year: Int, name: String) = File("src/main/resources/$year" +
        "", "$name.txt")
    .readLines()



/**
 * Converts string to mytechtoday.aoc.util.md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
