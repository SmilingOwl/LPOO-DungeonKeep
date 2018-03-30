package dkeep.logic;

import java.util.ArrayList;

public class Level2 extends Level{

	private char[][] board2 = new char[][] { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
		{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'k', 'X' }, 
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

		public Level2() {
			numberLevel=2;
		
			board = board2;
			boardSize=10;
			hero = new Hero(8, 1, 'A');
			hero.setArmed(true);
			ogres = new ArrayList<Ogre>();	
		    setRandomOgre();
		}
		public Level2(int num) {
			numberLevel=2;
			numOgres=num;
			board = board2;
			boardSize=10;
			hero = new Hero(8, 1, 'A');
			hero.setArmed(true);
			ogres = new ArrayList<Ogre>();	
				
			setOgres(numOgres);
		}
		
}
