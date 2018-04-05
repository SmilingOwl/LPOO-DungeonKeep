package dkeep.logic;

import java.util.Random;

public class Game {

	public enum State {
		Won, Wonlevel1, Lost, Playing
	}

	public enum Event {
		Colision, NewGame, levelUp, Victory
	}

	public State gameState;
	public boolean modify;
	public Level playingLevel;
	protected String map = "";
	protected char[][] map2;
	private int xHero = 0;
	private int yHero = 0;
	private int[] coorO;
	protected int numO = 0;

	private boolean levelUp = false;

	/**
	 * Class constructor
	 */
	public Game() {
		modify = false;
	}

	/**
	 * 
	 * Sets the modify attribute
	 */
	public void setModify(boolean modify) {
		this.modify = modify;
	}

	/**
	 * 
	 * return the coorO
	 */
	public int[] getCoorO() {
		return coorO;
	}

	/**
	 * 
	 * sets the coorO attribute
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
	 * sets the hero x coordinate
	 */
	public void setXHero(int x) {
		xHero = x;
	}

	/**
	 * 
	 * sets the hero y coordinate
	 */
	public void setYHero(int y) {
		yHero = y;
	}

	/**
	 * 
	 * return the map2 attribute
	 */
	public char[][] getMap2() {
		return map2;
	}

	/**
	 * 
	 * sets the map2 attribute
	 */
	public void setMap2(char[][] map) {
		this.map2 = map;
	}

	/**
	 * 
	 * return the playing level
	 */
	public Level getPlayingLevel() {
		return playingLevel;
	}

	/**
	 * 
	 * Sets the playing level
	 */
	public void setPlayingLevel(Level playingLevel) {
		this.playingLevel = playingLevel;

	}

	/**
	 * 
	 * return the ogres number
	 */
	public int getNumOgres() {
		return numO;
	}

	/**
	 * 
	 * Sets the ogres number
	 */
	public void setNumOgres(int num) {
		this.numO = num;
	}

	/**
	 * prints the game result (victory or game over)
	 */
	public void printEndGame() {

		System.out.println();
		printBoard();

		if (gameState == State.Wonlevel1 ||gameState==State.Won) {
			System.out.print(" Victory ");
			System.out.println();

		} else if (gameState == State.Lost) {
			System.out.print(" Game Over ");
			System.out.println();
		}
	}

	/**
	 * prints the board that you are playing
	 */
	public void printBoard() {

		for (int i = 0; i < playingLevel.getBoard().length; i++) {
			for (int j = 0; j < playingLevel.getBoard()[i].length; j++) {
				if (!updateBoard(i, j))
					System.out.print(playingLevel.getBoard()[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * This function update the game state
	 * 
	 * @param e
	 *            event
	 */
	public void updateStateGame(Event e) {
		if (e == Event.Colision) {
			gameState = State.Lost;
		}
		if (e == Event.levelUp) {
			levelUp = true;
			if(playingLevel.getNumberLevel()==1)
			{
				gameState = State.Wonlevel1;
				nextlevel();
			}
			else if(playingLevel.getNumberLevel()==2)
				gameState = State.Won;

		}
		if (e == Event.NewGame) {
			gameState = State.Playing;
		}
		
	}

	/**
	 * function that sets the next Level
	 */
	public void nextlevel() {
		if (playingLevel.numberLevel == 1) {
			// playingLevel = new Level2(numO);
			playingLevel = new Level2(numO, xHero, yHero, coorO);

			/*
			 * if(coorO !=null) playingLevel.setCoorO(coorO);
			 */
			playingLevel.setXHero(xHero);
			playingLevel.setYHero(yHero);
			if (numO == 0) {
				setRandomOgre();
			} else
				playingLevel.setNumberOgres(numO);
			if (modify) {
				this.playingLevel.setMap2(map2);
			}
		} 

	}

	// set randomly guard and ogres!

	/**
	 * this function add randomly one of the guard types
	 */
	public void setRandomGuard() {
		Random r = new Random();
		int type = r.nextInt(3);
		type = r.nextInt(3 - 1) + 1;
		if (type == 1)
			playingLevel.setGuard("Suspicious");
		if (type == 2)
			playingLevel.setGuard("Drunken");
		else
			playingLevel.setGuard("Rookie");

	}

	/**
	 * this function add randomly 1, 2 or 3 ogres
	 */
	public void setRandomOgre() {
		int number = 1 + (int) (Math.random() * 3);
		playingLevel.setOgres(number);
	}

	/**
	 * Sets the guard personality
	 * 
	 * @param personality
	 *            type of guard
	 */
	public void setGuard(String personality) {
		playingLevel.setGuard(personality);
	}

	/**
	 * Sets the number of ogres
	 * 
	 * @param numberOgres
	 */
	public void setOgres(int numberOgres) {
		playingLevel.setOgres(numberOgres);
	}

	/**
	 * function that manage user inputs
	 * 
	 * @param letter
	 *            direction of movement (WASD)
	 */
	public void heroMove(char letter) {
		// UP
		if (letter == 'w') {

			if (playingLevel.heroMovement(playingLevel.getHero().getXcoordinate() - 1,
					playingLevel.getHero().getYcoordinate()))
				playingLevel.getHero().setXcoordinate(playingLevel.getHero().getXcoordinate() - 1);
		}
		// left
		if (letter == 'a') {

			if (playingLevel.heroMovement(playingLevel.getHero().getXcoordinate(),
					playingLevel.getHero().getYcoordinate() - 1))
				playingLevel.getHero().setYcoordinate(playingLevel.getHero().getYcoordinate() - 1);
		}
		// down
		if (letter == 's') {

			if (playingLevel.heroMovement(playingLevel.getHero().getXcoordinate() + 1,
					playingLevel.getHero().getYcoordinate()))
				playingLevel.getHero().setXcoordinate(playingLevel.getHero().getXcoordinate() + 1);
		}
		// right
		if (letter == 'd') {

			if (playingLevel.heroMovement(playingLevel.getHero().getXcoordinate(),
					playingLevel.getHero().getYcoordinate() + 1))
				playingLevel.getHero().setYcoordinate(playingLevel.getHero().getYcoordinate() + 1);
		}
		// update all character

		updateGuardPosition();
		updateOgrePosition();
		updateKeyPosition();
		updateDoorPosition();
	}

	/**
	 * function that manage ogre´s move
	 * 
	 * @param ogre
	 */
	public void OgreMove(Ogre ogre) {
		Random random = new Random();

		int Xcoordinate = ogre.getXcoordinate();
		int Ycoordinate = ogre.getYcoordinate();

		int r = random.nextInt(4);
		do {
			r = 1 + (int) (Math.random() * 4);
		} while (playingLevel.checkObstacle(Xcoordinate, Ycoordinate, r));
		if (r == 3)
			Xcoordinate++;
		if (r == 2)
			Xcoordinate--;
		if (r == 4)
			Ycoordinate++;
		if (r == 1)
			Ycoordinate--;

		ogre.setXcoordinate(Xcoordinate);
		ogre.setYcoordinate(Ycoordinate);

	}

	/**
	 * Function that manage ogre´s arm move
	 * 
	 * @param ogre
	 */
	public void OgreDamageMove(Ogre ogre) {
		Random random = new Random();

		int Xcoordinate = ogre.getXcoordinate();
		int Ycoordinate = ogre.getYcoordinate();

		int r = random.nextInt(4);
		do {
			r = 1 + (int) (Math.random() * 4);
			;
		} while (playingLevel.checkObstacle(Xcoordinate, Ycoordinate, r));
		if (r == 3)
			Xcoordinate++;
		if (r == 2)
			Xcoordinate--;
		if (r == 4)
			Ycoordinate++;
		if (r == 1)
			Ycoordinate--;

		ogre.setxDamage(Xcoordinate);
		ogre.setyDamage(Ycoordinate);

	}

	/**
	 * Function that updates the position of the ogres and verifies collision with
	 * hero
	 * 
	 */
	public void updateOgrePosition() {

		if (playingLevel.getOgres() != null) {
			updateOgreDamagePosition();

			for (int i = 0; i < playingLevel.getOgres().size(); i++) {
				if (playingLevel.getOgres().get(i).ogreColision(playingLevel.getHero().getXcoordinate(),
						playingLevel.getHero().getYcoordinate()))
					updateStateGame(Event.Colision);

				if (playingLevel.getHero().isArmed() == true) {
					if (playingLevel.getOgres().get(i).ogreIsStuned(playingLevel.getHero().getXcoordinate(),
							playingLevel.getHero().getYcoordinate())) {

						playingLevel.getOgres().get(i).setLetter('8');
						playingLevel.getOgres().get(i).setStun(true);
					}
				}
				checkOgreLetter(i);
			}
		}

	}

	/**
	 * Function that updates the ogre´s letter
	 * 
	 * @param i
	 *            position of ogre in ogres array
	 */
	public void checkOgreLetter(int i) {

		if (playingLevel.foundKey(playingLevel.getOgres().get(i).getxDamage(),
				playingLevel.getOgres().get(i).getyDamage()))
			playingLevel.getOgres().get(i).setDamageSymbol('$');

		else
			playingLevel.getOgres().get(i).setDamageSymbol('*');

		if (playingLevel.foundKey(playingLevel.getOgres().get(i).getXcoordinate(),
				playingLevel.getOgres().get(i).getYcoordinate()))
			playingLevel.getOgres().get(i).setLetter('$');

		else if (!playingLevel.getOgres().get(i).isStun())
			playingLevel.getOgres().get(i).setLetter('O');

	}

	/**
	 * Function that updates the guard position and verifies collision with guard
	 */
	public void updateGuardPosition() {

		if (playingLevel.getGuard() != null) {
			playingLevel.getGuard().whatGuard();

			if (playingLevel.getGuard().guardColision(playingLevel.getHero().getXcoordinate(),
					playingLevel.getHero().getYcoordinate()))
				updateStateGame(Event.Colision);
		}

	}

	/**
	 * Function that updates the key position, and updates the hero letter
	 */
	public void updateKeyPosition() {

		if (playingLevel.foundKey(playingLevel.getHero().getXcoordinate(), playingLevel.getHero().getYcoordinate())) {
			// has lever
			if (playingLevel.isLever()) {
				playingLevel.getHero().setLetter('K');
				playingLevel.deleteAllKeys();
				if (playingLevel.getNumberLevel() == 1)
					playingLevel.openDoors();
			}
			// has key
			else
				playingLevel.openDoors();
		}
	}

	/**
	 * Function that updates the Door (close or open) and update the game state
	 */
	public void updateDoorPosition() {
		if (playingLevel.foundDoor(playingLevel.getHero().getXcoordinate(), playingLevel.getHero().getYcoordinate()))
			updateStateGame(Event.levelUp);

		if (playingLevel.unlockDoor && playingLevel.getNumberLevel() == 1)
			playingLevel.openDoors();

	}

	/**
	 * Function that verifies if ogre is stun or not
	 */
	public void updateOgreDamagePosition() {
		for (int i = 0; i < playingLevel.getOgres().size(); i++) {
			if (!playingLevel.getOgres().get(i).isStun())
				OgreMove(playingLevel.getOgres().get(i));

			else
				playingLevel.getOgres().get(i).TimeStunCounter();

			OgreDamageMove(playingLevel.getOgres().get(i));
		}
	}

	/**
	 * Updates the level board at x and y coordinate, printing the characters
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinate
	 * @return true if prints the characters and false otherwise
	 */
	public boolean updateBoard(int x, int y) {

		// hero
		if (playingLevel.getHero().getXcoordinate() == x && playingLevel.getHero().getYcoordinate() == y) {
			System.out.print(playingLevel.getHero().getLetter() + " ");
			return true;
		}
		// Ogre and damage
		if (playingLevel.getOgres() != null) {

			for (int i = 0; i < playingLevel.getOgres().size(); i++) {

				if (playingLevel.getOgres().get(i).getXcoordinate() == x
						&& playingLevel.getOgres().get(i).getYcoordinate() == y) {

					System.out.print(playingLevel.getOgres().get(i).getLetter() + " ");
					return true;
				}

				if (playingLevel.getOgres().get(i).getxDamage() == x
						&& playingLevel.getOgres().get(i).getyDamage() == y) {

					System.out.print(playingLevel.getOgres().get(i).getDamageSymbol() + " ");
					return true;
				}
			}
		}
		// guard
		if (playingLevel.getGuard() != null) {

			if (playingLevel.getGuard().getXcoordinate() == x && playingLevel.getGuard().getYcoordinate() == y) {
				System.out.print(playingLevel.getGuard().getLetter() + " ");
				return true;
			}
		}
		return false;
	}
}
