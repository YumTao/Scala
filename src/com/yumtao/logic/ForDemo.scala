package com.yumtao.logic

/**
  * Created by yumtao on 2018/12/10.
  */
object ForDemo {
  def main(args: Array[String]): Unit = {
    // for(i <- begin to end)
    for (i <- 1 to 10) {
      print(i + ", ")
    }
    println("\r\n《《for(i <- begin to end)》》 测试完毕\r\n")

    // for(i <- array)
    val array = Array("a", "b", 1)
    for (i <- array)
      print(i + ", ")
    println("\r\n《《for(i <- array)》》 测试完毕\r\n")

    // for 循环中可加入一个if来进行筛选
    // for(i <- array if ...)
    for (i <- 1 to 10 if i % 2 == 0 || i == 1)
      print(i + ", ")
    println("\r\n《《for 循环中可加入一个if来进行筛选》》 测试完毕\r\n")

    // 高级for： for嵌套，同一个括号内使用分号分隔
    for (i <- 1 to 5; j <- 1 to 2)
      print("[" + i + "," + j + "]")
    println("\r\n《《高级for： for嵌套》》 测试完毕\r\n")

    for (i <- 1 to 5; j <- 1 to 2; k <- 1 to 3) {
      val position = "[" + i + "," + j + "," + k + "]";
      print(position)
    }
    println("\r\n《《高级for： for嵌套3层嵌套》》 测试完毕\r\n")

    // for 循环加上yield关键字，可进行集合构造
    var numStar = for (i <- 1 to 2 ) yield i + "*"
      print(numStar)
    println("\r\n《《for 循环yield关键字》》 测试完毕\r\n")

    var testYield = for (i <- 1 to 3) yield {
      print(i + ", ")
      i * 2
    }
    println()
    println("testYield:" + testYield)

    // 不使用yield关键字时，获取到for循环的结果为()
    var testYield2 = for (i <- 1 to 3) {
      print(i + ", ")
      i
    }
    println()
    println("testYield2:" + testYield2)



  }

}
