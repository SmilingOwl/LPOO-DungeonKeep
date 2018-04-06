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
import dkeep.logic.Game;
import dkeep.logic.Level1;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Font;

public class PanelEdit extends JPanel{
	private Pictures pics;
	JSpinner spinner , spinner_1;
	JPanel panelBoard ;
	private int numOgres;
	private int xHero;
	private int yHero;
	private int[] coorO;
	private char[][] newBoard;
	JComboBox<String> comboBox ;
	private JPanel dd= new JPanel();
	private JTextField xPos;
	private JTextField yPos;
	private PanelControler panelC;

	private char[][] newBoard55=new char[][]{{'X','X','X','X','X','X','X'},
		{'I',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ','X'},
		{'X','X','X','X','X','X','X'}};;

		private char[][] newBoard56=new char[][]{
			{'X','X','X','X','X','X','X','X'},
			{'I',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X'},
			{'s','s','s','s','s','s','s','s'}};
			private char[][] newBoard57= new char[][]{
				{'X','X','X','X','X','X','X','X','X'},
				{'I',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X','X','X','X','X','X','X','X','X'},
				{'s','s','s','s','s','s','s','s','s'},
				{'s','s','s','s','s','s','s','s','s'}};
				private char[][] newBoard58= new char[][]{
					{'X','X','X','X','X','X','X','X','X','X'},
					{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
					{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
					{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
					{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
					{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
					{'X','X','X','X','X','X','X','X','X','X'},
					{'s','s','s','s','s','s','s','s','s','s'},
					{'s','s','s','s','s','s','s','s','s','s'},
					{'s','s','s','s','s','s','s','s','s','s'}};
					private char[][] newBoard65= new char[][]{ 
						{'X','X','X','X','X','X','X','s'},
						{'I',' ',' ',' ',' ',' ','X','s'},
						{'X',' ',' ',' ',' ',' ','X','s'},
						{'X',' ',' ',' ',' ',' ','X','s'},
						{'X',' ',' ',' ',' ',' ','X','s'},
						{'X',' ',' ',' ',' ',' ','X','s'},
						{'X',' ',' ',' ',' ',' ','X','s'},
						{'X','X','X','X','X','X','X','s'}};
						private char[][] newBoard66= new char[][]{
							{'X','X','X','X','X','X','X','X'},
							{'I',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ','X'},
							{'X','X','X','X','X','X','X','X'},
						};
						private char[][] newBoard67= new char[][]{
							{'X','X','X','X','X','X','X','X','X'},
							{'I',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X','X','X','X','X','X','X','X','X'},
							{'s','s','s','s','s','s','s','s','s'}};
							private char[][] newBoard68= new char[][]{
								{'X','X','X','X','X','X','X','X','X','X'},
								{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
								{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
								{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
								{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
								{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
								{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
								{'X','X','X','X','X','X','X','X','X','X'},
								{'s','s','s','s','s','s','s','s','s','s'},
								{'s','s','s','s','s','s','s','s','s','s'}};
								private char[][] newBoard75= new char[][]{
									{'X','X','X','X','X','X','X','s','s'},
									{'I',' ',' ',' ',' ',' ','X','s','s'},
									{'X',' ',' ',' ',' ',' ','X','s','s'},
									{'X',' ',' ',' ',' ',' ','X','s','s'},
									{'X',' ',' ',' ',' ',' ','X','s','s'},
									{'X',' ',' ',' ',' ',' ','X','s','s'},
									{'X',' ',' ',' ',' ',' ','X','s','s'},
									{'X',' ',' ',' ',' ',' ','X','s','s'},
									{'X','X','X','X','X','X','X','s','s'}};
									private char[][] newBoard76= new char[][]{
										{'X','X','X','X','X','X','X','X','s'},
										{'I',' ',' ',' ',' ',' ',' ','X','s'},
										{'X',' ',' ',' ',' ',' ',' ','X','s'},
										{'X',' ',' ',' ',' ',' ',' ','X','s'},
										{'X',' ',' ',' ',' ',' ',' ','X','s'},
										{'X',' ',' ',' ',' ',' ',' ','X','s'},
										{'X',' ',' ',' ',' ',' ',' ','X','s'},
										{'X',' ',' ',' ',' ',' ',' ','X','s'},
										{'X','X','X','X','X','X','X','X','s'}};
										private char[][] newBoard77= new char[][]{
											{'X','X','X','X','X','X','X','X','X'},
											{'I',' ',' ',' ',' ',' ',' ',' ','X'},
											{'X',' ',' ',' ',' ',' ',' ',' ','X'},
											{'X',' ',' ',' ',' ',' ',' ',' ','X'},
											{'X',' ',' ',' ',' ',' ',' ',' ','X'},
											{'X',' ',' ',' ',' ',' ',' ',' ','X'},
											{'X',' ',' ',' ',' ',' ',' ',' ','X'},
											{'X',' ',' ',' ',' ',' ',' ',' ','X'},
											{'X','X','X','X','X','X','X','X','X'},};
											private char[][] newBoard78= new char[][]{
												{'X','X','X','X','X','X','X','X','X','X'},
												{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
												{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
												{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
												{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
												{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
												{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
												{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
												{'X','X','X','X','X','X','X','X','X','X'},
												{'s','s','s','s','s','s','s','s','s','s'}};
												private char[][] newBoard85= new char[][]{{ 'X', 'X', 'X', 'X', 'X', 'X','X','s','s','s' },
													{ 'I', ' ', ' ', ' ', ' ', ' ','X','s','s' ,'s'}, 
													{ 'X', ' ', ' ', ' ', ' ', ' ','X','s' ,'s','s'},
													{ 'X', ' ', ' ', ' ', ' ', ' ','X','s','s','s'},
													{ 'X', ' ', ' ', ' ', ' ', ' ','X','s','s','s'},
													{ 'X', ' ', ' ', ' ', ' ', ' ','X','s' ,'s','s'},
													{ 'X', ' ', ' ', ' ', ' ', ' ','X','s' ,'s','s'},
													{ 'X', ' ', ' ', ' ', ' ', ' ','X','s' ,'s','s'}, 
													{ 'X', ' ', ' ', ' ', ' ', ' ','X','s','s','s'},
													{ 'X', 'X', 'X', 'X', 'X', 'X','X','s' ,'s','s'} };
													private char[][] newBoard86= new char[][]{{ 'X', 'X', 'X', 'X', 'X', 'X', 'X','X','s','s' },
														{ 'I', ' ', ' ', ' ', ' ', ' ', ' ','X','s','s' }, 
														{ 'X', ' ', ' ', ' ', ' ', ' ', ' ','X','s' ,'s'},
														{ 'X', ' ', ' ', ' ', ' ', ' ', ' ','X','s','s'},
														{ 'X', ' ', ' ', ' ', ' ', ' ', ' ','X','s','s'},
														{ 'X', ' ', ' ', ' ', ' ', ' ', ' ','X','s' ,'s'},
														{ 'X', ' ', ' ', ' ', ' ', ' ', ' ','X','s' ,'s'},
														{ 'X', ' ', ' ', ' ', ' ', ' ', ' ','X','s' ,'s'}, 
														{ 'X', ' ', ' ', ' ', ' ', ' ', ' ','X','s','s'},
														{ 'X', 'X', 'X', 'X', 'X', 'X', 'X','X','s' ,'s'} };
														private char[][] newBoard87= new char[][]{{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X','s' },
															{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ',  'X','s' }, 
															{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ',  'X','s' },
															{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ',  'X' ,'s'},
															{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ',  'X' ,'s'},
															{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ',  'X','s' },
															{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ',  'X','s' },
															{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ',  'X','s' }, 
															{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ',  'X' ,'s'},
															{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',  'X','s' } };
															private char[][] newBoard88= new char[][]{{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
																{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
																{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
																{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
																{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
																{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
																{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
																{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
																{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
																{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
																public PanelEdit(Pictures pics, PanelControler panelC)
																{
																	this.pics=pics;
																	dd.setBounds(500,500,0,0);
																	this.panelC=panelC;
																	add(dd);
																	newBoard = new char[][]{{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
																		{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
																		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
																		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
																		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
																		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
																		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
																		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
																		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
																		{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

																		setVisible(false);
																		setLayout(null);
																		setEnabled(false);
																		requestFocusInWindow();
																		setFocusable(true);
																		setLayout(null);
																		inicializeButtons();
																}
																private void inicializeButtons() {
																	init();
																	buttonReturn();
																	buttonAdd();
																	buttonExit();



																}

																private void init()
																{


																	JLabel Position=new JLabel("Position: (x,y)");
																	Position.setFont(new Font("Tahoma", Font.PLAIN, 18));
																	Position.setBounds(15, 53, 143, 37);

																	add(Position);

																	xPos = new JTextField();
																	xPos.setFont(new Font("Tahoma", Font.PLAIN, 18));
																	xPos.setBounds(159, 53, 55, 29);
																	xPos.setColumns(10);
																	add(xPos);
																	yPos = new JTextField();
																	yPos.setFont(new Font("Tahoma", Font.PLAIN, 18));
																	yPos.setBounds(229, 53, 51, 29);
																	yPos.setColumns(10);

																	add(yPos);



																	JLabel lbGuard=new JLabel("add");
																	lbGuard.setFont(new Font("Tahoma", Font.PLAIN, 18));
																	lbGuard.setBounds(15, 115, 110, 20);

																	add(lbGuard);
																	JLabel dimensions=new JLabel("Dimensions: ");

																	comboBox = new JComboBox();
																	comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));

																	comboBox.setBounds(126, 98, 170, 37);
																	add(comboBox);
																	comboBox.addItem("Ogre");
																	comboBox.addItem("Hero");
																	comboBox.addItem("key");
																	comboBox.addItem("white space");
																	comboBox.addItem("wall");


																}
																private void setDimentionsBoard( int y, int x){
																	pics.getGame().modify=true;
																	if (y==5)
																	{
																		if(x==5)
																			newBoard=newBoard55;
																		else if( x==6)
																			newBoard=newBoard56;
																		else if (x==7)
																			newBoard=newBoard57;
																		else if (x==8)
																			newBoard=newBoard58;
																	}	else if (y==6)
																	{
																		if(x==5)
																			newBoard=newBoard65;
																		else if( x==6)
																			newBoard=newBoard66;
																		else if (x==7)
																			newBoard=newBoard67;
																		else if (x==8)
																			newBoard=newBoard68;
																	} else if (y==7)
																	{
																		if(x==5)
																			newBoard=newBoard75;
																		else if( x==6)
																			newBoard=newBoard76;
																		else if (x==7)
																			newBoard=newBoard77;
																		else if (x==8)
																			newBoard=newBoard78;														
																	}else if (y==8)
																	{
																		if(x==5)
																			newBoard=newBoard85;
																		else if( x==6)
																			newBoard=newBoard86;
																		else if (x==7)
																			newBoard=newBoard87;
																		else if (x==8)
																			newBoard=newBoard88;}		
																	pics.getGame().setMap2(newBoard);}
																private void setBoard2Characters(){
																	xHero=0;
																	yHero=0;
																	coorO=new int[2*numOgres];
																	int numO=0;
																	for(int i=0; i < newBoard.length;i++)
																	{
																		for(int j=0; j < newBoard[i].length; j++)
																		{
																			if(newBoard[i][j]=='A')
																			{
																				xHero=i;
																				yHero=j;
																			}else if(newBoard[i][j]=='O')
																			{
																				if(numO <= 2*numOgres) 
																				{
																					coorO[numO]=i;
																					numO++;
																					coorO[numO]=j;
																					numO++;
																				}

																			}
																		}
																	}
																	pics.getGame().setCoorO(coorO);
																	pics.getGame().setXHero(xHero);
																	pics.getGame().setYHero(yHero);}
																private void buttonAdd()
																{
																	JButton buttonAdd = new JButton("add");
																	buttonAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
																	buttonAdd.addActionListener(new ActionListener()
																	{
																		public void actionPerformed(ActionEvent action)
																		{   

																			numOgres=pics.getOgreNum();
																			int x,y;
																			y=Integer.parseInt(xPos.getText());
																			x=Integer.parseInt(yPos.getText());
																			if( x > newBoard.length-2 || y> newBoard[1].length -2)
																			{
																				JOptionPane.showMessageDialog(dd, "Incorrect!");
																			}

																			if( comboBox.getSelectedItem().toString()== "key")
																			{  
																				if(numKeyInBoard() ==0)
																					newBoard[x][y]='k';


																			}else if(comboBox.getSelectedItem().toString()== "Ogre")
																			{ 
																				if(numOgreInBoard()<numOgres)
																				{
																					newBoard[x][y]='O';
																				}

																			}else if(comboBox.getSelectedItem().toString()== "Hero")
																			{
																				if(numHeroInBoard() ==0)
																					newBoard[x][y]='A';
																			}else if(comboBox.getSelectedItem().toString()== "wall")
																			{

																				newBoard[x][y]='X';
																			}else if(comboBox.getSelectedItem().toString()== "white space")
																			{

																				newBoard[x][y]=' ';
																			}
																			repaint();
																		}
																	});

																	buttonAdd.setBounds(362, 98, 100, 38);
																	add(buttonAdd);
																}
																private void buttonExit() {
																	JButton buttonExit = new JButton("Exit");
																	buttonExit.addActionListener(new ActionListener()
																	{
																		public void actionPerformed(ActionEvent action)
																		{
																			System.exit(0);
																		}
																	});

																	buttonExit.setBounds(704, 183, 90, 20);
																	add(buttonExit);

																	spinner = new JSpinner();
																	spinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
																	spinner.setModel(new SpinnerNumberModel(8, 5, 8, 1));
																	spinner.setBounds(484, 53, 55, 32);
																	add(spinner);

																	spinner_1 = new JSpinner();
																	spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
																	spinner_1.setModel(new SpinnerNumberModel(8, 5, 8, 1));
																	spinner_1.setBounds(549, 53, 51, 32);
																	add(spinner_1);

																	spinner_1.addChangeListener(listener);
																	spinner.addChangeListener(listener);
																	JLabel lblNewLabel = new JLabel("Dimentions");
																	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
																	lblNewLabel.setBounds(329, 55, 150, 30);
																	add(lblNewLabel);

																	panelBoard = new JPanel();
																	panelBoard.setBounds(51, 108, 296, 250);

																}
																ChangeListener listener = new ChangeListener() {
																	@Override
																	public void stateChanged(ChangeEvent e) {

																		setDimentionsBoard((Integer) spinner.getValue() ,(Integer)spinner_1.getValue());

																		repaint();
																	}
																};
																private int numOgreInBoard()
																{
																	int O=0;

																	for(int i=0; i < newBoard.length;i++)
																	{
																		for(int j=0; j < newBoard.length;j++)
																		{
																			if(newBoard[i][j]== 'O') 
																			{
																				O++;
																			}
																		}
																	}
																	return O;
																}
																private int numHeroInBoard()
																{
																	int O=0;

																	for(int i=0; i < newBoard.length;i++)
																	{
																		for(int j=0; j < newBoard.length;j++)
																		{
																			if(newBoard[i][j]== 'A') 
																			{
																				O++;
																			}
																		}
																	}
																	return O;
																}
																private int numKeyInBoard()
																{
																	int O=0;

																	for(int i=0; i < newBoard.length;i++)
																	{
																		for(int j=0; j < newBoard.length;j++)
																		{
																			if(newBoard[i][j]== 'k') 
																			{
																				O++;
																			}
																		}
																	}
																	return O;
																}
																private void buttonReturn() {
																	JButton buttonReturn = new JButton("Return");
																	buttonReturn.setFont(new Font("Tahoma", Font.BOLD, 20));

																	buttonReturn.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent a) {
																			setBoard2Characters();
																			if(numKeyInBoard()==0) 
																			{
																				JOptionPane.showMessageDialog(dd, "Please put the key!");


																			}else if(numOgreInBoard() != numOgres)
																			{
																				JOptionPane.showMessageDialog(dd, "Please put more Ogres!");

																			}else if(numHeroInBoard() ==0)
																			{
																				JOptionPane.showMessageDialog(dd, "Please put the Hero!");

																			}else 
																			{
																				panelC.choosePanel(Event.endsetting);

																			}
																		}
																	});

																	buttonReturn.setBounds(704, 65, 170, 71);
																	add(buttonReturn);

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
																	if(panelC.getState()== panelC.getState().editPanel ) {

																		for(int i=0; i < newBoard.length;i++)
																		{
																			for(int j=0; j < newBoard.length;j++)
																			{
																				if(newBoard[i][j]== 'X') 
																				{
																					g.drawImage(pics.getWall(),10+ j *60,150 +i*60,60,60,this);
																				}else if(newBoard[i][j]== ' '){
																					g.drawImage(pics.getGround(), 10+j*60,150+ i*60, 60 , 60 ,this);
																				}  else if(newBoard[i][j]== 'I')
																				{
																					g.drawImage(pics.getGround(), 10+ j*60,150+ i*60, 60 , 60 ,this);
																					g.drawImage(pics.getCloseDoor(), 10+j *60,150+i*60,60,60,this);

																				}else if(newBoard[i][j] == 'k' )
																				{
																					g.drawImage(pics.getGround(), 10+j*60,150 +i*60, 60 , 60 ,this);
																					g.drawImage(pics.getKey(), 10+j *60,150+ i*60,60,60,this);
																				}else if(newBoard[i][j] == 'O' )
																				{
																					g.drawImage(pics.getGround(), 10+j*60,150 +i*60, 60 , 60 ,this);
																					g.drawImage(pics.getOgre(), 10+j *60,150+ i*60,60,60,this);
																				}else if(newBoard[i][j] == 'A' )
																				{
																					g.drawImage(pics.getGround(), 10+j*60,150 +i*60, 60 , 60 ,this);
																					g.drawImage(pics.getHeroArmed(), 10+j *60,150+ i*60,60,60,this);
																				}else {}
																			}
																		}

																	}

																}


}
