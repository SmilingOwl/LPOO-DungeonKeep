package dkeep.gui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import dkeep.cli.Main;
import dkeep.logic.Board;
import dkeep.logic.Character;
import dkeep.logic.Game;
import dkeep.logic.Guard;
import dkeep.logic.Hero;

public class Pictures {
	private BufferedImage guard;
	private BufferedImage guardSleeping;
	public BufferedImage hero;
	private BufferedImage heroArmed;
	private BufferedImage closedDoor;
	private BufferedImage openDoor;
	private BufferedImage ground;
	private BufferedImage wall;
	private BufferedImage key;
	private BufferedImage ogre;
	private BufferedImage ogreStun;
	private BufferedImage ogreMartelo;
	private JFrame frame;
	private int width;
	private int height;
	private char[][] customMap;
	private Game game;
	private String guardType;
	private  int ogreNum;
	
	public Pictures(JFrame frame) throws IOException
	{
		this.frame=frame;
		this.width= frame.getWidth();
		this.height= frame.getHeight();
		//loadGame();
		
		
	}
	
	public void updateMove( char letter)
	{
		game.heroMove(letter);
			
		
	}
	
	public void loadImages() throws IOException {
		guard= ImageIO.read(new File(Pictures.class.getResource("/Images/guard.png").getFile()));
		guardSleeping= ImageIO.read(new File(Pictures.class.getResource("/Images/guardsleeping.png").getFile()));
		ogre= ImageIO.read(new File(Pictures.class.getResource("/Images/ogre.png").getFile()));
		ogreMartelo=ImageIO.read(new File(Pictures.class.getResource("/Images/ogremartelo.png").getFile()));
		ogreStun= ImageIO.read(new File(Pictures.class.getResource("/Images/ogrestun.png").getFile()));
		key= ImageIO.read(new File(Pictures.class.getResource("/Images/key.png").getFile()));
		hero= ImageIO.read(new File(Pictures.class.getResource("/Images/ff.png").getFile()));
		heroArmed= ImageIO.read(new File(Pictures.class.getResource("/Images/ff.png").getFile()));
		wall= ImageIO.read(new File(Pictures.class.getResource("/Images/wall.png").getFile()));
		closedDoor= ImageIO.read(new File(Pictures.class.getResource("/Images/doorcloose.png").getFile()));
		openDoor= ImageIO.read(new File(Pictures.class.getResource("/Images/dooropen.png").getFile()));
		ground= ImageIO.read(new File(Pictures.class.getResource("/Images/ground.png").getFile())); 
	}
	public BufferedImage getOgreMartelo()
	{
		return ogreMartelo;
	}
	public BufferedImage getKey()
	{
		return key;
	}
	public BufferedImage getOgre()
	{
		return ogre;
	}
	public BufferedImage getOgreStun()
	{
		return ogreStun;
	}
	public BufferedImage getGuardSleeping()
	{
		return guardSleeping;
	}
	public void loadGame() {
		int[] heroCoordinates = new int[2];
		heroCoordinates[0] = 1;
		heroCoordinates[1] = 1;

		Hero h = new Hero(heroCoordinates[0], heroCoordinates[1], 'H');

		int[] guardCoordinates = new int[2];
		guardCoordinates[0] = 1;
		guardCoordinates[1] = 8;

		Guard g = new Guard(guardCoordinates[0], guardCoordinates[1]);


		game=new Game();
		
		//game.getGuard().setGuard(guardType);
		game.setOgres(ogreNum);
	
	}
	public char[][] getCurrentMap()
	{
		return game.getPlayingLevel().getBoard();
	}
	public int getCurrentMapDimensions()
	{
		return game.getPlayingLevel().getBoard().length;
	}
	public char[][] getCustomMap()
	{
		return customMap;
	}
	public BufferedImage getGuard()
	{
		return guard;
	}
	public BufferedImage getHero()
	{
		return hero;
	}
	public BufferedImage getWall()
	{
		return wall;
	}
	public BufferedImage getCloseDoor()
	{
		return closedDoor;
	}
	public BufferedImage getOpenDoor()
	{
		return openDoor;
	}

	public void setGame(Game game2) {
		game=game2;
		// TODO Auto-generated method stub
		
	}

	public BufferedImage getGround() {
		// TODO Auto-generated method stub
		return ground;
	}

	public Game getGame() {
		// TODO Auto-generated method stub
		return game;
	}

	public Image getHeroArmed() {
		// TODO Auto-generated method stub
		return heroArmed;
	}
	

}
