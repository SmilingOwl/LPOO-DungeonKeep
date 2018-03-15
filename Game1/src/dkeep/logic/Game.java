package dkeep.logic;
import dkeep.logic.Board;

public class Game {
	private Board board ;
	public Game(Board b)
	{
		board=b;
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

}
