package com.gn.euler

import scala.annotation.tailrec

class Matrix(val rows: List[Array[Int]]) {
    val nrows = rows.size
    val ncols = rows(0).size
    val matrix = makeMatrix(rows)
 
    val dims = (nrows, ncols)
 
    private def makeMatrix(rows: List[Array[Int]]): Array[Array[Int]] = {
 
      var matrix = Array.ofDim[Int](nrows, ncols)
      @tailrec
      def matrixMake(i: Int, rows: List[Array[Int]], matrix: Array[Array[Int]]): Array[Array[Int]] = rows match {
    
        case Nil     => matrix
    
        case x :: xs => matrix(i) = x
                        matrixMake(i+1, xs, matrix)
                      
      }
 
      matrixMake(0, rows, matrix)
    }
  
    def getColumn(index: Int): List[Int] = matrix.map{_(index)}.toList
    def getRow(index: Int): List[Int] = matrix(index).toList
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
    
    def getReflection: Matrix = {
    
      val rows = for{i <- (0 until nrows).toList } yield getRow(i).reverse.toArray
      new Matrix(rows)
    
    }
    
    def diagonalScan: List[List[Int]] = {
      val startingPoints = getAllCoords
      val diags = List[List[Int]]()
      
      def inner(startingPoints: List[(Int, Int)], diags: List[List[Int]]): List[List[Int]] = startingPoints match {
      
        case Nil          => diags
        case (i, j) :: xs => {
                          val (search, searched) = getDiagonal(i,j)
                          val toSearch = xs filterNot(searched.contains(_))
                          val found = search +: diags
                          inner(toSearch, found)
                        }
      
      }
      
      inner(startingPoints, diags)
    
    }
    
    def getAllCoords: List[(Int, Int)] = {
      for ( x <- (0 until nrows).toList; y <- (0 until ncols).toList ) yield (x,y)
    }
    
    def getAllColumns: List[List[Int]] = {
      for ( y <- (0 until ncols).toList) yield getColumn(y)
    }
    
    def getAllRows: List[List[Int]] = {
      for ( x <- (0 until nrows).toList) yield getRow(x)
    }
 
 }