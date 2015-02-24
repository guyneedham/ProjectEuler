package com.gn.euler

class NthPrime {

  def nthPrime(n: Int): Int = {
    
    lazy val ps: Stream[Int] =
          2 #:: ps.map(i =>
          Stream.from(i + 1).find(j =>
          ps.takeWhile(k => k * k <= j).forall(j % _ > 0)
              ).get
              )
                                                  //> ps: => Stream[Int]
     ps.take(n).last  
    
  }
  
}