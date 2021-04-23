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
				
			for (int i = 0; i < 3; i++){
			    for (int j = 0; j < 3; j++){
				if(vsCPU) {
					if(isCPU) {
						button.setText(cpuPick);
						button.setForeground(Color.BLUE);
						button.setFont(new Font("Purisa", Font.PLAIN,button.getHeight()));
						isCPU = false;
						isPlayer1 = true;
						button.setEnabled(false);
						label.setText(Player1 + " it is your turn");
						label.setFont(new Font("Purisa", Font.PLAIN,40));
						label.setForeground(Color.BLUE);
					}
					else {
						button.setText(playerPick);
						button.setForeground(Color.BLUE);
						button.setFont(new Font("Purisa", Font.PLAIN,button.getHeight()));
						isCPU = true;
						isPlayer1 = false;
						button.setEnabled(false);
						label.setText("CPU's turn");
						label.setFont(new Font("Purisa", Font.PLAIN,40));
						label.setForeground(Color.BLUE);
					}
					
				}
				
				else {
					if(isPlayer1) {
						button.setText(player2Pick);
						button.setForeground(Color.BLUE);
						button.setFont(new Font("Purisa", Font.PLAIN,button.getHeight()));
						isPlayer2 = true;
						isPlayer1 = false;
						button.setEnabled(false);
						label.setText(Player1 + " it is your turn");
						label.setFont(new Font("Purisa", Font.PLAIN,40));
						label.setForeground(Color.BLUE);
					}
					else {
						button.setText(playerPick);
						button.setForeground(Color.BLUE);
						button.setFont(new Font("Purisa", Font.PLAIN,button.getHeight()));
						isPlayer2 = false;
						isPlayer1 = true;
						button.setEnabled(false);
						label.setText(Player2 + " it is your turn");
						label.setFont(new Font("Purisa", Font.PLAIN,40));
						label.setForeground(Color.BLUE);
					}
				}
				
				
	         }
				}
			}
		});
		
		
			
		}
	
	
	
	
	
	public JButton getButton(){return button;}
	
}