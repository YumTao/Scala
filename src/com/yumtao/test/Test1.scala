package com.yumtao.test

/**
  * Created by yumtao on 2018/12/25.
  */
object Test1 {
  def main(args: Array[String]): Unit = {

    //创建一个List
    val lst0 = List(1, 7, 9, 8, 0, 3, 5, 4, 6, 2)
    //将lst0中每个元素乘以10后生成一个新的集合
    val list0_10: List[Int] = lst0.map(_ * 10)
    println(s"将lst0中每个元素乘以10后生成一个新的集合 $list0_10")

    //将lst0中的偶数取出来生成一个新的集合
    val list0_even: List[Int] = lst0.filter(_ % 2 == 0)
    println(s"将lst0中的偶数取出来生成一个新的集合 $list0_even")

    //将lst0排序后生成一个新的集合
    val list0_order: List[Int] = lst0.sorted
    println(s"将lst0排序后生成一个新的集合 $list0_order")

    //将lst0排序后生成一个新的集合
    val list0_order2: List[Int] = lst0.sortBy { case (value) => 0 - value }
    println(s"将lst0倒排后生成一个新的集合 $list0_order2")

    //将lst0排序后生成一个新的集合
    val list0_order3: List[Int] = lst0.sortWith { case (left, right) => left > right }
    println(s"将lst0倒排后生成一个新的集合 $list0_order3")

    //反转顺序
    val reverse: List[Int] = lst0.reverse
    println(s"反转顺序 $reverse")

    //将lst0中的元素4个一组,类型为Iterator[List[Int]]
    val iterator: Iterator[List[Int]] = lst0.grouped(4)
    println(s"将lst0中的元素4个一组,类型为Iterator[List[Int]] $iterator")

    //将Iterator转换成List
    val list: List[List[Int]] = iterator.toList
    println(s"将Iterator转换成List $list")
    val flatten: List[Int] = list.flatten
    println(s"flatten List $flatten")

    //将多个list压扁成一个List
    val list1 = List(1)
    val list2 = List(2)
    val list3 = List(3)
    val lists = Array(list1, list2, list3).toList.flatten
    println(s"多个list结果$lists")

    //并行计算求和
    val reduce: Int = lst0.par.reduce(_ + _)
    //  val reduce: Int = lst0.par.reduce((a, b) => a + b)
    println(s"计算求和$reduce")

    //   //化简：reduce
    //   //将非特定顺序的二元操作应用到所有元素
    //
    //   //安装特点的顺序
    //
    //
    //   //折叠：有初始值（无特定顺序）
    //
    //   //折叠：有初始值（有特定顺序）
    //
    //
    //   //聚合
    //   val arr = List(List(1, 2, 3), List(3, 4, 5), List(2), List(0))
    //
    //
    val l1 = List(5, 6, 4, 7)
    val l2 = List(1, 2, 3, 4)
    //求并集
    println("求并集" + (l1.union(l2)))

    //求交集
    println("求交集" + (l1.intersect(l2)))

    //求差集
    println("求差集" + (l1.diff(l2)))

    val lines = List("hello tom hello jerry", "hello jerry", "hello kitty")
    //先按空格切分，在压平
    lines.flatMap(_.split(" ").toList)
    println(s"先按空格切分，在压平$lines")

    val groupBy: Map[String, List[(String, Int)]] = lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1)
    println(s"groupby: $groupBy")

    //  List((jerry,1), (jerry,1))
    // list.foldLeft(初始值)(左边元素与初始值相同类型值, 右边当前元素)
    val mapValues = groupBy.mapValues(_.foldLeft(0)(_ + _._2))
    println(s"mapValues: $mapValues")

    //  val stringToInt: Map[String, Int] = lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).mapValues(_.foldLeft(0)(_ + _._2))
    //  lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).map(t => (t._1, t._2.size)).toList.sortBy(_._2).reverse

  }
}

