package com.yumtao.obj

/**
  * Created by yumtao on 2018/12/11.
  */
class Person {
  //用val修饰的变量是只读属性，有getter但没有setter
  //（相当与Java中用final修饰的变量）
  val id = "9527"

  //用var修饰的变量既有getter又有setter
  var age: Int = 18

  //用var修饰的变量既有getter又有setter
  var name: String = "未知名"

  //类私有字段,只能在类的内部使用
  private var higher: Int = 160

  //对象私有字段,访问权限更加严格的，Person类的方法只能访问到当前对象的字段
  private[this] var length: Int = 18

}