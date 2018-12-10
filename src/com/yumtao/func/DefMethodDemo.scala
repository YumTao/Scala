package com.yumtao.func

/**
  * Created by yumtao on 2018/12/10.
  */
object DefMethodDemo {

  // args : argName1 : argType2, argName1 : argType2
  // 方法定义格式： def funname(args) [: retunType] = funcBody
  def productApple(): String = "apple"

  // 方法定义格式： def funname(args) [: retunType] = { funcBody }
  def productOrange(): String = {
    "Orange"
  }

  // 方法定义格式： def funname(args) [: retunType] { funcBody }
  def productBanana(){
    "Orange"
  }

  def main(args: Array[String]): Unit = {
    println(DefMethodDemo productApple())
    println(DefMethodDemo productOrange())
    println(DefMethodDemo productBanana())

  }

}
