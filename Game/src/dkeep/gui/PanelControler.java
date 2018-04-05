package dkeep.gui;

import javax.swing.JPanel;

public class PanelControler {
	public State state;
	private JPanel menu, game,edit;
	
	public enum State{
		mainPanel, gamePanel, editPanel
	};
	public enum Event{
		newGame, setting,endsetting
	}
	public PanelControler() {
		state = State.mainPanel;
	}
	
	public void setPanels( JPanel menu, JPanel game,JPanel edit) {
		this.menu=menu;
		this.game=game;
		this.edit=edit;
	}
	public State getState()
	{

		return state;
	}
	public void choosePanel(Event evt) {
		if( evt == Event.newGame)
		{
			state = State.gamePanel;
			menu.setVisible(false);
			edit.setVisible(false);
			game.setVisible(true);
			
		}
		else if(evt == Event.setting)
		{
			state = State.editPanel;
			menu.setVisible(false);
			edit.setVisible(true);
			game.setVisible(false);
		}
		else if(evt == Event.endsetting)
		{
			state = State.mainPanel;
			menu.setVisible(true);
			edit.setVisible(false);
			game.setVisible(false);
			
		}

	}
}