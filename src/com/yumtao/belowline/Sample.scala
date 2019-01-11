object Sample {
  def main(args: Array[String]) {
    /**
      * 偏函数：对已定义好的函数再次进行根据入参进行函数的封装,如下，将原本两个参数的函数，变为一个参数的偏函数
      */
    val set = setFunction(_: Double, _: Double)
    println(set(3, 7.1))
  }

  def setFunction(parm1: Double, parm2: Double): Double = parm1 + parm2
}

object Keli {
  def doubleParam(x: Int, y: Int) = x * y

  def keliFun(x: Int) = (y: Int) => x * y

  def main(args: Array[String]): Unit = {
    println(doubleParam(1, 2))
    println(keliFun(1)(2))

    val f4: (Int) => Int = { x => x * 4 }
    val f5 = (_: Int) * 5

    println(f4(1))

    println(f5(1))
  }

}