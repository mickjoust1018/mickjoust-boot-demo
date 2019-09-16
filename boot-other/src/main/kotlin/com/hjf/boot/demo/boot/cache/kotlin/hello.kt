package com.hjf.boot.demo.boot.cache.kotlin

/**
 * name: com.hjf.boot.demo.boot.high_concurrency.kotlin
 * author: mickjoust
 * date: 2018/5/9
 **/
fun main(args: Array<String>){
    println("Hello World");
}

class Person(val firstname: String,val lastname: String) {
    constructor(name: String) : this(name, "")
    fun printDetails() = println("FirstName: ${firstname}, LastName: ${lastname}")
}

interface ReportSender
{
    fun generateReport() : String
    fun sendReport() {
        val report = generateReport()
        println("Report: "+ report)
    }
}

class HTMLReportSender : ReportSender
{
    override fun generateReport(): String = "<html><body>ReportData</body></html>"
}

//fun main(args: Array<String>)
//{
//    val rs = HTMLReportSender()
//    rs.sendReport()
//}