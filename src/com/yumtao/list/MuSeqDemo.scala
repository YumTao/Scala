package com.yumtao.list

import scala.collection.mutable.ListBuffer
/**
  * Created by yumtao on 2018/12/11.
  */
object MuSeqDemo {

  def main(args: Array[String]): Unit = {
    var list = ListBuffer(0, 2)
    list(1) = 1
    println(list)

    println(list += 1)
    println(list.append(1))

    println(ListBuffer(1) ++= ListBuffer(1))

    println(ListBuffer(1, 2) -= 1)

  }

}
