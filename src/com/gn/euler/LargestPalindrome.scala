package com.gn.euler

class LargestPalindrome {

  /*A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
* 
*/
  def isPalindrome(x: Int): Boolean = {
      val sx = x.toString
      sx == sx.reverse
    } 
  
  assert( isPalindrome(9009) == true)
  
  def palindromes(xs: Range) = for {
      x <- xs
      y <- xs
      if isPalindrome( x * y )
    } yield(x*y)                              
    
  assert( (palindromes(10 to 99).max) == 9009)
  
}