package com.yumtao.implict

/**
  * Created by yumtao on 2019/1/20.
  */
case class Student(val name: String, val score: Int)

/**
  * 视图界定：必须传入一个隐式转换的函数
  * T <% ImplictObj[T]
  * 隐式将 T => 转换为 ImplictObj[T]
  * 注意：使用前要先导入对应隐式转换
  */
class Compare[T <% Ordered[T]] {
  def getBetter(left: T, right: T): T = {
    if (left > right) left else right
  }
}

object ViewBound extends App{
  val stud1 = Student("tangbohu", 100)
  val stud2 = Student("zhuzhishan", 10)

  import MyPredef.highScoreStudent
  val compare = new Compare[Student]()
  val better = compare.getBetter(stud1, stud2)
  println(better.name)

}


