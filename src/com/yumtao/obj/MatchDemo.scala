package com.yumtao.obj

/**
  * Created by yumtao on 2018/12/29.
  */
object MatchDemo {
  def main(args: Array[String]): Unit = {
    val animal = Array(new Dog("xiaotianquan", 999), new Cat("tom"))
    animal.foreach(println)

    animal(0) match {
      case Dog(name, age) => println(s"Dog : $name, $age")
      case Cat(name) => println(s"Cat : $name")
      case _ => println("anything else")
    }

    println(partialDemo("one"))
  }

  /**
    * 偏函数 PartialFunction[input, output]
    * 方法定义时不定义入参
    *
    * @return
    */
  def partialDemo: PartialFunction[String, Int] = {
    case "one" => 1
    case "two" => 2
    case _ => 0
  }
}

case class Dog(name: String, age: Int)

case class Cat(name: String)




