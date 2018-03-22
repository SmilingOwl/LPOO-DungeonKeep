package dkeep.logic;


 public class Character 
{
	protected int x;
	protected int y;
	protected char letter;
		
	
public Character(int x, int y, char letter) {
		super();
		this.x = x;
		this.y = y;
		this.letter = letter;
	}

//getters and setters

public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public char getLetter() {
	return letter;
}

public void setLetter(char letter) {
	this.letter = letter;
}

//Methods
public static boolean checkHeroPresence(char[][] map, Character c) {
    if (map[c.x - 1][c.y] == 'H') {
        return true;
    }
    if (map[c.x + 1][c.y] == 'H') {
        return true;
    }
    if (map[c.x][c.y - 1] == 'H') {
        return true;
    }
    if (map[c.x][c.y + 1] == 'H') {
        return true;
    }
    return false;
}

public void changeChar(char[][] map, int[] cordinates, int xCordinates, int yCordinates, char character) {
    map[cordinates[0]][cordinates[1]] = ' ';
    map[xCordinates][yCordinates] = character;

}


}

