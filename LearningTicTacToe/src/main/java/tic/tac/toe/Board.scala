package tic.tac.toe
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Buffer

/**
 * Simple representation of a tic-tac-toe board
 */
class Board {

  private val board = List(Buffer("_", "_", "_"),
		  		   		   Buffer("_", "_", "_"),
		  		   		   Buffer("_", "_", "_"));

  /**
   * Produces ASCII style board, along the lines of :
   * 
   *    3   _ _ 0
   *    2   _ X _
   *    1   0 _ X
   *      
   *        1 2 3
   *      
   */
  override def toString = {
    val rows = board.map(_.reduce(_+" "+_))
    val idxRows = rows.zipWithIndex.map {case (c,i) => (board.length-i)+"   "+c}
    idxRows.reduce(_+"\n"+_) + "\n\n    1 2 3"
  }
  
  /**
   * Allows easy setting of a tic-tac-toe cell, for example :
   *    
   *  3  _ _ _                         3  _ X _
   *  2  _ _ _  ==> board(2,3)="X" ==> 2  _ _ _
   *  1  _ _ _						   1  _ _ _
   *   
   *     1 2 3							  1 2 3
   */
  def update(x:Integer, y:Integer, char:String) = {
    board(board.length-y)(x-1) = char
  }
  
  /**
   * Returns raw immutable copy of the internal board data structure
   */
  def raw() = {
    board.map(_.toList)
  }
  
}