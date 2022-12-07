package mytechtoday.aoc.year2022
import mytechtoday.aoc.util.readInput
fun main() {
    fun solve(input:String, distinctCount:Int): Int {
        var inputCharArray =input.toCharArray();
        for (i in 0..inputCharArray.size-distinctCount) {
            var messageSet = mutableSetOf<Char>()
            for(j in i until i+distinctCount){
                messageSet.add(inputCharArray[j])
            }
            if(messageSet.size==distinctCount){
                return i+distinctCount;
            }
        }
        return 0;
    }

    fun part2(input: List<String>): Int {
        return solve(input[0], 14)
    }
    fun part1(input: List<String>): Int {
        return solve(input[0], 4)
    }
    val input = readInput(2022,"day6")
    println(part1(input))
    println(part2(input))
}
