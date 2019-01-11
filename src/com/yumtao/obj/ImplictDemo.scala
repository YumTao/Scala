package com.yumtao.obj

import scala.io.Source
import java.io.File

/**
  * Created by yumtao on 2019/1/10.
  */

/**
  * 隐式转换：
  * 1. 定义增强类class RichFile,提供增强方法
  * 2. 单例对象中写明隐式转换函数
  * 3. 使用前先导入隐式转换函数
  */

// 1. 定义增强类class RichFile,提供增强方法
class RichFile(val file: File) {
  def readTest: String = Source.fromFile(file).mkString
}

object RichFile {
  // 2. 单例对象中写明隐式转换函数
  // File --> RichFile
  implicit def getRichFile(file: File) = new RichFile(file)

}

object ImplictDemo {
  def main(args: Array[String]): Unit = {
    // 3. 使用前先导入隐式转换函数
    import com.yumtao.obj.RichFile.getRichFile
    println(new File("D://test.txt").readTest)
  }
}


/**
  * 隐式参数
  * 1. 定义增强类，参数加入implicit
  * 2. 单例对象中入参添加implicit关键字
  * 3. 使用前先导入隐式转换
  */
object Implicits_Param {
  implicit val default: String = "Java"
}

object Param {
  //函数中用implicit关键字 定义隐式参数
  def print(context: String)(implicit language: String) {
    println(s"$language:$context")
  }
}

object Implicit_Parameters {
  def main(args: Array[String]): Unit = {
    //隐式参数正常是可以传值的，和普通函数传值一样  但是也可以不传值，因为有缺省值(默认配置)
    Param.print("Spark")("Scala") //Scala:Spark

    import Implicits_Param._
    //隐式参数没有传值，编译器会在全局范围内搜索 有没有implicit String类型的隐式值 并传入
    Param.print("Hadoop") //Java:Hadoop
  }
}


object Implicit_Conversions_with_Implicit_Parameters {

  def main(args: Array[String]): Unit = {

    /**
      * (1)bigger[T]为泛型函数
      * (2)bigger(...)(...)该函数是柯里化的
      * (3)第二个括号传入的是一个匿名函数，类型为T => Ordered[T] orders是隐式参数 输入类型为T类型， 返回类型为Ordered[T]类型
      *
      **/
    def bigger[T](a: T, b: T)(implicit ordered: T => Ordered[T]) = {
      /**
        * ordered(a) > b中的">"是一个函数 具体定义在Ordered类中
        * Source define:
        * def >  (that: A): Boolean = (this compare that) >  0
        */
      if (ordered(a) > b) a else b // if (a > b) a else b  这样写也可以
    }

    println(bigger(4, 3)) //4
    println(bigger("Spark", "Hadoop")) //Spark
  }
}