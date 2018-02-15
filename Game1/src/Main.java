import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//imprimir legenda
		
		System.out.println("Legend:");
		System.out.println("X -> Wall");
		System.out.println("I -> Door");
		System.out.println("H -> Hero");
		System.out.println("G -> Guard");
		System.out.println("K -> Lever");
		System.out.println("emplty cell - free space");	
		System.out.println("\n\n");
		
		char[][] board = new char[][] { {'X','X','X','X','X','X','X','X','X','X'},
			{'X','H',' ',' ','I',' ','X',' ','G','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'X',' ','I',' ','I',' ','X',' ',' ','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'X','X','X',' ','X','X','X','X',' ','X'},
			{'X',' ','I',' ','I',' ','X','K',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'} };
			
		
		
		//Imprimir o tabuleiro
		
for( int i =0; i<board.length;i++) 
{
	for(int j=0; j<board[i].length;j++) 
	{
		System.out.print(board[i][j]+" ");
	}
	System.out.println();
	}

		//perguntar ao utilizador a direção
		System.out.println();
		System.out.println("Please choose a direction for your hero!");
		System.out.println("options: ");
		System.out.println("Up -> press 1");
		System.out.println("Down -> press 2");
		System.out.println("Left -> press 3");
		System.out.println("Right -> press 4");
		System.out.println();
		
	Scanner option =new Scanner(System.in);
	int option1 =option.nextInt();

	//coordenadas do heroi
	
	int x_heroi=1;
	int y_heroi=1;
	
	switch(option1)
	{
	case 1:
		if(board[x_heroi-1][y_heroi]=='X'|| board[x_heroi-1][y_heroi]=='I')
			break;
		else 
		{
			board[x_heroi][y_heroi]=' ';
			board[x_heroi-1][y_heroi]='H';
			x_heroi=x_heroi-1;
			
		}
		break;
	case 2:
		break;
	case 3:
		break;
	case 4:
		break;
	default : 
		System.out.println("Invalid option!");
		break;
	}
	
	
	}
}
