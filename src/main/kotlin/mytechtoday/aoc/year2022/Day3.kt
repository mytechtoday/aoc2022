package mytechtoday.aoc.year2022
import mytechtoday.aoc.util.readInput
fun main() {


    fun getPriority(charItem: Char): Int {
        if(charItem.toInt() in 97..122) {
            return charItem.toInt() - 96;
        }
        if(charItem.toInt() in 65..90) {
            return charItem.toInt() - 38;
        }
        return 0;
    }


    fun part2(input: List<String>): Int {
        var duplicateChar = mutableListOf<Char>()
        for (i in input.indices step 3) {
            var elfOne = input[i].toSet();
            var elfTwo = input[i+1].toSet();
            var elfThree = input[i+2].toSet();
            val intersect = elfOne.intersect(elfTwo).intersect(elfThree)
            duplicateChar.add(intersect.elementAt(0))
        }
        var prioritySum = 0;
        for(charItem in duplicateChar) {
            prioritySum += getPriority(charItem)
        }
        return  prioritySum;
    }



    fun part1(input: List<String>): Int {
        var duplicateChar = mutableListOf<Char>()
       for(item in input) {

           var compartmentOne = item.substring(0, item.length / 2);
           var compartmentTwo = item.substring(item.length / 2);
           val itemSet: Set<Char> = compartmentOne.toSet()

           for (item in compartmentTwo){
               if(itemSet.contains(item)){
                   duplicateChar.add(item)
                   break
               }
           }
       }
       var prioritySum = 0;
        for(charItem in duplicateChar) {
            prioritySum += getPriority(charItem)
        }
       return  prioritySum;
    }

    val input = readInput(2022,"day3")
    println(part1(input))
    println(part2(input))
}
