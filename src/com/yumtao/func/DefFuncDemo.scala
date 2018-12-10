package com.yumtao.func

/**
  * Created by yumtao on 2018/12/10.
  */
object DefFuncDemo {
  def main(args: Array[String]): Unit = {
    val sum = (x: Int, y: Int) => x + y;
    println(sum(1, 2))
  }

  def callFunc(func: (Int, Int) => Int): Int = {
    println(func)
    func(1, 2)
  }
}
