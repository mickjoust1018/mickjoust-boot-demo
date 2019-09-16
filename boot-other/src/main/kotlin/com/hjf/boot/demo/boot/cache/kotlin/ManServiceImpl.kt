package com.hjf.boot.demo.boot.cache.kotlin

import org.springframework.stereotype.Service

/**
 * name: com.hjf.boot.demo.boot.cache.kotlin
 * author: mickjoust
 * date: 2018/5/10
 **/
@Service
class ManServiceImpl : ManService {
    override fun findByName(name: String): Man {
        return Man(1,name,"12323131313")
    }
}