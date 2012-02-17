package bowling

import org.junit._
import Assert._

class TestGame {

	val game:Game = new Game()
  
	@Test def perfectGame() {
	  assertEquals(300, game.score("XXXXXXXXXXXX"))
	}
	
	@Test def goodGameBadEnd() {
	  assertEquals(280, game.score("XXXXXXXXXX5-"))
	}
	
	@Test def allNines() {
	  assertEquals(90, game.score("9-9-9-9-9-9-9-9-9-9-"))
	}
	
	@Test def allFives() {
	  assertEquals(150, game.score("5/5/5/5/5/5/5/5/5/5/5"))
	}
	
	@Test def mixItUp() {
	  assertEquals(121, game.score("4/330-X4/X2-X9-X9/"))
	}
	
	@Test def two() {
	  assertEquals(2, game.score("11------------------"))
	}
	
	@Test def spareBonus() {
	  assertEquals(16, game.score("9/3-----------------"))
	}

	@Test def strikeBonus() {
	  assertEquals(24, game.score("X34-----------------"))
	}

	@Test def gutterBall() {
	  assertEquals(0, game.score("--------------------"))
	}
	
	@Test def mixItUpAgain() {
	  assertEquals(168, game.score("X7/729/XXX236/7/3"))
	}

}