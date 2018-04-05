package dkeep.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dkeep.gui.PanelControler.Event;
import dkeep.gui.PanelControler.State;
import dkeep.logic.Game;
import dkeep.logic.Level1;
import java.awt.Font;
import javax.swing.ImageIcon;

public class PanelMenu extends JPanel{
	private Pictures pics;
	JComboBox<String> comboBox ;
	private JTextField textF;
	private PanelControler panelC;
	private JLabel label;
	private JPanel dd= new JPanel();
	public PanelMenu(Pictures pics, PanelControler panelC)
	{
		this.pics=pics;
		this.panelC=panelC;
		Game game=new Game();
		game.playingLevel=new Level1();
		dd.setBounds(500,500,0,0);

		pics.setGame(game);
		//setPreferredSize(new Dimension(400,400));
		//setBounds(100, 100, 10*60 + 20, 10*60+50);
		setVisible(true);
		setEnabled(true);
add(dd);

	
		requestFocusInWindow();

		setFocusable(true);
		setLayout(null);
		inicializeButtons();
	}
	private void inicializeButtons() {
		init();
		buttonNewGame();
		buttonSetting();
		buttonExit();



	}
	private void init()
	{

		//number of ogres
		JLabel lbNumOgres=new JLabel("Number of Ogres");
		lbNumOgres.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbNumOgres.setBounds(15, 17, 145, 33);

		add(lbNumOgres);

		textF = new JTextField();
		textF.setBounds(175, 16, 42, 34);
		textF.setColumns(10);
		add(textF);
		textF.setText( "0" );



		//guard personality
		JLabel lbGuard=new JLabel("Guard personality");
		lbGuard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbGuard.setBounds(15, 55, 170, 33);

		add(lbGuard);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));

		comboBox.setBounds(178, 54, 242, 34);
		add(comboBox);
		comboBox.addItem("Rookie");
		comboBox.addItem("Drunken");
		comboBox.addItem("Suspicious");

	


	}
	private void buttonExit() {
		JButton buttonExit = new JButton("Exit");
		buttonExit.setFont(new Font("Calibri", Font.PLAIN, 16));
		buttonExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent action)
			{
				System.exit(0);
			}
		});

		buttonExit.setBounds(47, 839, 90, 20);
		add(buttonExit);

	}
	private void buttonSetting() {
		JButton buttonSettings = new JButton("Create Board");
		buttonSettings.setIcon(null);
		buttonSettings.setFont(new Font("Calibri", Font.ITALIC, 18));
		buttonSettings.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent action)
			{
				if(Integer.parseInt(textF.getText()) >5 ||Integer.parseInt(textF.getText()) <1 ) {
					//JOptionPane.showMessageDialog(frame, "invalid number!Please insert a positive number!");
					//JOptionPane.showInputDialog(this, "invalid number!Please insert a positive number!");
					JOptionPane.showMessageDialog(dd, "invalid number!Please insert a positive number!");
				}else {
				pics.setOgreNum(Integer.parseInt(textF.getText()));
				pics.getGame().setNumOgres(Integer.parseInt(textF.getText()));
				pics.getGame().playingLevel.setGuard(comboBox.getSelectedItem().toString());
				panelC.choosePanel(Event.setting);}

				//settings.setVisible(true);
			}
		});

		buttonSettings.setBounds(655, 30, 200, 50);
		add(buttonSettings);


	}
	private void buttonNewGame() {
		JButton buttonNewGame = new JButton("New Game");
		buttonNewGame.setFont(new Font("Calibri", Font.BOLD, 20));

		buttonNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

				if(Integer.parseInt(textF.getText()) >5 ||Integer.parseInt(textF.getText()) <1 ) {
					//JOptionPane.showMessageDialog(frame, "invalid number!Please insert a positive number!");
					JOptionPane.showMessageDialog(dd, "invalid number!Please insert a positive number!");
				}else
				{
					/*Game game=new Game();
					game.playingLevel=new Level1(); 
					
*/
					//pics.setGame(game);
					 pics.getGame().playingLevel.setGuard(comboBox.getSelectedItem().toString());
					pics.getGame().setNumOgres(Integer.parseInt(textF.getText()));
					panelC.choosePanel(Event.newGame);

				}


			}
		});

		buttonNewGame.setBounds(47, 699, 170, 67);
		add(buttonNewGame);

	}
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {			
			pics.loadImages(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	//	g.drawImage(pics.getMainMenu(), 0,0,569,455,this);
		g.drawImage(pics.getMainMenu(), 0,0,1000,1000,this);
		
	}
}
