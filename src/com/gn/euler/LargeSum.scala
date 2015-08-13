package com.gn.euler

/**
 * @author guyneedham
 */
class LargeSum {
 /*
  * Problem 13
Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
  *  
  */
  
  def largeSum(input: String, groupLength: Int = 50, sumLength: Int = 10): String = 
    input.filterNot(x => x == ' ' || x == '\n').grouped(groupLength).toList.map{BigInt(_)}.sum.toString.take(sumLength)
    //clean the input String                    group characters into a list of biginst    sum the list take the first few digits
  
  val testInput = """
37107287533902102798797998220837590246510135740250
46376937677490009712648124896970078050417018260538
"""
    assert( largeSum(testInput) == "8348422521" )
}