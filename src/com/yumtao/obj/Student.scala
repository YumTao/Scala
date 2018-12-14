package com.yumtao.obj

/**
  * Created by yumtao on 2018/12/11.
  * 每个类都有主构造器，主构造器的参数直接放置类名后面，与类交织在一起
  */
class Student(val name: String, val age: Int) {
  //主构造器会执行类定义中的所有语句
  println("执行主构造器")

  try {
    println("发生异常")
    throw new RuntimeException("has some error, maybe i want sleep")
  } catch {
    case e: RuntimeException => println("runtime:" + e.getMessage)
    case e: Exception => println("exception:" + e.getMessage)
  } finally {
    println("make the light dark")
  }

  private var gender = "male"

  private[this] var weight: Double = 66.66

  //用this关键字定义辅助构造器
  def this(name: String, age: Int, gender: String) {
    //每个辅助构造器必须以主构造器或其他的辅助构造器的调用开始
    this(name, age)
    println("执行辅助构造器")
    this.gender = gender
  }

  def this(name: String, age: Int, gender: String, weight: Double) {
    this(name, age, gender)
    println("执行第二辅助构造器")
    this.weight = weight
  }

  def testFun = println("invoke testFun")

  override def toString: String = "name: " + this.name + ", age: " + this.age + ", gender:" + this.gender + ", weight:" + this.weight
}

object StudentInstanceTest {
  def main(args: Array[String]): Unit = {
    //    val student = new Student("张三", 10)
    //    println(student)

    val standGena = new Student("李四", 20, "男")
    println(standGena)

  }
}