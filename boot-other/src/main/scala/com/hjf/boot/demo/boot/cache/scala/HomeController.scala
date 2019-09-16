package com.hjf.boot.demo.boot.cache.scala

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RestController}

/**
  * name: com.hjf.boot.demo.boot.cache.scala
  * author: mickjoust
  * date: 2018/5/10
  **/
@RestController
class HomeController {

  @Autowired
  var manService:ManService = _

  @GetMapping(Array("/ok"))
  def home() : String = {
    val man = manService.findByName("mickjoust")
    "ok ==> scala:"+"id:"+man.id+" name:"+man.name+" email:"+man.email
  }

}
