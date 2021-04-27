package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends Main {

	private Button[][] board;
	private static JFrame frame; 
	public static JLabel label;


	public Board(){

		// Create panel for information on the game
		JPanel infoPanel = new JPanel(); 

		// Create panel for the board of the game in a 3x3 grid
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(3, 3, 0, 0));

		label = new JLabel();
		// Create a frame for everything
		frame = new JFrame(); 
		infoPanel.add(label);
		frame.add(infoPanel, BorderLayout.NORTH); 
		frame.add(boardPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic-Tac-Toe");
		frame.pack();
		frame.setVisible(true); 

		// Create Button objects for each board location 
		board = new Button[3][3];
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				final Button button = new Button(i, j);
				board[i][j] = button;
				boardPanel.add(button.getButton()); 
				button.getButton().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
								if(getVsCpu()) {
									if(getIsCpu()) {
										button.getButton().setText(getCpuPick());
										button.getButton().setForeground(Color.BLUE);
										button.getButton().setFont(new Font("Purisa", Font.PLAIN,button.getButton().getHeight()));
										setIsCpu(false);
										setIsPlayer1(true);
										button.getButton().setEnabled(false);
										label.setText(Player1 + " it is your turn");
										label.setFont(new Font("Purisa", Font.PLAIN,40));
										label.setForeground(Color.BLUE);
									}
									else {
										button.getButton().setText(getPlayerPick());
										button.getButton().setForeground(Color.BLUE);
										button.getButton().setFont(new Font("Purisa", Font.PLAIN,button.getButton().getHeight()));
										setIsCpu(true);
										setIsPlayer1(false);
										button.getButton().setEnabled(false);
										label.setText("CPU's turn");
										label.setFont(new Font("Purisa", Font.PLAIN,40));
										label.setForeground(Color.BLUE);
									}
								}
								
								else {
									if(getIsPlayer1()) {
										button.getButton().setText(getPlayerPick());
										button.getButton().setForeground(Color.BLUE);
										button.getButton().setFont(new Font("Purisa", Font.PLAIN,button.getButton().getHeight()));
										setIsPlayer2(true);
										setIsPlayer1(false); 
										button.getButton().setEnabled(false);
										/*button.getButton().removeActionListener(this);*/
										
										label.setText(Player2 + " it is your turn");
										label.setFont(new Font("Purisa", Font.PLAIN,40));
										label.setForeground(Color.BLUE);
									}
									else {
										button.getButton().setText(getPlayer2Pick());
										button.getButton().setForeground(Color.BLUE);
										button.getButton().setFont(new Font("Purisa", Font.PLAIN,button.getButton().getHeight()));
										setIsPlayer2(false);
										setIsPlayer1(true); 
										button.getButton().setEnabled(false);
										label.setText(Player1 + " it is your turn");
										label.setFont(new Font("Purisa", Font.PLAIN,40));
										label.setForeground(Color.BLUE);
									}
								}
						if (checkWin()){
							if (getIsPlayer2())
								JOptionPane.showMessageDialog(Board.getFrame(), getPlayer1() + " is the winner!");
							else
								JOptionPane.showMessageDialog(Board.getFrame(), getPlayer2() + " is the winner!");
							String Option[] = {"Yes", "No"};
							int Answer = JOptionPane.showOptionDialog(null,"Replay?", "Do you want to play again?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, Option, null);
							if (Answer == 0){
								frame.setVisible(false);
								main(null); 
							}
							if (Answer == 1)
								System.exit(0);
						}
					}
				});
			}
		}
	} 

		public boolean checkWin() {
			for (int i = 0; i < 3; i++){
				if (!board[i][0].getString().equals("") && board[i][0].getString().equals(board[i][1].getString()) && board[i][0].getString().equals(board[i][2].getString()))
					return true;
			}
			for (int j = 0; j < 3; j++){
				if (!board[0][j].getString().equals("") && board[0][j].getString().equals(board[1][j].getString()) && board[0][j].getString().equals(board[2][j].getString()))
					return true;	
			}
			if (!board[0][0].getString().equals("") && board[0][0].getString().equals(board[1][1].getString()) && board[0][0].getString().equals(board[2][2].getString()))
				return true;
			if (!board[0][2].getString().equals("") && board[0][2].getString().equals(board[1][1].getString()) && board[0][2].getString().equals(board[2][0].getString()))
				return true;
			
			return false;
		}
		 public void paint(Graphics g) {
			    super.paint(g); 
			    Graphics2D g2 = (Graphics2D) g;
			    Line2D lin = new Line2D.Float(100, 100, 250, 260);
			    g2.draw(lin);
			  }
		
		public static JFrame getFrame(){
			return frame; 
		}
}