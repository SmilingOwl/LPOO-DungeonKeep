package dkeep.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dkeep.cli.Main;
import dkeep.logic.Board;
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

	private JFrame frame;
	private JLabel label;
	private Game game;
	private JTextField textF;
	private JTextArea textA;
	private Pictures pic;
	private JPanel panel ; 

	public static void main(String[] args) throws IOException {
		GameGui window = new GameGui();
		window.frame.setVisible(true);
	}

	public GameGui() throws IOException {
		starting();
	}

	public void runButton(char letter)
	{
		if((game.gameState != State.Lost) && (game.gameState != State.Won))
		{
		game.heroMove(letter);
		/*if(game.getLevel()==0)
		{
			game=null;
			label.setText("Play again!");
		*/
		}
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
	}
	private void starting() throws IOException {
		frame = new JFrame();

		
		pic= new Pictures(frame);
		panel = new PanelGame(pic);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel.setEnabled(true);
		frame.setBounds(100, 100, 600, 450);
		frame.getContentPane().setLayout(null);
		//frame.getContentPane().add(panel);
		//frame.setVisible(true);

		//-------------------BUTTON--------------------------------
		// EXIT
		JButton buttonExit = new JButton("Exit");
		buttonExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent action)
			{
				System.exit(0);
			}
		});

		buttonExit.setBounds(400, 330, 90, 20);
		frame.getContentPane().add(buttonExit);

		//*******LABELS***************

		//number of ogres
		JLabel lbNumOgres=new JLabel("Number of Ogres");
		lbNumOgres.setBounds(15, 17, 110, 20);

		frame.getContentPane().add(lbNumOgres);

		textF = new JTextField();
		textF.setBounds(130, 17, 37, 22);
		frame.getContentPane().add(textF);
		textF.setColumns(10);

		//guard personality
		JLabel lbGuard=new JLabel("Guard personality");
		lbGuard.setBounds(15, 55, 110, 20);

		frame.getContentPane().add(lbGuard);

		JComboBox<String> comboBox = new JComboBox();

		comboBox.setBounds(130, 55, 150, 22);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Rookie");
		comboBox.addItem("Drunken");
		comboBox.addItem("Suspicious");

		//you can...
		label=new JLabel("You can start a new game");
		label.setBounds(15, 360, 160, 40);
       
		frame.getContentPane().add(label);

		//******************************************

		// NEW GAME
		JButton buttonNewGame = new JButton("New Game");

		buttonNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

				game=new Game();
				game.playingLevel=new Level1();
				game.playingLevel.setGuard(comboBox.getSelectedItem().toString());
				//game.getGuard().setPersonality(comboBox.getSelectedItem().toString());

				if(Integer.parseInt(textF.getText()) >5 ||Integer.parseInt(textF.getText()) <1)
					JOptionPane.showMessageDialog(frame, "invalid number!Please insert a positive number!");
				else
				{
					game.setOgres(Integer.parseInt(textF.getText()));
					game.setNumOgres(Integer.parseInt(textF.getText()));
					//game.printBoard();
					
					game.printstring();
					textA.setText(game.getMap());
				}
				GameGui2 coiso = null;
				try {
					coiso = new GameGui2(game);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



				label.setText("Play!");
				
			}
		});

		buttonNewGame.setBounds(400, 90, 120, 20);
		frame.getContentPane().add(buttonNewGame);

		textA = new JTextArea();
		textA.setFont(new Font("Courier New", Font.PLAIN, 20));

		textA.setBounds(15, 82, 335, 250);
		frame.getContentPane().add(textA);

		// UP
		JButton buttonUP = new JButton("Up");

		buttonUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runButton('w');
			}
		});

		buttonUP.setBounds(410, 200, 68, 20);
		frame.getContentPane().add(buttonUP);

		// Down
		JButton buttonDown = new JButton("Down");
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runButton('s');
			}
		});

		buttonDown.setBounds(410, 250, 68, 20);
		frame.getContentPane().add(buttonDown);

		// LEFT
		JButton buttonLeft = new JButton("Left");
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runButton('a');
			}
		});

		buttonLeft.setBounds(375, 225, 65, 20);
		frame.getContentPane().add(buttonLeft);

		// RIGHT
		JButton buttonRight = new JButton("Right");

		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runButton('d');
			}
		});

		buttonRight.setBounds(442, 225, 65, 20);
		frame.getContentPane().add(buttonRight);

	}
}
