package tic.tac.toe

abstract class Player(mark:String) {
  
  def marker:String = mark
  
  def move(board:Board):Unit;
  
  def won(): Unit = {
    println(marker + " wins!")
  }

  def lost(): Unit = {
    println(marker + " loses!")
  }

  override def toString = marker
  
}