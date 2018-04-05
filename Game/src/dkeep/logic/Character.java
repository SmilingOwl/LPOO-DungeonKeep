package dkeep.logic;

public class Character {

	protected int x;
	protected int y;
	protected char letter;

	/**
	 * Superclass Constructor
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @param letter
	 *            letter that represents the character
	 */
	public Character(int x, int y, char letter) {
		super();
		this.x = x;
		this.y = y;
		this.letter = letter;
	}

	// getters and setters

	/**
	 * return x coordinate of the character
	 * 
	 */
	public int getXcoordinate() {
		return x;
	}

	/**
	 * sets the x coordinate of the character
	 * 
	 */
	public void setXcoordinate(int x) {
		this.x = x;
	}

	/**
	 * return y coordinate of the character
	 * 
	 */
	public int getYcoordinate() {
		return y;
	}

	/**
	 * sets y coordinate of the character
	 * 
	 */
	public void setYcoordinate(int y) {
		this.y = y;
	}

	/**
	 * return the character´s letter
	 * 
	 */
	public char getLetter() {
		return letter;
	}

	/**
	 * 
	 * sets the character´s letter
	 */
	public void setLetter(char letter) {
		this.letter = letter;
	}

}
