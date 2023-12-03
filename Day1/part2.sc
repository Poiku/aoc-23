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

def findDigInStr(line: String, first: Boolean): String =
    var result: String = " "
    stringToDigit.keys.foreach(key =>
        if line.contains(key) then
            if first then
                val keyIndex: Int = line.indexOf(key)
                val currentStrIndex: Int = line.indexOf(result)

                if currentStrIndex == -1 then result = key
                else if keyIndex < currentStrIndex then result = key
            else
                val keyIndex: Int = line.lastIndexOf(key)
                val currentStrIndex: Int = line.lastIndexOf(result)

                if currentStrIndex == -1 then result = key
                else if keyIndex > currentStrIndex then result = key
    )
    result

var sum: Int = 0
for line <- input do
    var firstDigit: Char = line.find(_.isDigit).getOrElse(' ')
    var firstString: String = findDigInStr(line, first = true)
    var stringIndex: Int = line.indexOf(firstString); var digitIndex: Int = line.indexOf(firstDigit)
    if firstString != " " && stringIndex < digitIndex || digitIndex == -1 then firstDigit = stringToDigit(firstString)

    var lastDigit: Char = line.findLast(_.isDigit).getOrElse(' ')
    var lastString: String = findDigInStr(line, first = false)
    stringIndex = line.lastIndexOf(lastString); digitIndex = line.lastIndexOf(lastDigit)
    if lastString != " " && stringIndex > digitIndex || digitIndex == -1 then lastDigit = stringToDigit(lastString)

    val num: Int = s"$firstDigit$lastDigit".toInt
    sum += num
println(s"Part 2 answer: $sum")