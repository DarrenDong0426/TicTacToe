package TicTacToe;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;


public class Button{

	private JButton button; 
		
	public Button(int i, int j){
		
		button = new JButton();
		button.setBackground(Color.WHITE);
		
		button.setBorder(BorderFactory.createLineBorder(Color.black));
	
	     
	           
	}
	
	public JButton getButton(){return button;}
	public String getString(){return this.getButton().getText();}
}