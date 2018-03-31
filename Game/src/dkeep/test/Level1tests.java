package dkeep.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dkeep.logic.Game;
import dkeep.logic.Game.Event;
import dkeep.logic.Game.State;
import dkeep.logic.Level;
import dkeep.logic.Level1;

public class Level1tests {

	char[][] map1 = { { 'X', 'I', 'X', 'X', 'X' }, 
			{ 'X', 'H', ' ', 'G', 'X' }, 
			{ 'X', ' ', ' ', ' ', 'X' },
			{ 'I', 'k', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', 'X', 'X' } };

	@Test
	public void testMoveHeroIntoFreeCell() {

		Level board=new Level(map1);
		Game newGame=new Game();
		newGame.setPlayingLevel(board);
		newGame.playingLevel.setLever(true);
		newGame.setRandomGuard();
		
		assertEquals(1, board.getHero().getXcoordinate());
		assertEquals(1, board.getHero().getYcoordinate());
	
		newGame.heroMove('d');
		assertEquals(1, board.getHero().getXcoordinate());
		assertEquals(2, board.getHero().getYcoordinate());
		
		newGame.heroMove('a');
		assertEquals(1, board.getHero().getXcoordinate());
		assertEquals(1, board.getHero().getYcoordinate());
		
		newGame.heroMove('s');
		assertEquals(2, board.getHero().getXcoordinate());
		assertEquals(1, board.getHero().getYcoordinate());
		
		newGame.heroMove('w');
		assertEquals(1, board.getHero().getXcoordinate());
		assertEquals(1, board.getHero().getYcoordinate());
		
	}
	@Test
	public void testMoveHeroIntoWall()
	{
		Level board=new Level(map1);
		Game newGame=new Game();
		newGame.setPlayingLevel(board);
		newGame.playingLevel.setLever(true);
		newGame.setRandomGuard();
		
		assertEquals(1, board.getHero().getXcoordinate());
		assertEquals(1, board.getHero().getYcoordinate());
		//ao andar para a direita tem uma parede 
		//o heroi tem de ficar na mesma posição
		newGame.heroMove('a');
		assertEquals(1, board.getHero().getXcoordinate());
		assertEquals(1, board.getHero().getYcoordinate());
		
	}
	@Test
	public void testHeroAndGuardColision()
	{	
		Level board=new Level(map1);
		Game newGame=new Game();
		newGame.setPlayingLevel(board);
		newGame.playingLevel.setLever(true);
		
		newGame.updateStateGame( Event.NewGame);
		
		assertEquals(1, board.getHero().getXcoordinate());
		assertEquals(1, board.getHero().getYcoordinate());
		
		assertEquals(newGame.gameState, State.Playing);
		
		newGame.heroMove('d');
		assertEquals(newGame.gameState, State.Lost);
		
	}
	
	@Test
	public void testHeroAndClosedDoorColision()
	{
		Level board=new Level(map1);
		Game newGame=new Game();
		newGame.setPlayingLevel(board);
		newGame.playingLevel.setLever(true);
		newGame.setRandomGuard();
		newGame.updateStateGame( Event.NewGame);
		
		assertEquals(1, board.getHero().getXcoordinate());
		assertEquals(1, board.getHero().getYcoordinate());
		
		//ir para a parede
		newGame.heroMove('d');
		newGame.heroMove('w');
		
		assertEquals(1, board.getHero().getXcoordinate());
		assertEquals(2, board.getHero().getYcoordinate());
		
		
	}
	
	@Test
	public void testHeroLeverAndOpenDoor()
	{
		Level board=new Level(map1);
		Game newGame=new Game();
		newGame.setPlayingLevel(board);
		newGame.playingLevel.setLever(true);
		newGame.playingLevel.setNumberLevel(1);
		newGame.setRandomGuard();
		
		assertEquals(1, board.getHero().getXcoordinate());
		assertEquals(1, board.getHero().getYcoordinate());
		
		//ir para a alavanca
		newGame.heroMove('s');
		newGame.heroMove('s');
		
		assertEquals('K', board.getHero().getLetter());
		assertEquals('S',board.getBoard()[0][1]);
		
	}
	
	@Test
	public void testHeroLevelUp()
	{
		Level board=new Level(map1);
		Game newGame=new Game();
		newGame.setPlayingLevel(board);
		newGame.playingLevel.setLever(true);
		newGame.playingLevel.setNumberLevel(1);
		newGame.setRandomGuard();
		
		assertEquals(1, board.getHero().getXcoordinate());
		assertEquals(1, board.getHero().getYcoordinate());
		
		newGame.heroMove('s');
		newGame.heroMove('s');
		newGame.heroMove('a');
		
		assertEquals(newGame.gameState, State.Won);
		
	}
	@Test
	public void testOpenDoorslevel1()
	{
		Level board=new Level1();
		Game newGame=new Game();
		newGame.setPlayingLevel(board);
		
		newGame.playingLevel.openDoors();
		
		assertEquals(newGame.playingLevel.getBoard()[5][0],'S');
		assertEquals(newGame.playingLevel.getBoard()[6][0],'S');
		
		newGame.printstring();
		
		
	}
}
