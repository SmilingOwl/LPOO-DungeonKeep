package dkeep.logic;
import java.util.ArrayList;
import java.util.Random;

import dkeep.logic.Board;

public class Game {
	
	protected Board board ;
	protected char[][] b;
	protected int level;
	protected  ArrayList<Ogre> ogres=new ArrayList<Ogre>();
	protected Hero hero;
	protected Guard guard;
	public String map="";
	
	public int getLevel()
	{
		return level;
	}
	public Game(Board b)
	{
		board=b;
	}
	
	public Game(Hero h, Guard g )
	{
	//board.setBoard(board.board1);
		b= board.board1;
		hero=h;
		guard=g;
		
		level=1;
	}
	public void setB(char[][]b)
	{
		this.b=b;
	}
	public Guard getGuard()
	{
		return guard;
	}
	
	public void setOgres(int number)
	{
		int[] ogreCordinates = new int[2];
		int[] ogreCordinatesDamage = new int[2];
		for (int i = 0; i < number; i++) {
			ogreCordinates[0] = randInt(2, 6);
			ogreCordinates[1] = randInt(2, 6);

			ogreCordinatesDamage[0] = 1;
			ogreCordinatesDamage[1] = 1;

			Ogre o = new Ogre(ogreCordinates[0], ogreCordinates[1], ogreCordinatesDamage[0],
					ogreCordinatesDamage[1]);
			/*ogres.get(i).setX(randInt(2, 6));
			ogres.get(i).setY(randInt(2, 6));

			ogres.get(i).setXdamage(1);
			ogres.get(i).setYdamage(1);

			Ogre o = new Ogre(ogres.get(i).getX(), ogres.get(i).getY(),ogres.get(i).getXdamage(),
					ogres.get(i).getYdamage());*/
			
			Board.board2[o.getX()][o.getY()] = 'O';
			ogres.add(o);
		}
	}
	
	public int getHeroX()
	{
		for(int j=0; j < board.getBoard().length;j++) {
			for(int i=0; i < board.getBoard().length;i++)
			{
				if(board.getBoard()[i][j]== 'H')
				{
					return i;
				}

			}
		}
		return 0;
	}
	public int getGuardX()
	{
		for(int j=0; j < board.getBoard().length;j++) {
			for(int i=0; i < board.getBoard().length;i++)
			{
				if(board.getBoard()[i][j]== 'G')
				{
					return i;
				}

			}
		}
		return 0;
	}
	public int getOgreX()
	{
		for(int j=0; j < board.getBoard().length;j++) {
			for(int i=0; i < board.getBoard().length;i++)
			{
				if(board.getBoard()[i][j]== 'O')
				{
					return i;
				}

			}
		}
		return 0;
	}
	public ArrayList<Ogre> getOgres()
	{
		return ogres;
	}
	public int getHeroY()
	{
		for(int j=0; j < board.getBoard().length;j++) {
			for(int i=0; i < board.getBoard().length;i++)
			{
				if(board.getBoard()[i][j]== 'H')
				{
					return j;
				}

			}
		}
		return 0;
	}
	public int getGuardY()
	{
		for(int j=0; j < board.getBoard().length;j++) {
			for(int i=0; i < board.getBoard().length;i++)
			{
				if(board.getBoard()[i][j]== 'G')
				{
					return j;
				}

			}
		}
		return 0;
	}
	public int getOgreY()
	{
		for(int j=0; j < board.getBoard().length;j++) {
			for(int i=0; i < board.getBoard().length;i++)
			{
				if(board.getBoard()[i][j]== 'O')
				{
					return j;
				}

			}
		}
		return 0;
	}

	public static int randInt(int min, int max) {

		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
	
	public void printBoard() {
		
		for (int i = 0; i < board.getBoard().length; i++) {
			for (int j = 0; j < board.getBoard()[i].length; j++) {
				System.out.print(board.getBoard()[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void printstring()
	{
		map="";
		
		for(int i=0; i<10;i++)
		{
			for(int j=0; j<10; j++)
			{
				map+=b[i][j]+" ";
			}
			map+="\n";
		}
		
	}
	public Hero getHero() {
	
		return hero;
	}
	public char[][] getB() {
		// TODO Auto-generated method stub
		return b;
	}
	public void setLevel(int i) {
		// TODO Auto-generated method stub
		level=i;
	}
}
