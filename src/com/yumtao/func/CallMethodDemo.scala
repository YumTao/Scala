package com.yumtao.func

import com.yumtao.logic.DefVal

/**
  * scala 中都是方法，任何操作实际上都是调用方法
  * Created by yumtao on 2018/12/10.
  */
object CallMethodDemo {
  def main(args: Array[String]): Unit = {
    // @NOTICE object.fun(args) 等价于 object fun args
    val a = 1
    val b = 1
    // a + b == a.+(b)
    val sum = a + b
    val sumFun1 = a.+(b)

    // DefVal.main(args) == DefVal main args
    DefVal.main(Array("aaa"))
    DefVal main Array("aaa")
  }

}
