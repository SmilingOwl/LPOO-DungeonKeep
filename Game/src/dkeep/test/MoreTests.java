package dkeep.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import dkeep.logic.Game;
import dkeep.logic.Game.Event;
import dkeep.logic.Level;
import dkeep.logic.Level1;
import dkeep.logic.Level2;

public class MoreTests {

	char[][] boarddd = {
			{ 'X', 'X', 'X', 'X', 'X' }, 
			{ 'X', 'H', ' ', ' ', 'X' }, 
			{ 'I', ' ', ' ', ' ', 'X' },
			{ 'I', 'k', ' ', 'O', 'X' },
			{ 'X', 'X', 'X', 'X', 'X' } };
	
	
	@Test
	public void testNextLevel(){
		Level board= new Level1();
		Game game1 = new Game();
		game1.setPlayingLevel(board);
		
		game1.nextlevel();
		assertTrue(game1.playingLevel instanceof Level2);
		
	}
	
	@Test
	public void testRookie()
	{
		Level board= new Level1();
		Game game1 = new Game();
		game1.setPlayingLevel(board);
		game1.playingLevel.setGuard("Rookie");
		game1.playingLevel.setLever(true);
		game1.updateStateGame(Event.NewGame);
		
		assertEquals(game1.playingLevel.getGuard().getXcoordinate(),1);
		assertEquals(game1.playingLevel.getGuard().getYcoordinate(),8);
		
		game1.heroMove('w');
		
		assertEquals(game1.playingLevel.getGuard().getXcoordinate(),1);
		assertEquals(game1.playingLevel.getGuard().getYcoordinate(),7);
		
		game1.heroMove('w');
		
		assertEquals(game1.playingLevel.getGuard().getXcoordinate(),2);
		assertEquals(game1.playingLevel.getGuard().getYcoordinate(),7);
		
		for(int i =0; i < 22; i++){
			game1.heroMove('w');
		}
		
		assertEquals(game1.playingLevel.getGuard().getXcoordinate(),1);
		assertEquals(game1.playingLevel.getGuard().getYcoordinate(),8);
		
	}
	
	@Test(timeout=5000)
	public void testDrunken()
	{
		boolean sleeping=false;
		Level board= new Level1();
		Game game1 = new Game();
		game1.setPlayingLevel(board);
		game1.setGuard("Rookie");
		game1.playingLevel.setGuard("Drunken");
		game1.playingLevel.setLever(true);
		game1.updateStateGame(Event.NewGame);
		
		assertEquals(game1.playingLevel.getGuard().getXcoordinate(),1);
		assertEquals(game1.playingLevel.getGuard().getYcoordinate(),8);
		
		while(true)
		{
			game1.heroMove('w');
			
			int x=game1.playingLevel.getGuard().getXcoordinate();
			int y=game1.playingLevel.getGuard().getYcoordinate();
			
			if(game1.playingLevel.getGuard().getLetter()=='g'){
				sleeping=true;
				break;
			}
		}
		assertTrue(sleeping);
		assertEquals(game1.playingLevel.getGuard().getPersonality(),"Drunken");
	}
	
	@Test
	public void testNumberOgres()
	{
		Level board= new Level2(2);
		Game game1 = new Game();
		game1.setPlayingLevel(board);
		
		assertEquals(game1.playingLevel.getOgres().size(),2);
		assertTrue(game1.playingLevel instanceof Level2);
			
	}
	
	
}


