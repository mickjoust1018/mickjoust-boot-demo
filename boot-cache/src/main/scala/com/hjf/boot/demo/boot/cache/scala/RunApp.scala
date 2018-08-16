package com.hjf.boot.demo.boot.cache.scala

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
  * name: com.hjf.boot.demo.boot.cache.scala
  * author: mickjoust
  * date: 2018/5/10
  **/
@SpringBootApplication
class RunApp {
}

object RunApp {
  def main(args: Array[String]) : Unit = {
    SpringApplication.run(classOf[RunApp], args:_*)
  }
}
