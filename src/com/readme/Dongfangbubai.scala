package com.readme

import scala.actors.Actor._

/**
  * Created by yumtao on 2018/12/14.
  */
// 定义类，主私有构造方法
class Dongfangbubai private(val name: String) {
  def kill(name: String): Unit = {
    println("%s kill %s".format(this.name, name))
  }

  def play(game: String, members: Array[Member], perform: Member => String) = {
    println("Thre group is playing a game : %s".format(game))
    members.foreach {
      member =>
        val result = perform(member)
        if (result != null) println(result)
    }
  }

  /*Curry化函数定义，fun(a)(b)(c)*/
  def play_curry(game: String, members: Array[Member])(perform: Member => String) = {
    this.play(name, members, perform)
  }

  def search(condition: Any): String = {
    Thread.sleep(2000)
    return "the result is : their are too many people named jeff!"
  }

}

/*Dongfangbubai的伴生对象*/
object Dongfangbubai {
  /*创建字典对象*/
  private val groups = Map(
    ("techparty", new Dongfangbubai("techparty")),
    ("barcamp", new Dongfangbubai("barcamp"))
  )

  def getGroup(name: String): Dongfangbubai = {
    if (groups.contains(name)) groups.get(name).get else null
  }
}

class Member(val name: String, val topic: String) extends Fan {
  /*副构造函数：前提必须直接或间接调用主构造函数*/
  def this(name: String) {
    this(name, null)
  }
}

/*定义特性*/
trait Fan {
  def like() = "techparty"
}

/*扩展特性*/
trait JavaFan extends Fan {
  override def like(): String = "java, %s".format(super.like())
}

trait PythonFan extends Fan {
  override def like(): String = "python, %s".format(super.like())
}

/*继承App对象，编程可执行函数*/
object HelloScala extends App {
  /*Object定义的属性与方法相当于java里的静态属性与静态方法*/
  val techparty = Dongfangbubai.getGroup("techparty")

  /*DSL风格的函数调用*/
//  techparty kill "linghuchong"

  /*数组创建*/
  val members = Array(
    new Member("renwoxing", "49") with JavaFan, // 运行时混入特性，可混入多个特性
    new Member("yingying", "18") with Fan,
    new Member("yuebuqun") with PythonFan with JavaFan,
    new Member("lingpingzhi")
  )

  /*以闭包做为参数调用函数*/
//  techparty.play("baskatboll", members, member => "My name is wowowo")

  def present(member: Member) = {
    if (member.topic != null) member.name + " is presenting." else null
  }

  /*入参为函数调用函数*/
//  techparty.play("present", members, present)

  /*偏应用函数的定义及使用*/
  val potluck = techparty.play("let`s go potluck", members, _: Member => String)

  /*函数的Curry化*/
  techparty.play_curry("dismiss", members) {
    member => member.name + " is leaving and going home"
  }


  val receiver = self // 把自己编程一个actor， self 不是this
  actor { // 创建一个Actor
    // 给另一个actor异步发送消息
    receiver ! techparty.search("jeff", 2010)
  }
  val jane = actor {
    receiver ! (self, techparty.search("gfw"))
  }

  /*For循环*/
  for (i <- 1 to 2) {
    receive {// 同步接收消息
      // 模式匹配
      case (at, status: String) => println("hey,jane have her searching job done!")
      case result: String => println("search result: " + result)
    }
  }
}



