package mytechtoday.aoc

import mytechtoday.aoc.model.Move
import mytechtoday.aoc.util.readInput
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

fun main() {

    fun getMoves(moveString: List<String>): List<Move> {
        val moveList = mutableListOf<Move>()
        val pattern: Pattern = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)")
        for (item in moveString) {
            val matcher: Matcher = pattern.matcher(item)
            matcher.find()
            moveList.add(Move(matcher.group(1).toInt(), matcher.group(2).toInt(), matcher.group(3).toInt()))
        }
        return moveList;
    }

    fun part1(input: List<String>): String {

        val crateStackList: MutableList<Stack<Char>> = arrayListOf();
        var one = Stack<Char>();
        var two = Stack<Char>();
        var three = Stack<Char>();
        var four = Stack<Char>();
        var five = Stack<Char>();
        var six = Stack<Char>();
        var seven = Stack<Char>();
        var eight = Stack<Char>();
        var nine = Stack<Char>();
        one.addAll(listOf('V','C','D','R','Z','G','B','W'))
        two.addAll(listOf('G','W','F','C','B','S','T','V'))
        three.addAll(listOf('C','B','S','N','W'))
        four.addAll(listOf('Q','G','M','N','J','V','C','P'))
        five.addAll(listOf('T','S','L','F','D','H','B'))
        six.addAll(listOf('J','V','T','W','M','N'))
        seven.addAll(listOf('P','F','L','C','S','T','G'))
        eight.addAll(listOf('B','D','Z'))
        nine.addAll(listOf('M','N','Z','W'))

        crateStackList.addAll(listOf(one, two, three, four, five, six, seven, eight, nine))
        val moveList = getMoves(input.subList(10, 511));
       for( move in moveList){
           var count = move.count
           println("move $count from ${move.src} to ${move.dest}")
           while(count>0) {
               crateStackList[move.dest-1].push(crateStackList[move.src-1].pop());
               count--
           }
       }
       var topChars = ""
        for(stack in crateStackList){
           if(!stack.empty()) {
               topChars += stack.peek();
           }
        }
        return topChars;


    }

    fun part2(input: List<String>): String {
        val crateStackList: MutableList<Stack<Char>> = arrayListOf();
        var one = Stack<Char>();
        var two = Stack<Char>();
        var three = Stack<Char>();
        var four = Stack<Char>();
        var five = Stack<Char>();
        var six = Stack<Char>();
        var seven = Stack<Char>();
        var eight = Stack<Char>();
        var nine = Stack<Char>();
        one.addAll(listOf('V','C','D','R','Z','G','B','W'))
        two.addAll(listOf('G','W','F','C','B','S','T','V'))
        three.addAll(listOf('C','B','S','N','W'))
        four.addAll(listOf('Q','G','M','N','J','V','C','P'))
        five.addAll(listOf('T','S','L','F','D','H','B'))
        six.addAll(listOf('J','V','T','W','M','N'))
        seven.addAll(listOf('P','F','L','C','S','T','G'))
        eight.addAll(listOf('B','D','Z'))
        nine.addAll(listOf('M','N','Z','W'))

        crateStackList.addAll(listOf(one, two, three, four, five, six, seven, eight, nine))
        val moveList = getMoves(input.subList(10, 511));
        for( move in moveList){
            var count = move.count
          //  println("move $count from ${move.src} to ${move.dest}")
            var tempStack: Stack<Char>  = Stack()
            while(count>0) {

                tempStack.push(crateStackList[move.src-1].pop());
                count--
            }
            while(!tempStack.empty()) {
                crateStackList[move.dest - 1].push(tempStack.pop())
            }
        }
        var topChars = ""
        for(stack in crateStackList){
            if(!stack.empty()) {
                topChars += stack.peek();
            }
        }
        return topChars;
    }

    val input = readInput(2022, "day5")
    println(part1(input))
    println(part2(input))
}

