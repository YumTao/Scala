package com.yumtao.obj

/**
  * 伴生对象：相同类名的类(class)与对象(object)
  * 可相互调用对方的方法与属性包含私有方法与属性，但私有对象属性不能相互调用
  * 注意同一方法不能相互调用，否则会栈溢出
  * Created by yumtao on 2018/12/12.
  */
class SingletonByApply private {
  val color: String = "black"

  private var name: String = "jack"

  private[this] var len: Int = 18

  def eat: Unit = {
    println("dog : %s can eat bone， its age is : %d".format(name, SingletonByApply.age))
  }

}

object SingletonByApply {
  var age: Int = 1

  def lookAfterHome = {
    val dog = new SingletonByApply()
    println("dog name is %s".format(dog.name))
    dog.eat
  }

  /*饿汉式：直接先创建： scala中貌似没有办法实现懒汉式*/
  private[this] val singletonObj = new SingletonByApply

  // 定义apply(args)方法后，外部调用 Object(args)，及调用apply(args)方法，注意参数要相同，且无参时括号不能省略
  def apply() = {
    println("object apply")
    singletonObj
  }

  def main(args: Array[String]): Unit = {
    for (i <- 1 until 10) println(SingletonByApply)
  }

}
