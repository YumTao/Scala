//package com.yumtao.actor
//
//import java.io._
//
//import scala.actors._
//import scala.io.Source
//import scala.collection.mutable
//
///**
//  * Created by yumtao on 2018/12/24.
//  */
//class WordCountActor extends Actor {
//  override def act(): Unit = {
//    loop {
//      react {
//        case SubmitTask(fileName) => {
//          val content = Source.fromFile(new File(fileName)).mkString
//          val arr = content.split("\r\n")
//          // [hello world] -> [hello, world]
//          val flatMap = arr.flatMap(_.split(" "))
//
//          // [hello, world]  -> [(hello,1), (world, 1)]
//          val map = flatMap.map((_, 1))
//
//          // [(hello,1), (world, 1)] -> Map(hello -> 1, world -> 1)
//          val toMap = map.toMap
//          println(s"current statistic wordcount $toMap")
//          sender ! ResultTask(toMap)
//
//
//        }
//        case EndTask => {
//          // 将统计结果返回去
//        }
//      }
//    }
//  }
//}
//
//case class SubmitTask(fileName: String)
//
//case class ResultTask(result: Map[String, Int])
//
//case class EndTask()
//
//object WordCount extends App {
//
//  val replaySet = new mutable.HashSet[Future[Any]]
//  val resultList = new mutable.ListBuffer[ResultTask]
//
//  val files = Array("D:/wordcount.txt", "D:/wordcount2.txt")
//  for (file <- files) {
//    val actor = new WordCountActor()
//    actor.start()
//    val result: Future[Any] = actor !! new SubmitTask(file)
//    replaySet += result
//    val value = result.apply()
//    println(value)
//
//    val resultTask = value.asInstanceOf[ResultTask]
//    println(resultTask.result.getClass)
//    println(resultTask.result)
//    resultList += resultTask
//  }
//
//  while(replaySet.size > 0){
//    val toCumpute = replaySet.filter(_.isSet)
//    for(r <- toCumpute){
//      val result = r.apply()
//      resultList += result.asInstanceOf[ResultTask]
//      replaySet.remove(r)
//    }
//    Thread.sleep(100)
//  }
//  val finalResult = resultList.map(_.result).flatten.groupBy(_._1).mapValues(x => x.foldLeft(0)(_ + _._2))
//  println(finalResult)
//
//
//
//  //  private val source: Source = Source.fromString("hehehe")
//  //  println(source.mkString)
//}
