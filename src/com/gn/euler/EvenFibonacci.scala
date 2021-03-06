package com.gn.euler

class EvenFibonacci {

  /*
   * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
   */
  
	def makeFib(xs: List[Int], end: Int): List[Int] = xs match {

	    case a :: b :: ys => if (a + b < end ) makeFib( a+b :: xs, end)
			                     else xs
	    case _ => xs
	} 

	def filterFib(xs: List[Int], end: Int, f: Int => Boolean): List[Int] = {

			makeFib(xs, end) filter f

	}   

  
  
}