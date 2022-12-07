package mytechtoday.aoc.year2022
import mytechtoday.aoc.util.readInput
fun main() {

    fun getValue(inputChar: Char):Int = when (inputChar) {
        'X' -> 1
        'Y' -> 2
        else -> 3
    }

    fun getValueProblem2(inputChar: String):Int = when (inputChar) {
        // Rock 1 , paper- 2, sessior 3
        //x is loose
        //y is draw
        //z is win
        "AX"->3 //3+0  R - s
        "BX"->1 //1+0  P  -r
        "CX"->2//      S  - p
        "AY"->4  //1+3 R  - R
        "BY"->5     // P  - P
        "CY"->6    //  s  -S
        "AZ"->8   //   R  - p
        "BZ"->9     // p  - S
        "CZ"->7 //1+6  s  ; R
        else -> 0

    }
    fun getPoint(opponent: Char, own: Char):Int {
       var point =getValue(own)

        if((own=='X' && opponent=='A') ||(own=='Y' && opponent=='B') || (own=='Z' && opponent=='C')){
            point+=3;
        } else if((own=='X' && opponent=='C') ||(own=='Y' && opponent=='A') || (own=='Z' && opponent=='B')) {
            point+=6;
        }
        return  point;
    }

    fun part1(input: List<String>): Int {
        var totalPoint = 0;
        for(item in input){
            var trim : CharArray= item.trim().toCharArray()
            totalPoint+=getPoint(trim[0],trim[2])
        }
        return totalPoint;
    }

    fun part2(input: List<String>): Int {
        var totalPoint = 0;
        for(item in input){
            var trim : CharArray= item.trim().toCharArray()
            totalPoint+=getValueProblem2(""+trim[0]+trim[2])
        }
        return totalPoint;
    }



    val input = readInput(2022,"day2")
    println(part1(input))
    println(part2(input))
}
