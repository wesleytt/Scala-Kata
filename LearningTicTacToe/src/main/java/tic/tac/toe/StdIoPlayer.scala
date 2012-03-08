package tic.tac.toe

import scala.collection.immutable.List
import java.util.Scanner

class StdIoPlayer(marker:String) extends Player(marker) {
  
  def move(board: Board): Unit = {
    println(">> x,y")
    print(">> ")
    val in = new Scanner(System.in).nextLine()
    val xy = in.split(",").map(Integer.parseInt(_))
    board(xy(0), xy(1)) = marker
  }

}