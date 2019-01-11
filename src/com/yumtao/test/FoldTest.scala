package com.yumtao.test

object FoldTest {
  def main(args: Array[String]): Unit = {
    val intList = List(1, 2, 3)
    println(intList.fold(0)(_ + _))
    println(intList.foldLeft(0)(_ + _))

    val stringList = List("aaa", "cccccc", "b")
    println(stringList.fold("")(fun2))

    val tuples = List(("aa", 1), ("aa", 2))

    val tuple2 = tuples.fold(("aa", 0))((left, right) => (left._1, left._2 + right._2))
    println(tuple2)

    // 如需折叠后改变类型，则用foldLeft不用fold
    val i = tuples.foldLeft(0)(_ + _._2)
    println(i)

    val dupList = List(List(1, 2, 3), List(10, 10, 10))
    val sum = dupList.foldLeft(0)(_ + _ (1))
    println(sum)

  }

  def fun2(left: String, right: String): String = {
    left + right
  }
}