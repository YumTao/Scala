# Scala





## 隐式转换
[传送门](https://github.com/YumTao/Scala/tree/master/src/com/yumtao/implict)


**Q:JAVA中，继承、代理、装饰区别**
- 继承是类级别的，自定义类继承父类所有非私有的功能与特性，使用时是通过new出来的
- 代理:对象级别的，根据原对象创建出代理对象。不改变原对象的方法名，只在方法前后环绕增加功能。（静、动态代理）
- 装饰:对象级别的，根据原对象创建出装饰者对象。对原对象方法进行包装，可改变功能、方法名。

scala中的隐式转换，在编译期动态将原对象包装成包装对象，从而达到增强功能的目的。

包括隐式函数、隐式参数（隐式值）

### Hello World

    package com.yumtao.implict
    
    import java.io.File
    
    /**
      * Created by yumtao on 2019/1/20.
      */
    object HelloWorld extends App {
    
      /**
        * Scala 隐式转换、隐式参数：动态封装对象，是对象加强的一种方式。
        * 原理是使用装饰者设计模式,在编译阶段将原对象包装成隐式转换后的对象
        * 注意：隐式函数 => 方法， 隐式参数 => 值
        */
    
      /*=========隐式函数使用=========*/
      // 1. 导入隐式转换
      import RichFile.getRichFile
      // 2. File 类中无read方法时，编译器会从import的上下文中去寻找有read方法的对象（File -> RichFile）
      new File("test").read()
    
      /*=========隐式参数使用=========*/
      // 1. 导入隐式参数
      import RichFile.params
      // 2. 执行隐式参数所在方法
      new RichFile(new File("test")).printParam
    
    }
    
    class RichFile(val file: File) {
      def read(): Unit = {
        println("I have read function")
      }
    
      def printParam(implicit arg: String = "default"): Unit = {
        println(arg)
      }
    }
    
    object RichFile {
      /**
        * 隐式函数定义
        */
      implicit def getRichFile(file: File): RichFile = new RichFile(file)
    
      /**
        * 隐式参数定义
        * 注意：隐式参数值的类型必须指定
        */
      implicit val params: String = "other"
    }
    


### 科里化与隐式转换结合

#### 科里化代码

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
    

    
    
#### 隐式转化代码
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


### 视图界定（ViewBound）
相当于科里化+隐式转换，开发者不需要写科里化参数部分，scala默认将传入类型转换成隐式转换后的目标类型。
**注意传入为隐式函数，使用前需导入隐式转换，**

    package com.yumtao.implict
    
    /**
      * Created by yumtao on 2019/1/20.
      */
    case class Student(val name: String, val score: Int)
    
    /**
      * 视图界定：必须传入一个隐式转换的函数
      * T <% ImplictObj[T]
      * 隐式将 T => 转换为 ImplictObj[T]
      * 注意：使用前要先导入对应隐式转换
      */
    class Compare[T <% Ordered[T]] {
      def getBetter(left: T, right: T): T = {
        if (left > right) left else right
      }
    }
    
    object ViewBound extends App{
      val stud1 = Student("tangbohu", 100)
      val stud2 = Student("zhuzhishan", 10)
    
      import MyPredef.highScoreStudent
      val compare = new Compare[Student]()
      val better = compare.getBetter(stud1, stud2)
      println(better.name)
    
    }
    
    

