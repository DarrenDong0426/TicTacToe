
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicButtonUI;


public class Button{

	private JButton button; 
		
	public Button(int i, int j){
		
		button = new JButton();
		button.setBackground(Color.WHITE);
		
		button.setBorder(BorderFactory.createLineBorder(Color.black));
		
	     
	           
	}
	
	
	
	
	
	// Accessor Method
	public JButton getButton(){return button;}
	public String getString(){return this.getButton().getText();}
}