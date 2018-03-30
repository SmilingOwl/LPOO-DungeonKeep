package dkeep.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Graphics;
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
import dkeep.logic.Ogre;

import javax.swing.JComboBox;
import javax.swing.JTextArea;



public class GameGui2 {

	private JFrame frame;
	private static Pictures pic;
	private JPanel panel ; 
	private Game game;
	
	public void main() throws IOException {
		GameGui2 window = new GameGui2(game);
		window.frame.setVisible(true);
		//this.initialize();
	}

	public GameGui2(Game game) throws IOException {
		frame = new JFrame();
		pic= new Pictures(frame);
		panel = new PanelGame(pic);
		this.game=game;
		pic.setGame(this.game);
		initialize();
		//main();
	}

	public void setPic(Pictures pics) {
		this.pic = pics;
	}
	
	public void initialize() {
		
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 10*60 + 20, 10*60+50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setEnabled(true);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		
	}
	
	
/*
	public void runButton(char letter)
	{
		if(game.getLevel()==0)
		{
			game=null;
			label.setText("Play again!");
			
		}
		if(game.getLevel() == 1) {
			game.getHero().heroMovement(game.getB(), String.valueOf(letter));// heroCordinates
			game.getGuard().whatGuard();

			if (Character.checkHeroPresence(game.getB(), game.getGuard())) {
				game.setLevel(0);
				Main.loss();
				label.setText("Play again!");
				
			}
			if(game.getHero().moveLevel2(game.getB(),String.valueOf(letter)))
			{
				game.setLevel(2);
				game.setMap();
			}


		}
		if(game.getLevel() == 2)
		{

			if (game.getB()[1][8] == ' ' && game.getB()[1][0] == 'I' && game.getB()[game.getHero().getX()][game.getHero().getY()] == 'H') {
				game.getB()[1][8] = 'k';
			}

			
			
			int coordinates[] = { game.getHero().getX(),  game.getHero().getY() };

			 game.getHero().heroMovementKeyTansport(coordinates, Board.board2,String.valueOf(letter));
			for (int i = 0; i < game.getOgres().size(); i++) {
				game.getOgres().get(i).randomOgreDirection();

				if (game.getB()[game.getOgres().get(i).getXdamage()][game.getOgres().get(i).getYdamage()] != 'O') {
					game.getB()[game.getOgres().get(i).getXdamage()][game.getOgres().get(i).getYdamage()] = ' ';
				}

				game.getOgres().get(i).radomOgreDamage();

				if (game.getOgres().get(i).checkifstun(game.getHero())) {

				}
				if (game.getOgres().get(i).checkifloss(game.getHero())) {
					Main.loss();
					game.setLevel(0);
					label.setText("Play again!");
					
				}
			}
		}
		game.printstring();
		textA.setText(game.map);
	}
	private void starting()throws IOException{
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
				
				
				int[] heroCoordinates = new int[2];
				heroCoordinates[0] = 1;
				heroCoordinates[1] = 1;

				Hero h = new Hero(heroCoordinates[0], heroCoordinates[1], 'H');

				int[] guardCoordinates = new int[2];
				guardCoordinates[0] = 1;
				guardCoordinates[1] = 8;

				Guard g = new Guard(guardCoordinates[0], guardCoordinates[1]);


				game=new Game(h,g);
				
				game.getGuard().setPersonality(comboBox.getSelectedItem().toString());

				if(Integer.parseInt(textF.getText()) >5 ||Integer.parseInt(textF.getText()) <1)
					JOptionPane.showMessageDialog(frame, "invalid number!Please insert a positive number!");
				else
				{
					game.setOgres(Integer.parseInt(textF.getText()));
					//game.printBoard();
					//frame.getContentPane().add(panel);
					game.printstring();
					textA.setText(game.map);
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
	*/
}
