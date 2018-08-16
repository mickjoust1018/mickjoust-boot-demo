//package com.hjf.boot.demo.boot.cache.groovy
//
///**
// * name: com.hjf.boot.demo.boot.cache.groovy
// * author: mickjoust
// * date: 2018/5/10
// **/
//def name = "John"
//def amount = 125
//println('My name is ${name}')
//println("My name is ${name}")
//println("He paid \$${amount}")
//
////using single quotes
//def content = '''My Name is John.
//    I live in London.
//    I am a software developer'''
//def name = 'John'
//def address = 'London'
//def occupation = 'software developer'
////using double quotes
//def bio = """My name is ${name}.
//        I live in ${address}.
//        I am a ${occupation}."""
//
////class Person
////{
////    def id
////    def name
////    def email
////}
////def p = new Person()
////p.id = 1
////p.name = 'Jon'
////p.email = 'john@mail.com'
////println("Id: ${p.id}, Name: ${p.name}, Email: ${p.email}")
//
////for(i in 0..5) { print "${i}" }
////The output is as follows:
////0 1 2 3 4 5
////Iterate using upto() with the lower and upper limits inclusive:
////0.upto(3) { print "$it " }
////The output is as follows:
////0 1 2 3
////Iterate using times(), starting from 0:
////5.times { print "$it " }
////The output is as follows:
////0 1 2 3 4
////Iterate using step() with the lower and upper limits and a step value:
////        0.step(10, 2) { print "$it "}
////The output is as follows:
////0 2 4 6 8