package com.yumtao.exception

import scala.None

/**
  * Created by yumtao on 2019/1/29.
  */
object TryCatch {
  def main(args: Array[String]): Unit = {
    val line = Array("zxcf|app|20191325235905000355719||2019-01-25 23:59:51|2087561|132123123312|余威|备注|",
      "zxcf|app|20191325235905000355718||2019-01-25 23:49:05|10090|132123123313|陶申|备注|999998")

    val rdd = line.map(_.split("\\|")).map(tmp => {
      try {
        // 将数据用Option对象返回，方便后期去除空值
        Option(tmp(2), tmp(5), tmp(9))
      } catch {
        case e: Exception => {
          println("has something error" + tmp.toBuffer)
          None
        }
      }
    })

    // 筛选去除空值
    val noNullRdd = rdd.filter(tmp => {
      tmp.isInstanceOf[Some[(String, String, String)]]
    }).map(_.get)
    println(noNullRdd.toBuffer)
  }
}
