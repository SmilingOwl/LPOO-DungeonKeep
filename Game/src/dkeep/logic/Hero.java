package dkeep.logic;

public class Hero extends Character {

	private boolean Armed = false;

	/**
	 * Class constructor
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @param letter
	 *            represents the Hero ('A' or 'H')
	 */
	public Hero(int x, int y, char letter) {
		super(x, y, letter);
		// hero can be 'A' 'H' 'K'
	}

	//Getters and Setters
	
	/**
	 * check if the hero is armed
	 * 
	 * @return true if armed, false otherwise
	 */
	public boolean isArmed() {
		return Armed;
	}

	/**
	 * sets if the hero is armed or not
	 * 
	 * @param armed
	 *            boolean to set Armed
	 */
	public void setArmed(boolean armed) {
		Armed = armed;
	}

}
