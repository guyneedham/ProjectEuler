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
    
  }
  
}