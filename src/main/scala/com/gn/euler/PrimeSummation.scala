package com.gn.euler

class PrimeSummation {

  assert( sumPrimes(10) == 17L)
  
  def sumPrimes(limit: Int): Long = {
    
    lazy val ps: Stream[Int] =
            // stream starting at 2
            // going on to infinity
            // built with recursive call to ps
      2 #:: ps.map(i =>
                      // map value to a stream of values
          Stream.from(i + 1).
              // find the next value satisfying this
              find(j =>
                     // all values where k^2 is less than the value j and j is prime
                     ps.takeWhile(k => k * k <= j).forall(j % _ > 0)
                     // get method returns value from an Option type
                         ).get
             )            //> ps: => Stream[Int]
             
    val result = ps.takeWhile(_ < limit).foldLeft(0L)(_ + _)
    return result
    
    
  }
  
}
