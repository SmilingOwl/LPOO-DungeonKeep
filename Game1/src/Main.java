import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner option = new Scanner(System.in);
		int option1 = 0;
		boolean state = true;

		// coordenadas do heroi

		int x_heroi = 1;
		int y_heroi = 1;

		// coordenadas do guarda

		int xGuarda = 1;
		int yGuarda = 8;
		int passoGuarda = 0;

		char[][] board = new char[][] { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'K', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

		// imprimir legenda

		System.out.println("Legend:");
		System.out.println("X -> Wall");
		System.out.println("I -> Door");
		System.out.println("H -> Hero");
		System.out.println("G -> Guard");
		System.out.println("K -> Lever");
		System.out.println("emplty cell - free space");
		System.out.println("\n\n");

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
		
		
		while (state) {

			printBoard(board);

			option1 = option.nextInt();

			switch (option1) {
			case 1:
				if (board[x_heroi - 1][y_heroi] != 'X' && board[x_heroi - 1][y_heroi] != 'I') {

					if (board[x_heroi - 1][y_heroi] == 'K') {
						board[5][0] = 'S';
						board[6][0] = 'S';
					}
					if (board[x_heroi - 1][y_heroi] == 'G' || board[x_heroi + 1][y_heroi] == 'G'
							|| board[x_heroi][y_heroi - 1] == 'G' || board[x_heroi][y_heroi + 1] == 'G')

						{
						state = false;
						System.out.println("Game Over!");
						}
					
					if (board[x_heroi - 1][y_heroi] == 'S' || board[x_heroi + 1][y_heroi] == 'S'
							|| board[x_heroi][y_heroi - 1] == 'S' || board[x_heroi][y_heroi + 1] == 'S')

						{
						state = false;	
						System.out.println("Victory!");
						}

					board[x_heroi][y_heroi] = ' ';
					board[x_heroi - 1][y_heroi] = 'H';
					x_heroi = x_heroi - 1;

				}
				break;
			case 2:
				if (board[x_heroi + 1][y_heroi] != 'X' && board[x_heroi + 1][y_heroi] != 'I') {

					if (board[x_heroi + 1][y_heroi] == 'K') {
						board[5][0] = 'S';
						board[6][0] = 'S';
					}
					if (board[x_heroi - 1][y_heroi] == 'G' || board[x_heroi + 1][y_heroi] == 'G'
							|| board[x_heroi][y_heroi - 1] == 'G' || board[x_heroi][y_heroi + 1] == 'G')

					{
						state = false;
						System.out.println("Game Over!");
						}
					
					if (board[x_heroi - 1][y_heroi] == 'S' || board[x_heroi + 1][y_heroi] == 'S'
							|| board[x_heroi][y_heroi - 1] == 'S' || board[x_heroi][y_heroi + 1] == 'S')

					{
						state = false;	
						System.out.println("Victory!");
						}

					board[x_heroi][y_heroi] = ' ';
					board[x_heroi + 1][y_heroi] = 'H';
					x_heroi = x_heroi + 1;

				}
				break;
			case 3:
				if (board[x_heroi][y_heroi - 1] != 'X' && board[x_heroi][y_heroi - 1] != 'I') {

					if (board[x_heroi][y_heroi - 1] == 'K') {
						board[5][0] = 'S';
						board[6][0] = 'S';
					}

					if (board[x_heroi - 1][y_heroi] == 'G' || board[x_heroi + 1][y_heroi] == 'G'
							|| board[x_heroi][y_heroi - 1] == 'G' || board[x_heroi][y_heroi + 1] == 'G')

					{
						state = false;
						System.out.println("Game Over!");
						}
					if (board[x_heroi - 1][y_heroi] == 'S' || board[x_heroi + 1][y_heroi] == 'S'
							|| board[x_heroi][y_heroi - 1] == 'S' || board[x_heroi][y_heroi + 1] == 'S')

					{
						state = false;	
						System.out.println("Victory!");
						}

					board[x_heroi][y_heroi] = ' ';
					board[x_heroi][y_heroi - 1] = 'H';
					y_heroi = y_heroi - 1;

				}
				break;
			case 4:
				if (board[x_heroi][y_heroi + 1] != 'X' && board[x_heroi][y_heroi + 1] != 'I') {

					if (board[x_heroi][y_heroi + 1] == 'K') {
						board[5][0] = 'S';
						board[6][0] = 'S';
					}
					if (board[x_heroi - 1][y_heroi] == 'G' || board[x_heroi + 1][y_heroi] == 'G'
							|| board[x_heroi][y_heroi - 1] == 'G' || board[x_heroi][y_heroi + 1] == 'G')

					{
						state = false;
						System.out.println("Game Over!");
						}

					if (board[x_heroi - 1][y_heroi] == 'S' || board[x_heroi + 1][y_heroi] == 'S'
							|| board[x_heroi][y_heroi - 1] == 'S' || board[x_heroi][y_heroi + 1] == 'S')

					{
						state = false;	
						System.out.println("Victory!");
						}

					board[x_heroi][y_heroi] = ' ';
					board[x_heroi][y_heroi + 1] = 'H';
					y_heroi = y_heroi + 1;

				}
				break;
			default:
				System.out.println("Invalid option!");
				break;
			}

			if(passoGuarda==24)
				passoGuarda=0;
			
			if (passoGuarda == 0) 
			{
				board[xGuarda][yGuarda] = ' ';
				board[xGuarda][yGuarda-1]='G';
				passoGuarda++;
				
				yGuarda=yGuarda-1;
			}
			else if (passoGuarda < 5) 
			{
				board[xGuarda][yGuarda] = ' ';
				board[xGuarda+1][yGuarda]='G';
				passoGuarda++;
				
				xGuarda=xGuarda+1;

			} 
			else if (passoGuarda < 11) 
			{
				board[xGuarda][yGuarda] = ' ';
				board[xGuarda][yGuarda-1]='G';
				passoGuarda++;
				
				yGuarda=yGuarda-1;

			} 
			else if (passoGuarda == 11) 
			{
				board[xGuarda][yGuarda] = ' ';
				board[xGuarda+1][yGuarda]='G';
				passoGuarda++;
				
				xGuarda=xGuarda+1;

			} 
			else if (passoGuarda < 19) 
			{
				board[xGuarda][yGuarda] = ' ';
				board[xGuarda][yGuarda+1]='G';
				passoGuarda++;
				
				yGuarda=yGuarda+1;
			} 
			else if (passoGuarda < 24) 
			{
				board[xGuarda][yGuarda] = ' ';
				board[xGuarda-1][yGuarda]='G';
				passoGuarda++;
				
				xGuarda=xGuarda-1;
			}

		}

	}
	// método imprimir tabuleiro
		public static void printBoard(char[][] board) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
}