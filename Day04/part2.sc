val input: Array[Array[Array[Int]]] = scala.io.Source.fromFile("input.txt", "UTF-8").mkString.split("\n").map(_.split(": ").last.split('|').map(_.split(" ")).map(_.filter(_.nonEmpty)).map(_.map(_.toInt)))

var res = 0
for i <- 0 until input.length do
    res += getWin(input, i)
println(res + input.length)
def getWin(cards: Array[Array[Array[Int]]], index: Int): Int = 
    val initialWins = cards(index)(0).count(i => cards(index)(1).contains(i))
    var numOfCards = initialWins
    for i <- index + 1 to (index + initialWins) do
        numOfCards += getWin(cards, i)
    numOfCards