package com.yumtao.implict

import java.io.File

/**
  * Created by yumtao on 2019/1/20.
  */
object HelloWorld extends App {

  /**
    * JAVA中，继承、代理、装饰区别
    * 1. 继承是类级别的，自定义类继承父类所有非私有的功能与特性，使用时是通过new出来的
    * 2. 代理:对象级别的，根据原对象创建出代理对象。不改变原对象的方法名，只在方法前后环绕增加功能。（静、动态代理）
    * 3. 装饰:对象级别的，根据原对象创建出装饰者对象。对原对象方法进行包装，可改变功能、方法名。
    *
    * Scala 隐式转换包括: 隐式函数、隐式参数：动态封装对象，是对象加强的一种方式。
    * 原理是使用装饰者设计模式,在编译阶段将原对象包装成隐式转换后的对象
    * 注意：隐式函数 => 方法， 隐式参数 => 值
    */

  /*=========隐式函数使用=========*/
  // 1. 导入隐式转换
  import RichFile.getRichFile
  // 2. File 类中无read方法时，编译器会从import的上下文中去寻找有read方法的对象（File -> RichFile）
  new File("test").read()

  /*=========隐式参数使用=========*/
  // 1. 导入隐式参数
  import RichFile.params
  // 2. 执行隐式参数所在方法
  new RichFile(new File("test")).printParam

}

class RichFile(val file: File) {
  def read(): Unit = {
    println("I have read function")
  }

  def printParam(implicit arg: String = "default"): Unit = {
    println(arg)
  }
}

object RichFile {
  /**
    * 隐式函数定义
    */
  implicit def getRichFile(file: File): RichFile = new RichFile(file)

  /**
    * 隐式参数定义
    * 注意：隐式参数值的类型必须指定
    */
  implicit val params: String = "other"
}


