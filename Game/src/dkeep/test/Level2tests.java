package dkeep.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dkeep.logic.Game;
import dkeep.logic.Game.Event;
import dkeep.logic.Game.State;
import dkeep.logic.Level;
import dkeep.logic.Level2;
import dkeep.logic.Ogre;

public class Level2tests {

	char[][] map2 = { { 'X', 'X', 'X', 'X', 'X' }, 
			{ 'I', ' ', ' ', 'k', 'X' }, 
			{ 'X', 'H', ' ', 'O', 'X' },
			{ 'X', ' ', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', 'X', 'X' } };
	
	char[][] map3 = { { 'X', 'X', 'X', 'X', 'X' }, 
			{ 'I', 'H', ' ', 'O', 'X' }, 
			{ 'X', 'X', 'X', 'X', 'X' } };


	@Test
	public void testHeroAndOgreColision() {
		Level board2 = new Level(map3);
		Game newGame = new Game();
		newGame.setPlayingLevel(board2);
		newGame.updateStateGame(Event.NewGame);
		newGame.updateStateGame(Event.levelUp);

		assertEquals(1, board2.getHero().getXcoordinate());
		assertEquals(1, board2.getHero().getYcoordinate());

		newGame.heroMove('d');
		newGame.heroMove('d');
		newGame.printEndGame();
		assertEquals(newGame.gameState, State.Lost);

	}

	@Test
	public void testHeroLetter() {
		Level board2 = new Level(map2);
		Game newGame = new Game();
		newGame.setPlayingLevel(board2);
		newGame.updateStateGame(Event.NewGame);
		newGame.updateStateGame(Event.levelUp);

		assertEquals(2, board2.getHero().getXcoordinate());
		assertEquals(1, board2.getHero().getYcoordinate());

		newGame.heroMove('w');
		newGame.heroMove('d');
		newGame.heroMove('d');

		assertEquals('K', board2.getHero().getLetter());
		assertEquals(' ', board2.getBoard()[1][3]);

	}

	@Test
	public void testHeroIntoClosedDoorWithoutKey() {
		Level board2 = new Level(map2);
		Game newGame = new Game();
		newGame.setPlayingLevel(board2);
		newGame.updateStateGame(Event.NewGame);
		newGame.updateStateGame(Event.levelUp);

		assertEquals(2, board2.getHero().getXcoordinate());
		assertEquals(1, board2.getHero().getYcoordinate());

		newGame.heroMove('w');
		newGame.heroMove('a');
		assertEquals(1, board2.getHero().getXcoordinate());
		assertEquals(1, board2.getHero().getYcoordinate());

		newGame.printBoard();
	}

	@Test
	public void testHeroOpenDoor() {
		Level board2 = new Level(map2);
		Game newGame = new Game();
		newGame.setPlayingLevel(board2);
		newGame.updateStateGame(Event.NewGame);
		newGame.updateStateGame(Event.levelUp);

		assertEquals(2, board2.getHero().getXcoordinate());
		assertEquals(1, board2.getHero().getYcoordinate());

		newGame.heroMove('w');
		newGame.heroMove('d');
		newGame.heroMove('d');

		assertEquals('K', board2.getHero().getLetter());

		newGame.heroMove('a');
		newGame.heroMove('a');
		newGame.heroMove('a');

		assertEquals(true, board2.foundDoor(board2.getHero().getYcoordinate(), board2.getHero().getXcoordinate() - 1));

	}

	@Test
	public void testHeroOpenDoorAndVictory() {
		Level board2 = new Level(map2);
		Game newGame = new Game();
		newGame.setPlayingLevel(board2);
		newGame.updateStateGame(Event.NewGame);
		//newGame.updateStateGame(Event.levelUp);
		newGame.getPlayingLevel().setNumberLevel(2);

		assertEquals(2, board2.getHero().getXcoordinate());
		assertEquals(1, board2.getHero().getYcoordinate());

		newGame.heroMove('w');
		newGame.heroMove('d');
		newGame.heroMove('d');

		assertEquals('K', board2.getHero().getLetter());

		newGame.heroMove('a');
		newGame.heroMove('a');

		assertEquals(true,
				board2.foundClosedDoor(board2.getHero().getYcoordinate(), board2.getHero().getXcoordinate() - 1));
		newGame.heroMove('a');

		newGame.printEndGame();
		assertEquals(newGame.gameState, State.Won);
	}

	@Test
	public void testLevel2() {
		Level board2 = new Level2();
		Game newGame = new Game();
		newGame.setPlayingLevel(board2);
		newGame.updateStateGame(Event.NewGame);

	}

	@Test
	public void testOgreIsStunned1() {
		Ogre g = new Ogre(2, 2);

		int x = 1;
		int y = 2;

		assertEquals(true, g.ogreIsStuned(x, y));

		x = 2;
		y = 2;

		assertEquals(false, g.ogreIsStuned(x, y));
		
		x = 3;
		y = 2;

		assertEquals(true, g.ogreIsStuned(x, y));
		
		x = 2;
		y = 1;

		assertEquals(true, g.ogreIsStuned(x, y));
		
		x = 2;
		y = 3;

		assertEquals(true, g.ogreIsStuned(x, y));
		
		x = 0;
		y = 0;

		assertEquals(false, g.ogreIsStuned(x, y));
	}
	@Test
	public void setOgresNotRandomTest()
	{
		Level l=new Level();
		int[] coord= {1,1};
		l.setOgresNotRandom(coord);
		
	}
	
	@Test
	public void setOgresNotRandomTest2()
	{
		Level l=new Level2(2);
		
		int[] coord= {1,1};
		l.setOgresNotRandom(coord);
		
	}
}
