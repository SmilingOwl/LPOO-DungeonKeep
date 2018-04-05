package dkeep.logic;

public class Ogre extends Character {

	private int xDamage;
	private int yDamage;
	private char damageSymbol;

	private boolean isStun = false;
	private int timeStun = 0;

	/**
	 * Class constructor
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 */
	public Ogre(int x, int y) {
		super(x, y, 'O');
		this.xDamage = x + 1;
		this.yDamage = y;
		this.damageSymbol = '*';
	}

	// Getters and Setters
	/**
	 * 
	 * return x damage coordinate
	 */
	public int getxDamage() {
		return xDamage;
	}

	/**
	 * 
	 * Sets the x damage coordinate
	 */
	public void setxDamage(int xDamage) {
		this.xDamage = xDamage;
	}

	/**
	 * 
	 * return y damage coordinate
	 */
	public int getyDamage() {
		return yDamage;
	}

	/**
	 * 
	 * Sets the y damage coordinate
	 */
	public void setyDamage(int yDamage) {
		this.yDamage = yDamage;
	}

	/**
	 * 
	 * return the damage symbol
	 */
	public char getDamageSymbol() {
		return damageSymbol;
	}

	/**
	 * Sets the damage symbol
	 * @param damageSymbol
	 */
	public void setDamageSymbol(char damageSymbol) {
		this.damageSymbol = damageSymbol;
	}

	/**
	 * 
	 * return if ogre is stun or not
	 */
	public boolean isStun() {
		return isStun;
	}

	/**
	 * 
	 * Sets the isStun variable
	 */
	public void setStun(boolean isStun) {
		this.isStun = isStun;
	}

	// Methods

	/**
	 * Function that checks if the position passed can stun the ogre
	 * 
	 * @param x
	 *            x coordinate of the position (character)
	 * @param y
	 *            y coordinate of the position (character)
	 * @return true if it´s stun, false otherwise
	 */
	public boolean ogreIsStuned(int x, int y) {
		// same line as *
		if (y == this.y) {
			if (x == this.x - 1 || x == this.x + 1)
				return true;
		}
		// same column as *
		if (x == this.x) {
			if (y == this.y - 1 || y == this.y + 1)
				return true;
		}

		return false;
	}

	/**
	 * checks if there is a collision between the ogre´s damage * and the character
	 * of coordinates x,y
	 * 
	 * @param x
	 *            x coordinate to check collision
	 * @param y
	 *            y coordinate to check collision
	 * @return true if there is a collision, false otherwise
	 */
	public boolean ogreColision(int x, int y) {
		// same line as *
		if (y == this.yDamage) {
			if (x == this.xDamage - 1 || x == this.xDamage + 1)
				return true;
		}
		// same column as *
		if (x == this.xDamage) {
			if (y == this.yDamage - 1 || y == this.yDamage + 1)
				return true;
		}

		return false;
	}

	/**
	 * Increases the number of rounds in which the ogre is stunned
	 */
	public void TimeStunCounter() {
		timeStun++;

		if (timeStun == 3) {
			isStun = false;
			timeStun = 0;
		}
	}
}
