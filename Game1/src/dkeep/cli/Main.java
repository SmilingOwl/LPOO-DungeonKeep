package dkeep.cli;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import dkeep.logic.*;
import dkeep.logic.Character;

public class Main {
	public static int mapNumber = 1;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] heroCoordinates = new int[2];
		heroCoordinates[0] = 1;
		heroCoordinates[1] = 1;

		Hero h = new Hero(heroCoordinates[0], heroCoordinates[1], 'H');

		int[] guardCoordinates = new int[2];
		guardCoordinates[0] = 1;
		guardCoordinates[1] = 8;

		Guard g = new Guard(guardCoordinates[0], guardCoordinates[1]);

		firstMap(scanner, h, g);

		// level 2

		if (mapNumber != 0) {
			System.out.println("Numero de Ogres: ");
			int numero;
			numero = scanner.nextInt();

			int[] ogreCordinates = new int[2];
			int[] ogreCordinatesDamage = new int[2];

			ArrayList<Ogre> ogres = new ArrayList<Ogre>();

			for (int i = 0; i < numero; i++) {
				ogreCordinates[0] = randInt(2, 6);
				ogreCordinates[1] = randInt(2, 6);

				ogreCordinatesDamage[0] = 1;
				ogreCordinatesDamage[1] = 1;

				Ogre o = new Ogre(ogreCordinates[0], ogreCordinates[1], ogreCordinatesDamage[0],
						ogreCordinatesDamage[1]);
				Board.board2[o.getX()][o.getY()] = 'O';
				ogres.add(o);
			}

			h.setX(8);
			h.setY(1);

			secondMap(scanner, h, ogres);
		}

		scanner.close();
	}

	// **********************METHODS******************************

	public static int randInt(int min, int max) {

		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public static void firstMap(Scanner scanner, Hero h, Guard g) {
		String movementDirection;
		int whatGuard = randInt(1, 3);

		if (whatGuard == 1) {
			g.setPersonality("Rookie");
		} else if (whatGuard == 2) {
			g.setPersonality("Drunken");
		} else if (whatGuard == 3) {
			g.setPersonality("  ");

		}

		while (mapNumber == 1) {
			
			printBoard(Board.board1);
			movementDirection = readDirection(scanner);
		
			h.heroMovement(Board.board1, movementDirection);// heroCordinates
			g.whatGuard();
			
			if (Character.checkHeroPresence(Board.board1, g)) {
				loss();
			}

		}

		printBoard(Board.board1);
	}

	public static void secondMap(Scanner scanner, Hero h, ArrayList<Ogre> o) {
		String movementDirection;

		while (mapNumber == 2) {

			if (Board.board2[1][8] == ' ' && Board.board2[1][0] == 'I' && Board.board2[h.getX()][h.getY()] == 'H') {
				Board.board2[1][8] = 'k';
			}

			printBoard(Board.board2);
			movementDirection = readDirection(scanner);
			int coordinates[] = { h.getX(), h.getY() };

			h.heroMovementKeyTansport(coordinates, Board.board2, movementDirection);
			for (int i = 0; i < o.size(); i++) {
				o.get(i).randomOgreDirection();

				if (Board.board2[o.get(i).getXdamage()][o.get(i).getYdamage()] != 'O') {
					Board.board2[o.get(i).getXdamage()][o.get(i).getYdamage()] = ' ';
				}

				o.get(i).radomOgreDamage();

				if (o.get(i).checkifstun(h)) {

				}
				if (o.get(i).checkifloss(h)) {
					loss();
				}
			}
		}
		printBoard(Board.board2);
	}

	public static void printLegend() {
		System.out.println("Legend:");
		System.out.println("X -> Wall");
		System.out.println("I -> Exit Door");
		System.out.println("H -> Hero");
		System.out.println("G -> Guard");
		System.out.println("O -> Crazy Ogre");
		System.out.println("K -> key");
		System.out.println("empty cell - free space\n");
	}

	public static String readDirection(Scanner scanner) {

		String direction;

		do {
			direction = scanner.next();
		} while (!direction.equals("w") && !direction.equals("a") && !direction.equals("s") && !direction.equals("d"));

		return direction;
	}

	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void victory() {
		mapNumber++;
		System.out.println("Victory!");
	}

	public static void loss() {
		mapNumber--;
		System.out.println("Fatality!");
	}

}
