package com.yumtao.obj

import scala.collection.mutable.ArrayBuffer

/**
  * Created by yumtao on 2018/12/11.
  */
object SingletonDemo {
  def main(args: Array[String]): Unit = {
    val session = SingletoFactory getSession;
    println(session)
    val session2 = SingletoFactory getSession;
    println(session2)

    println(SingletoFactory.counts)
  }
}

object SingletoFactory {
  // 相当于java的静态成员变量
  var counts = 1
  var sessions = ""

  if (counts > 0) sessions = "session"

  def getSession: String = {
    sessions
  }

}
