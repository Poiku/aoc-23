val input: Array[Array[Array[Int]]] = scala.io.Source.fromFile("input.txt", "UTF-8").mkString.split("\n").map(_.split(": ").last.split('|').map(_.split(" ")).map(_.filter(_.nonEmpty)).map(_.map(_.toInt)))
val matches: Array[Int] = input.map(x => x(0).count(y => x(1).contains(y)))

var res = 0
for i <- 0 until matches.length do
    res += 1 + getWin(matches, i)
println(res)
def getWin(matches: Array[Int], index: Int): Int = 
    val initialWins: Int = matches(index)
    var numOfCards: Int = initialWins
    for i <- index + 1 to (index + initialWins) do
        numOfCards = numOfCards + getWin(matches, i)
    numOfCards