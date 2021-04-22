import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board {

	public Board(){
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		JFrame frame = new JFrame(); 
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic-Tac-Toe");
		frame.pack();
		frame.setVisible(true); 
		
		JButton[][] board = new JButton[3][3];
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				JButton button = new JButton();
				panel.add(button); 
			}
		}
		
		
		
		
	}
	
}
