package dkeep.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import dkeep.cli.Main;

import dkeep.logic.Character;
import dkeep.logic.Game;
import dkeep.logic.Guard;
import dkeep.logic.Hero;
import dkeep.logic.Level1;

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
	private BufferedImage menu;
	private JFrame frame;
	private int width;
	private int height;
	
	private char[][] customMap;
	private Game game;
	private String guardType;
	private  int ogreNum;
	
	public void setOgreNum(int num)
	{
		ogreNum=num;
	}
	public int getOgreNum()
	{
		return ogreNum;
	}
	public Pictures(JFrame frame) throws IOException
	{
		this.frame=frame;
		this.width= frame.getWidth();
		this.height= frame.getHeight();
		
	}
	
	public void updateMove( char letter)
	{
		game.heroMove(letter);
			
		
	}
	
	public void loadImages() throws IOException {
		menu= ImageIO.read(new File(Pictures.class.getResource("/Images/narutoMenu.png").getFile()));
		guard= ImageIO.read(new File(Pictures.class.getResource("/Images/guard.png").getFile()));
		guardSleeping= ImageIO.read(new File(Pictures.class.getResource("/Images/guardsleeping.png").getFile()));
		ogre= ImageIO.read(new File(Pictures.class.getResource("/Images/ogre1.png").getFile()));
		ogreMartelo=ImageIO.read(new File(Pictures.class.getResource("/Images/ogremartelo.png").getFile()));
		ogreStun= ImageIO.read(new File(Pictures.class.getResource("/Images/ogre1sleeping.png").getFile()));
		key= ImageIO.read(new File(Pictures.class.getResource("/Images/key.png").getFile()));
		hero= ImageIO.read(new File(Pictures.class.getResource("/Images/heron.png").getFile()));
		heroArmed= ImageIO.read(new File(Pictures.class.getResource("/Images/hero.png").getFile()));
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

	public BufferedImage getHeroArmed() {
		// TODO Auto-generated method stub
		return heroArmed;
	}

	public BufferedImage getMainMenu() {
		// TODO Auto-generated method stub
		return menu;
	}

	public void setWidth(int i) {
		width=i;
		
	}

	public void setHeight(int i) {
		height=i;
	
	}

	public JFrame getFrame() {
	
		return frame;
	}
	public void setFrame(int dimension)
	{
		setWidth(dimension*70 + 300);
		setHeight(dimension*70 + 47);
		frame.setSize(width,height);
	}

	public double getWidth() {
				return width;
	}

	public double getHeight() {
			return height;
	}
	

}
