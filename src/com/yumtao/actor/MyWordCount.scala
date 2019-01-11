package com.yumtao.actor

import scala.actors._
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by yumtao on 2019/1/2.
  */

class WordCountMapTask extends Actor {
  override def act(): Unit = {
    loop {
      react {
        case SubmitTask(filename) => {
          // do task
          //  ("hello world hello yumtao") -> map("hello" -> 2, world -> 1, yumtao -> 1)
          val mapResult = Source.fromFile(filename).getLines().flatMap(_.split(" ")).map((_, 1)).toList.groupBy(_._1).mapValues(_.foldLeft(0)(_ + _._2))
          sender ! ResultTask(mapResult)
        }
        case ShutDownTask => {
          exit()
        }
      }
    }
  }
}

class WordCountReduceTask extends Actor {
  private var totalResult: Map[String, Int] = Map()

  override def act(): Unit = {
    loop {
      react {
        case ResultTask(result) => {
          totalResult = (totalResult.toList ++ result.toList).groupBy(_._1).mapValues(_.foldLeft(0)(_ + _._2))
          sender ! totalResult
        }
        case ShutDownTask => {
          exit()
        }
      }
    }
  }
}

case class SubmitTask(filename: String)

case class ResultTask(result: Map[String, Int])

case object ShutDownTask

object MyWordCount {
  def main(args: Array[String]): Unit = {
    var resultSet = new mutable.HashSet[Future[Any]]()

    val fileGroup = Array[String]("D://wordcount.txt", "D://wordcount2.txt")
    for (file <- fileGroup) {
      val map = new WordCountMapTask()
      map.start()
      val value = map !! SubmitTask(file)
      resultSet += value
      println("isset: " + value.isSet)
      println("value:[" + value.apply().asInstanceOf[ResultTask])
    }

    val reduce = new WordCountReduceTask()
    reduce.start()
    val resultVal = resultSet.filter(_.isSet)
    for (result <- resultVal) {
      val mapValue = result.apply().asInstanceOf[ResultTask]
      val value = reduce !? mapValue
      println(value)
    }

  }
}


