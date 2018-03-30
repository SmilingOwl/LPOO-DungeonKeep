package dkeep.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dkeep.logic.Game;
import dkeep.logic.Game.Event;
import dkeep.logic.Game.State;
import dkeep.logic.Level;

public class Level2tests {
	
	char[][] map2 = { { 'X', 'X', 'X', 'X', 'X' }, 
			{ 'I', ' ', ' ', 'k', 'X' }, 
			{ 'X', 'H', ' ', 'O', 'X' },
			{ 'X', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X' } };
	
	@Test
	public void testHeroAndOgreColision()
	{
		Level board2=new Level(map2);
		Game newGame=new Game();
		newGame.setPlayingLevel(board2);
		newGame.updateStateGame(Event.levelUp);
		
		assertEquals(2, board2.getHero().getXcoordinate());
		assertEquals(1, board2.getHero().getYcoordinate());
		
		newGame.heroMove('s');
		newGame.heroMove('d');
		newGame.heroMove('d');
		newGame.heroMove('w');
		
		assertEquals(newGame.gameState,State.Lost);
		newGame.setRandomOgre();
		
	}
	
	@Test
	public void testHeroLetter()
	{
		//TODO
	}
	
	@Test
	public void testHeroIntoClosedDoorWithoutKey()
	{
		//TODO
	}
	
	@Test
	public void testHeroOpenDoor()
	{
		//TODO	
	}
	
	@Test
	public void testHeroOpenDoorAndVictory()
	{
		//TODO
	}
	
	
}
