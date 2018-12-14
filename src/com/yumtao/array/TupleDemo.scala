package com.yumtao.array

/**
  * Created by yumtao on 2018/12/11.
  */
object TupleDemo {

  def main(args: Array[String]): Unit = {
    // 元组
    val tuple1 = ("x", "y", "z")
    println(tuple1)
    // 元组取值 var._index : index从1开始
    println(tuple1._1)

    // 最简单的元组，只包含两个元素，称为对偶， 与映射中的元素相同
    val simTuple = ("x", 1)
    // 对偶转换成映射
    val map = Array(simTuple).toMap
    println(map.get("x").get)

    /**
      * 格式： keySet.zip(valueSet)
      */
    // zip 命令：关联两个集合为映射
    // 格式
    val age = Array(1, 2, 3, 4)
    val name = Array("jack", "rose", "tom")
    val na = name zip age
    println(na.toMap)
  }

}
