package com.hjf.boot.demo.boot.cache.kotlin

//import org.springframework.data.jpa.repository.JpaRepository

/**
 * name: com.hjf.boot.demo.boot.high_concurrency.kotlin
 * author: mickjoust
 * date: 2018/5/9
 **/
interface ManService  {
    fun findByName(name: String): Man
}