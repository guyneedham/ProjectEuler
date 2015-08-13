package test.scala.com.gn.euler

import org.scalatest._
import com.gn.euler.Matrix

/**
 * @author guyneedham
 */
class MatrixTestSuite extends FlatSpec {
  
  "A 3x3 Matrix" should "have the correct dimensions" in {
    
    val mat = new Matrix(List(Array(1,2,3),Array(4,5,6),Array(7,8,9)))
    assert( mat.dims == (3,3) )
    
  }
  
  
  
}