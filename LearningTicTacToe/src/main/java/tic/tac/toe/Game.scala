package tic.tac.toe

class Game {

  private val board = new Board()
  var player1:Player = null;
  var player2:Player = null;
  
  def play() = {
    playGame()
	alertResult()
  }  
  
  private def printGameState(player:Player) = {
    println("==========")
    println(board)
    println("==========")
    println(player + "'s move!")
    println("==========")
  }
  
  private def playGame(): Unit = {
    var player = player1
    while(Game.winner(board.raw) == null) {
      printGameState(player)
      player.move(board)
      player = swapPlayers(player)
    }
  }
  
  private def alertResult(): Unit = {
    val (winner, loser) = findWinner()
    winner.won()
    loser.lost()
  }
  
  private def swapPlayers(oldPlayer:Player): Player = {
    if (oldPlayer == player1) {
      player2 
    } else {
      player1
    }
  }
  
  private def findWinner() = {
    val winmark = Game.winner(board.raw)
    if (player1.marker == winmark) {
    	(player1, player2)
    } else {
    	(player2, player1)
    }
  }
}

object Game {
  
  /**
   * Utility method to return the winner of a tic-tac-toe game, or
   * null is none exist, i.e. 
   * 
   *  Game.winner(List(List("_", "0", "_"),
   *  		  		       ("_", "0", "X"),    
   *  				       ("X", "0", "X")))   ==>   "0"
   * 
   */
  def winner(rows:List[List[String]]):String = {
    val cols = Range(0, rows.length, 1).map(i => rows.map(_(i))).toList
    val diag = List(List(rows(0)(0), rows(1)(1), rows(2)(2)),
    				List(rows(0)(2), rows(1)(1), rows(2)(0)))
    val lines = rows ::: cols ::: diag
    val winners = lines.filter {case(x :: y :: z :: _) => x == y && y == z}
                       .filter {case(x :: _) => x != "_"}
    if (winners.length > 0) {
      return winners(0)(0)
    } else {
      return null
    }
  }  
  
}