package dkeep.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import dkeep.logic.Game;
import dkeep.logic.Game.Event;
import dkeep.logic.Hero;
import dkeep.logic.Level;
import dkeep.logic.Level1;
import dkeep.logic.Level2;
import dkeep.logic.Ogre;

public class MoreTests {

	char[][] boarddd = { { 'X', 'X', 'X', 'X', 'X' }, { 'X', 'H', ' ', ' ', 'X' }, { 'I', ' ', ' ', ' ', 'X' },
			{ 'I', 'k', ' ', 'O', 'X' }, { 'X', 'X', 'X', 'X', 'X' } };

	@Test
	public void testNextLevel() {
		Level board = new Level1();
		Game game1 = new Game();
		game1.setPlayingLevel(board);

		game1.nextlevel();
		assertTrue(game1.playingLevel instanceof Level2);

	}

	@Test
	public void testNextLevel2() {
		Level board = new Level1();
		Game game1 = new Game();
		game1.setPlayingLevel(board);
		game1.setNumOgres(1);
		game1.getNumOgres();
		game1.setModify(true);
		game1.nextlevel();

	}

	@Test
	public void getPlayingLevelTest() {
		Game game1 = new Game();
		Level level1 = new Level();
		game1.setPlayingLevel(level1);
		assertEquals(level1, game1.getPlayingLevel());
	}

	@Test
	public void testRookie() {
		Level board = new Level1();
		Game game1 = new Game();
		game1.setPlayingLevel(board);
		game1.playingLevel.setGuard("Rookie");
		game1.playingLevel.setLever(true);
		game1.updateStateGame(Event.NewGame);

		assertEquals(game1.playingLevel.getGuard().getXcoordinate(), 1);
		assertEquals(game1.playingLevel.getGuard().getYcoordinate(), 8);

		game1.heroMove('w');

		assertEquals(game1.playingLevel.getGuard().getXcoordinate(), 1);
		assertEquals(game1.playingLevel.getGuard().getYcoordinate(), 7);

		game1.heroMove('w');

		assertEquals(game1.playingLevel.getGuard().getXcoordinate(), 2);
		assertEquals(game1.playingLevel.getGuard().getYcoordinate(), 7);

		for (int i = 0; i < 22; i++) {
			game1.heroMove('w');
		}

		assertEquals(game1.playingLevel.getGuard().getXcoordinate(), 1);
		assertEquals(game1.playingLevel.getGuard().getYcoordinate(), 8);

	}

	@Test(timeout = 5000)
	public void testDrunken() {
		boolean sleeping = false;
		Level board = new Level1();
		Game game1 = new Game();
		game1.setPlayingLevel(board);
		game1.setGuard("Rookie");
		game1.playingLevel.setGuard("Drunken");
		game1.playingLevel.setLever(true);
		game1.updateStateGame(Event.NewGame);

		assertEquals(game1.playingLevel.getGuard().getXcoordinate(), 1);
		assertEquals(game1.playingLevel.getGuard().getYcoordinate(), 8);

		while (true) {
			game1.heroMove('w');

			int x = game1.playingLevel.getGuard().getXcoordinate();
			int y = game1.playingLevel.getGuard().getYcoordinate();

			if (game1.playingLevel.getGuard().getLetter() == 'g') {
				sleeping = true;
				break;
			}
		}
		assertTrue(sleeping);
		assertEquals(game1.playingLevel.getGuard().getPersonality(), "Drunken");
	}

	@Test
	public void testNumberOgres() {
		Level board = new Level2(2);
		Game game1 = new Game();
		game1.setPlayingLevel(board);

		assertEquals(game1.playingLevel.getOgres().size(), 2);
		assertTrue(game1.playingLevel instanceof Level2);

	}

	@Test
	public void TimeStunCounter() {
		Ogre g = new Ogre(1, 1);
		g.TimeStunCounter();
		g.TimeStunCounter();
		g.TimeStunCounter();
		assertEquals(g.isStun(), false);
	}

	@Test
	public void SetStun() {
		Ogre g = new Ogre(1, 1);
		g.setStun(true);
		assertEquals(g.isStun(), true);
		g.setStun(false);
		assertEquals(g.isStun(), false);

	}

	@Test
	public void getAndSetCoorO() {
		Game g = new Game();
		int[] coor = { 1, 2 };
		g.setCoorOO(coor);

		assertEquals(g.getCoorOO(), coor);

	}

	@Test
	public void getAndSetHero() {
		Game g = new Game();
		Hero h = new Hero(1, 1, 'H');
		g.setXHeroo(1);
		g.setYHeroo(1);
		assertEquals(g.getXHeroo(), h.getXcoordinate());
		assertEquals(g.getYHeroo(), h.getYcoordinate());

	}

	@Test
	public void setMap2Test() {
		Game g = new Game();
		g.setMap3(boarddd);
	}

	@Test
	public void getAndSetCoorOTestL() {
		Level l=new Level();
		int[] coor = { 1, 2 };
		l.setCoorO(coor);
		assertEquals(l.getCoorO(), coor);
	}
	
	@Test
	public void getAndSetHeroTestL() {
		
		Level l=new Level();
		Hero h = new Hero(1, 1, 'H');
		l.setXHero(1);
		l.setYHero(1);
		assertEquals(l.getXHero(), h.getXcoordinate());
		assertEquals(l.getYHero(), h.getYcoordinate());

	}
	
}
