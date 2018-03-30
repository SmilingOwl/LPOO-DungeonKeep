package dkeep.cli;

import java.util.Scanner;
import dkeep.logic.Game.State;
import dkeep.logic.Game;
import dkeep.logic.Level;
import dkeep.logic.Level1;
import dkeep.logic.Level2;

public class Main {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		// novo jogo 
		Game game=new Game();
	
	
		game.playingLevel=new Level1();
		
			game.setRandomGuard();
			//game.setRandomOgre();
		printLegend();
		game.printBoard();

		while ((game.gameState != State.Lost) && (game.gameState != State.Won)) {
		
			char direction = scanner.next().charAt(0);
			game.heroMove(direction);
			game.printEndGame();
		}
		scanner.close();
	}

	/**
	 * prints the legend on the console
	 */
	public static void printLegend() {
		System.out.println("Legend:");
		System.out.println("X -> Wall");
		System.out.println("I -> Exit Door");
		System.out.println("H -> Hero");
		System.out.println("G -> Guard");
		System.out.println("O -> Crazy Ogre");
		System.out.println("K -> key");
		System.out.println("empty cell -> free space\n");
	}
}
