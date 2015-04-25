package com.gn.euler

class LargestPrimeFactor {
	

	def largest(n: Long): Long = {
		// firstly find a stream of all prime Ints
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
				     ) 
  
		val limit = math.sqrt(n)  // use a limit to reduce the number of stream elements
	        // search over limited list to find factors, and take the max
		val r = ps.view.takeWhile(_ < limit).filter(n % _ == 0).max
		r
	}

}
