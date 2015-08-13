package com.gn.euler

class PythagoreanTriplet {

  def pythagorean(target: Int): Int = {
                                  
  def sqr(x: Int): Int = scala.math.pow(x, 2).toInt
                                                  
  val res = for {
    b <- 2 until target
    a <- 1 until b
    c = 1000 - a - b
    if (sqr(a) + sqr(b) == sqr(c)) && (a+b+c == target)
  } yield a*b*c
  
  res.head
  }    
  
}
