package com.hjf.boot.demo.boot.cache.scala

/**
  * name: com.hjf.boot.demo.boot.cache.scala
  * author: mickjoust
  * date: 2018/5/14
  **/
class Hello (val firstName: String, val lastName: String){
  def this(firstName: String) { this(firstName, "")}
}
object Hello {
  def toUpper(str: String): String = {
    return str.toUpperCase()
  }
}

object Main extends App {
  val p1 = new Hello("mickjoust","huang")
  val p2 = new Hello("mickjoust")

  println(Hello.toUpper("mickjoust"))

}

