package com.yumtao.list

/**
  * Scala的集合有三大类：序列Seq、集Set、映射Map，所有的集合都扩展自Iterable特质
  * 在Scala中集合有可变（mutable）和不可变（immutable）两种类型，
  * immutable类型的集合初始化后就不能改变了（注意与val修饰的变量进行区别）
  * Created by yumtao on 2018/12/11.
  */
object SeqDemo {
  def main(args: Array[String]): Unit = {
    // list 头部插入
    /**
      * seq 头部插入, 与java 集合不同的是，对集合进行添加删除操作，需定义变量接收
      * 1. ::
      * 2. +:
      * seq 尾部插入： :+
      *
      * 新增的为集合时， 头部插入++：或 ::: ， 尾部插入 ++
      */
    val list1 = List(1)
    val headAdd = 0 :: list1

    println(list1)
    println(headAdd)

    val list2 = list1.+:(0)
    println(list2)

    val list3 = list1.:+(0)
    println(list3)

    println(List(1).++:(List(2)))

    println(List(1) ++ (List(2)))

    println(List(1, 2)(1))

  }
}
