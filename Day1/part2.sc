
val input: Vector[String] = scala.io.Source.fromFile("p2-testinput.txt", "UTF-8").mkString.split("\n").toVector

val stringDigit: Map[String, Char] = Map(
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
    var firstDigit: Char = ' '
    var i: Int = 0
    while i < line.length() && firstDigit == ' ' do
        if line(i).isDigit then firstDigit = line(i)
        i += 1

    stringDigit.keys.foreach(key => // bra för att hitta den sista stringen, men inte den första
        if line.contains(key) && line.indexOf(key) < (i - 1) then
            println(stringDigit(key) + " " + line.indexOf(key) + " " + (i - 1))
            firstDigit = stringDigit(key)
    )
    println(firstDigit)