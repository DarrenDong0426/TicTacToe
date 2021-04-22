package TicTacToe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Button extends Main {

	private int index1;
	private int index2;
	private JButton button; 
		
	public Button(int i, int j){
		
		index1 = i;
		index2 = j;
		button = new JButton();
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            button.setText(playerPick);
	            button.setForeground(Color.BLUE);
	            button.setFont(new Font("Purisa", Font.BOLD,button.getHeight()));
	         }
		});
	}
	
	
	
	
	public JButton getButton(){return button;}
	
}