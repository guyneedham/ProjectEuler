package com.gn.euler

class LargestPrimeFactor {
	

	def largest(n: Long): Long = {
		// firstly find a stream of all prime Ints
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
