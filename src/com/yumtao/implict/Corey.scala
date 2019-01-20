package com.yumtao.implict

import scala.math.Ordering

/**
  * Created by yumtao on 2019/1/20.
  */
case class Girl(val name: String, val faceValue: Int, val age: Int)


/**
  * 上下文界定: 必须传入一个隐式参数（隐式值）
  */
class Choose[T: Ordering] {
  /**
    * 科里化与隐式参数结合使用
    *
    * @param ord 隐式参数，调用时未传入，则在import的上下文查找匹配类型的隐式参数
    */
  def getMostBeauty(left: T, right: T)(implicit ord: Ordering[T]): T = {
    if (ord.gt(left, right)) left else right
  }
}

object Corey extends App {
  val g1 = Girl("beiluqi", 98, 40)
  val g2 = Girl("sijiali", 95, 30)

  import MyPredef.highFaceValueGirl
  val choose = new Choose[Girl]()

  val mostBeauty = choose.getMostBeauty(g1, g2)
  println(mostBeauty.name)
}

