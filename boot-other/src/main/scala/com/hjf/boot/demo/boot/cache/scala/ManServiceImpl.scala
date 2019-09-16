package com.hjf.boot.demo.boot.cache.scala

import org.springframework.stereotype.Service

/**
  * name: com.hjf.boot.demo.boot.cache.scala
  * author: mickjoust
  * date: 2018/5/10
  **/
@Service
class ManServiceImpl extends ManService {
  override def findByName(name: String) = new Man(1,name,"test@test")
}
