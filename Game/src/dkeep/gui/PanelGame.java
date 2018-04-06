package dkeep.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dkeep.logic.Game.State;

public class PanelGame  extends JPanel implements KeyListener{
	private JButton buttonDown;
	private JButton buttonUp;
	private JButton buttonLeft;
	private JButton buttonRight; 
	private Pictures pics;
	private PanelControler panelC;



	public PanelGame(Pictures pics, PanelControler panelC) throws IOException
	{
		this.pics=pics;
		this.panelC=panelC;	
		setPreferredSize(new Dimension(600,600));
	
		setBounds(15, 15, 700, 700);

		requestFocusInWindow();
		addKeyListener(this);
		setFocusable(true);
		setLayout(null);
		

	}


	private void runButton(char c) {

		if((pics.getGame().gameState != State.Lost) && (pics.getGame().gameState != State.Won))
		{
			pics.updateMove(c);
			if(pics.getGame().gameState == State.Lost)
			{
				JLabel Label=new JLabel("You Lost!!");
				Label.setBounds(200, 50, 500, 400);
				Label.setFont(new Font("Serif", Font.PLAIN, 100));
				Label.setForeground (Color.CYAN);

				add(Label); 
			}else if(pics.getGame().gameState == State.Won)
			{
				JLabel Label=new JLabel("You won!!");
				Label.setBounds(200, 50, 500, 400);
				Label.setFont(new Font("Serif", Font.PLAIN, 100));
				Label.setForeground (Color.CYAN);

				add(Label);
			}
			repaint();

		}
	}


	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		try {			
			pics.loadImages(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(panelC.getState()== panelC.getState().gamePanel  ) {
			for (int i=0; i < pics.getCurrentMapDimensions();i++)
			{
				for (int j=0; j < pics.getCurrentMapDimensions();j++)
				{
					if(pics.getCurrentMap()[i][j]== 'X') 
					{
						g.drawImage(pics.getWall(), j *100,i*100,100,100,this);
					}
					else if(pics.getCurrentMap()[i][j]== 'S')
					{  g.drawImage(pics.getGround(), j*100, i*100, 100 , 100 ,this);
						g.drawImage(pics.getOpenDoor(), j *100,i*100,100,105,this);

					}
					else if(pics.getCurrentMap()[i][j]== 'k')
					{
						g.drawImage(pics.getGround(), j*100, i*100, 100 , 100 ,this);
						g.drawImage(pics.getKey(), j *100,i*100,100,100,this);
					}
					else if(pics.getCurrentMap()[i][j]== 'I')
					{
						g.drawImage(pics.getGround(), j*100, i*100, 100 , 100 ,this);
						g.drawImage(pics.getCloseDoor(), j *100,i*100,100,100,this);

					}else if(pics.getCurrentMap()[i][j]== 's')
					{


					}else {
						g.drawImage(pics.getGround(), j*100, i*100, 100 , 100 ,this);
					}
				}
			}
			paintCharacters(g);
		}

	}
	public void paintCharacters(Graphics g)
	{
		requestFocusInWindow();
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
				if(pics.getGame().getPlayingLevel().getOgres().get(i).isStun())
				{
					g.drawImage(pics.getOgreStun(),pics.getGame().getPlayingLevel().getOgres().get(i).getYcoordinate() *100,pics.getGame().getPlayingLevel().getOgres().get(i).getXcoordinate() *100,100,100,this);
				}else {
					g.drawImage(pics.getOgre(),pics.getGame().getPlayingLevel().getOgres().get(i).getYcoordinate() *100,pics.getGame().getPlayingLevel().getOgres().get(i).getXcoordinate() *100,100,100,this);
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
				g.drawImage(pics.getOgreMartelo(),pics.getGame().getPlayingLevel().getOgres().get(i).getyDamage()*100,pics.getGame().getPlayingLevel().getOgres().get(i).getxDamage()*100,100,100,this);
			}
		}
	}
	public void paintGuard(Graphics g)
	{
		if(pics.getGame().getPlayingLevel().getNumberLevel()== 1 && pics.getGame().getPlayingLevel().getGuard().getLetter() != 'g')
		{
			g.drawImage(pics.getGuard(),pics.getGame().getPlayingLevel().getGuard().getYcoordinate()*100,pics.getGame().getPlayingLevel().getGuard().getXcoordinate()*100,100,100,this);
		}
		else if( pics.getGame().getPlayingLevel().getNumberLevel()== 1)
		{
			g.drawImage(pics.getGuardSleeping(),pics.getGame().getPlayingLevel().getGuard().getYcoordinate()*100,pics.getGame().getPlayingLevel().getGuard().getXcoordinate()*100,100,100,this);
		}

	}
	public void paintHero(Graphics g)
	{
		if(pics.getGame().getPlayingLevel().getNumberLevel()== 1 )
		{
			g.drawImage(pics.getHero(),pics.getGame().getPlayingLevel().getHero().getYcoordinate()*100,pics.getGame().getPlayingLevel().getHero().getXcoordinate()*100,100,100,this);
		}
		else if(pics.getGame().getPlayingLevel().getNumberLevel()== 2 )
		{
			g.drawImage(pics.getHeroArmed(),pics.getGame().getPlayingLevel().getHero().getYcoordinate()*100,pics.getGame().getPlayingLevel().getHero().getXcoordinate()*100,100,100,this);
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
