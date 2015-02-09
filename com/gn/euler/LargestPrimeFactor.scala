package com.gn.euler

class LargestPrimeFactor {

	/* first attempt doesn't work well with large numbers
  def primeFactors(x: Int): List[Int] = {
    def isPrime(i: Int) : Boolean = {
          if (i <= 1)
            false
          else if (i == 2)
            true
          else
            !(2 to (i-1)).exists(x => i % x == 0)
        }
    val ints = (2 until x).toList filter isPrime filter (a => x % a == 0)
    //List(1)
    ints
   // primes(ints(2))  take 10 toList
  }

  def largestPrime(x: Int) = primeFactors(x).max
  //> primeFactors: (x: Int)List[Int]
  assert ( (largestPrime(13195) ) == 29 )
	 */

	// firstly find a stream of all prime Ints

	def largest(n: Long): Long = {
		lazy val ps: Stream[Int] =
			2 #:: ps.map(i =>
					Stream.from(i + 1).
					    find(j =>
					           ps.takeWhile(k => k * k <= j).forall(j % _ > 0)
				                 ).get
				     ) 
  
		val limit = math.sqrt(n)  // use a limit to reduce the number of stream elements
	    // search over limited list to find factors, and take the max
		val r = ps.view.takeWhile(_ < limit).filter(n % _ == 0).max
		r
	}

}
