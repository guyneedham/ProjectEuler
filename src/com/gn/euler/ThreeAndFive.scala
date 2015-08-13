package com.gn.euler



class ThreeAndFive {

  /*
   * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
   * The sum of these multiples is 23.

     Find the sum of all the multiples of 3 or 5 below 1000.
   * 
   */
  
  val toTen = (1 until 10).toList
  // curried function
  private def divides(x: Int)(a: Int): Boolean =  x % a == 0 
  // two partially applied functions
  private def mulThree(x: Int) = divides(x)(3)
  private def mulFive(x: Int) = divides(x)(5)
  // filter a sequence and find its sum
  def mulThreeOrFive(xs: Seq[Int]) = xs filter ( x => mulThree(x) || mulFive(x) ) sum
  // assert syntax for in-line testing
  val test = mulThreeOrFive( toTen)               //> test  : Int = 23
  assert( test == 23)
  
}
