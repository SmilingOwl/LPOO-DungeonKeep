package dkeep.logic;

import java.util.ArrayList;

public class Level2 extends Level {

	private char[][] board2 = new char[][] { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'k', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

	/**
	 * Class constructor
	 */
	public Level2() {
		numberLevel = 2;
		board = board2;
		boardSize = 10;
		hero = new Hero(8, 1, 'A');
		hero.setArmed(true);
		ogres = new ArrayList<Ogre>();
		setRandomOgre();
	}

	/**
	 * 
	 * Class constructor
	 * 
	 * @param num
	 *            number of ogres
	 */
	public Level2(int num) {
		numberLevel = 2;
		numOgres = num;
		if (map2 == null) {
			board = board2;
		} else
			board = map2;
		boardSize = 10;
		if (xHero == 0) {
			hero = new Hero(8, 1, 'A');
		} else {
			hero = new Hero(xHero, yHero, 'A');
		}

		hero.setArmed(true);
		if (coorO == null) {
			ogres = new ArrayList<Ogre>();
			setOgres(numOgres);
		}
	}

	/**
	 * Class constructor
	 * 
	 * @param num
	 *            number of ogres
	 * @param xh
	 *            x hero coordinate
	 * @param yh
	 *            y hero coordinate
	 * @param corogre
	 *            ogres array
	 */
	public Level2(int num, int xh, int yh, int[] corogre) {
		numberLevel = 2;
		numOgres = num;
		if (map2 == null) {
			board = board2;
		} else
			board = map2;
		boardSize = board.length;
		if (xh == 0) {
			hero = new Hero(8, 1, 'A');
		} else {
			hero = new Hero(xh, yh, 'A');
		}
		ogres = new ArrayList<Ogre>();

		hero.setArmed(true);
		if (corogre != null) {
			setOgresNotRandom(corogre);
		} else {
			setOgres(numOgres);
		}

	}

}
