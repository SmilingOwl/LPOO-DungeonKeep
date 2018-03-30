package dkeep.logic;

public class Character {

	protected int x;
	protected int y;
	protected char letter;
		
	/**
	 * Superclass Constructor
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param letter letter that represents the character
	 */
public Character(int x, int y, char letter) {
		super();
		this.x = x;
		this.y = y;
		this.letter = letter;
	}

//getters and setters

public int getXcoordinate() {
	return x;
}

public void setXcoordinate(int x) {
	this.x = x;
}

public int getYcoordinate() {
	return y;
}

public void setYcoordinate(int y) {
	this.y = y;
}

public char getLetter() {
	return letter;
}

public void setLetter(char letter) {
	this.letter = letter;
}

}
