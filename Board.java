import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board {

	public Board(){
		
		// Create panel for information on the game
		JPanel infoPanel = new JPanel(); 
		
		// Create panel for the board of the game in a 3x3 grid
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(3, 3, 0, 0));
		
		// Create a frame for everything
		JFrame frame = new JFrame(); 
		frame.add(infoPanel, BorderLayout.NORTH); 
		frame.add(boardPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic-Tac-Toe");
		frame.pack();
		frame.setVisible(true); 
		
		// Create Button objects for each board location 
		Button[][] board = new Button[3][3];
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				Button button = new Button(i, j);
				boardPanel.add(button.getButton()); 
			}
		}
		
		
		
		
	}
	
}
