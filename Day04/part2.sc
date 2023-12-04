val input: Vector[String] = scala.io.Source.fromFile("testinput.txt", "UTF-8").mkString.split("\n").toVector
val p = for line <- input yield
    val l = line.split(": ").last.split('|').map(_.split(" ")).map(_.filter(_.nonEmpty)).map(_.map(_.toInt))
    println()