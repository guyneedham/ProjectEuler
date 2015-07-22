package com.gn.euler

import scala.annotation.tailrec
/** A 2D matrix of Ints.
 *  @constructor create a new Matrix
 *  @param rows the rows of the matrix
 *  {{{
 *  val mat = new Matrix(List(Array(1,2,3),Array(4,5,6),Array(7,8,9)))
 *  //> mat  : com.gn.euler.Matrix = 
 *  //| 1 2 3
 *  //| 4 5 6
 *  //| 7 8 9
 *  }}}
 */
class Matrix(val rows: List[Array[Int]]) {
    val nrows = rows.size
    val ncols = rows(0).size
    var matrix = makeMatrix(rows)
 
    val dims = (nrows, ncols)
 
    /** Private constructor for the matrix.
     *  @param rows the rows of the matrix
     */
    private def makeMatrix(rows: List[Array[Int]]): Array[Array[Int]] = {
 
      // the matrix object is a 2D array
      var matrix = Array.ofDim[Int](nrows, ncols)
      // recurse through the lines, add each one to the matrix
      @tailrec
      def matrixMake(i: Int, rows: List[Array[Int]], matrix: Array[Array[Int]]): Array[Array[Int]] = rows match {
    
        case Nil     => matrix
    
        case x :: xs => matrix(i) = x
                        matrixMake(i+1, xs, matrix)
                      
      }
 
      matrixMake(0, rows, matrix)
    }
    
    
    override def toString = {
      
      val rows = getAllRows
      val mString = rows.map(_ mkString "\t" ) mkString "\n"
      "\n"+mString
      
      
    }
  
    def getColumn(index: Int): List[Int] = matrix.map{_(index)}.toList
    def getRow(index: Int): List[Int] = matrix(index).toList
    
    //find one diagonal run in the matrix, given a pair of coordinates
    //only finds left-to-right diagonals
    //returns the run found and the coordinates of each point
    /** Find one left-to-right diagonal run in the matrix.
     *  @param i Int, the i index of the start
     *  @param j Int, the j index of the start
     * 
     */
    def getDiagonal(i: Int, j: Int): (List[Int], List[(Int, Int)]) = {
      val res = List[Int]()
      val vis = List[(Int, Int)]()
      @tailrec
      def inner(i: Int, j: Int, visited: List[(Int, Int)], res: List[Int]): (List[Int], List[(Int, Int)]) = {
        if(i < nrows & j < ncols) {
          val r1 = matrix(i)(j) +: res
          val v1 = (i,j) +: visited
          
          inner(i+1, j+1, v1, r1)
        } else {
          (res,visited)
        }
      }
      val visited = inner(i, j, vis, res)
      visited
    }
    
    // construct a matrix which is the reflection of this one
    /** Find the reflection of this matrix.
     * 
     */
    def getReflection: Matrix = {
    
      val rows = for{i <- (0 until nrows).toList } yield getRow(i).reverse.toArray
      new Matrix(rows)
    
    }
    
    
    /** Find all unique left-to-right diagonal runs in the matrix
     * 
     */
    def diagonalScan: List[List[Int]] = {
      // start with all points and an empty list of results
      val startingPoints = getAllCoords
      val diags = List[List[Int]]()
      
      //recurse through the starting points
      @tailrec
      def inner(startingPoints: List[(Int, Int)], diags: List[List[Int]]): List[List[Int]] = startingPoints match {
        // in the case that there are no points left, return results
        case Nil          => diags 
        // where there is a starting point
        case (i, j) :: xs => {
                          // get the diagonal
                          val (search, searched) = getDiagonal(i,j)
                          // remove all points on the diagonal from the starting points
                          // this avoids searching twice
                          val toSearch = xs filterNot(searched.contains(_))
                          // store results
                          val found = search +: diags
                          // recurse
                          inner(toSearch, found)
                        }
      
      }
      
      inner(startingPoints, diags)
    
    }
    
    /** Find the coordinates of all (i,j) pairs in the matrix.
     * 
     */
    def getAllCoords: List[(Int, Int)] = {
      for ( x <- (0 until nrows).toList; y <- (0 until ncols).toList ) yield (x,y)
    }
    
    def getAllColumns: List[List[Int]] = {
      for ( y <- (0 until ncols).toList) yield getColumn(y)
    }
    
    def getAllRows: List[List[Int]] = {
      for ( x <- (0 until nrows).toList) yield getRow(x)
    }
    
    def copy(rows: List[Array[Int]] = getAllRows.map(_.toArray) ) = new Matrix(rows)
    
    def transpose: Matrix = {
      
      val mt = matrix.transpose
      //val allRows = getAllRows.map(_.toArray)
      val m1 = this.copy() //(allRows)
      m1.matrix = mt
      m1
      
    }
 
 }