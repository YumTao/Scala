package com.yumtao.array

import scala.collection.mutable.ArrayBuffer

/**
  * Created by yumtao on 2018/12/11.
  */
object ArrayDemo {

  def main(args: Array[String]): Unit = {

    //    valArray

    // 数组取值 arrayVal(index)
    //    println("获取数组[1,2,3]索引为0的值为：" + getFromArray(Array(1, 2, 3), 0))

    //    varArray

    //    varArrayOper(ArrayBuffer())

    varArrayForeach
  }

  /**
    * 定长数组，创建方式
    * 1. new Array(len)
    * 2. Array(len)
    * 3. Array(具体值)
    */
  private def valArray = {
    println("\r\n定长数组： new Array(len)")
    val valArray_new = new Array[Int](5)
    println(valArray_new)
    println(valArray_new.toBuffer)

    println("\r\n定长数组：Array(len)")
    val valArray = Array(5)
    println(valArray)
    println(valArray.toBuffer)

    println("\r\n定长数组：Array(args)")
    val valArray_value = Array(1, 2, 3)
    println(valArray_value)
    println(valArray_value.toBuffer)
  }

  /**
    * 数组取值 arrayVal(index)
    */
  def getFromArray(array: Array[Int], index: Int) = {
    array(index)
  }

  /**
    * 变长数组定义：
    * 1. new ArrayBuffer(len)
    * 2. ArrayBuffer(len)
    * 3. ArrayBuffer(具体值)
    */
  def varArray: Unit = {
    println("\r\n变长数组： new ArrayBuffer(len)")
    val ab = new ArrayBuffer[Int]()
    println(ab)
    println("array length : " + ab.length)

    val ab2 = ArrayBuffer()
    println(ab2)
    println(ab2.length)

    val ab3 = ArrayBuffer(1, 2, 3)
    println(ab3)
    println(ab3.length)
  }

  /**
    * 变长数组元素添加与删除
    */
  private def varArrayOper(ab: ArrayBuffer[Int]) = {
    /**
      * 变长数组尾部添加元素
      * 1. += 元素
      * 2. ++= 数组
      */
    ab += 1
    ab += (2, 3, 4)
    ab ++= Array(1, 1, 1)
    ab ++= ArrayBuffer(2, 2)
    println(ab)

    println("\r\n" + ab + ": insert(0,9)")
    // insert: 指定位置添加元素
    ab.insert(0, 9)
    println(ab)

    println("\r\n" + ab + ": remove(0)")
    println("remove value: " + ab.remove(0))
    println(ab)
  }

  /**
    * for 循环遍历： for(i <- array) {方法体}
    * reverse 数组倒序
    * until 同 to (1 until 3 == 1 to 2)： 注意 to 是左右包含， until 是左闭右开
    */
  private def varArrayForeach: Unit = {
    println("\r\n正序遍历")
    val varArray = ArrayBuffer(1, 2, 3)
    for (eml <- varArray) print(eml + ", ")
    println()

    println("\r\n倒序遍历")
    for (eml <- varArray.reverse) print(eml + ", ")
    println()

    println("\r\n 遍历中使用 until获取索引")
    for (index <- 0 until varArray.length) print("[index: " + index + ", eml:" + varArray(index) + "], ")
    println()

    println("\r\n 遍历中使用 to获取索引")
    for (index <- 0 to varArray.length - 1) print("[index: " + index + ", eml:" + varArray(index) + "], ")
    println()

  }

}
