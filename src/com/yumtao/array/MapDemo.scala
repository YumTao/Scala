package com.yumtao.array

import scala.collection.mutable.{ArrayBuffer, Map}

/**
  * Created by yumtao on 2018/12/11.
  */
object MapDemo {

  def main(args: Array[String]): Unit = {

    /**
      * 定义映射（json）：
      * 1. Map(key1 -> val1, key2 -> val2)
      * 2. Map((key1, val1), (key2, val2))
      *
      * 映射取值
      * 1. var(key)
      * 2. var.get(key).get
      * 3. var.getOrElse(key,defalut)
      */
    var taitan = Map("jack" -> 18, "rose" -> "20")
    println("key:jack, value:" + taitan.get("jack").get)

    var juren = Map(("sanli", 18), ("binzhang", "20"))
    println("key:binzhang, value:" + juren.get("binzhang").get)

    println(juren("binzhang"))
    println(juren.getOrElse("binzhang", 0))

    juren += (("arm", 19), ("ailun", 20))
    // 修改Map的值时，需import scala.collection.mutable.Map
    juren("sanli") = 81
    println(juren)
    juren ++= Map("laina" -> 18)
    println(juren)

  }

}
