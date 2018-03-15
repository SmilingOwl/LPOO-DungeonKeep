package dkeep.logic;

public class Level {

	public boolean checkObstacle(char[][] map, int[] cordinates, int direction) {
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

	public static void checkUnlockableDoor(char[][] map, int[] coordenates, int[] heroCord) {
		if (map[2][0] == 'I' && map[coordenates[0]][coordenates[1]] == 'K') {
			map[2][0] = 'S';
			map[heroCord[0]][heroCord[1]] = 'H';
		}
	}

}
