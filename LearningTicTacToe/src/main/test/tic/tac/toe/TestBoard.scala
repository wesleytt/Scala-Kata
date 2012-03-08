package tic.tac.toe

import org.junit.Assert.assertEquals
import org.junit.Test

class TestBoard {

	val board:Board = new Board()
  
	@Test def testToString() {
	  assertEquals("""|3   _ _ _
			  	 	  |2   _ _ _
			  		  |1   _ _ _
			  		  |
			  		  |    1 2 3""".stripMargin, 
			  		  board.toString())
	}
	
	@Test def testWrite() {
	  val board:Board = new Board()
	  board(1,2)="X"
	  board(2,3)="0"
	  assertEquals("""|3   _ 0 _
			  	 	  |2   X _ _
			  		  |1   _ _ _
			  		  |
			  		  |    1 2 3""".stripMargin, 
			  		  board.toString())
	}
	
	@Test def testRaw() {
	  assertEquals(List(List("_", "_", "_"),
			  			List("_", "_", "_"),
			  			List("_", "_", "_")), board.raw)
	}

}