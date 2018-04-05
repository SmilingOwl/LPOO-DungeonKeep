package dkeep.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import dkeep.logic.Game;
import dkeep.logic.Level;
import dkeep.logic.Game.Event;

public class RandomMovement {

	char[][] map = { { 'X', 'I', 'X', 'X', 'X' }, { 'X', 'H', ' ', 'G', 'X' }, { 'X', ' ', ' ', ' ', 'X' },
			{ 'I', 'k', ' ', ' ', 'X' }, { 'X', 'X', 'X', 'X', 'X' } };

	@Test(timeout = 1000)
	public void testRandom() {
		Level board = new Level(map);
		Game newGame = new Game();
		newGame.setPlayingLevel(board);
		newGame.setRandomOgre();
		newGame.updateStateGame(Event.NewGame);
		newGame.updateStateGame(Event.levelUp);

		boolean upMoveAndUpDamage = false;
		boolean upMoveAndDownDamage = false;
		boolean upMoveAndLeftDamage = false;
		boolean upMoveAndRightDamage = false;

		boolean downMoveAndUpDamage = false;
		boolean downMoveAndDownDamage = false;
		boolean downMoveAndLeftDamage = false;
		boolean downMoveAndRightDamage = false;

		boolean leftMoveAndUpDamage = false;
		boolean leftMoveAndDownDamage = false;
		boolean leftMoveAndLeftDamage = false;
		boolean leftMoveAndRightDamage = false;

		boolean rightMoveAndUpDamage = false;
		boolean rightMoveAndDownDamage = false;
		boolean rightMoveAndLeftDamage = false;
		boolean rightMoveAndRightDamage = false;

		while (!upMoveAndUpDamage || !upMoveAndDownDamage | !upMoveAndLeftDamage || !upMoveAndRightDamage
				|| !downMoveAndUpDamage || !downMoveAndDownDamage || !downMoveAndLeftDamage || !downMoveAndRightDamage
				|| !leftMoveAndUpDamage || !leftMoveAndDownDamage || !leftMoveAndLeftDamage || !leftMoveAndRightDamage
				|| !rightMoveAndUpDamage || !rightMoveAndDownDamage || !rightMoveAndLeftDamage
				|| !rightMoveAndRightDamage) {

			int oldX = newGame.playingLevel.getOgres().get(0).getXcoordinate();
			int oldY = newGame.playingLevel.getOgres().get(0).getYcoordinate();

			newGame.heroMove('s');

			int x = newGame.playingLevel.getOgres().get(0).getXcoordinate();
			int y = newGame.playingLevel.getOgres().get(0).getYcoordinate();

			int xDamage = newGame.playingLevel.getOgres().get(0).getxDamage();
			int yDamage = newGame.playingLevel.getOgres().get(0).getyDamage();

			// UP
			if (oldX - 1 == x && oldY == y && x - 1 == xDamage && y == yDamage)
				upMoveAndUpDamage = true;
			else if (oldX - 1 == x && oldY == y && x == xDamage && y - 1 == yDamage)
				upMoveAndLeftDamage = true;
			else if (oldX - 1 == x && oldY == y && x == xDamage && y + 1 == yDamage)
				upMoveAndRightDamage = true;
			else if (oldX - 1 == x && oldY == y && x + 1 == xDamage && y == yDamage)
				upMoveAndDownDamage = true;
			// Left
			else if (oldX == x && oldY - 1 == y && x - 1 == xDamage && y == yDamage)
				leftMoveAndUpDamage = true;
			else if (oldX == x && oldY - 1 == y && x == xDamage && y - 1 == yDamage)
				leftMoveAndLeftDamage = true;
			else if (oldX == x && oldY - 1 == y && x == xDamage && y + 1 == yDamage)
				leftMoveAndRightDamage = true;
			else if (oldX == x && oldY - 1 == y && x + 1 == xDamage && y == yDamage)
				leftMoveAndDownDamage = true;
			// Right
			else if (oldX == x && oldY + 1 == y && x - 1 == xDamage && y == yDamage)
				rightMoveAndUpDamage = true;
			else if (oldX == x && oldY + 1 == y && x == xDamage && y - 1 == yDamage)
				rightMoveAndLeftDamage = true;
			else if (oldX == x && oldY + 1 == y && x == xDamage && y + 1 == yDamage)
				rightMoveAndRightDamage = true;
			else if (oldX == x && oldY + 1 == y && x + 1 == xDamage && y == yDamage)
				rightMoveAndDownDamage = true;
			// down
			else if (oldX + 1 == x && oldY == y && x - 1 == xDamage && y == yDamage)
				downMoveAndUpDamage = true;
			else if (oldX + 1 == x && oldY == y && x == xDamage && y - 1 == yDamage)
				downMoveAndLeftDamage = true;
			else if (oldX + 1 == x && oldY == y && x == xDamage && y + 1 == yDamage)
				downMoveAndRightDamage = true;
			else if (oldX + 1 == x && oldY == y && x + 1 == xDamage && y == yDamage)
				downMoveAndDownDamage = true;
			else
				fail("ERROR!!!\n");
		}
	}

}
