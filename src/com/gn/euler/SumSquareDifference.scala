package com.gn.euler

class SumSquareDifference {

  /*The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum. */
  
  def sumSquareDifference(max: Int): Int = {
  
    def sqr(x: Int) = scala.math.pow(x, 2).toInt
    val allInts = Stream.from(1)
    val ints = allInts.take(max).toList
    val sumSqrs = ints.map{x => sqr(x)}.sum
    val sqrSum = sqr(ints.sum)
    sqrSum - sumSqrs
  }
  
}