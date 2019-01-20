package com.yumtao.implict

/**
  * 门面设计模式：将所有增强的功能隐式转换代码放入同一个类下，统一导入
  * Created by yumtao on 2019/1/20.
  */
object MyPredef {

  // 隐式参数定义: 创建rdering实例，根据颜值从高到低排
  implicit val highFaceValueGirl = new Ordering[Girl] {
    override def compare(x: Girl, y: Girl): Int = {
      if (x.faceValue > y.faceValue) 1 else -1
    }
  }

  // 隐式参数定义
  //  implicit object highFaceValue extends Ordering[Girl] {
  //    override def compare(x: Girl, y: Girl): Int = {
  //      if (x.faceValue > y.faceValue) 1 else -1
  //    }
  //  }


  // 隐式函数定义
  implicit val highScoreStudent = (std: Student) => new Ordered[Student] {
    override def compare(that: Student): Int = {
      std.score - that.score
    }
  }

}
