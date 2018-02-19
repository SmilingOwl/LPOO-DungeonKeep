import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// vari�veis
		Scanner option = new Scanner(System.in);
		int option1 = 0;
		int option2 = 0;
		boolean gameOver = true;
		boolean victory = true;
		boolean state2 = true;
		int ogreOption = 0;
		int ogreDano = 0;
		boolean firstTime = true;
		boolean key = false;

		// coordenadas do dano
		int xDano = 0;
		int yDano = 0;

		// coordenadas do heroi nivel 1
		int x_heroi = 1;
		int y_heroi = 1;

		// coordenadas do heroi nivel 2
		int x_heroi2 = 8;
		int y_heroi2 = 1;

		// coordenadas do guarda
		int xGuarda = 1;
		int yGuarda = 8;
		int passoGuarda = 0; // contador de passos do guarda, para fazer a patrulha

		// coordenadas do ogre
		int xOgre = 1;
		int yOgre = 5;

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

		// imprimir legenda
		System.out.println("Legend:");
		System.out.println("X -> Wall");
		System.out.println("I -> Door");
		System.out.println("H -> Hero");
		System.out.println("G -> Guard");
		System.out.println("K -> Lever");
		System.out.println("emplty cell - free space");
		System.out.println();

		// imprime o tabuleiro
		printBoard(board);

		// perguntar ao utilizador a dire��o
		System.out.println();
		System.out.println("Please choose a direction for your hero!");
		System.out.println("options: ");
		System.out.println("Up -> press 1");
		System.out.println("Down -> press 2");
		System.out.println("Left -> press 3");
		System.out.println("Right -> press 4");
		System.out.println();

		// jogo
		while (gameOver && victory) {

			printBoard(board);

			// l� input do utilizador
			option1 = option.nextInt();

			switch (option1) {
			// up
			case 1:

				if (board[x_heroi - 1][y_heroi] != 'X' && board[x_heroi - 1][y_heroi] != 'I') {

					if (board[x_heroi - 1][y_heroi] == 'k') {
						board[5][0] = 'S';
						board[6][0] = 'S';
					}

					gameOver = gameOver(board, x_heroi, y_heroi);

					victory = victory(board, x_heroi, y_heroi);

					board[x_heroi][y_heroi] = ' ';
					board[x_heroi - 1][y_heroi] = 'H';
					x_heroi = x_heroi - 1;
				}
				break;
			// down
			case 2:

				if (board[x_heroi + 1][y_heroi] != 'X' && board[x_heroi + 1][y_heroi] != 'I') {

					if (board[x_heroi + 1][y_heroi] == 'k') {
						board[5][0] = 'S';
						board[6][0] = 'S';
					}

					gameOver = gameOver(board, x_heroi, y_heroi);
					victory = victory(board, x_heroi, y_heroi);

					board[x_heroi][y_heroi] = ' ';
					board[x_heroi + 1][y_heroi] = 'H';
					x_heroi = x_heroi + 1;

				}
				break;
			// left
			case 3:
				if (board[x_heroi][y_heroi - 1] != 'X' && board[x_heroi][y_heroi - 1] != 'I') {

					if (board[x_heroi][y_heroi - 1] == 'k') {
						board[5][0] = 'S';
						board[6][0] = 'S';
					}
					gameOver = gameOver(board, x_heroi, y_heroi);
					victory = victory(board, x_heroi, y_heroi);

					board[x_heroi][y_heroi] = ' ';
					board[x_heroi][y_heroi - 1] = 'H';
					y_heroi = y_heroi - 1;

				}
				break;
			// right
			case 4:
				if (board[x_heroi][y_heroi + 1] != 'X' && board[x_heroi][y_heroi + 1] != 'I') {

					if (board[x_heroi][y_heroi + 1] == 'k') {
						board[5][0] = 'S';
						board[6][0] = 'S';
					}

					gameOver = gameOver(board, x_heroi, y_heroi);

					victory = victory(board, x_heroi, y_heroi);

					board[x_heroi][y_heroi] = ' ';
					board[x_heroi][y_heroi + 1] = 'H';
					y_heroi = y_heroi + 1;

				}
				break;
			default:
				System.out.println("Invalid option!");
				break;
			}

			if (passoGuarda == 24) {
				passoGuarda = 0;
			}

			if (passoGuarda == 0) {
				board[xGuarda][yGuarda] = ' ';
				board[xGuarda][yGuarda - 1] = 'G';
				passoGuarda++;

				yGuarda = yGuarda - 1;
			} else if (passoGuarda < 5) {
				board[xGuarda][yGuarda] = ' ';
				board[xGuarda + 1][yGuarda] = 'G';
				passoGuarda++;

				xGuarda = xGuarda + 1;

			} else if (passoGuarda < 11) {
				board[xGuarda][yGuarda] = ' ';
				board[xGuarda][yGuarda - 1] = 'G';
				passoGuarda++;

				yGuarda = yGuarda - 1;

			} else if (passoGuarda == 11) {
				board[xGuarda][yGuarda] = ' ';
				board[xGuarda + 1][yGuarda] = 'G';
				passoGuarda++;

				xGuarda = xGuarda + 1;

			} else if (passoGuarda < 19) {
				board[xGuarda][yGuarda] = ' ';
				board[xGuarda][yGuarda + 1] = 'G';
				passoGuarda++;

				yGuarda = yGuarda + 1;
			} else if (passoGuarda < 24) {
				board[xGuarda][yGuarda] = ' ';
				board[xGuarda - 1][yGuarda] = 'G';
				passoGuarda++;

				xGuarda = xGuarda - 1;
			}
			victory = false;
		}
		// -------------------------------------Level2-------------------------------------------

		// imprimir legenda2
		System.out.println("Legend:");
		System.out.println("X -> Wall");
		System.out.println("I -> Exit Door");
		System.out.println("H -> Hero");
		System.out.println("O -> Crazy Ogre");
		System.out.println("K -> key");
		System.out.println("emplty cell - free space");
		System.out.println();

		if (victory == false) {
			while (state2) {

				printBoard(board2);

				// l� input do utilizador
				option2 = option.nextInt();

				switch (option2) {
				// up
				case 1:

					if (board2[x_heroi2 - 1][y_heroi2] != 'X') {
						if (board2[x_heroi2 - 1][y_heroi2] != 'I') {

							if (board2[x_heroi2 - 1][y_heroi2] == 'k') {
								// board2[2][0] = 'S';
								board2[x_heroi2][y_heroi2] = ' ';
								board2[x_heroi2 - 1][y_heroi2] = 'K';
								x_heroi2 = x_heroi2 - 1;
								key = true;
								break;
							}

							if (board2[x_heroi2][y_heroi2] == 'H') {
								board2[x_heroi2][y_heroi2] = ' ';
								board2[x_heroi2 - 1][y_heroi2] = 'H';
								x_heroi2 = x_heroi2 - 1;
							}

							if (board2[x_heroi2 - 1][y_heroi2] == 'S') {
								System.out.println("Victory!");
								state2 = false;
							}

							if (board2[x_heroi2][y_heroi2] == 'K') {
								board2[x_heroi2][y_heroi2] = ' ';
								board2[x_heroi2 - 1][y_heroi2] = 'K';
								x_heroi2 = x_heroi2 - 1;
							}

						} else if (board2[x_heroi2 - 1][y_heroi2] == 'I' && key == true)
							board2[2][0] = 'S';
					}
					break;
				// down
				case 2:

					if (board2[x_heroi2 + 1][y_heroi2] != 'X') {
						if (board2[x_heroi2 + 1][y_heroi2] != 'I') {

							if (board2[x_heroi2 + 1][y_heroi2] == 'k') {
								// board2[2][0] = 'S';
								board2[x_heroi2][y_heroi2] = ' ';
								board2[x_heroi2 + 1][y_heroi2] = 'K';
								x_heroi2 = x_heroi2 + 1;
								key = true;
								break;
							}

							if (board2[x_heroi2][y_heroi2] == 'H') {

								board2[x_heroi2][y_heroi2] = ' ';
								board2[x_heroi2 + 1][y_heroi2] = 'H';
								x_heroi2 = x_heroi2 + 1;

							}

							if (board2[x_heroi2 + 1][y_heroi2] == 'S') {
								System.out.println("Victory!");
								state2 = false;
							}

							if (board2[x_heroi2][y_heroi2] == 'K') {
								board2[x_heroi2][y_heroi2] = ' ';
								board2[x_heroi2 + 1][y_heroi2] = 'K';
								x_heroi2 = x_heroi2 + 1;
							}
						} else if (board2[x_heroi2 + 1][y_heroi2] == 'I' && key == true)
							board2[2][0] = 'S';
					}
					break;
				// left
				case 3:
					if (board2[x_heroi2][y_heroi2 - 1] != 'X') {

						if (board2[x_heroi2][y_heroi2 - 1] != 'I') {

							if (board2[x_heroi2][y_heroi2 - 1] == 'k') {

								// board2[2][0] = 'S';
								board2[x_heroi2][y_heroi2] = ' ';
								board2[x_heroi2][y_heroi2 - 1] = 'K';
								y_heroi2 = y_heroi2 - 1;
								key = true;
								break;
							}
							if (board2[x_heroi2][y_heroi2] == 'H') {

								board2[x_heroi2][y_heroi2] = ' ';
								board2[x_heroi2][y_heroi2 - 1] = 'H';
								y_heroi2 = y_heroi2 - 1;
							}

							if (board2[x_heroi2][y_heroi2 - 1] == 'S') {
								System.out.println("Victory!");
								state2 = false;
							}

							if (board2[x_heroi2][y_heroi2] == 'K') {

								board2[x_heroi2][y_heroi2] = ' ';
								board2[x_heroi2][y_heroi2 - 1] = 'K';
								y_heroi2 = y_heroi2 - 1;
							}

						} else if (board2[x_heroi2][y_heroi2 - 1] == 'I' && key == true)

							board2[2][0] = 'S';

					}
					break;

				// right
				case 4:
					if (board2[x_heroi2][y_heroi2 + 1] != 'X') {
						if (board2[x_heroi2][y_heroi2 + 1] != 'I') {

							if (board2[x_heroi2][y_heroi2 + 1] == 'k') {
								// board2[2][0] = 'S';
								board2[x_heroi2][y_heroi2] = ' ';
								board2[x_heroi][y_heroi2 + 1] = 'K';
								y_heroi2 = y_heroi2 + 1;
								key = true;
								break;
							}

							if (board2[x_heroi2][y_heroi2] == 'H') {
								board2[x_heroi2][y_heroi2] = ' ';
								board2[x_heroi2][y_heroi2 + 1] = 'H';
								y_heroi2 = y_heroi2 + 1;
							}

							if (board2[x_heroi2][y_heroi2 + 1] == 'S') {
								System.out.println("Victory!");
								state2 = false;
							}

							if (board2[x_heroi2][y_heroi2] == 'K') {
								board2[x_heroi2][y_heroi2] = ' ';
								board2[x_heroi2][y_heroi2 + 1] = 'K';
								y_heroi2 = y_heroi2 + 1;
							}

						} else if (board2[x_heroi2][y_heroi2 + 1] == 'I' && key == true) {
							board2[2][0] = 'S';
						}
					}
					break;
				default:
					System.out.println("Invalid option!");
					break;
				}

				// -------------------------------------------------MOVIMENTO DO
				// OGRE--------------------------------------------------------

				do {
					ogreOption = 1 + (int) (Math.random() * 4);

				} while (testDirection(xOgre, yOgre, board2, ogreOption));

				if (firstTime) {
					firstTime = false;

				} else if (board2[xDano][yDano] != '$') {
					board2[xDano][yDano] = ' ';
				}

				switch (ogreOption) {

				// up
				case 1:

					if (board2[1][8] == '$' && board2[xOgre - 1][yOgre] != 'X' && board2[xOgre - 1][yOgre] != 'I') {

						board2[1][8] = 'k';
						board2[xOgre - 1][yOgre] = 'O';
						xOgre = xOgre - 1;

					} else if (board2[xOgre - 1][yOgre] != 'X' && board2[xOgre - 1][yOgre] != 'I') {

						if (board2[xOgre - 1][yOgre] == 'k') {
							board2[xOgre][yOgre] = ' ';
							board2[xOgre - 1][yOgre] = '$';
							xOgre = xOgre - 1;
						} else {
							board2[xOgre][yOgre] = ' ';
							board2[xOgre - 1][yOgre] = 'O';
							xOgre = xOgre - 1;
						}

					}
					break;
				// down
				case 2:
					if (board2[1][8] == '$' && board2[xOgre + 1][yOgre] != 'X' && board2[xOgre + 1][yOgre] != 'I') {

						board2[1][8] = 'k';
						board2[xOgre + 1][yOgre] = 'O';
						xOgre = xOgre + 1;

					} else if (board2[xOgre + 1][yOgre] != 'X' && board2[xOgre + 1][yOgre] != 'I') {

						if (board2[xOgre + 1][yOgre] == 'k') {
							board2[xOgre][yOgre] = ' ';
							board2[xOgre + 1][yOgre] = '$';
							xOgre = xOgre + 1;
						} else {
							board2[xOgre][yOgre] = ' ';
							board2[xOgre + 1][yOgre] = 'O';
							xOgre = xOgre + 1;
						}

					}
					break;
				// left
				case 3:
					if (board2[1][8] == '$' && board2[xOgre][yOgre - 1] != 'X' && board2[xOgre][yOgre - 1] != 'I') {
						board2[1][8] = 'k';
						board2[xOgre][yOgre - 1] = 'O';
						yOgre = yOgre - 1;
					} else if (board2[xOgre][yOgre - 1] != 'X' && board2[xOgre][yOgre - 1] != 'I') {

						if (board2[xOgre][yOgre - 1] == 'k') {
							board2[xOgre][yOgre] = ' ';
							board2[xOgre][yOgre - 1] = '$';
							yOgre = yOgre - 1;
						} else {
							board2[xOgre][yOgre] = ' ';
							board2[xOgre][yOgre - 1] = 'O';
							yOgre = yOgre - 1;
						}

					}
					break;
				// right
				case 4:
					if (board2[1][8] == '$' && board2[xOgre][yOgre + 1] != 'X' && board2[xOgre][yOgre + 1] != 'I') {

						board2[1][8] = 'k';
						board2[xOgre][yOgre + 1] = 'O';
						yOgre = yOgre + 1;
					} else if (board2[xOgre][yOgre + 1] != 'X' && board2[xOgre][yOgre + 1] != 'I') {

						if (board2[xOgre][yOgre + 1] == 'k') {
							board2[xOgre][yOgre] = ' ';
							board2[xOgre][yOgre + 1] = '$';
							yOgre = yOgre + 1;

						} else {
							board2[xOgre][yOgre] = ' ';
							board2[xOgre][yOgre + 1] = 'O';
							yOgre = yOgre + 1;
						}

					}
					break;
				}
				// Dano do ogre---------------------------------------

				do {
					ogreDano = 1 + (int) (Math.random() * 4);
				} while (testDirection(xOgre, yOgre, board2, ogreDano));

				switch (ogreDano) {
				// up
				case 1:

					if (board2[1][8] == '$' && xOgre != 1 && yOgre != 8) {
						board2[1][8] = 'k';
					}

					if (board2[xOgre - 1][yOgre] != 'X' && board2[xOgre - 1][yOgre] != 'I'
							&& board2[xOgre - 1][yOgre] != 'S') {
						if (board2[xOgre - 1][yOgre] == 'k') {
							board2[xOgre - 1][yOgre] = '$';

						} else if (board2[xOgre - 1][yOgre] == 'K' || board2[xOgre - 1][yOgre] == 'H') {
							board2[xOgre - 1][yOgre] = '*';
							System.out.println("Game Over!");
							state2 = false;

						} else {
							board2[xOgre - 1][yOgre] = '*';
							xDano = xOgre - 1;
							yDano = yOgre;

						}

					}
					break;
				// down
				case 2:
					if (board2[1][8] == '$' && xOgre != 1 && yOgre != 8) {
						board2[1][8] = 'k';
					}
					if (board2[xOgre + 1][yOgre] != 'X' && board2[xOgre + 1][yOgre] != 'I'
							&& board2[xOgre + 1][yOgre] != 'S') {

						if (board2[xOgre + 1][yOgre] == 'k') {
							board2[xOgre + 1][yOgre] = '$';

						} else if (board2[xOgre + 1][yOgre] == 'K' || board2[xOgre + 1][yOgre] == 'H') {
							board2[xOgre + 1][yOgre] = '*';
							System.out.println("Game Over!");
							state2 = false;

						} else {
							board2[xOgre + 1][yOgre] = '*';
							xDano = xOgre + 1;
							yDano = yOgre;

						}

					}
					break;
				// left
				case 3:

					if (board2[1][8] == '$' && xOgre != 1 && yOgre != 8) {
						board2[1][8] = 'k';
					}
					if (board2[xOgre][yOgre - 1] != 'X' && board2[xOgre][yOgre - 1] != 'I'
							&& board2[xOgre][yOgre - 1] != 'S') {
						if (board2[xOgre][yOgre - 1] == 'k') {
							board2[xOgre][yOgre - 1] = '$';
						} else if (board2[xOgre][yOgre - 1] == 'K' || board2[xOgre][yOgre - 1] == 'H') {
							board2[xOgre][yOgre - 1] = '*';
							System.out.println("Game Over!");
							state2 = false;
						} else {

							board2[xOgre][yOgre - 1] = '*';
							xDano = xOgre;
							yDano = yOgre - 1;

						}

					}
					break;
				// right
				case 4:

					if (board2[1][8] == '$' && xOgre != 1 && yOgre != 8) {
						board2[1][8] = 'k';
					}
					if (board2[xOgre][yOgre + 1] != 'X' && board2[xOgre][yOgre + 1] != 'I'
							&& board2[xOgre][yOgre + 1] != 'S') {

						if (board2[xOgre][yOgre + 1] == 'k') {
							board2[xOgre][yOgre + 1] = '$';
						} else if (board2[xOgre][yOgre + 1] == 'K' || board2[xOgre][yOgre + 1] == 'H') {
							board2[xOgre][yOgre + 1] = '*';
							System.out.println("Game Over!");
							state2 = false;

						} else {

							board2[xOgre][yOgre + 1] = '*';
							xDano = xOgre;
							yDano = yOgre + 1;

						}

					}
					break;
				}

			}
		}
	}

	// ----------------------------------M�todos-----------------------------------------------
	// m�todo imprimir tabuleiro
	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	// trata da colis�o heroi-guarda
	public static boolean gameOver(char[][] board, int x_heroi, int y_heroi) {
		if (board[x_heroi - 1][y_heroi] == 'G' || board[x_heroi + 1][y_heroi] == 'G'
				|| board[x_heroi][y_heroi - 1] == 'G' || board[x_heroi][y_heroi + 1] == 'G') {
			System.out.println("Game Over!");
			return false;
		}
		return true;
	}

	// trata da colis�o heroi-sa�da
	public static boolean victory(char[][] board, int x_heroi, int y_heroi) {
		if (board[x_heroi - 1][y_heroi] == 'S' || board[x_heroi + 1][y_heroi] == 'S'
				|| board[x_heroi][y_heroi - 1] == 'S' || board[x_heroi][y_heroi + 1] == 'S') {
			System.out.println("Victory!");
			return false;
		}
		return true;
	}

	/**
	 * Testa a presen�a de um obst�culo na dire��o tomada
	 *
	 * @param x
	 * @param y
	 * @param board
	 * @param order
	 * @return retorna true se encontrar parede e false caso contr�rio
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

}
