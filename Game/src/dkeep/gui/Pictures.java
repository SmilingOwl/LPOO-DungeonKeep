package dkeep.gui;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
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
	public char[][] getCurrentMap()
	{
		return game.getPlayingLevel().getBoard();
	}
	public int getCurrentMapDimensions()
	{
		return game.getPlayingLevel().getBoard().length;
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
			}

	public BufferedImage getGround() {
		return ground;
	}

	public Game getGame() {
			return game;
	}

	public BufferedImage getHeroArmed() {
				return heroArmed;
	}

	public BufferedImage getMainMenu() {
				return menu;
	}

	public void setWidth(int i) {
		width=i;
				
	}

	public void setHeight(int i) {
		height=i;
				
	}
	

}
