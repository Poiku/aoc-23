val input: Vector[String] = scala.io.Source.fromFile("input.txt", "UTF-8").mkString.split("\n").toVector

var sum: Int = 0
for line <- input do
    val firstDigit: Char = line.find(_.isDigit).get
    val lastDigit: Char = line.findLast(_.isDigit).get

    val num: Int = s"$firstDigit$lastDigit".toInt
    sum += num
println(sum)