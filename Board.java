import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends Main {

	private Button[][] b;
	private static JFrame frame; 


	public Board(){

		// Create panel for information on the game
		JPanel infoPanel = new JPanel(); 

		// Create panel for the board of the game in a 3x3 grid
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(3, 3, 0, 0));
		// Create panel for the b of the game in a 3x3 grid
		JPanel bPanel = new JPanel();
		bPanel.setLayout(new GridLayout(3, 3, 0, 0));

		label = new JLabel();
		// Create a frame for everything
		frame = new JFrame(); 
		infoPanel.add(label);
		frame.add(infoPanel, BorderLayout.NORTH); 
		frame.add(boardPanel, BorderLayout.CENTER);
		frame.add(bPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic-Tac-Toe");
		frame.pack();
		frame.setVisible(true); 

		// Create Button objects for each board location 
		Button[][] board = new Button[3][3];
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				final Button button = new Button(i, j);
				button.getButton().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						for (int i = 0; i < 3; i++){
						    for (int j = 0; j < 3; j++){
								if(vsCPU) {
									if(isCPU) {
										button.getButton().setText(cpuPick);
										button.getButton().setForeground(Color.BLUE);
										button.getButton().setFont(new Font("Purisa", Font.PLAIN,button.getButton().getHeight()));
										isCPU = false;
										isPlayer1 = true;
										button.getButton().setEnabled(false);
										label.setText(Player1 + " it is your turn");
										label.setFont(new Font("Purisa", Font.PLAIN,40));
										label.setForeground(Color.BLUE);
									}
									else {
										button.getButton().setText(playerPick);
										button.getButton().setForeground(Color.BLUE);
										button.getButton().setFont(new Font("Purisa", Font.PLAIN,button.getButton().getHeight()));
										isCPU = true;
										isPlayer1 = false;
										button.getButton().setEnabled(false);
										label.setText("CPU's turn");
										label.setFont(new Font("Purisa", Font.PLAIN,40));
										label.setForeground(Color.BLUE);
									}
								}
								
								else {
									if(isPlayer1) {
										button.getButton().setText(player2Pick);
										button.getButton().setForeground(Color.BLUE);
										button.getButton().setFont(new Font("Purisa", Font.PLAIN,button.getButton().getHeight()));
										isPlayer2 = true;
										isPlayer1 = false;
										button.getButton().setEnabled(false);
										label.setText(Player1 + " it is your turn");
										label.setFont(new Font("Purisa", Font.PLAIN,40));
										label.setForeground(Color.BLUE);
									}
									else {
										button.getButton().setText(playerPick);
										button.getButton().setForeground(Color.BLUE);
										button.getButton().setFont(new Font("Purisa", Font.PLAIN,button.getButton().getHeight()));
										isPlayer2 = false;
										isPlayer1 = true;
										button.getButton().setEnabled(false);
										label.setText(Player2 + " it is your turn");
										label.setFont(new Font("Purisa", Font.PLAIN,40));
										label.setForeground(Color.BLUE);
									}
								}
						    }
						}
						if (checkWin()){
							if (isPlayer2 == false)
								JOptionPane.showMessageDialog(Board.getFrame(), getPlayer2() + " is the winner!");
							else
								JOptionPane.showMessageDialog(Board.getFrame(), getPlayer1() + " is the winner!");
							String Option[] = {"Yes", "No"};
							int Answer = JOptionPane.showOptionDialog(null,"Replay?", "Do you want to play again?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, Option, null);
							if (Answer == 0)
								main(null); 
							if (Answer == 1)
								System.exit(0);
						}
					}
				});
				boardPanel.add(button.getButton()); 
				bPanel.add(button.getButton()); 
			}
		}
	} 

		public boolean checkWin() {
			for (int i = 0; i < 3; i++){
				for (int j = 0; j < 3; j++){
					if(i == 0 && j == 0) {
						/* Order: first is vertical comparison, then horizontal then across*/
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
				}
			}
			return false;
		}
		
		
		public static JFrame getFrame(){
			return frame; 
		}
}