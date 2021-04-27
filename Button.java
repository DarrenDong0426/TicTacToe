import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Button extends Main {

	private int index1;
	private int index2;
	private JButton button; 
		
	public Button(int i, int j){
		
		index1 = i;
		index2 = j;
		button = new JButton();
		button.setBackground(Color.WHITE);
		
	}
	
	
	
	
	
	// Accessor Method
	public JButton getButton(){return button;}
	public String getString(){return this.getButton().getText();}
}