package com.mahmud.scala.ScalaCookBook

object LoopExamples {

  def main(args: Array[String]): Unit = {
    val a = Array("apple", "banana", "mango", "Orange")

    for (e <- a)
      println(e)

    // for - yield . loops returns a value

    val newArray = for (e <- a) yield
                   {
                       val s = e.toUpperCase
                       s
                   }
    for (e <- newArray)
      println(e)

  // For Loop Counters
    for (i <- 0 until a.length) {
      println(s"$i is ${a(i)}")
    }

    // Using Range in for loops
    for ( i <- 1 to 3)
      println(i)

    println("-----------------------------------------------------")

    // Using Guards in for loops
    for ( i <- 1 to 10 if i <4)
      println(i)


    // Looping over a map
    val names = Map("fname" -> "Robert",
                    "lname" -> "Goren")
    for ((k,v) <- names)
      println(s"key: $k, value: $v")

    // Using foreach to traverse a collection
    newArray.foreach( e => println(e))
  }
}
