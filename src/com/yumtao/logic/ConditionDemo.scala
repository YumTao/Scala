package com.yumtao.logic

/**
  * Created by yumtao on 2018/12/10.
  */
object ConditionDemo {

  def main(args: Array[String]): Unit = {
    val x = 0
    // if  val1 else val2
    val ifElse = if (x > 1) "yes" else 0
    // if val1 否则 ()
    val ifs = if (x > 1) 1
    // if val1 else if val2 else val3
    val ifElseIf = if (x > 1) "if" else if (x < 0) "elseIf" else "else"

    println(ifElse)
    println(ifs)
    println(ifElseIf)
  }
}
