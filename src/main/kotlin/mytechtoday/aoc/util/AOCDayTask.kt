package mytechtoday.aoc.util

import org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.LocalDate

class AOCDayTask private constructor() {

    private val client: HttpClient = WebClient.client

    private fun retrieveDay(day: String, year: String) {
        retrieveInput(day, year)
    }

    private fun retrieveInput(day: String, year: String) {
        val dayFile = getFile(day, year)
        dayFile.parentFile.mkdirs()
        if (!dayFile.exists()) {
            writeFile(dayFile, doRequest("$year/day/$day/input"))
        }
    }

    private fun getFile(day: String, year: String): File {
        return getResource("$year/day$day.txt")
    }

    private fun writeFile(file: File, content: String) {
        try {
            FileUtils.writeStringToFile(file, content)
        } catch (e: IOException) {
            throw IllegalStateException(e)
        }
    }

    private fun getResource(path: String): File {
        return File("src/main/resources/$path")
    }

    private fun doRequest(path: String): String {
        return try {
            val req = HttpRequest.newBuilder()
                .uri(URI.create("https://adventofcode.com/$path"))
                .GET().build()
            client.send(req, HttpResponse.BodyHandlers.ofString()).body()
        } catch (e: Exception) {
            throw IllegalStateException(e)
        }
    }

    private fun createTaskTemplate(year: String, taskDay: String) {
        if (!File("src/main/kotlin/mytechtoday/aoc/year$year", "Day$taskDay.kt").exists()) {
            val file = File("src/main/kotlin/mytechtoday/aoc/year$year", "Day$taskDay.kt")
                .writeText(
                    """package mytechtoday.aoc.year2022
import mytechtoday.aoc.util.readInput
fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput($year,"day$taskDay")
    println(part1(input))
    println(part2(input))
}
"""
                )
        }
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var year = "2022"
            var taskDay = (LocalDate.now().dayOfMonth + 1).toString();
            println("day is $taskDay")
            taskDay = "4";
            AOCDayTask().createTaskTemplate(year, taskDay);
            AOCDayTask().retrieveDay(taskDay, year)
        }


    }
}