package dkeep.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;



public class GameGui {

	private JFrame frame;
	private JLabel label;
	private JTextField textF;
	private JTextArea textA;

	public static void main(String[] args) {
		GameGui window = new GameGui();
		window.frame.setVisible(true);
	}

	public GameGui() {
		starting();
	}

	public void runButton(char letter)
	{
	
		
	}
	private void starting() {
		frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 600, 450);
		frame.getContentPane().setLayout(null);
		
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
		JLabel lbGame=new JLabel("You can start a new game");
		lbGame.setBounds(15, 370, 160, 40);
		
		frame.getContentPane().add(lbGame);
		//******************************************
		
		// NEW GAME
		JButton buttonNewGame = new JButton("New Game");

		buttonNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				//TODO  colocar o nivel!

				label.setText("You can play now.");
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
