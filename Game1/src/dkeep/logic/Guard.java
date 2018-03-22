package dkeep.logic;

import java.util.Random;

public class Guard extends Character {

	private String personality;
	private boolean reverse = false;
	private boolean wasSleeping = false;
	private int indice;
	private int array[];

	private int arraynormal[] = { 'l', 'd', 'd', 'd', 'd', 'l', 'l', 'l', 'l', 'l', 'l', 'd', 'r', 'r', 'r', 'r', 'r',
			'r', 'r', 'u', 'u', 'u', 'u', 'u' };

	private int arrayinverso[] = { 'd', 'd', 'd', 'd', 'd', 'l', 'l', 'l', 'l', 'l', 'l', 'l', 'u', 'r', 'r', 'r', 'r',
			'r', 'r', 'u', 'u', 'u', 'u', 'r' };

	public Guard(int x, int y) {
		super(x, y, 'G');
		array = arraynormal;
		indice = 0;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

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

	// normal
	// 2 colunas e 24 linhas
	public void rookieMovement() {
		
		Board.board1[x][y] = ' ';
		switch (array[indice]) {
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
		if (indice == 24) {
			indice = 0;
		}
		Board.board1[x][y] = 'G';

	}

	public void indice_convert() {
		switch (indice) {
		case 1:
			indice = 23;
			break;
		case 2:
			indice = 22;
			break;
		case 3:
			indice = 21;
			break;
		case 4:
			indice = 20;
			break;
		case 5:
			indice = 19;
			break;
		case 6:
			indice = 18;
			break;
		case 7:
			indice = 17;
			break;
		case 8:
			indice = 16;
			break;
		case 9:
			indice = 15;
			break;
		case 10:
			indice = 14;
			break;
		case 11:
			indice = 13;
			break;
		case 12:
			indice = 12;
			break;
		case 13:
			indice = 11;
			break;
		case 14:
			indice = 10;
			break;
		case 15:
			indice = 9;
			break;
		case 16:
			indice = 8;
			break;
		case 17:
			indice = 7;
			break;
		case 18:
			indice = 6;
			break;
		case 19:
			indice = 5;
			break;
		case 20:
			indice = 4;
			break;
		case 21:
			indice = 3;
			break;
		case 22:
			indice = 2;
			break;
		case 23:
			indice = 1;
			break;

		}

	}

	public void drunkenMovement() 
	{ 
		Random r1 = new Random();
		Random r2 = new Random();

		int sleep = r1.nextInt(4);// se 0->dormir, senão move
		int goBack = 1;
		if (wasSleeping == true) {
			goBack = r2.nextInt(2);
		} // se 0-> reverse, senão normal

		if (sleep == 0) {
			this.setLetter('g');
			wasSleeping = true;
			Board.board1[x][y] = 'g';

		} else {
			this.setLetter('G');

			if (goBack == 0) {
				reverse = true;

				if (array != arrayinverso) {
					array = arrayinverso;
					indice_convert();
				}
			} else {
				if (array != arraynormal) {
					array = arraynormal;
					indice_convert();
				}
				reverse = false;

			}

			rookieMovement();
		}

	}

	// turning back
	public void suspiciousMovement() {
		Random r = new Random();
		int goBack = r.nextInt(2); // se 0-> reverse, senão normal

		if (goBack == 0) {
			reverse = true;
			if (array != arrayinverso) {
				array = arrayinverso;
				indice_convert();
			}
		} else {
			reverse = false;
			if (array != arraynormal) {
				array = arraynormal;
				indice_convert();
			}

		}

		rookieMovement();
	}
}