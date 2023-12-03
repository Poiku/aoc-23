val input: Vector[String] = scala.io.Source.fromFile("input.txt", "UTF-8").mkString.split("\n").toVector

val stringToDigit: Map[String, Char] = Map(
    "one" -> '1',
    "two" -> '2',
    "three" -> '3',
    "four" -> '4',
    "five" -> '5',
    "six" -> '6',
    "seven" -> '7',
    "eight" -> '8',
    "nine" -> '9'
)

var sum: Int = 0
for line <- input do
    var firstDigit: Char = line.find(_.isDigit).getOrElse(' ')

    var firstString: String = " "
    stringToDigit.keys.foreach(key =>
        if line.contains(key) then
            val keyIndex: Int = line.indexOf(key)
            val currentStrIndex: Int = line.indexOf(firstString)

            if currentStrIndex == -1 then firstString = key
            else if keyIndex < currentStrIndex then firstString = key
    )
    var stringIndex: Int = line.indexOf(firstString); var digitIndex: Int = line.indexOf(firstDigit)
    if firstString != " " && stringIndex < digitIndex || digitIndex == -1 then firstDigit = stringToDigit(firstString)


    var lastDigit: Char = line.findLast(_.isDigit).getOrElse(' ')

    var lastString: String = " "
    stringToDigit.keys.foreach(key =>
        if line.contains(key) then
            val keyIndex: Int = line.lastIndexOf(key)
            val currentStrIndex: Int = line.lastIndexOf(lastString)
            
            if currentStrIndex == -1 then lastString = key
            else if keyIndex > currentStrIndex then lastString = key
    )

    stringIndex = line.lastIndexOf(lastString); digitIndex = line.lastIndexOf(lastDigit)
    if lastString != " " && stringIndex > digitIndex || digitIndex == -1 then lastDigit = stringToDigit(lastString)

    val num: Int = s"$firstDigit$lastDigit".toInt
    sum += num
println(s"Part 2 answer: $sum")