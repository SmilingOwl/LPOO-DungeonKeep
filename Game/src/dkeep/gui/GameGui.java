package dkeep.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import dkeep.cli.Main;

import dkeep.logic.Character;
import dkeep.logic.Game;
import dkeep.logic.Guard;
import dkeep.logic.Hero;
import dkeep.logic.Level1;
import dkeep.logic.Ogre;
import dkeep.logic.Game.State;

import javax.swing.JComboBox;
import javax.swing.JTextArea;



public class GameGui {

	private JPanel panelMenu;
	private JPanel panelGame;
	private JPanel panelEdit;
	private PanelControler panelC;
	private JFrame frame;
	private JLabel label;
	private Game game;
	private JTextField textF;
	private JTextArea textA;
	private Pictures pic;
	private JPanel panel ; 
	static JLayeredPane layeredPane;
/**
 * 
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException {
		GameGui window = new GameGui();
		window.frame.setVisible(true);
	}
 
	public GameGui() throws IOException {
		starting();
	}

	/*public void runButton(char letter)
	{
		if((game.gameState != State.Lost) && (game.gameState != State.Won))
		{
		game.heroMove(letter);
		/*if(game.getLevel()==0)
		{
			game=null;
			label.setText("Play again!");
		*/
		/*}
		if(game.gameState == State.Lost)
		{
			label.setText("Play again!");
		}
		if(game.gameState == State.Won)
		{
			label.setText("You win!");
		}
		game.printstring();
		textA.setText(game.getMap());
	}*/
	private void starting() throws IOException {
		frame = new JFrame();
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       // frame.setBounds(100, 100, 700, 750);
		frame.getContentPane().setLayout(null);
		// não percebi muito bem o que isto faz xD
			 layeredPane = new JLayeredPane();
		 layeredPane.setBounds(0, 0, 1070, 1070);
		 frame.getContentPane().add(layeredPane);
		 layeredPane.setLayout(null);
		 
		 
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			//panel.setEnabled(true);
			frame.setBounds(0, 0, 1000, 1000);
			frame.getContentPane().setLayout(null);
		pic= new Pictures(frame);
			
		panelC= new PanelControler(); 
		panel = new PanelGame(pic,panelC); //panel==panelgame
		panel.setEnabled(true);
		layeredPane.add(panel);
		panelMenu= new PanelMenu(pic,panelC);
		panelMenu.setBounds(0,0,1070,1070);
		layeredPane.add(panelMenu);
		
		panelMenu.setLayout(null); 
				
		
		
		panelEdit = new PanelEdit(pic, panelC);
		panelEdit.setBounds(0,0,1070,1070);
		//frame.getContentPane().add(panelEdit);
		layeredPane.add(panelEdit);
	
	
	    //frame.getContentPane().add(panelMenu);
		frame.getContentPane().add(panel); 
		panel.setBounds(0,0,1070,1070);
		//frame.getContentPane().add(panelEdit);
	   	panelC.setPanels(panelMenu, panel,panelEdit);
		//frame.getContentPane().add(panel);
		//frame.setVisible(true);

		//-------------------BUTTON--------------------------------
		
}
}
