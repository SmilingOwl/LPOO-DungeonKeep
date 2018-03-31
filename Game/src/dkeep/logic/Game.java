package dkeep.logic;

import java.util.Random;

public class Game {

	public enum State {
		Won, Lost, Playing
	}

	public enum Event {
		Colision, NewGame, levelUp, Victory
	}

	public State gameState;
	public Level playingLevel;
	protected String map = "";
	protected int numO;

	private boolean levelUp = false;

	/**
	 * Class constructor
	 */
	public Game() {
	}

	public Level getPlayingLevel() {
		return playingLevel;
	}

	public void setPlayingLevel(Level playingLevel) {
		this.playingLevel = playingLevel;

	}

	public int getNumOgres() {
		return numO;
	}

	public void setNumOgres(int num) {
		this.numO = num;
	}

	/**
	 * prints the game result (victory or game over)
	 */

	public void printEndGame() {

		System.out.println();
		printBoard();

		if (gameState == State.Won) {
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

	public boolean updateMap(int x, int y) {

		// hero
		if (playingLevel.getHero().getXcoordinate() == x && playingLevel.getHero().getYcoordinate() == y) {
			map += playingLevel.getHero().getLetter() + " ";
			// System.out.print(playingLevel.getHero().getLetter() + " ");
			return true;
		}
		// Ogre and damage
		if (playingLevel.getOgres() != null) {

			for (int i = 0; i < playingLevel.getOgres().size(); i++) {

				if (playingLevel.getOgres().get(i).getXcoordinate() == x
						&& playingLevel.getOgres().get(i).getYcoordinate() == y) {
					map += playingLevel.getOgres().get(i).getLetter() + " ";
					// System.out.print(playingLevel.getOgres().get(i).getLetter() + " ");
					return true;
				}

				if (playingLevel.getOgres().get(i).getxDamage() == x
						&& playingLevel.getOgres().get(i).getyDamage() == y) {
					map += playingLevel.getOgres().get(i).getDamageSymbol() + " ";
					// System.out.print(playingLevel.getOgres().get(i).getDamageSymbol() + " ");
					return true;
				}
			}
		}
		// guard
		if (playingLevel.getGuard() != null) {

			if (playingLevel.getGuard().getXcoordinate() == x && playingLevel.getGuard().getYcoordinate() == y) {
				map += playingLevel.getGuard().getLetter() + " ";
				// System.out.print(playingLevel.getGuard().getLetter() + " ");
				return true;
			}
		}
		return false;
	}

	public String getMap() {
		return map;
	}

	public void printstring() {
		map = "";
		for (int i = 0; i < playingLevel.getBoard().length; i++) {
			for (int j = 0; j < playingLevel.getBoard()[i].length; j++) {
				if (!updateMap(i, j))
					map += playingLevel.getBoard()[i][j] + " ";
			}
			map += "\n";
		}
		System.out.println();
	}

	/**
	 * this function update the game state
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
			gameState=State.Won;
			nextlevel();
		}
		if (e == Event.NewGame) {
			gameState = State.Playing;
		}
		if (e == Event.Victory) {
			gameState = State.Won;
		}
	}

	public void nextlevel() {
		if (playingLevel.numberLevel == 1) {
			playingLevel = new Level2(numO);
			playingLevel.setNumberOgres(numO);
		} else
			System.out.println("Game completed!");

	}

	// set randomly guard and ogres!

	/**
	 * this function add randomly one of the guard types
	 */
	public void setRandomGuard() {
		Random r = new Random();
		int type = r.nextInt(3);
		type = r.nextInt(3 - 1) + 1;
		playingLevel.setGuard("Drunken");
		/*
		 * if (type == 1) playingLevel.setGuard("Suspicious"); if (type == 2)
		 * playingLevel.setGuard("Drunken"); else playingLevel.setGuard("Rookie");
		 */
	}

	/**
	 * this function add randomly 1, 2 or 3 ogres
	 */

	public void setRandomOgre() {

		Random r = new Random();
		int number = r.nextInt(3);
		
		playingLevel.setOgres(1); // add 1 ogre if (number == 0)
		playingLevel.setNumberOgres(1); // add 2 ogres if (number == 1)
		playingLevel.setNumberOgres(2); // add 3 ogres else
		playingLevel.setNumberOgres(3);

	}

	// set with parameters guard and ogres

	public void setGuard(String personality) {
		playingLevel.setGuard(personality);
	}

	public void setOgres(int numberOgres) {
		playingLevel.setOgres(numberOgres);
	}

	// Movements

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

	public void updateGuardPosition() {

		if (playingLevel.getGuard() != null) {
			playingLevel.getGuard().whatGuard();

			if (playingLevel.getGuard().guardColision(playingLevel.getHero().getXcoordinate(),
					playingLevel.getHero().getYcoordinate()))
				updateStateGame(Event.Colision);
		}

	}

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

	public void updateDoorPosition() {
		if (playingLevel.foundDoor(playingLevel.getHero().getXcoordinate(), playingLevel.getHero().getYcoordinate()))
			updateStateGame(Event.levelUp);

		if (playingLevel.unlockDoor && playingLevel.getNumberLevel() == 1)
			playingLevel.openDoors();

	}

	public void updateOgreDamagePosition() {
		for (int i = 0; i < playingLevel.getOgres().size(); i++) {
			if (!playingLevel.getOgres().get(i).isStun())
				OgreMove(playingLevel.getOgres().get(i));

			else
				playingLevel.getOgres().get(i).TimeStunCounter();

			OgreDamageMove(playingLevel.getOgres().get(i));
		}
	}

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
