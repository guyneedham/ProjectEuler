package com.gn.euler

class SmallestMultiple {

  /*
   * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
      What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
  */
  
  def smallestMultiple(divisors: Range): Int = {
      
      // define a function to test for no remainder for all numbers in a range
      def noRemainder(divisors: Range)(x: Int): Boolean = divisors.forall( x % _ == 0)
      // range of all ints - originally used a Stream but that lead to memory issues as the Stream grew
      val ints = Range(divisors.max+1, Int.MaxValue)
      // find the first member of the range who satisfies the noRemainder predicate
      ints.find( x => noRemainder(divisors)(x) ).get
      
   }                              
      
   assert( smallestMultiple(1 to 10) == 2520 )

  
}