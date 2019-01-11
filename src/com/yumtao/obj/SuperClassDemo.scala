package com.yumtao.obj

/**
  * Created by yumtao on 2018/12/18.
  */
trait Flyable {
  def fly(): Unit = {
    println("I can fly")
  }

  def flight(): String
}

abstract class Animal {
  def run(): Int

  val name: String
}

class Human extends Animal /* with Flyable */ {
  val name: String = "abc"

  // t1 = (1, 2, 3), t2 = (1, 2, 3), (a, b, c) = (1, 2, 3)
  val t1, t2, (a, b, c) = {
    println("ABC")
    (1, 2, 3)
  }

  println(t1, t2, a, b, c)

  //  println(a)
  //  println(t1._1)


  /*def flight(): String = {
    "flight with 棒子"
  }*/

  def run(): Int = {
    1
  }

}

object SuperClassDemo {
  def main(args: Array[String]): Unit = {
    val human = new Human with Flyable {
      override def flight(): String = "aaa"
    }
    //    println(human.flight())
    human.fly()
    println(human.flight())

  }
}
