package TicTacToe;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Board extends Main {
	private Button[][] b;
	
	
	public Board(){
		
		// Create panel for information on the game
		JPanel infoPanel = new JPanel(); 
		
		// Create panel for the b of the game in a 3x3 grid
		JPanel bPanel = new JPanel();
		bPanel.setLayout(new GridLayout(3, 3, 0, 0));
		
		label = new JLabel();
		// Create a frame for everything
		JFrame frame = new JFrame(); 
		infoPanel.add(label);
		frame.add(infoPanel, BorderLayout.NORTH); 
		frame.add(bPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic-Tac-Toe");
		frame.pack();
		frame.setVisible(true); 
		
		// Create Button objects for each b location 
		b = new Button[3][3];
		for (int i = 0; i < b.length; i++){
			for (int j = 0; j < b[i].length; j++){
				Button button = new Button(i, j);
				bPanel.add(button.getButton()); 
			}
		}
	}
	
		
		public boolean checkWin(int i, int j) {
			/* Order: first is vert comparison, then hori then across*/
			if(i == 0 && j == 0) {
				if((b[i][j].getButton().getText().equals(b[i+1][j].getButton().getText()) &&
						b[i][j].getButton().getText().equals(b[i+2][j].getButton().getText())) ||
						(b[i][j].getButton().getText().equals(b[i][j+1].getButton().getText()) &&
								b[i][j].getButton().getText().equals(b[i][j+2].getButton().getText()))
						|| (b[i][j].getButton().getText().equals(b[i+1][j+1].getButton().getText()) &&
								b[i][j].getButton().getText().equals(b[i+2][j+2].getButton().getText()))) {
					return true;
				}
			}else if(i == 0 && j == 2) {
				if((b[i][j].getButton().getText().equals(b[i-1][j].getButton().getText()) &&
						b[i][j].getButton().getText().equals(b[i-2][j].getButton().getText())) ||
						(b[i][j].getButton().getText().equals(b[i][j-1].getButton().getText()) &&
								b[i][j].getButton().getText().equals(b[i][j-2].getButton().getText()))
						|| (b[i][j].getButton().getText().equals(b[i+1][j-1].getButton().getText()) &&
								b[i][j].getButton().getText().equals(b[i+2][j-2].getButton().getText()))) {
					return true;
				}
			}else if(i == 2 && j == 0){
				if((b[i][j].getButton().getText().equals(b[i-1][j].getButton().getText()) &&
						b[i][j].getButton().getText().equals(b[i-2][j].getButton().getText())) ||
						(b[i][j].getButton().getText().equals(b[i][j+1].getButton().getText()) &&
								b[i][j].getButton().getText().equals(b[i][j+2].getButton().getText()))
						|| (b[i][j].getButton().getText().equals(b[i-1][j+1].getButton().getText()) &&
								b[i][j].getButton().getText().equals(b[i-2][j+2].getButton().getText()))) {
					return true;
				}
			}else if(i == 2 && j == 2){
				if((b[i][j].getButton().getText().equals(b[i-1][j].getButton().getText()) &&
						b[i][j].getButton().getText().equals(b[i-2][j].getButton().getText())) ||
						(b[i][j].getButton().getText().equals(b[i][j-1].getButton().getText()) &&
								b[i][j].getButton().getText().equals(b[i][j-2].getButton().getText()))
						|| (b[i][j].getButton().getText().equals(b[i-1][j-1].getButton().getText()) &&
								b[i][j].getButton().getText().equals(b[i-2][j-2].getButton().getText()))) {
					return true;
				}
			}else if(i == 1) {
				if(j == 0) {
					if(b[i][j].getButton().getText().equals(b[i][j+1]) && 
							b[i][j].getButton().getText().equals(b[i][j+2])) {
						return true;
					}
				}else if (j == 1) {
					if(b[i][j].getButton().getText().equals(b[i][j+1]) && 
							b[i][j].getButton().getText().equals(b[i][j-1]) ||
							b[i][j].getButton().getText().equals(b[i-1][j]) && 
							b[i][j].getButton().getText().equals(b[i+1][j])) {
						return true;
					}
				}else if(j == 2) {
					if(b[i][j].getButton().getText().equals(b[i][j-1]) && 
							b[i][j].getButton().getText().equals(b[i][j-2])) {
						return true;
					}
				}
			}else if (j == 1) {
				if(i == 0) {
					if(b[i][j].getButton().getText().equals(b[i+1][j].getButton().getText()) &&
							b[i][j].getButton().getText().equals(b[i+2][j].getButton().getText())) {
						return true;
					}
				}
				}else if(i == 2) {
					if(b[i][j].getButton().getText().equals(b[i-1][j].getButton().getText()) &&
							b[i][j].getButton().getText().equals(b[i-2][j].getButton().getText())) {
						
				}
			}
			return false;
		}
	

}
