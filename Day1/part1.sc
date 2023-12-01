val input: Vector[String] = scala.io.Source.fromFile("input.txt", "UTF-8").mkString.split("\n").toVector

var sum: Int = 0
for line <- input do
    var firstDigit: Char = ' '
    var i: Int = 0
    while i < line.length() && firstDigit == ' ' do
        if line(i).isDigit then firstDigit = line(i)
        i += 1
    
    var lastDigit: Char = ' '
    line.foreach(char => if char.isDigit then lastDigit = char)
    
    val num: Int = (firstDigit.toString() + lastDigit.toString()).toInt
    sum += num
println(sum)