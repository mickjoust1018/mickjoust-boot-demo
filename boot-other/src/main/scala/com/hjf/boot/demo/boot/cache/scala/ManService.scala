package com.hjf.boot.demo.boot.cache.scala

import org.springframework.stereotype.Service

/**
  * name: com.hjf.boot.demo.boot.cache.scala
  * author: mickjoust
  * date: 2018/5/10
  **/
trait ManService {

  def findByName(name: String): Man

}
