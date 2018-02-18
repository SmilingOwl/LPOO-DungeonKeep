import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// variáveis
		Scanner option = new Scanner(System.in);
		int option1 = 0;
		int option2 = 0;
		boolean gameOver = true;
		boolean victory = true;
		boolean state2 = true;

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
				{ 'X', ' ', ' ', ' ', 'X', 'O', ' ', ' ', 'k', 'X' },
				{ 'I', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X', 'X' },
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

		// perguntar ao utilizador a direção
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

			// lê input do utilizador
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

			if (passoGuarda == 24)
				passoGuarda = 0;

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

				System.out.println("pre-movimento");
				printBoard(board2);

				// lê input do utilizador
				option2 = option.nextInt();

				switch (option2) {
				// up
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
					
				}
			}
		}
	}
	// ----------------------------------Métodos-----------------------------------------------

	// método imprimir tabuleiro
	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * @param board
	 * @param x_heroi
	 * @param y_heroi
	 * @return
	 */

	// trata da colisão heroi-guarda
	public static boolean gameOver(char[][] board, int x_heroi, int y_heroi) {
		if (board[x_heroi - 1][y_heroi] == 'G' || board[x_heroi + 1][y_heroi] == 'G'
				|| board[x_heroi][y_heroi - 1] == 'G' || board[x_heroi][y_heroi + 1] == 'G')

		{
			System.out.println("Game Over!");
			return false;
		}
		return true;
	}

	/**
	 * Trata da colisão do Heroi, 'H' e das escadas/sa´da 'S', vencendo o jogo
	 * 
	 * @param board
	 *            tabuleiro onde se passa o jogo
	 * @param x_heroi
	 *            coordenada inicial do heroi na matriz (linhas)
	 * @param y_heroi
	 *            coordenada inicial do heroi na matriz (colunas)
	 * @return retorna falso se existir colisão, o jogador vence, retorna true caso
	 *         contrário
	 */
	public static boolean victory(char[][] board, int x_heroi, int y_heroi) {
		if (board[x_heroi - 1][y_heroi] == 'S' || board[x_heroi + 1][y_heroi] == 'S'
				|| board[x_heroi][y_heroi - 1] == 'S' || board[x_heroi][y_heroi + 1] == 'S')

		{
			System.out.println("Victory!");
			return false;
		}
		return true;
	}
}
