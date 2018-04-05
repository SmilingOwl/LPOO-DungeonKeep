package dkeep.logic;

import java.util.Random;

public class Guard extends Character {

	private String personality;
	private int array[];
	private boolean reverse = false;
	private boolean wasSleeping =false;
	private int indice;
	private int goBack =1;
	
	private int arraynormal[] = { 'l', 'd','d' ,'d','d','l','l','l','l','l','l','d',
			'r','r','r','r','r','r','r','u','u','u','u','u'};
	
	private int arrayinverso[]= { 'd','d','d','d','d','l','l','l','l','l','l','l',
			'u','r','r','r','r','r','r','u','u','u','u','r'};
 

	/**
	 * Class constructor
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinate
	 */
	public Guard(int x, int y) {
		super(x, y, 'G');
		array=arraynormal;
		indice=0;
	}

	// Getters and Setters

	/**
	 * * @return the string that represents the guard personality
	 */
	public String getPersonality() {
		return personality;
	}

	/**
	 * set the guard personality
	 * 
	 * @param personality
	 *            string that represents the guard personality
	 */
	public void setPersonality(String personality) {
		this.personality = personality;
	}

	// Methods

	/**
	 * determines the behavior of the guard according to his personality
	 */
	public void whatGuard() {

		if (personality == "Rookie")
			this.rookieMovement();
		else {
			if (personality == "Drunken")
				this.drunkenMovement();
			else
				this.suspiciousMovement();
		}

	}

	/**
	 * Rookie guard movement (the guard moves normally)
	 */
	public void rookieMovement() {
		switch(array[indice])
		{
		case 'l':
			y--;
			break;
		case 'u':
			x--;
			break;
		case 'r':
			y++;
			break;
		case 'd':
			x++;
			break;


		}
		indice++;
		if(indice == 24)
		{
			indice=0;
		}

	}

	/**
	 * Function that converts indices
	 */
	public void indice_convert()
	{
		if(indice == 0)
			return;
					
		indice = 24 - indice;

	}

	/**
	 * Drunken movement (the guard fall asleep randomly while patrolling)
	 */
	public void drunkenMovement() {

		Random r1 = new Random();
		Random r2 = new Random();

		int sleep = r1.nextInt(4);// se 0->dormir, senão move
		if(wasSleeping==true)
		{
			
		goBack= r2.nextInt(2);
		wasSleeping=false;
		}

		if (sleep == 0) {
			this.setLetter('g');
			wasSleeping=true;

		} else {
			this.setLetter('G');

			if (goBack == 0) {
				reverse = true;
				
				if(array!= arrayinverso)
				{
				array=arrayinverso;
				indice_convert();
				}
			}
			else {
				if(array!= arraynormal)
				{
				array=arraynormal;
				indice_convert();
				}
				reverse = false;
				
			}

			rookieMovement();
		}

	}

	/**
	 * Suspicious movement (the guard randomly reverses patrolling direction)
	 */
	public void suspiciousMovement() {

		Random r=new Random();
		int goBack = r.nextInt(2); // se 0-> reverse, senão normal

		if (goBack == 0)
		{
			reverse = true;
			if(array!= arrayinverso)
			{
			array=arrayinverso;
			indice_convert();
			}
		}
		else {
			reverse = false;
			if(array!= arraynormal)
			{
			array=arraynormal;
			indice_convert();
			}
			
		}

		rookieMovement();

	}

	/**
	 * checks if there is collision between the guard and the given coordinates. 
	 * @param x x coordinate to check collision
	 * @param y y coordinate to check collision
	 * @return true if there is collision, otherwise false
	 */
	public boolean guardColision(int x, int y) {
		
		if (this.getLetter() == 'G') 
		{
			if (y == this.getYcoordinate() ) 
			{
				if (x == this.getXcoordinate() - 1 || x == this.getXcoordinate() + 1 || x == this.getXcoordinate())
					return true;
			}
			
			if (x == this.getXcoordinate()) 
			{
				if (y == this.getYcoordinate() - 1 || y == this.getYcoordinate() + 1 || y == this.getYcoordinate())
					return true;
			}
		}

		return false;
	}
		
	}