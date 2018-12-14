package com.yumtao.logic

/**
  * Created by yumtao on 2018/12/10.
  */
object DefVal {
  def main(args: Array[String]) {
    // val 定义的变量值不可变
    val i = 1
    // var 定义的变量可变（同js var）
    var s = "hello"
    // 声明变量的类型（可不用，scala会自动判断变量的类型）
    val str: String = "world"

    println(i)
    println(s)
    println(str)
  }

}
