val input: Vector[String] = scala.io.Source.fromFile("input.txt", "UTF-8").mkString.split("\n").toVector
val p = for line <- input yield
    val l = line.split(": ").last.split('|').map(_.split(" ")).map(_.filter(_.nonEmpty)).map(_.map(_.toInt))
    val c = l(0).count(i => l(1).contains(i)) - 1
    if c >= 0 then math.pow(2, c) else 0
println(p.sum.toInt)