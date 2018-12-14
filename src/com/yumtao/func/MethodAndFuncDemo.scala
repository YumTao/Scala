package com.yumtao.func

/**
  * Created by yumtao on 2018/12/10.
  */
object MethodAndFuncDemo {
  def main(args: Array[String]): Unit = {
    /**
      * 函数定义格式： (args) => 函数体
      * args : argName1: argType1, argName2: argType2...
      * 函数体: 单行无需加{}， 多行需使用{}
      */
    val sum = (x: Int, y: Int) => x + y
    println(sum(1, 2))
    val mul = (x: Int, y: Int) => {
      val temp = x + y
      temp * x * y
    }
    println(mul(1, 1))

    println(callFunc(sum))

    // 函数中可调用对应方法进行操作
    val strSub = (x: String, y: String) => type2Int(x) - type2Int(y)
    println(strSub("111", "11"))

    /**
      * 方法转函数  methodName _
      */
    val type2IntFunc = type2Int _
    println(type2IntFunc("111"))
  }

  /**
    * 定义方法，入参为函数，方法体操作函数
    * 1.函数可以像任何其他数据类型一样被传递和操作
    * 2.所以方法中可使用函数做为入参，与操作调用函数
    *
    * @param func
    * @return
    */
  def callFunc(func: (Int, Int) => Int): Int = {
    func(1, 2)
  }

  def type2Int(str: String): Int = {
    str.toInt
  }

}
