package dkeep.test;
import static org.junit.Assert.*;

import org.junit.Test;

import dkeep.logic.Board;
import dkeep.logic.Character;
import dkeep.logic.Guard;
import dkeep.logic.Hero;
import dkeep.logic.Ogre;
import dkeep.logic.Game;

public class TestDungeonGameLogic {
	char[][] map= {{'X','X','X','X','X'},
			{'X','H',' ','G','X'},
			{'I',' ',' ',' ','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}};
	char[][]mapOgre={{'X','X','X','X','X'},
			{'X','H',' ','O','X'},
			{'I',' ',' ',' ','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}};


	@Test
	public void testMoveHeroIntofreeCell() {
		int[] heroCoordinates = new int[2];
		Board board= new Board(map);
		Game game= new Game(board);
		heroCoordinates[0] = game.getHeroX();
		heroCoordinates[1] = game.getHeroY();
		assertEquals( 1,heroCoordinates[0] );
		assertEquals( 1,heroCoordinates[1] );
		Hero h= new Hero(heroCoordinates[0],heroCoordinates[1],'H');
		h.heroMovement(map, "s");
		assertEquals(2, h.getX());
		assertEquals(1, h.getY());

	}
	@Test
	public void testHeroIsCapturedByGuard() {
		int[] heroCoordinates = new int[2];
		int[] GuardCoordinates = new int[2];
		Board board= new Board(map);
		Game game= new Game(board);
		heroCoordinates[0] = game.getHeroX();
		heroCoordinates[1] = game.getHeroY();

		Hero h= new Hero(heroCoordinates[0],heroCoordinates[1],'H');
		Guard g= new Guard(game.getGuardX(),game.getGuardY());
		h.heroMovement(map, "d");
		assertTrue(Character.checkHeroPresence(map, g)); // função equivalente a game is over

	}
	@Test
	public void testHeroTryToMoveIntoaWall() {
		int[] heroCoordinates = new int[2];
		Board board= new Board(map);
		Game game= new Game(board);
		heroCoordinates[0] = game.getHeroX();
		heroCoordinates[1] = game.getHeroY();
		assertEquals( 1,heroCoordinates[0] );
		assertEquals( 1,heroCoordinates[1] );
		Hero h= new Hero(heroCoordinates[0],heroCoordinates[1],'H');
		h.heroMovement(map, "a");
		assertEquals(1, h.getX());
		assertEquals(1, h.getY());

	}
	@Test
	public void testHeroTryToMoveIntoaexitDoors() {
		int[] heroCoordinates = new int[2];
		Board board= new Board(map);
		Game game= new Game(board);
		heroCoordinates[0] = game.getHeroX();
		heroCoordinates[1] = game.getHeroY();
		assertEquals( 1,heroCoordinates[0] );
		assertEquals( 1,heroCoordinates[1] );
		Hero h= new Hero(heroCoordinates[0],heroCoordinates[1],'H');
		h.heroMovement(map, "s");
		assertEquals(2, h.getX());
		assertEquals(1, h.getY());
		h.heroMovement(map, "a");
		assertEquals(2, h.getX());
		assertEquals(1, h.getY());
	}
	@Test
	public void testHeroMoveIntoLeverCell() {
		int[] heroCoordinates = new int[2];
		Board board= new Board(map);
		Game game= new Game(board);
		heroCoordinates[0] = game.getHeroX();
		heroCoordinates[1] = game.getHeroY();
		assertEquals( 1,heroCoordinates[0] );
		assertEquals( 1,heroCoordinates[1] );
		Hero h= new Hero(heroCoordinates[0],heroCoordinates[1],'H');
		h.heroMovement(map, "s");
		assertEquals(2, h.getX());
		assertEquals(1, h.getY());
		h.heroMovement(map, "s");
		assertEquals(3, h.getX());
		assertEquals(1, h.getY());

		assertEquals(map[3][0], 'S');
		assertEquals(map[2][0], 'S');

	}
	@Test
	public void testHeroMoveIntoExitDoorsSuccessfully() {
		int[] heroCoordinates = new int[2];
		Board board= new Board(map);
		Game game= new Game(board);
		heroCoordinates[0] = game.getHeroX();
		heroCoordinates[1] = game.getHeroY();
		assertEquals( 1,heroCoordinates[0] );
		assertEquals( 1,heroCoordinates[1] );
		Hero h= new Hero(heroCoordinates[0],heroCoordinates[1],'H');
		h.heroMovement(map, "s");
		assertEquals(2, h.getX());
		assertEquals(1, h.getY());
		h.heroMovement(map, "s");
		assertEquals(3, h.getX());
		assertEquals(1, h.getY());
		assertEquals(map[3][0], 'S');
		assertEquals(map[2][0], 'S');
		assertFalse(h.moveLevel2(map, "w"));
		assertTrue(h.moveLevel2(map, "a"));
		h.heroMovement(map, "a");

	}
	@Test
	public void testHeroMoveNextToOgre() {
		int[] heroCoordinates = new int[2];
		Board board= new Board(mapOgre);
		Game game= new Game(board);
		heroCoordinates[0] = game.getHeroX();
		heroCoordinates[1] = game.getHeroY();
		assertEquals( 1,heroCoordinates[0] );
		assertEquals( 1,heroCoordinates[1] );
		Hero h= new Hero(heroCoordinates[0],heroCoordinates[1],'H');
		Ogre o= new Ogre(game.getOgreX(),game.getOgreY());
		
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "d");
		assertTrue(o.checkIfLoss(h));
	}
	@Test
	public void testHeroChangesToK() {
		int[] heroCoordinates = new int[2];
		Board board= new Board(mapOgre);
		Game game= new Game(board);
		heroCoordinates[0] = game.getHeroX();
		heroCoordinates[1] = game.getHeroY();
		assertEquals( 1,heroCoordinates[0] );
		assertEquals( 1,heroCoordinates[1] );
		Hero h= new Hero(heroCoordinates[0],heroCoordinates[1],'H');
		Ogre o= new Ogre(game.getOgreX(),game.getOgreY());
		
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "s");
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "s");
		assertEquals(mapOgre[3][1], 'K');
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "w");
		assertEquals(mapOgre[2][1], 'K');
		assertEquals(mapOgre[3][1], ' ');

	}
	@Test
	public void testHeroOpenDoorSuccessfully() {
		int[] heroCoordinates = new int[2];
		Board board= new Board(mapOgre);
		Game game= new Game(board);
		heroCoordinates[0] = game.getHeroX();
		heroCoordinates[1] = game.getHeroY();
		assertEquals( 1,heroCoordinates[0] );
		assertEquals( 1,heroCoordinates[1] );
		Hero h= new Hero(heroCoordinates[0],heroCoordinates[1],'H');
		Ogre o= new Ogre(game.getOgreX(),game.getOgreY());
		
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "s");
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "s");
		assertEquals(mapOgre[3][1], 'K');
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "w");
		assertEquals(mapOgre[2][1], 'K');
		assertEquals(mapOgre[3][1], ' ');
		heroCoordinates[0] = game.getHeroX();
		heroCoordinates[1] = game.getHeroY();
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "s");
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "a");
		assertEquals(mapOgre[3][0], 'S');
		
		
		//assertTrue(h.checkUnlockableDoor(mapOgre,heroCoordinates , heroCoordinates));
		
		
	}
	@Test
	public void testHeroOpenDoorUnsuccessfully() {
		int[] heroCoordinates = new int[2];
		Board board= new Board(mapOgre);
		Game game= new Game(board);
		heroCoordinates[0] = game.getHeroX();
		heroCoordinates[1] = game.getHeroY();
		assertEquals( 1,heroCoordinates[0] );
		assertEquals( 1,heroCoordinates[1] );
		Hero h= new Hero(heroCoordinates[0],heroCoordinates[1],'H');
		Ogre o= new Ogre(game.getOgreX(),game.getOgreY());
		
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "s");
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "a");
		assertEquals(mapOgre[2][0], 'I');
		assertEquals(mapOgre[2][1], 'A');// Não está certo
		
		
		//assertTrue(h.checkUnlockableDoor(mapOgre,heroCoordinates , heroCoordinates));
		
		
	}
	@Test
	public void testHeroWins() { // imcompleto 
		int[] heroCoordinates = new int[2];
		Board board= new Board(mapOgre);
		Game game= new Game(board);
		heroCoordinates[0] = game.getHeroX();
		heroCoordinates[1] = game.getHeroY();
		assertEquals( 1,heroCoordinates[0] );
		assertEquals( 1,heroCoordinates[1] );
		Hero h= new Hero(heroCoordinates[0],heroCoordinates[1],'H');
		Ogre o= new Ogre(game.getOgreX(),game.getOgreY());
		
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "s");
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "s");
		assertEquals(mapOgre[3][1], 'K');
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "w");
		assertEquals(mapOgre[2][1], 'K');
		assertEquals(mapOgre[3][1], ' ');
		heroCoordinates[0] = game.getHeroX();
		heroCoordinates[1] = game.getHeroY();
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "s");
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "a");
		assertEquals(mapOgre[3][0], 'S');
		h.heroMovementKeyTansport(heroCoordinates , mapOgre, "a");
		assertEquals(mapOgre[3][0], 'A');
		
		
		
		
		
	}

}
	


