package com.gn.euler

object Driver {

  def main(args: Array[String]) {
    
    val threeAndFive = new ThreeAndFive
    val toOneThou = (1 until 1000).toList
    val sumOneThou = threeAndFive.mulThreeOrFive( toOneThou )
  
    println( "Problem 1: " + sumOneThou )
    
    def evens(x: Int): Boolean = x % 2 == 0 
    
    val evenFib = new EvenFibonacci
    val sumEvens = evenFib.filterFib(List(2,1), 4000000,evens).sum
    
    println("Problem 2: " + sumEvens)
    
    val largePrimeFactor = new LargestPrimeFactor
    val largest = largePrimeFactor.largest( 600851475143L)
    
    println("Problem 3: "+largest)
    
    val largestPalindrome = new LargestPalindrome
    val largestPal = largestPalindrome.palindromes(100 to 999).max
    
    println("Problem 4: "+largestPal)
    
    val smallestMultiple = new SmallestMultiple
    val smallMult = smallestMultiple.smallestMultiple(1 to 20)
    
    println("Problem 5: "+smallMult)
    
    val sumSq = new SumSquareDifference
    val sumSqFirst100 = sumSq.sumSquareDifference(100)
    
    println("Problem 6: "+sumSqFirst100)
    
    val nthPr = new NthPrime
    val OnethPr = nthPr.nthPrime(10001)
    
    println("Problem 7: "+OnethPr)
    
    val largeProd = new SeriesProduct
    val thirteenth = largeProd.maxVal(13)
    
    println("Problem 8: "+thirteenth)
    
    val pyth = new PythagoreanTriplet
    val pythOneThou = pyth.pythagorean(1000)
    
    println("Problem 9: "+pythOneThou)
    
    val ps = new PrimeSummation
    val sumTwoMillion = ps.sumPrimes(2000000)
    
    println("Problem 10: "+sumTwoMillion)
    
  }
  
}
