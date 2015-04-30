package com.gn.multiplesOf3and5



object testREPL {
  
 val toTen = (1 until 10).toList                  //> toTen  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  // curried function
 def divides(x: Int)(a: Int): Boolean =  x % a == 0
                                                  //> divides: (x: Int)(a: Int)Boolean
  // two partially applied functions
 def mulThree(x: Int) = divides(x)(3)             //> mulThree: (x: Int)Boolean
 def mulFive(x: Int) = divides(x)(5)              //> mulFive: (x: Int)Boolean
  // filter a sequence and find its sum
 def mulThreeOrFive(xs: Seq[Int]): Int = xs filter ( x => mulThree(x) || mulFive(x) ) sum
                                                  //> mulThreeOrFive: (xs: Seq[Int])Int
  // assert syntax for in-line testing
  val test = mulThreeOrFive( toTen)               //> test  : Int = 23
  assert( test == 23)
// assert( (mulThreeOrFive( toTen) ) == 23 )
 		
}