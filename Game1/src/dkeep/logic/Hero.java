package dkeep.logic;
import dkeep.logic.Board;
import dkeep.cli.*;

public class Hero extends Character {
	private boolean isArmed = false;

	public Hero(int x, int y, char letter) {
		super(x, y, letter);
	}

	public void heroMovement( char[][] map, String movementDirection) {

		int[] heroCordinate =new int[2];
		heroCordinate[0]=x;
		heroCordinate[1]=y;
		switch (movementDirection) {
		case "a":

			if (map[x][y - 1] != 'X'
			&& map[x][y - 1] != 'I') {

				checkLever(map, x, y - 1);
				checkLadders(map, heroCordinate, x, y - 1);
				changeChar(map, heroCordinate, x, y - 1, 'H');
				y = y - 1;

			}
			break;
		case "w":

			if (map[x- 1][y] != 'X'
			&& map[x- 1][y] != 'I') {

				checkLever(map,x- 1, y);
				checkLadders(map, heroCordinate, x - 1, y);

				changeChar(map, heroCordinate, x - 1, y, 'H');
				x = x - 1;
			}
			break;
		case "s":

			if (map[x + 1][y] != 'X'
			&& map[x + 1][y] != 'I') {

				checkLever(map, x + 1, y);
				checkLadders(map, heroCordinate, x + 1, y);

				changeChar(map, heroCordinate, x + 1, y, 'H');
				x = x + 1;

			}
			break;
		case "d":

			if (map[x][y + 1] != 'X'
			&& map[x][y + 1] != 'I') {

				checkLever(map, x, y + 1);
				checkLadders(map, heroCordinate, x, y + 1);

				changeChar(map, heroCordinate, x, y + 1, 'H');
				y = y + 1;

			}
			break;
		}
	}

	public boolean moveLevel2(char[][] map, String movementDirection)
	{
		switch(movementDirection){
		case "a":
			if(map[x][y - 1] == 'S')
				return true;
			break;
		case "s":
			if (map[x + 1][y] == 'S')
				return true;
			break;
		case "w":
			if(map[x - 1][y] == 'S')
				return true;
			break;
		case "d":
			if(map[x][y + 1] == 'S')
				return true;
			break;

		}
		return false;
	}
	public void heroMovementKeyTansport(int[] heroCordinate, char[][] map, String movementDirection) {

		switch (movementDirection) {
		case "a":

			if (map[x][y- 1] != 'X'
			&& map[x][y- 1] != 'I') {

				if (map[x][y - 1] == 'S') {
					changeChar(map, heroCordinate, x, y - 1, 'A');
					map[x][y]= ' ';
					y =y - 1;
					Main.victory();

				} else if (map[x][y - 1] == 'k'
						|| map[x][y] == 'K') {
					changeChar(map, heroCordinate, x, y - 1, 'K');
					map[x][y]= ' ';
					y = y - 1;

				} else {
					changeChar(map, heroCordinate, x, y - 1, 'A');
					map[x][y]= ' ';
					y = y - 1;

				}

			} else {
				checkUnlockableDoor(map, heroCordinate, heroCordinate);
			}

			break;
		case "w":

			if (map[x - 1][y] != 'X'
			&& map[x - 1][y] != 'I') {

				if (map[x - 1][y] == 'S') {
					changeChar(map, heroCordinate, x - 1, y, 'A');
					map[x][y]= ' ';
					x = x - 1;
					Main.victory();

				} else if (map[x - 1][y] == 'k'
						|| map[x][y] == 'K') {
					changeChar(map, heroCordinate, x - 1, y, 'K');
					map[x][y]= ' ';
					x = x - 1;

				} else {
					changeChar(map, heroCordinate, x - 1, y, 'A');
					map[x][y]= ' ';
					x = x - 1;
				}

			} else {
				checkUnlockableDoor(map, heroCordinate, heroCordinate);
			}
			break;

		case "s":

			if (map[x + 1][y] != 'X'
			&& map[x + 1][y] != 'I') {

				if (map[x + 1][y] == 'S') {
					changeChar(map, heroCordinate, x + 1, y, 'A');
					map[x][y]= ' ';
					x = x + 1;
					Main.victory();

				} else if (map[x + 1][y] == 'k'
						|| map[x][y] == 'K') {
					changeChar(map, heroCordinate, x + 1, y, 'K');
					map[x][y]= ' ';
					x = x + 1;

				} else {
					changeChar(map, heroCordinate, x + 1, y, 'A');
					map[x][y]= ' ';
					x = x + 1;
				}

			} else {
				checkUnlockableDoor(map, heroCordinate, heroCordinate);
			}
			break;
		case "d":

			if (map[x][y + 1] != 'X'
			&& map[x][y + 1] != 'I') {

				if (map[x][y + 1] == 'S') {
					changeChar(map, heroCordinate, x, y + 1, 'A');
					map[x][y]= ' ';
					y = y + 1;
					Main.victory();

				} else if (map[x][y + 1] == 'k'
						|| map[x][y] == 'K') {
					changeChar(map, heroCordinate, x,y + 1, 'K');
					map[x][y]= ' ';
					y = y + 1;

				} else {
					changeChar(map, heroCordinate, x, y + 1, 'A');
					map[x][y]= ' ';
					y = y + 1;
				}

			} else {
				checkUnlockableDoor(map, heroCordinate, heroCordinate);
				
			}

			break;
		}
	}

	public  boolean checkUnlockableDoor(char[][] map, int[] coordenates, int[] heroCord) {
		
		int x=0,y=0;
		for(int j=0; j < map.length;j++) {
			for(int i=0; i < map.length;i++)
			{
				if(map[i][j]== 'I')
				{
					x=i;
					y=j;
				}

			}
		}
		if (map[x][y] == 'I' && map[x][y+1] == 'K' ) {
			map[x][y] = 'S';
			map[heroCord[0]][heroCord[1]] = 'A';
			return true;
		}
		return false;
		/*if (map[1][0] == 'I' && map[coordenates[0]][coordenates[1]] == 'K') {
			map[1][0] = 'S';
			map[heroCord[0]][heroCord[1]] = 'A';
			return true;
		}
		return false;*/
	}

	public void pushLever(char[][] map) {
		for(int i=0; i < map.length;i++)
		{
			for(int j=0; j < map.length;j++)
			{
				if(map[i][j]== 'I')
				{
					map[i][j] = 'S';
				}
			}
		}

		/*map[5][0] = 'S';
		map[6][0] = 'S';*/
	}

	public void checkLever(char[][] map, int xCordinate, int yCordinate) {
		if (map[xCordinate][yCordinate] == 'k') {
			pushLever(map);
		}
	}

	public void checkLadders(char[][] map, int[] oldCordinates, int xCordinate, int yCordinate) {
		if (map[xCordinate][yCordinate] == 'S') {
			map[oldCordinates[0]][oldCordinates[1]] = ' ';
			map[xCordinate][yCordinate] = 'H';
			Main.victory();
		}
	}
}
