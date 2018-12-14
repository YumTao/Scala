package com.yumtao.list

import scala.collection.mutable.Set

/**
  * Created by yumtao on 2018/12/11.
  */
object SetDemo {

  def main(args: Array[String]): Unit = {
    var orgSet = Set(0)
    var set1 = orgSet + 1
    var set2 = orgSet ++ Set(0, 1, 2)
    println(orgSet)
    println(set1)
    println(set2)
    println(set2.getClass)

    orgSet += 2
    println(orgSet)

    orgSet.remove(2)
    println(orgSet.remove(2))
    println(orgSet)

  }

}
