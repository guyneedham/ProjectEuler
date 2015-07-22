package com.gn.multiplesOf3and5

import scala.annotation.tailrec
import com.gn.euler.Matrix

object testREPL {
 val mat = new Matrix(List(Array(1,2,3),Array(4,5,6),Array(7,8,9)))
                                                  //> mat  : com.gn.euler.Matrix = 
                                                  //| 1	2	3
                                                  //| 4	5	6
                                                  //| 7	8	9
 
 val mt = mat.transpose                           //> mt  : com.gn.euler.Matrix = 
                                                  //| 1	4	7
                                                  //| 2	5	8
                                                  //| 3	6	9
 
          
 
 def makeAList[A](item1: A, item2: A, item3: A): List[A] = List(item1, item2, item3)
                                                  //> makeAList: [A](item1: A, item2: A, item3: A)List[A]
 
 makeAList(1,2,3)                                 //> res0: List[Int] = List(1, 2, 3)
 makeAList("1", "2", "2")                         //> res1: List[String] = List(1, 2, 2)
 
}