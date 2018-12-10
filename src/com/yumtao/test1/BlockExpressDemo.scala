package com.yumtao.test1

/**
  * Created by yumtao on 2018/12/10.
  */
object BlockExpressDemo {

  def main(args: Array[String]): Unit = {
    val blockVal = {
      val condition = 10
      val ifVal = if (condition % 3 == 1) "1" else if (condition % 3 == 2) "2" else "0"
      println(ifVal)
      if (ifVal == 1) 1 else if (ifVal == 2) 2 else 0
    }

    // 块表达式的定义变量值=块表达式的值
    val blockVal2 = {
      2
    }

    println(blockVal)
    println(blockVal2)
  }
}
