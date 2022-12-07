package mytechtoday.aoc

import mytechtoday.aoc.util.readInput

fun main() {
    fun getCalList(input: List<String>): MutableList<Int> {
        var sum: Int = 0;
        val subTotal = mutableListOf<Int>()
        for (item in input) {
            if (item.isNotBlank()) {
                sum += Integer.valueOf(item);
            } else {
                subTotal.add(sum)
                sum =0;
            }
        }
        return subTotal
    }

    fun part1(input: List<String>): Int {
        var subTotals = getCalList(input)
        return subTotals.max();
    }

    fun part2(input: List<String>): Int {
        var subTotals = getCalList(input)
        var sorted = subTotals.sortedDescending();
        return sorted[0] + sorted[1] + sorted[2];
    }

    val input = readInput(2022,"day1")
    println(part1(input))
    println(part2(input))
}
