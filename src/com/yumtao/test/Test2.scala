package com.yumtao.test

/**
  * Created by yumtao on 2018/12/26.
  */
object Test2 extends App {
  val lines = List("hello tom hello jerry", "hello jerry", "hello kitty")

  // 遍历集合按空格切分并压扁
  // List(hello, tom, hello, jerry, hello, jerry, hello, kitty)
  val wordGroup: List[String] = lines.flatMap(_.split(" "))

  // 遍历单词集合，组装成元组集合，(k,v),k为单词，v为次数
  // List((hello,1), (tom,1), (hello,1), (jerry,1), (hello,1), (jerry,1), (hello,1), (kitty,1))
  val wordOneTuple = wordGroup.map((_, 1))

  // 按单词进行分组，同单词的在一个List中
  // Map(tom -> List((tom,1)), kitty -> List((kitty,1)), jerry -> List((jerry,1), (jerry,1)), hello -> List((hello,1), (hello,1), (hello,1), (hello,1)))
  val groupByWord: Map[String, List[(String, Int)]] = wordOneTuple.groupBy(_._1)
  println(groupByWord)


  // 统计同单词的一组出现次数
  // mapValues(): 对map的value进行操作后，与原来的key重新组成map
  // foldLeft(B0)(B1,C) 对list进行折叠， B0:初始值， C:对当前元素的操作， B1:B0与C执行表达式后的值
  // Map(tom -> 1, kitty -> 1, jerry -> 2, hello -> 4)
  val countByWord: Map[String, Int] = groupByWord.mapValues(_.foldLeft(0)((defaultVal, elm) => defaultVal + elm._2))
  val _countByWord: Map[String, Int] = groupByWord.mapValues(_.foldLeft(0)(_ + _._2))

  // 对map进行排序
  // List((hello,4), (jerry,2), (kitty,1), (tom,1))
  val sortList: List[(String, Int)] = _countByWord.toList.sortBy(_._2).reverse

  // aggregate(初始值)((局部函数2), (汇总函数2))
  // 局部函数2(B, A) => {方法体}  B:初始值与方法体操作后的值， A: 当前元素
  // 汇总函数2(B, B) => {方法体}  B:初始值与方法体操作后的值， A: 当前元素
  val listGroup = List(List(1, 2, 3), List(1, 1, 1))
  val sum: Int = listGroup.aggregate(0)(_ + _.par.sum, _ + _)
  val sum2: Int = listGroup.aggregate(0)(((funVal, elm) => funVal + elm.par.sum), (seqVal1, seqVal2) => seqVal1 + seqVal2)

  val thirdDpList = List(List(List(1, 1, 1), List(2, 2, 2)), List(List(3, 3, 3), List(4, 4, 4)))
  val sumThird: Int = thirdDpList.aggregate(0)((default, dpList) => default + dpList.aggregate(0)(_ + _.sum, _ + _), (_ + _))
}
