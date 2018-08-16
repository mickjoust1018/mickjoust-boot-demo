package com.hjf.boot.demo.boot.cache.scala

/**
  * name: com.hjf.boot.demo.boot.cache.scala
  * author: mickjoust
  * date: 2018/5/14
  **/
trait TestTest {
  def sendReport(report: String): Unit = {
    //模拟发送emal的content代码
  }
  def generateReport() : String
}
class HTMLSender extends TestTest {
  override def generateReport(): String = "<html><body>ReportData</body></html>"
}
