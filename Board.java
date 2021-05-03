import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Board extends Main {

	private Button[][] board;
	private static JFrame frame; 
	public static JLabel label;
	private static boolean tie; 
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
	private JPanel infoPanel;
	private JPanel boardPanel; 
	

	public Board(){
		
		// Create panel for information on the game
		infoPanel = new JPanel(); 

		// Create panel for the board of the game in a 3x3 grid
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(3, 3, 0, 0));

		label = new JLabel();
		// Create a frame for everything
		frame = new JFrame(); 
		infoPanel.add(label);
		frame.add(infoPanel, BorderLayout.NORTH); 
		frame.add(boardPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic-Tac-Toe");
		
	    frame.setSize(650, 650);
		/*frame.setExtendedState(JFrame.MAXIMIZED_BOTH);*/ 
	
	    frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	    frame.setResizable(true); 
	   
		
		

		// Create Button objects for each board location 
		
		board = new Button[3][3];
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				final Button button = new Button(i, j);
				board[i][j] = button;
				button.getButton().setFocusPainted(false);
				boardPanel.add(button.getButton()); 
				frame.setVisible(true); 
				button.getButton().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
								if(getVsCpu()) {
									if(getIsCpu() == false) {
										button.getButton().setText(getPlayerPick());
										button.getButton().setForeground(new Color(255, 102, 102));
										button.getButton().setFont(new Font("Purisa", Font.PLAIN,button.getButton().getHeight()));
										button.getButton().removeActionListener(this);
									}
									if (checkWin() == false){
										label.setText(Player1 + " it is your turn");
										label.setFont(new Font("Purisa", Font.PLAIN,40));
										label.setForeground(new Color(51, 51, 51));
										button.getButton().removeActionListener(this);
										CpuMove();
										if (checkWin() == false)
											setIsCpu(false); 
										else
											setIsCpu(true);
									}
								}
								
								else {
									if(getIsPlayer1()) {
										button.getButton().setText(getPlayerPick());
										button.getButton().setFont(new Font("Purisa", Font.PLAIN,button.getButton().getHeight()));
										button.getButton().setForeground(new Color(51, 204, 255));
										setIsPlayer2(true);
										setIsPlayer1(false); 
										button.getButton().removeActionListener(this);
										
										label.setText(Player2 + " it is your turn");
										label.setFont(new Font("Purisa", Font.PLAIN,40));
										label.setForeground(new Color(51, 51, 51));
									}
									else {
										button.getButton().setText(getPlayer2Pick());
										button.getButton().setForeground(new Color(255, 102, 102));
										button.getButton().setFont(new Font("Purisa", Font.PLAIN,button.getButton().getHeight()));
										setIsPlayer2(false);
										setIsPlayer1(true); 
										label.setText(Player1 + " it is your turn");
										label.setFont(new Font("Purisa", Font.PLAIN,40));
										label.setForeground(new Color(51, 51, 51));
										button.getButton().removeActionListener(this);
									}
								}
						if (checkWin()) {
							if(getVsCpu()) {
								if (getIsPlayer2() || getIsCpu())
									JOptionPane.showMessageDialog(Board.getFrame(), getPlayer2() + " is the winner!");
								else
									JOptionPane.showMessageDialog(Board.getFrame(), getPlayer1() + " is the winner!");
							}
							else 
								if(getIsPlayer2())
									JOptionPane.showMessageDialog(Board.getFrame(), getPlayer1() + " is the winner!");
								else
									JOptionPane.showMessageDialog(Board.getFrame(), getPlayer2() + " is the winner!");;
							String Option[] = {"Yes", "No"};
							int Answer = JOptionPane.showOptionDialog(null,"Replay?", "Do you want to play again?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, Option, null);
							if (Answer == 0){
								frame.setVisible(false);
								main(null); 
							}
							if (Answer == 1)
								System.exit(0);
						}
						else{
							if (tie){
								JOptionPane.showMessageDialog(Board.getFrame(), "It's a tie! No one is the winner!");
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
					}
				});
			}
		}
		if (getIsCpu()){
			CpuMove(); 
		}
	} 

	
		
		public void CpuMove() {
			boolean moved = false;
			for (int i = 0; i < 3; i++){
				for (int j = 0; j < 3; j++){
					if (board[i][j].getString().equals("")){
						board[i][j].getButton().setForeground(new Color(51, 204, 255));
						board[i][j].getButton().setFont(new Font("Purisa", Font.PLAIN, board[i][j].getButton().getHeight())); 
						board[i][j].getButton().setText(getCpuPick());
						board[i][j].getButton().setEnabled(false);
						
						moved = true;
						break;
					}
				}
				if (moved)
					break; 
			}
			setIsCpu(false); 
		}

		public boolean checkWin() {
			 tie = true;
			 for (int i = 0; i < 3; i++){
				 for (int j = 0; j < 3; j++){
					 if (board[i][j].getString().equals("")){
						 tie = false;
						 break;  
					 }
				 }
				 if (!tie)
					 break;
			}
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
		
		public static JFrame getFrame(){
			return frame; 
		}
}