package bowling

/**
 * Basic representation of a game. 
 * Doesn't hold any state, basically just a namespace for useful functions.
 */
class Game {

  /**
   * Takes a string representing a valid bowling game, and returns the 
   * integer score of that game.
   */
  def score(game: String): Int = {
    val seq = game.toList.map(_.toString);
    val fr = findFrames(seq, List())
    asInts(parseSpare(fr)).reduce(_+_)
  }

  /**
   * Recursive function that takes a list of rolls (represented by strings), and returns
   * some variable length tuples (actually lists) wrapping up each frame and 
   * its required lookahead state for later calculation.
   */
  private def findFrames(xs: List[String], acc: List[List[String]]): List[List[String]] = {
    if (acc.size >= 10)
      return acc
    xs.take(3) match {
      case "X" :: y :: z :: _ => findFrames(xs.drop(1), acc :+ List("X", y, z))
      case x :: "/" :: z :: _ => findFrames(xs.drop(2), acc :+ List(x, "/", z))
      case x :: y :: _ => findFrames(xs.drop(2), acc :+ List(x, y))
    }
  }

  /**
   * Removes all spares from the frames, and replaces with 10
   */
  private def parseSpare(xs: List[List[String]]): List[List[String]] = {
    xs.map((x: (List[String])) => {
      x match {
        case x :: "/" :: z :: _ => List("10", z)
        case x :: y :: "/" :: _ => List(x, "10")
        case x => x
      }
    })
  }

  /**
   * Converts all syntax to integers
   */
  private def asInts(xs: List[List[String]]): List[Int] = {
    xs.map({ _.map(x => if ("X" == x) "10" else x) })
      .map({ _.map(x => if ("-" == x) "0" else x) })
      .map({ _.map(_.toInt).reduce(_ + _) })
  }

}