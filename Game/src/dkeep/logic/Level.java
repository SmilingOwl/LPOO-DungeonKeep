package dkeep.logic;

import java.util.ArrayList;
import java.util.Random;

public class Level {

	protected char[][] playingLevel;
	protected int boardSize;
	protected char[][] board;
	protected char[][] map2;
	protected int xHero;
	protected int yHero;
	protected int[] coorO;

	protected Hero hero;
	protected Guard guard;
	protected int numOgres;
	protected ArrayList<Ogre> ogres;

	protected boolean doorsOpen = false;
	protected boolean unlockDoor = false;
	protected boolean lever = false;
	protected int numberLevel;

	/**
	 * class Constructor
	 */
	public Level() {

	}

	/**
	 * 
	 * return the coorO variable
	 */
	public int[] getCoorO() {
		return coorO;
	}

	/**
	 * 
	 * Sets the coorO variable
	 */
	public void setCoorO(int[] cooro) {
		coorO = cooro;
	}

	/**
	 * 
	 * return the hero x coordinate
	 */
	public int getXHero() {
		return xHero;
	}

	/**
	 * 
	 * return the hero y coordinate
	 */
	public int getYHero() {
		return yHero;
	}

	/**
	 * 
	 * Sets the x hero coordinate
	 */
	public void setXHero(int x) {
		xHero = x;
	}

	/**
	 * 
	 * Sets the y hero coordinate
	 */
	public void setYHero(int y) {
		yHero = y;
	}

	/**
	 * 
	 * return map2 variable
	 */
	public char[][] getMap2() {
		return map2;
	}

	/**
	 * 
	 * Sets map2 variable
	 */
	public void setMap2(char[][] map) {

		this.map2 = map;
		board = map2;
	}

	/**
	 * This function make a board with any matrix
	 * 
	 * @param board
	 *            matrix given
	 */
	public Level(char[][] board) {

		boardSize = board.length;

		this.board = new char[boardSize][board[0].length];
		ogres = new ArrayList<Ogre>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] == 'H' || board[i][j] == 'A') {
					this.board[i][j] = ' ';
					hero = new Hero(i, j, board[i][j]);
				}

				else if (board[i][j] == 'G') {
					this.board[i][j] = ' ';
					guard = new Guard(i, j);
				} else if (board[i][j] == 'O') {
					this.board[i][j] = ' ';
					Ogre ogre = new Ogre(i, j);
					ogres.add(ogre);
				} else
					this.board[i][j] = board[i][j];
			}
		}
	}

	// Methods

	/**
	 * 
	 * return the number of ogres in the level
	 */
	public int getNumberOgres() {
		return numOgres;
	}

	/**
	 * 
	 * Sets the numberLevel
	 */
	public void setNumberLevel(int numberLevel) {
		this.numberLevel = numberLevel;
	}

	/**
	 * Sets the number of ogres
	 * 
	 * @param num
	 *            number of ogres
	 */
	public void setNumberOgres(int num) {
		this.numOgres = num;
	}

	/**
	 * 
	 * return the number level
	 */
	public int getNumberLevel() {
		return numberLevel;
	}

	/**
	 * return the board
	 * 
	 */
	public char[][] getBoard() {
		return board;
	}

	/**
	 * 
	 * Sets the doorsOpen variable
	 */
	public void setDoorsOpen(boolean doorsOpen) {
		this.doorsOpen = doorsOpen;
	}

	/**
	 * Sets the board
	 * 
	 */
	public void setBoard(char[][] board) {
		this.board = board;
	}

	/**
	 * 
	 * return the hero
	 */
	public Hero getHero() {
		return hero;
	}

	/**
	 * 
	 * Sets the hero
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}

	/**
	 * 
	 * return guard
	 */
	public Guard getGuard() {
		return guard;
	}

	/**
	 * Sets the guard pesonality
	 * 
	 */
	public void setGuard(String personality) {
		if (guard != null) {
			this.guard.setPersonality(personality);
		}
	}

	/**
	 * 
	 * return the ogres array
	 */
	public ArrayList<Ogre> getOgres() {
		return ogres;
	}

	/**
	 * Sets the ogres
	 * 
	 * @param coord
	 *            coordinates to set the ogre
	 */
	public void setOgresNotRandom(int[] coord) {

		if (ogres != null) {

			for (int i = 0; i < coord.length-1; i++) {
				Ogre ogre = new Ogre(coord[i], coord[i+1]);
				ogres.add(ogre);
				i++;
			}
		}
	}

	/**
	 * Sets the ogres in (1,1)
	 * 
	 * @param NumberOgres
	 */
	public void setOgres(int NumberOgres) {
		this.numOgres = NumberOgres;
		if (ogres != null) {

			for (int i = 0; i < NumberOgres; i++) {
				Ogre ogre = new Ogre(1, 1);
				ogres.add(ogre);
			}
		}

	}

	/**
	 * 
	 * return the lever value
	 */
	public boolean isLever() {
		return lever;
	}

	/**
	 * Sets the lever
	 * 
	 */
	public void setLever(boolean lever) {
		this.lever = lever;
	}

	/**
	 * Verifies the coordinates given collision with walls and door
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @param direction
	 *            user input (WASD)
	 * @return true if collision and false otherwise
	 */
	public boolean checkObstacle(int x, int y, int direction) {
		if (direction == 2) {
			if (board[x - 1][y] == 'X' || board[x - 1][y] == 'I' || board[x - 1][y] == 'S') {
				return true;
			} else {
				return false;
			}
		}
		if (direction == 3) {
			if (board[x + 1][y] == 'X' || board[x + 1][y] == 'I' || board[x + 1][y] == 'S') {
				return true;
			} else {
				return false;
			}
		}
		if (direction == 1) {
			if (board[x][y - 1] == 'X' || board[x][y - 1] == 'I' || board[x][y - 1] == 'S') {
				return true;
			} else {
				return false;
			}
		}
		if (direction == 4) {
			if (board[x][y + 1] == 'X' || board[x][y + 1] == 'I' || board[x][y + 1] == 'S') {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	/**
	 * Checks if the ogre in the coordinates passed can move
	 * @param x coordinate
	 * @param y coordinate 
	 * @return true if can move else otherwise
	 */
	public boolean ogreMovement(int x, int y) {
		if (board[x][y] == 'X' || board[x][y] == 'I')

			return false;
		else
			return true;
	}

	/**
	 * Sets a random number of ogres
	 */
	public void setRandomOgre() {

		Random r = new Random();
		int number = r.nextInt(3);

		if (number == 0)
			setNumberOgres(1);
		if (number == 1)
			setNumberOgres(2);
		else
			setNumberOgres(3);

	}

	/**
	 * Verifies if hero can move
	 * 
	 * @param x
	 *            hero coordinate
	 * @param y
	 *            hero coordinate
	 * @return true if hero can move and false otherwise
	 */
	public boolean heroMovement(int x, int y) {

		if (hero.getLetter() == 'K' && board[x][y] == 'I') {
			openDoors();
			return false;
		} else if (board[x][y] == 'X' || board[x][y] == 'I') {
			return false;
		} else
			return true;
	}

	/**
	 * This function opens all door in the playing board
	 */
	public void openDoors() {
		setDoorsOpen(true);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 'I')
					board[i][j] = 'S';
			}
		}

	}

	/**
	 * Verifies if the door is found in the coordinates given
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinate
	 * @return true if the door is found and false otherwise
	 */
	public boolean foundDoor(int x, int y) {
		if (board[x][y] == 'S')
			return true;

		else
			return false;
	}

	/**
	 * This function verifies if the door is closed 
	 * @param x coordinate
	 * @param y coordinate
	 * @return true if the door closed is found and false otherwise
	 */
	public boolean foundClosedDoor(int x, int y) {
		if (board[x][y] == 'I') {
			board[x][y] = 'S';
			return true;
		} else
			return false;
	}

	/**
	 * Function that checks if hero found key
	 * 
	 * @param x
	 *            coordinate to check
	 * @param y
	 *            coordinate to check
	 * @return true if found key, and false otherwise
	 */
	public boolean foundKey(int x, int y) {
		if (board[x][y] == 'k') {
			lever = true;
			return true;
		} else
			return false;
	}

	/**
	 * Function that deletes all keys in the board
	 */
	public void deleteAllKeys() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'k')
					board[i][j] = ' ';
			}
		}
	}
}
