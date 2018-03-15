package dkeep.logic;

import dkeep.cli.Main;

public class Ogre extends Character {

	private int xDamage;
	private int yDamage;
	private boolean isStun;
	private boolean key;
	private int timeStun;

public Ogre(int x,int y)
{
	super(x,y,'O');
	isStun=false;
	key =false;
	timeStun=0;
}
	public Ogre(int x,int y,int xDamage, int yDamage) {
		super(x,y,'O');
		this.xDamage=xDamage;
		this.yDamage=yDamage;
		isStun=false;
		key =false;
		timeStun=0;
	}
	public int getXdamage()
	{
		return xDamage;
	}
	public int getYdamage()
	{
		return yDamage;
	}
	public boolean getIsStun()

	{
		return isStun;
	}
	public void randomOgreDirection() {
		int direction = 0;
		int[] ogreCordinates =new int[2];
		ogreCordinates[0]=x;
		ogreCordinates[1]=y;

		if(isStun==false)
		{
			do {
				direction = 1 + (int) (Math.random() * 4);
			} while (checkObstacle( direction) == true);

			switch (direction) {
			case 1:

				if (Board.board2[x][y - 1] == 'A'
				|| Board.board2[x][y - 1] == 'K') {
					Main.loss();

				} else if (Board.board2[x][y] == '$') {//Board.board2[x][y] == 'k'
					Board.board2[x][y] ='k';
					Board.board2[x][y - 1] = 'O';
					
					y = y - 1;

				} else if (Board.board2[x][y - 1] != '$'
						&& Board.board2[x][y - 1] != 'k') {

					changeChar(Board.board2, ogreCordinates, x, y - 1, 'O');
					y = y - 1;

				} else {

					changeChar(Board.board2, ogreCordinates, x, y- 1, '$');
					y = y - 1;
				}

				break;
			case 2:

				if (Board.board2[x - 1][y] == 'A'
				|| Board.board2[x- 1][y] == 'K') {
					Main.loss();

				} else if (Board.board2[x][y] == '$') {
					Board.board2[x- 1][y] = 'O';
					Board.board2[x][y] ='k';
					x = x - 1;

				} else if (Board.board2[x - 1][y] != '$'
						&& Board.board2[x- 1][y] != 'k') {
					changeChar(Board.board2, ogreCordinates, x - 1, y, 'O');
					x = x - 1;

				} else {
					changeChar(Board.board2, ogreCordinates, x - 1, y, '$');
					x = x - 1;
				}

				break;
			case 3:

				if (Board.board2[x + 1][y] == 'A'
				|| Board.board2[x + 1][y] == 'K') {
					Main.loss();

				} else if (Board.board2[x][y] == '$') {
					Board.board2[x + 1][y] = 'O';
					Board.board2[x][y] ='k';
					x = x + 1;

				} else if (Board.board2[x + 1][y] != '$'
						&& Board.board2[x + 1][y] != 'k') {
					changeChar(Board.board2, ogreCordinates, x + 1, y, 'O');
					x = x + 1;

				} else {
					changeChar(Board.board2, ogreCordinates, x+ 1, y, '$');
					x = x + 1;
				}

				break;
			case 4:

				if (Board.board2[x][y + 1] == 'A'
				|| Board.board2[x][y + 1] == 'K') {
					Main.loss();

				} else if (Board.board2[x][y] == '$') {
					Board.board2[x][y + 1] = 'O';
					Board.board2[x][y] ='k';
					y = y + 1;

				} else if (Board.board2[x][y + 1] != '$'
						&& Board.board2[x][y+ 1] != 'k') {
					changeChar(Board.board2, ogreCordinates, x, y + 1, 'O');
					y = y + 1;

				} else {
					changeChar(Board.board2, ogreCordinates, x, y + 1, '$');
					y = y+ 1;
					//y = y + 1;
				}

				break;
			}
		}else
		{
			timeStun++;
			if(timeStun==2)
			{
				timeStun=0;
				isStun=false;
			}
		}


	}
	public  boolean checkifstun(Hero h ) // coordenadas do ogre
	{

		if(Board.board2[x][y-1]== 'A' || Board.board2[x][y-1]== 'K' )
		{

			//Character.changeChar( Board.board2, cor , x, y - 1, '8');
			Board.board2[x][y]='8';
			isStun=true;
			return true;
		}
		else if(Board.board2[x][y+1]== 'A'|| Board.board2[x][y+1]== 'K' )
		{
			//Character.changeChar( cor, x, y + 1, '8');
			Board.board2[x][y]='8';
			isStun=true;
			return true;
		}
		else if(Board.board2[x-1][y]== 'A' || Board.board2[x-1][y]== 'K')
		{
			//Character.changeChar( cor, x-1,y, '8');
			Board.board2[x][y]='8';
			isStun=true;
			return true;
		}
		else if(Board.board2[x+1][y]== 'A' || Board.board2[x+1][y]== 'K')
		{
			//Character.changeChar( cor, x+1, y , '8');
			Board.board2[x][y]='8';
			isStun=true;
			return true;
		}
		else if (Board.board2[x][y]== 'A' || Board.board2[x][y]== 'K')
		{
			Board.board2[x][y]='8';
			isStun=true;
			return true;
		}

		return false;

	}
	public  boolean checkIfLoss(Hero h ) // coordenadas do ogre
	{

		if(x == h.getX() && y== h.getY()+1)
		{
			return true;
		}
		else if(x == h.getX() && y== h.getY()-1 )
		{
		
			return true;
		}
		else if(x == h.getX() +1 && y== h.getY())
		{
			
			return true;
		}
		else if(x == h.getX()-1 && y== h.getY())
		{
		
			return true;
		}
		else if (x == h.getX() && y== h.getY())
		{
			
			return true;
		}

		return false;

	}
	public  boolean checkifloss(Hero h ) // coordenadas do ogre
	{

		if(xDamage == h.getX() && yDamage== h.getY()+1)
		{
			return true;
		}
		else if(xDamage == h.getX() && yDamage== h.getY()-1 )
		{
		
			return true;
		}
		else if(xDamage == h.getX() +1 && yDamage== h.getY())
		{
			
			return true;
		}
		else if(xDamage == h.getX()-1 && yDamage== h.getY())
		{
		
			return true;
		}
		else if (xDamage == h.getX() && yDamage== h.getY())
		{
			
			return true;
		}

		return false;

	}

	public void radomOgreDamage() {
		int direction = 0;

		do {
			direction = 1 + (int) (Math.random() * 4);

		} while (checkObstacle( direction) == true);

		switch (direction) {
		case 1:

			if (Board.board2[x][y - 1] == 'A'
			|| Board.board2[x][y - 1] == 'K') {
				Board.board2[x][y - 1] = '$';
				Main.loss();

			} else if (Board.board2[x][y - 1] == 'k') {
				Board.board2[x][y - 1] = '$';
				key=true;
				

			}else if (key) { // Board.board2[xDamage][yDamage] == '$'
				Board.board2[1][8] = 'k';
				Board.board2[x][y - 1] = '*';
				key=false;
				xDamage = x;
				yDamage = y - 1;
				
			}else {

				Board.board2[x][y - 1] = '*';
				xDamage = x;
				yDamage = y - 1;
			}

			break;
		case 2:

			if (Board.board2[x - 1][y] == 'A'
			|| Board.board2[x - 1][y] == 'K') {
				Board.board2[x - 1][y] = '$';
				Main.loss();

			} else if (Board.board2[x - 1][y] == 'k') {
				Board.board2[x - 1][y] = '$';
				key=true;
				xDamage = x - 1;
				yDamage = y;

			} else if (key) {
				Board.board2[1][8] = 'k';
				Board.board2[x- 1][y ] = '*';
				key=false;
				xDamage = x - 1;
				yDamage = y;
				
			}else {

				Board.board2[x - 1][y] = '*';
				xDamage = x - 1;
				yDamage = y;
			}

			break;
		case 3:

			if (Board.board2[x + 1][y] == 'A'
			|| Board.board2[x + 1][y] == 'K') {
				Board.board2[x + 1][y] = '$';
				Main.loss();

			} else if (Board.board2[x + 1][y] == 'k') {
				Board.board2[x + 1][y] = '$';
				key=true;
				xDamage = x + 1;
				yDamage = y;

			} else if (key) {
				Board.board2[1][8] = 'k';
				Board.board2[x+ 1][y ] = '*';
				key=false;
				xDamage = x + 1;
				yDamage = y;
				
			}else {

				Board.board2[x + 1][y] = '*';
				xDamage = x + 1;
				yDamage = y;
			}

			break;
		case 4:

			if (Board.board2[x][y + 1] == 'A'
			|| Board.board2[x][y + 1] == 'K') {
				Board.board2[x][y + 1] = '$';
				Main.loss();

			} else if (Board.board2[x][y + 1] == 'k') {
				Board.board2[x][y + 1] = '$';
				key=true;
				xDamage = x;
				yDamage = y + 1;

			} else if (key) {
				Board.board2[1][8] = 'k';
				Board.board2[x][y + 1] = '*';
				key=false;
				xDamage = x;
				yDamage = y + 1;
				
			}else {

				Board.board2[x][y + 1] = '*';
				xDamage = x;
				yDamage = y + 1;
			}

			break;
		}
		


	}
	public boolean checkObstacle( int direction) {
		if (direction == 2) {
			if (Board.board2[x - 1][y] == 'X' || Board.board2[x - 1][y] == 'I' || Board.board2[x - 1][y] == 'S') {
				return true;
			} else {
				return false;
			}
		}
		if (direction == 3) {
			if (Board.board2[x + 1][y] == 'X' || Board.board2[x + 1][y] == 'I' || Board.board2[x + 1][y] == 'S') {
				return true;
			} else {
				return false;
			}
		}
		if (direction == 1) {
			if (Board.board2[x][y - 1] == 'X' || Board.board2[x][y - 1] == 'I' || Board.board2[x][y- 1] == 'S') {
				return true;
			} else {
				return false;
			}
		}
		if (direction == 4) {
			if (Board.board2[x][y+ 1] == 'X' || Board.board2[x][y + 1] == 'I' || Board.board2[x][y + 1] == 'S') {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}
}
