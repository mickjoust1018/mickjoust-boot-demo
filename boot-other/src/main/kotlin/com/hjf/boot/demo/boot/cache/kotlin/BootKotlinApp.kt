package com.hjf.boot.demo.boot.cache.kotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * name: com.hjf.boot.demo.boot.high_concurrency.kotlin
 * author: mickjoust
 * date: 2018/5/9
 **/
@SpringBootApplication
open class BootKotlinApp

fun main(args: Array<String>) {

    SpringApplication.run(BootKotlinApp::class.java, *args);

}