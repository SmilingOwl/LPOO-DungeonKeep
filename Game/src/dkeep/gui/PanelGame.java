package dkeep.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import dkeep.logic.Game.State;

public class PanelGame  extends JPanel implements KeyListener{
	private JButton buttonDown;
	private JButton buttonUp;
	private JButton buttonLeft;
	private JButton buttonRight; 
	private Pictures pics;
	
	
	
	public PanelGame(Pictures pics) throws IOException
	 {
		this.pics=pics;
		setPreferredSize(new Dimension(400,400));
	//	hero= ImageIO.read(new File(images.class.getResource("/Images/hero.png").getFile()));
		 inicializeButtons();
		 requestFocusInWindow();
		 addKeyListener(this);
		 setFocusable(true);
		 setLayout(null);
	 }
	
	public void inicializeButtons() {
		/*buttonLeft();
		buttonUp();
		buttonRight();
		buttonDown();*/
	}
	private void runButton(char c) {
		
		if((pics.getGame().gameState != State.Lost) && (pics.getGame().gameState != State.Won))
		{
		pics.updateMove(c);
		/*if(game.getLevel()==0)
		{
			game=null;
			label.setText("Play again!");
		*/
		}
		//pics.updateMove(c);
		repaint();
				// TODO Auto-generated method stub
				
			}
	/*public void buttonUp()
	{
		this.buttonUp = new JButton("Up");

		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runButton('w');
				
			}

			
		});
		buttonUp.setBounds(410, 200, 68, 20);
		add(buttonUp);
	}
	public void buttonDown()
	{
		this.buttonUp = new JButton("Up");

		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runButton('w');
			}
		});
	}
	public void buttonLeft()
	{
		this.buttonUp = new JButton("Up");

		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runButton('w');
			}
		});
	}
	public void buttonRight()
	{
		this.buttonUp = new JButton("Up");

		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runButton('w');
			}
		});
	}*/
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		try {			
			pics.loadImages();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i=0; i < pics.getCurrentMapDimensions();i++)
		{
			for (int j=0; j < pics.getCurrentMapDimensions();j++)
			{
				if(pics.getCurrentMap()[i][j]== 'X')
				{
					g.drawImage(pics.getWall(), j *60,i*60,60,60,this);
				}
				else if(pics.getCurrentMap()[i][j]== 'S')
				{  
					g.drawImage(pics.getOpenDoor(), j *60,i*60,60,65,this);
					
				}
				else if(pics.getCurrentMap()[i][j]== 'k')
				{
					g.drawImage(pics.getGround(), j*60, i*60, 60 , 60 ,this);
					g.drawImage(pics.getKey(), j *60,i*60,60,60,this);
				}
				else if(pics.getCurrentMap()[i][j]== 'I')
				{
					g.drawImage(pics.getCloseDoor(), j *60,i*60,60,60,this);
					
				}
				else {
					g.drawImage(pics.getGround(), j*60, i*60, 60 , 60 ,this);
				}
			}
		}
		paintCharacters(g);
	
	
	}
	public void paintCharacters(Graphics g)
	{
		paintGuard(g);
		paintHero(g);
		paintOgre(g);
		paintOgreDamage(g);
	}
	public void paintOgre(Graphics g)
	{
		if(pics.getGame().getPlayingLevel().getNumberLevel()==2)
		{
			for(int i=0; i < pics.getGame().getPlayingLevel().getOgres().size();i++)
			{
				if(pics.getGame().getPlayingLevel().getOgres().get(i).getIsStun())
				{
					g.drawImage(pics.getOgreStun(),pics.getGame().getPlayingLevel().getOgres().get(i).getYcoordinate() *60,pics.getGame().getPlayingLevel().getOgres().get(i).getXcoordinate() *60,60,60,this);
				}else {
					g.drawImage(pics.getOgre(),pics.getGame().getPlayingLevel().getOgres().get(i).getYcoordinate() *60,pics.getGame().getPlayingLevel().getOgres().get(i).getXcoordinate() *60,60,60,this);
				}
				}
		}
	}
	public void paintOgreDamage(Graphics g)
	{
		if(pics.getGame().getPlayingLevel().getNumberLevel()==2)
		{
			for(int i=0; i < pics.getGame().getPlayingLevel().getOgres().size();i++)
			{
				g.drawImage(pics.getOgreMartelo(),pics.getGame().getPlayingLevel().getOgres().get(i).getyDamage()*60,pics.getGame().getPlayingLevel().getOgres().get(i).getxDamage()*60,60,60,this);
			}
		}
	}
	public void paintGuard(Graphics g)
	{
		if(pics.getGame().getPlayingLevel().getNumberLevel()== 1 && pics.getGame().getPlayingLevel().getGuard().getLetter() != 'g')
		{
			g.drawImage(pics.getGuard(),pics.getGame().getPlayingLevel().getGuard().getYcoordinate()*60,pics.getGame().getPlayingLevel().getGuard().getXcoordinate()*60,60,60,this);
		}
		else if( pics.getGame().getPlayingLevel().getNumberLevel()== 1)
		{
			g.drawImage(pics.getGuardSleeping(),pics.getGame().getPlayingLevel().getGuard().getYcoordinate()*60,pics.getGame().getPlayingLevel().getGuard().getXcoordinate()*60,60,60,this);
		}
			
	}
	public void paintHero(Graphics g)
	{
		if(pics.getGame().getPlayingLevel().getNumberLevel()== 1 )
		{
			g.drawImage(pics.getHero(),pics.getGame().getPlayingLevel().getHero().getYcoordinate()*60,pics.getGame().getPlayingLevel().getHero().getXcoordinate()*60,60,60,this);
		}
		else if(pics.getGame().getPlayingLevel().getNumberLevel()== 2 )
		{
			g.drawImage(pics.getHeroArmed(),pics.getGame().getPlayingLevel().getHero().getYcoordinate()*60,pics.getGame().getPlayingLevel().getHero().getXcoordinate()*60,60,60,this);
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0)
	{
		if(arg0.getKeyCode() == KeyEvent.VK_UP)
		{
			runButton('w');
		} else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			runButton('d');
		}else if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
		{
			runButton('s');
		}else if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
		{
			runButton('a');
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			System.exit(0);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
}
