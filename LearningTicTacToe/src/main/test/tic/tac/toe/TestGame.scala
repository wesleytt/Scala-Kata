package tic.tac.toe

import org.junit.Assert.assertEquals
import org.junit.Test
import tic.tac.toe.StdIoPlayer

class TestGame {
  
	@Test def testWinnerNull() {
	  val board = List(List("_", "_", "_"),
			  		   List("_", "_", "_"),
			  		   List("_", "_", "_"))	
	  assertEquals(Game.winner(board), null)
	}

	@Test def testWinnerRow() {
	  val board = List(List("0", "_", "_"),
			  		   List("0", "_", "_"),
			  		   List("X", "X", "X"))	
	  assertEquals(Game.winner(board), "X")
	}
	
	@Test def testWinnerCol() {
	  val board = List(List("_", "0", "_"),
			  		   List("_", "0", "_"),
			  		   List("X", "0", "X"))	
	  assertEquals(Game.winner(board), "0")
	}
	
	@Test def testWinnerDiag() {
	  val board = List(List("X", "_", "_"),
			  		   List("0", "X", "_"),
			  		   List("0", "0", "X"))	
	  assertEquals(Game.winner(board), "X")
	}
	
	@Test def testPlayer() {
		var game = new Game()
		game.player1 = new StdIoPlayer("X")
		game.player2 = new StdIoPlayer("0")
		game.play()
	}
	
}