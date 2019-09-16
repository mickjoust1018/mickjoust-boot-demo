package com.hjf.boot.demo.boot.cache.kotlin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * name: com.hjf.boot.demo.boot.high_concurrency.kotlin
 * author: mickjoust
 * date: 2018/5/9
 **/
@RestController
class ManController(val manService:ManService) {

    @GetMapping("/ok")
    fun home(): String {
        val man = manService.findByName("mickjoust")
        return "ok ==> kotlin"+"name:"+man.name
    }

}