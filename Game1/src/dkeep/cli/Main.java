package dkeep.cli;

import java.util.Scanner;

public class Main {

	private static int level = 1;

	public static void main(String[] args) {

		// coordenadas das personagens
		int[] hero = new int[2];
		int[] guard = new int[2];
		int[] ogre = new int[2];
		int[] damage = new int[2];

		char[][] board = new char[][] { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

		char[][] board2 = new char[][] { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', 'O', ' ', ' ', 'k', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

		// Level 1

		// printLegend();
		// printDirections();

		// hero[0] = 1;
		// hero[1] = 1;
		// guard[0] = 1;
		// guard[1] = 8;

		// level1(board, hero, guard);

		// Level 2
		level++;

		printLegend();
		printDirections();

		hero[0] = 8;
		hero[1] = 1;
		ogre[0] = 1;
		ogre[1] = 5;
		damage[0] = 0;
		damage[1] = 0;

		level2(board2, hero, ogre, damage);
	}

	/**
	 * Imprime a matiz que recebe como parametro
	 * 
	 * @param board
	 *            matriz a imprimir no ecrã
	 */
	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void victory() {
		level++;
		System.out.println("Victory!!!");
	}

	/**
	 * Testa a presença de um obstáculo na direção tomada
	 *
	 * @param x
	 * @param y
	 * @param board
	 * @param order
	 * @return retorna true se encontrar parede e false caso contrário
	 */
	public static boolean testDirection(int x, int y, char[][] board, int order) {
		switch (order) {
		case 1:
			if (board[x - 1][y] == 'X' || board[x - 1][y] == 'I') {
				return true;
			}
			break;

		case 2:
			if (board[x + 1][y] == 'X' || board[x + 1][y] == 'I') {
				return true;
			}
			break;

		case 3:
			if (board[x][y - 1] == 'X' || board[x - 1][y - 1] == 'I') {
				return true;
			}
			break;

		case 4:
			if (board[x][y + 1] == 'X' || board[x][y + 1] == 'I') {
				return true;
			}
			break;

		}

		return false;
	}

	public static void heroMovementKeyTansport(int[] heroCordinate, char[][] map, int movementDirection) {
		switch (movementDirection) {
		case 1:

			if (map[heroCordinate[0]][heroCordinate[1] - 1] != 'X'
					&& map[heroCordinate[0]][heroCordinate[1] - 1] != 'I') {
				if (map[heroCordinate[0]][heroCordinate[1] - 1] == 'S') {
					map[heroCordinate[0]][heroCordinate[1]] = ' ';
					map[heroCordinate[0]][heroCordinate[1] - 1] = 'H';
					heroCordinate[1] = heroCordinate[1] - 1;
					victory();
				} else if (map[heroCordinate[0]][heroCordinate[1] - 1] == 'k'
						|| map[heroCordinate[0]][heroCordinate[1]] == 'K') {
					map[heroCordinate[0]][heroCordinate[1]] = ' ';
					map[heroCordinate[0]][heroCordinate[1] - 1] = 'K';
					heroCordinate[1] = heroCordinate[1] - 1;
				} else {
					map[heroCordinate[0]][heroCordinate[1]] = ' ';
					map[heroCordinate[0]][heroCordinate[1] - 1] = 'H';
					heroCordinate[1] = heroCordinate[1] - 1;

				}

			} else {
				checkUnlockableDoor(map, heroCordinate);
			}
			if (map[1][8] == ' ' && map[2][0] == 'I') {
				map[1][8] = 'k';
			}
			break;
		case 2:

			if (map[heroCordinate[0] - 1][heroCordinate[1]] != 'X'
					&& map[heroCordinate[0] - 1][heroCordinate[1]] != 'I') {
				if (map[heroCordinate[0] - 1][heroCordinate[1]] == 'S') {
					map[heroCordinate[0]][heroCordinate[1]] = ' ';
					map[heroCordinate[0] - 1][heroCordinate[1]] = 'H';
					heroCordinate[0] = heroCordinate[0] - 1;
					victory();
				} else if (map[heroCordinate[0] - 1][heroCordinate[1]] == 'k'
						|| map[heroCordinate[0]][heroCordinate[1]] == 'K') {
					map[heroCordinate[0]][heroCordinate[1]] = ' ';
					map[heroCordinate[0] - 1][heroCordinate[1]] = 'K';
					heroCordinate[0] = heroCordinate[0] - 1;
				} else {
					map[heroCordinate[0]][heroCordinate[1]] = ' ';
					map[heroCordinate[0] - 1][heroCordinate[1]] = 'H';
					heroCordinate[0] = heroCordinate[0] - 1;
				}

			} else {
				checkUnlockableDoor(map, heroCordinate);
			}
			if (map[1][8] == ' ' && map[2][0] == 'I') {
				map[1][8] = 'k';
			}
			break;

		case 3:

			if (map[heroCordinate[0] + 1][heroCordinate[1]] != 'X'
					&& map[heroCordinate[0] + 1][heroCordinate[1]] != 'I') {
				if (map[heroCordinate[0] + 1][heroCordinate[1]] == 'S') {
					map[heroCordinate[0]][heroCordinate[1]] = ' ';
					map[heroCordinate[0] + 1][heroCordinate[1]] = 'H';
					heroCordinate[0] = heroCordinate[0] + 1;
					victory();
				} else if (map[heroCordinate[0] + 1][heroCordinate[1]] == 'k'
						|| map[heroCordinate[0]][heroCordinate[1]] == 'K') {
					map[heroCordinate[0]][heroCordinate[1]] = ' ';
					map[heroCordinate[0] + 1][heroCordinate[1]] = 'K';
					heroCordinate[0] = heroCordinate[0] + 1;
				} else {
					map[heroCordinate[0]][heroCordinate[1]] = ' ';
					map[heroCordinate[0] + 1][heroCordinate[1]] = 'H';
					heroCordinate[0] = heroCordinate[0] + 1;
				}

			} else {
				checkUnlockableDoor(map, heroCordinate);
			}
			if (map[1][8] == ' ' && map[2][0] == 'I') {
				map[1][8] = 'k';
			}
			break;
		case 4:

			if (map[heroCordinate[0]][heroCordinate[1] + 1] != 'X'
					&& map[heroCordinate[0]][heroCordinate[1] + 1] != 'I') {
				if (map[heroCordinate[0]][heroCordinate[1] + 1] == 'S') {
					map[heroCordinate[0]][heroCordinate[1]] = ' ';
					map[heroCordinate[0]][heroCordinate[1] + 1] = 'H';
					heroCordinate[1] = heroCordinate[1] + 1;
					victory();
				} else if (map[heroCordinate[0]][heroCordinate[1] + 1] == 'k'
						|| map[heroCordinate[0]][heroCordinate[1]] == 'K') {
					map[heroCordinate[0]][heroCordinate[1]] = ' ';
					map[heroCordinate[0]][heroCordinate[1] + 1] = 'K';
					heroCordinate[1] = heroCordinate[1] + 1;
				} else {
					map[heroCordinate[0]][heroCordinate[1]] = ' ';
					map[heroCordinate[0]][heroCordinate[1] + 1] = 'H';
					heroCordinate[1] = heroCordinate[1] + 1;
				}

			} else {
				checkUnlockableDoor(map, heroCordinate);
			}

			break;
		}
	}

	/**
	 * Imprime a legenda dos tabuleiros
	 */
	public static void printLegend() {
		System.out.println("\n Legend:");
		System.out.println("X -> Wall");
		System.out.println("I -> Exit Door");
		System.out.println("H -> Hero");
		System.out.println("G -> Guard");
		System.out.println("O -> Crazy Ogre");
		System.out.println("K -> key");
		System.out.println("emplty cell - free space \n");
	}

	/**
	 * Imprime as instruções de direção
	 */
	public static void printDirections() {
		System.out.println("\n Please choose a direction for your hero!");
		System.out.println("options: ");
		System.out.println("Up -> press 1");
		System.out.println("Down -> press 2");
		System.out.println("Left -> press 3");
		System.out.println("Right -> press 4\n");

	}

	public static boolean checkHeroPresence(char[][] map, int[] cordinates) {
		if (map[cordinates[0] - 1][cordinates[1]] == 'H' || map[cordinates[0] + 1][cordinates[1]] == 'H'
				|| (map[cordinates[0]][cordinates[1] + 1] == 'H') || map[cordinates[0]][cordinates[1] + 1] == 'H')
			return true;

		return false;
	}

	public static int readDirection() {
		int direction = 0;
		Scanner option = new Scanner(System.in);
		while (direction > 4 || direction < 1) {
			direction = option.nextInt();
		}
		return direction;
	}

	public static char[][] guardMovement(char[][] map, int guardStep, int[] guardCoord) {
		if (guardStep == 0) {
			if (map[guardCoord[0]][guardCoord[1] - 1] == 'H') {
				changeChar(map, guardCoord, guardCoord[0], guardCoord[1] - 1, 'G');
				loss();
			} else {

				changeChar(map, guardCoord, guardCoord[0], guardCoord[1] - 1, 'G');
				guardCoord[1] = guardCoord[1] - 1;
			}

		} else if (guardStep < 5) {
			if (map[guardCoord[0] + 1][guardCoord[1]] == 'H') {
				changeChar(map, guardCoord, guardCoord[0] + 1, guardCoord[1], 'G');
				loss();
			} else {
				changeChar(map, guardCoord, guardCoord[0] + 1, guardCoord[1], 'G');

				guardCoord[0] = guardCoord[0] + 1;
			}

		} else if (guardStep < 11) {
			if (map[guardCoord[0]][guardCoord[1] - 1] == 'H') {
				changeChar(map, guardCoord, guardCoord[0], guardCoord[1] - 1, 'G');
				loss();
			} else {
				changeChar(map, guardCoord, guardCoord[0], guardCoord[1] - 1, 'G');

				guardCoord[1] = guardCoord[1] - 1;
			}

		} else if (guardStep == 11) {
			if (map[guardCoord[0] + 1][guardCoord[1]] == 'H') {
				changeChar(map, guardCoord, guardCoord[0] + 1, guardCoord[1], 'G');
				loss();
			} else {
				changeChar(map, guardCoord, guardCoord[0] + 1, guardCoord[1], 'G');

				guardCoord[0] = guardCoord[0] + 1;
			}

		} else if (guardStep < 19) {
			if (map[guardCoord[0]][guardCoord[1] + 1] == 'H') {
				changeChar(map, guardCoord, guardCoord[0], guardCoord[1] + 1, 'G');
				loss();
			} else {
				changeChar(map, guardCoord, guardCoord[0], guardCoord[1] + 1, 'G');

				guardCoord[1] = guardCoord[1] + 1;
			}

		} else if (guardStep < 24) {
			if (map[guardCoord[0] - 1][guardCoord[1]] == 'H') {
				changeChar(map, guardCoord, guardCoord[0] - 1, guardCoord[1], 'G');
				loss();
			} else {
				changeChar(map, guardCoord, guardCoord[0] - 1, guardCoord[1], 'G');

				guardCoord[0] = guardCoord[0] - 1;
			}
		}

		if (checkHeroPresence(map, guardCoord) == true) {
			loss();
		}
		return map;
	}

	public static char[][] changeChar(char[][] map, int[] cordinates, int xCordinates, int yCordinates,
			char character) {
		map[cordinates[0]][cordinates[1]] = ' ';
		map[xCordinates][yCordinates] = character;
		return map;
	}

	public static char[][] checkPushLever(char[][] map, int x, int y) {
		if (map[x][y] == 'k') {
			map[5][0] = 'S';
			map[6][0] = 'S';
		}
		return map;
	}

	public static char[][] checkLadders(char[][] map, int[] oldCordinates, int x, int y) {
		if (map[x][y] == 'S') {
			map[oldCordinates[0]][oldCordinates[1]] = ' ';
			map[x][y] = 'H';
			victory();
		}
		return map;
	}

	public static void heroMovement(int[] heroCoor, char[][] map, int direction) {
		switch (direction) {
		// up
		case 1:

			if (map[heroCoor[0] - 1][heroCoor[1]] != 'X' && map[heroCoor[0] - 1][heroCoor[1]] != 'I') {

				map = checkPushLever(map, heroCoor[0] - 1, heroCoor[1]);

				map = checkLadders(map, heroCoor, heroCoor[0] - 1, heroCoor[1]);

				map[heroCoor[0]][heroCoor[1]] = ' ';
				map[heroCoor[0] - 1][heroCoor[1]] = 'H';
				heroCoor[0] = heroCoor[0] - 1;
			}
			break;
		// down
		case 2:

			if (map[heroCoor[0] + 1][heroCoor[1]] != 'X' && map[heroCoor[0] + 1][heroCoor[1]] != 'I') {

				map = checkPushLever(map, heroCoor[0] + 1, heroCoor[1]);

				map = checkLadders(map, heroCoor, heroCoor[0] + 1, heroCoor[1]);

				map[heroCoor[0]][heroCoor[1]] = ' ';
				map[heroCoor[0] + 1][heroCoor[1]] = 'H';
				heroCoor[0] = heroCoor[0] + 1;

			}
			break;
		// left
		case 3:
			if (map[heroCoor[0]][heroCoor[1] - 1] != 'X' && map[heroCoor[0]][heroCoor[1] - 1] != 'I') {

				map = checkPushLever(map, heroCoor[0], heroCoor[1] - 1);

				map = checkLadders(map, heroCoor, heroCoor[0], heroCoor[1] - 1);

				map[heroCoor[0]][heroCoor[1]] = ' ';
				map[heroCoor[0]][heroCoor[1] - 1] = 'H';
				heroCoor[1] = heroCoor[1] - 1;

			}
			break;
		// right
		case 4:
			if (map[heroCoor[0]][heroCoor[1] + 1] != 'X' && map[heroCoor[0]][heroCoor[1] + 1] != 'I') {

				map = checkPushLever(map, heroCoor[0], heroCoor[1] + 1);

				map = checkLadders(map, heroCoor, heroCoor[0], heroCoor[1] + 1);

				map[heroCoor[0]][heroCoor[1]] = ' ';
				map[heroCoor[0]][heroCoor[1] + 1] = 'H';
				heroCoor[1] = heroCoor[1] + 1;

			}
			break;
		}
	}

	public static void level1(char[][] map, int[] heroCoor, int[] guardCoor) {

		int guardStep = 0;
		int movementOption;
		while (level == 1) {
			printBoard(map);
			movementOption = readDirection();
			heroMovement(heroCoor, map, movementOption);
			guardMovement(map, guardStep, guardCoor);
			guardStep++;

			if (guardStep == 24) {
				guardStep = 0;
			}
		}
		printBoard(map);

	}

	public static void loss() {
		level--;
		System.out.println("Fatality!");
	}

	public static boolean checkObstacle(char[][] map, int[] cordinates, int direction) {
		if (direction == 2) {
			if (map[cordinates[0] - 1][cordinates[1]] == 'X' || map[cordinates[0] - 1][cordinates[1]] == 'I'
					|| map[cordinates[0] - 1][cordinates[1]] == 'S') {
				return true;
			} else {
				return false;
			}
		}
		if (direction == 3) {
			if (map[cordinates[0] + 1][cordinates[1]] == 'X' || map[cordinates[0] + 1][cordinates[1]] == 'I'
					|| map[cordinates[0] + 1][cordinates[1]] == 'S') {
				return true;
			} else {
				return false;
			}
		}
		if (direction == 1) {
			if (map[cordinates[0]][cordinates[1] - 1] == 'X' || map[cordinates[0]][cordinates[1] - 1] == 'I'
					|| map[cordinates[0]][cordinates[1] - 1] == 'S') {
				return true;
			} else {
				return false;
			}
		}
		if (direction == 4) {
			if (map[cordinates[0]][cordinates[1] + 1] == 'X' || map[cordinates[0]][cordinates[1] + 1] == 'I'
					|| map[cordinates[0]][cordinates[1] + 1] == 'S') {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	public static void checkUnlockableDoor(char[][] map, int[] coordenates) {
		if (map[2][0] == 'I' && map[coordenates[0]][coordenates[1]] == 'K') {
			map[2][0] = 'S';
		}
	}

	public static void randomOgreDirection(char[][] map, int[] ogreCordinates) {
		int direction = 0;
		do {
			direction = 1 + (int) (Math.random() * 4);
		} while (checkObstacle(map, ogreCordinates, direction) == true);

		switch (direction) {
		case 1:

			if (map[ogreCordinates[0]][ogreCordinates[1] - 1] == 'H'
					|| map[ogreCordinates[0]][ogreCordinates[1] - 1] == 'K') {
				loss();
			} else if (map[ogreCordinates[0]][ogreCordinates[1]] == 'k') {
				map[ogreCordinates[0]][ogreCordinates[1] - 1] = 'O';
				ogreCordinates[1] = ogreCordinates[1] - 1;
			} else if (map[ogreCordinates[0]][ogreCordinates[1] - 1] != '$'
					&& map[ogreCordinates[0]][ogreCordinates[1] - 1] != 'k') {
				map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
				map[ogreCordinates[0]][ogreCordinates[1] - 1] = 'O';
				ogreCordinates[1] = ogreCordinates[1] - 1;
			} else {
				map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
				map[ogreCordinates[0]][ogreCordinates[1] - 1] = '$';
				ogreCordinates[1] = ogreCordinates[1] - 1;
			}

			break;
		case 2:

			if (map[ogreCordinates[0] - 1][ogreCordinates[1]] == 'H'
					|| map[ogreCordinates[0] - 1][ogreCordinates[1]] == 'K') {
				loss();
			} else if (map[ogreCordinates[0]][ogreCordinates[1]] == 'k') {
				map[ogreCordinates[0] - 1][ogreCordinates[1]] = 'O';
				ogreCordinates[0] = ogreCordinates[0] - 1;
			} else if (map[ogreCordinates[0] - 1][ogreCordinates[1]] != '$'
					&& map[ogreCordinates[0] - 1][ogreCordinates[1]] != 'k') {
				map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
				map[ogreCordinates[0] - 1][ogreCordinates[1]] = 'O';
				ogreCordinates[0] = ogreCordinates[0] - 1;
			} else {
				map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
				map[ogreCordinates[0] - 1][ogreCordinates[1]] = '$';
				ogreCordinates[0] = ogreCordinates[0] - 1;
			}

			break;
		case 3:

			if (map[ogreCordinates[0] + 1][ogreCordinates[1]] == 'H'
					|| map[ogreCordinates[0] + 1][ogreCordinates[1]] == 'K') {
				loss();
			} else if (map[ogreCordinates[0]][ogreCordinates[1]] == 'k') {
				map[ogreCordinates[0] + 1][ogreCordinates[1]] = 'O';
				ogreCordinates[0] = ogreCordinates[0] + 1;
			} else if (map[ogreCordinates[0] + 1][ogreCordinates[1]] != '$'
					&& map[ogreCordinates[0] + 1][ogreCordinates[1]] != 'k') {
				map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
				map[ogreCordinates[0] + 1][ogreCordinates[1]] = 'O';
				ogreCordinates[0] = ogreCordinates[0] + 1;
			} else {
				map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
				map[ogreCordinates[0] + 1][ogreCordinates[1]] = '$';
				ogreCordinates[0] = ogreCordinates[0] + 1;
			}

			break;
		case 4:

			if (map[ogreCordinates[0]][ogreCordinates[1] + 1] == 'H'
					|| map[ogreCordinates[0]][ogreCordinates[1] + 1] == 'K') {
				loss();
			} else if (map[ogreCordinates[0]][ogreCordinates[1]] == 'k') {
				map[ogreCordinates[0]][ogreCordinates[1] + 1] = 'O';
				ogreCordinates[1] = ogreCordinates[1] + 1;
			} else if (map[ogreCordinates[0]][ogreCordinates[1] + 1] != '$'
					&& map[ogreCordinates[0]][ogreCordinates[1] + 1] != 'k') {
				map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
				map[ogreCordinates[0]][ogreCordinates[1] + 1] = 'O';
				ogreCordinates[1] = ogreCordinates[1] + 1;
			} else {
				map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
				map[ogreCordinates[0]][ogreCordinates[1] + 1] = '$';
				ogreCordinates[1] = ogreCordinates[1] + 1;
			}

			break;
		}
	}

	public static void radomOgreDamage(char[][] map, int[] ogreCoord, int[] ogreDamage) {
		int direction = 0;
		do {
			direction = 1 + (int) (Math.random() * 4);
		} while (checkObstacle(map, ogreDamage, direction) == true);

		switch (direction) {
		// up
		case 1:

			if (map[1][8] == '$' && ogreCoord[0] != 1 && ogreCoord[1] != 8) {
				map[1][8] = 'k';
			}

			if (map[ogreCoord[0] - 1][ogreCoord[1]] != 'X' && map[ogreCoord[0] - 1][ogreCoord[1]] != 'I'
					&& map[ogreCoord[0] - 1][ogreCoord[1]] != 'S') {
				if (map[ogreCoord[0] - 1][ogreCoord[1]] == 'k') {
					map[ogreCoord[0] - 1][ogreCoord[1]] = '$';

				} else if (map[ogreCoord[0] - 1][ogreCoord[1]] == 'K' || map[ogreCoord[0] - 1][ogreCoord[1]] == 'H') {
					map[ogreCoord[0] - 1][ogreCoord[1]] = '*';
					loss();

				} else {
					map[ogreCoord[0] - 1][ogreCoord[1]] = '*';
					ogreDamage[0] = ogreCoord[0] - 1;
					ogreDamage[1] = ogreCoord[1];

				}

			}
			break;
		// down
		case 2:
			if (map[1][8] == '$' && ogreCoord[0] != 1 && ogreCoord[1] != 8) {
				map[1][8] = 'k';
			}
			if (map[ogreCoord[0] + 1][ogreCoord[1]] != 'X' && map[ogreCoord[0] + 1][ogreCoord[1]] != 'I'
					&& map[ogreCoord[0] + 1][ogreCoord[1]] != 'S') {

				if (map[ogreCoord[0] + 1][ogreCoord[1]] == 'k') {
					map[ogreCoord[0] + 1][ogreCoord[1]] = '$';

				} else if (map[ogreCoord[0] + 1][ogreCoord[1]] == 'K' || map[ogreCoord[0] + 1][ogreCoord[1]] == 'H') {
					map[ogreCoord[0] + 1][ogreCoord[1]] = '*';
					loss();

				} else {
					map[ogreCoord[0] + 1][ogreCoord[1]] = '*';
					ogreDamage[0] = ogreCoord[0] + 1;
					ogreDamage[1] = ogreCoord[1];

				}

			}
			break;
		// left
		case 3:

			if (map[1][8] == '$' && ogreCoord[0] != 1 && ogreCoord[1] != 8) {
				map[1][8] = 'k';
			}
			if (map[ogreCoord[0]][ogreCoord[1] - 1] != 'X' && map[ogreCoord[0]][ogreCoord[1] - 1] != 'I'
					&& map[ogreCoord[0]][ogreCoord[1] - 1] != 'S') {
				if (map[ogreCoord[0]][ogreCoord[1] - 1] == 'k') {
					map[ogreCoord[0]][ogreCoord[1] - 1] = '$';
				} else if (map[ogreCoord[0]][ogreCoord[1] - 1] == 'K' || map[ogreCoord[0]][ogreCoord[1] - 1] == 'H') {
					map[ogreCoord[0]][ogreCoord[1] - 1] = '*';
					loss();
				} else {

					map[ogreCoord[0]][ogreCoord[1] - 1] = '*';
					ogreDamage[0] = ogreCoord[0];
					ogreDamage[1] = ogreCoord[1] - 1;

				}

			}
			break;
		// right
		case 4:

			if (map[1][8] == '$' && ogreCoord[0] != 1 && ogreCoord[1] != 8) {
				map[1][8] = 'k';
			}
			if (map[ogreCoord[0]][ogreCoord[1] + 1] != 'X' && map[ogreCoord[0]][ogreCoord[1] + 1] != 'I'
					&& map[ogreCoord[0]][ogreCoord[1] + 1] != 'S') {

				if (map[ogreCoord[0]][ogreCoord[1] + 1] == 'k') {
					map[ogreCoord[0]][ogreCoord[1] + 1] = '$';
				} else if (map[ogreCoord[0]][ogreCoord[1] + 1] == 'K' || map[ogreCoord[0]][ogreCoord[1] + 1] == 'H') {
					map[ogreCoord[0]][ogreCoord[1] + 1] = '*';
					loss();

				} else {

					map[ogreCoord[0]][ogreCoord[1] + 1] = '*';
					ogreDamage[0] = ogreCoord[0];
					ogreDamage[1] = ogreCoord[1] + 1;

				}

			}
			break;

		}

	}

	public static void level2(char[][] map, int[] heroCordinates, int[] ogreCordinates, int[] ogreCordinatesDamage) {
		int movementDirection;

		while (level == 2) {
			if (map[1][8] == ' ' && map[2][0] == 'I') {
				map[1][8] = 'k';
			}
			printBoard(map);
			movementDirection = readDirection();
			heroMovementKeyTansport(heroCordinates, map, movementDirection);
			randomOgreDirection(map, ogreCordinates);
			map[ogreCordinatesDamage[0]][ogreCordinatesDamage[1]] = ' ';
			radomOgreDamage(map, ogreCordinates, ogreCordinatesDamage);
		}
		printBoard(map);
	}

}
