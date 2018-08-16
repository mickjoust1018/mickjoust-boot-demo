package com.hjf.boot.demo.boot.cache.kotlin

//import javax.persistence.*

/**
 * name: com.hjf.boot.demo.boot.high_concurrency.kotlin
 * author: mickjoust
 * date: 2018/5/9
 **/
//@Entity
//@Table(name="users")
class Man(
//        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = -1,
        var name: String = "",
        var email: String = ""
) {
    override fun toString(): String {
        return "Man(id=$id, name='$name', email='$email')"
    }
}