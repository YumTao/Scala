package com.yumtao.actor

import scala.actors._

/**
  * Created by yumtao on 2018/12/18.
  * 1.先调用start()方法启动Actor
  * 2.调用start()方法后其act()方法会被执行
  * 3.向Actor发送消息
  * 发送消息的方式
  * !	  发送异步消息，没有返回值。
  * !?	发送同步消息，等待返回值。
  * !!	发送异步消息，返回值是 Future[Any]。
  *
  */
class MyActor extends Actor {
  override def act(): Unit = {
    println("act function started")
    while (true) {
      receive {
        case "start" => {
          println("staring ...")
          Thread.sleep(1000)
          println("started")
        }
        case "stop" => {
          println("stopping ...")
          Thread.sleep(1000)
        }
      }
    }
  }
}

object MyActorTest {
  def main(args: Array[String]): Unit = {
    val act = new MyActor()
    act.start()
    act ! "start"
    act ! "stop"
    act ! "stopsss"
  }
}

/**
  * reactor
  */

class MyReActor extends Actor {
  override def act(): Unit = {
    loop {
      react {
        case "start" => {
          println("staring2 ...")
          Thread.sleep(1000)
          println("started2")
        }
        case "stop" => {
          println("stopping2 ...")
          Thread.sleep(1000)
        }
      }
    }
  }
}

object MyReActorTest {
  def main(args: Array[String]): Unit = {
    val reactor = new MyReActor()
    reactor.start()
    reactor ! "start"
  }
}


/**
  * case class
  */
class CaseClassActor extends Actor {
  override def act(): Unit = {
    loop {
      react {
        case "start" => println("started")
        case SyncMsg(id, msg) => {
          println(s"$id,sync :$msg")
          // 回复消息
          sender ! ReplyMsg(3, "finish communication")
        }
        case AsyncMsg(id, msg) => {
          println(s"$id,sync :$msg")
        }
      }
    }
  }
}

case class SyncMsg(id: Int, msg: String)

case class AsyncMsg(id: Int, msg: String)

case class ReplyMsg(id: Int, msg: String)

object CaseClassActorTest extends App {
  val actor = new CaseClassActor()
  actor.start()
  private val result: Any = actor !? SyncMsg(1, "hello")
  private val msg: ReplyMsg = result.asInstanceOf[ReplyMsg]
  println(msg.toString)

  //  println(result.isSet)
  //  println(result.apply())
}