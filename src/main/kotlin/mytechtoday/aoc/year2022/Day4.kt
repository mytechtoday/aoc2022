package mytechtoday.aoc.year2022
import mytechtoday.aoc.util.readInput
fun main() {

     fun String.parsePair() =
        split("-").let { IntRange(it[0].toInt() , it[1].toInt()) }


    fun contains(pair:List<IntRange>) : Boolean {
        return (pair[0].contains(pair[1].first) && pair[0].contains(pair[1].last))
                || (pair[1].contains(pair[0].first) && pair[1].contains(pair[0].last))
    }

    fun overlaps(pair:List<IntRange>) :Boolean {
       return pair[0].first <= pair[1].last && pair[0].last >= pair[1].first
    }

    fun part1(input: List<String>): Int {
        val ranges = input.map { it.split(",").map { it.parsePair() } }
        var total = 0;
        for(item in ranges){
            if(contains(item)){
                total++
            }
        }
        return total
    }

    fun part2(input: List<String>): Int {;
        val ranges = input.map { it.split(",").map { it.parsePair() } }
        var total = 0;
        for(item in ranges){
            if(overlaps(item)){
                total++
            }
        }
        return total
    }

    val input = readInput(2022,"day4")
    println(part1(input))
    println(part2(input))
}

