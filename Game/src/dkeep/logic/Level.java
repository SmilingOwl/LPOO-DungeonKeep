package dkeep.logic;

import java.util.ArrayList;
import java.util.Random;

public class Level {

	protected char[][] playingLevel;
	protected int boardSize;
	protected char[][] board;

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

	
	public int getNumberOgres() {
		return numOgres;
	}

	public void setNumberLevel(int numberLevel) {
		this.numberLevel = numberLevel;
	}


	public void setNumberOgres(int num) {
		this.numOgres = num;
	}

	public int getNumberLevel() {
		return numberLevel;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setDoorsOpen(boolean doorsOpen) {
		this.doorsOpen = doorsOpen;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Guard getGuard() {
		return guard;
	}

	public void setGuard(String personality) {
		if (guard != null) {
			this.guard.setPersonality(personality);
		}
	}

	public ArrayList<Ogre> getOgres() {
		return ogres;
	}

	public void setOgres(int NumberOgres) {
		this.numOgres = NumberOgres;
		/*
		 * for (int i = 0; i < NumberOgres; i++) { Ogre ogre = new Ogre(1, 1);
		 * ogres.add(ogre);}
		 */
		if (ogres != null) {

			for (int i = 0; i < NumberOgres; i++) {
				Ogre ogre = new Ogre(1, 1);
				ogres.add(ogre);
			}
		}

	}

	public boolean isLever() {
		return lever;
	}

	public void setLever(boolean lever) {
		this.lever = lever;
	}

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

	public boolean ogreMovement(int x, int y) {
		if (board[x][y] == 'X' || board[x][y] == 'I')

			return false;
		else
			return true;
	}

	public void setRandomOgre() {

		Random r = new Random();
		int number = r.nextInt(3);

		// playingLevel.setOgres(1);
		// add 1 ogre
		if (number == 0)
			setNumberOgres(1);
		// add 2 ogres
		if (number == 1)
			setNumberOgres(2);
		// add 3 ogres
		else
			setNumberOgres(3);

	}

	public boolean heroMovement(int x, int y) {

		if (hero.getLetter() == 'K' && board[x][y] == 'I') {
			openDoors();
			return false;
		} else if (board[x][y] == 'X' || board[x][y] == 'I') {
			return false;
		} else
			return true;
	}

	public void openDoors() {
		setDoorsOpen(true);
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (board[i][j] == 'I')
					board[i][j] = 'S';
			}
		}

	}

	public boolean foundDoor(int x, int y) {
		if (board[x][y] == 'S')
			return true;

		else
			return false;
	}

	public boolean foundClosedDoor(int x, int y) {
		if (board[x][y] == 'I') {
			board[x][y] = 'S';
			return true;
		} else
			return false;
	}

	public boolean foundKey(int x, int y) {
		if (board[x][y] == 'k') {
			lever = true;
			return true;
		} else
			return false;
	}

	public void deleteAllKeys() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'k')
					board[i][j] = ' ';
			}
		}
	}
}
