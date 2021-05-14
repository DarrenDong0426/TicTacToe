package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends Main {

	private Button[][] board;
	private static JFrame frame; 
	public static JLabel label;
	private static boolean tie = false; 
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
	private JPanel infoPanel;
	private JPanel boardPanel; 
	

	public Board(){
		
		infoPanel = new JPanel(); 

		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(3, 3, 0, 0));

		label = new JLabel();
		frame = new JFrame(); 
		infoPanel.add(label);
		frame.add(infoPanel, BorderLayout.NORTH); 
		frame.add(boardPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic-Tac-Toe");
		
	    frame.setSize(650, 650);
	
	    frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	    frame.setResizable(true); 
	   
		
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
									if (checkWin().equals("none")){
										button.getButton().removeActionListener(this);
										CpuMove();
										if (checkWin().equals("none")){
											setIsCpu(false); 
										}
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
						if (checkWin().equals("Player")) {
							JOptionPane.showMessageDialog(frame, getPlayer1() + " is the winner!");
							String Option[] = {"Yes", "No"};
							int Answer = JOptionPane.showOptionDialog(null,"Replay?", "Do you want to play again?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, Option, null);
							if (Answer == 0){
								frame.setVisible(false);
								main(null); 
							}
							if (Answer == 1)
								System.exit(0);
						}
						if (checkWin().equals("opponent")){
							JOptionPane.showMessageDialog(frame, getPlayer2() + " is the winner!");;
							String Option[] = {"Yes", "No"};
							int Answer = JOptionPane.showOptionDialog(null,"Replay?", "Do you want to play again?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, Option, null);
							if (Answer == 0){
								frame.setVisible(false);
								main(null); 
							}
							if (Answer == 1)
								System.exit(0);
						}
						if (checkWin().equals("tie")){
							JOptionPane.showMessageDialog(frame, "It's a tie! No one is the winner!");
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
		if (getIsCpu()){
			for (int i = 0; i < 3; i++){
				for (int j = 0; j < 3; j++){
					board[i][j].getButton().setForeground(Color.WHITE);
				}
			}
			label.setText("CPU is deciding... Do not make a move."); 
			label.setFont(new Font("Purisa", Font.PLAIN,20));
			label.setForeground(new Color(51, 51, 51));
			CpuMove();
			label.setText(Player1 + " it is your turn"); 
			label.setFont(new Font("Purisa", Font.PLAIN,40));
			
		}
		if (getIsPlayer1()){
			label.setText(Player1 + " it is your turn");  
			label.setFont(new Font("Purisa", Font.PLAIN,40));
			label.setForeground(new Color(51, 51, 51));
			
		}
			
	} 

	
		
	public void CpuMove(){
		int score = Integer.MIN_VALUE; 
		int index1 = 0, index2 = 0;
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if (board[i][j].getString().equals("")){
					board[i][j].getButton().setText(getCpuPick());
					int value = minimax(false);
					board[i][j].getButton().setText("");
					if (value > score){
						score = value; 
						index1 = i;
						index2 = j; 
					}
				}
			}
		}
		board[index1][index2].getButton().setText(getCpuPick());
		board[index1][index2].getButton().setForeground(new Color(51, 204, 255));
		board[index1][index2].getButton().setFont(new Font("Purisa", Font.PLAIN, board[index1][index2].getButton().getHeight())); 
		board[index1][index2].getButton().setEnabled(false);
		setIsCpu(false); 
	}
	
	public int minimax(boolean max){
		
		if (checkWin().equals("Player")) {
			return -10; 
		}
		if (checkWin().equals("opponent")){
			return 10; 
		}
		if (checkWin().equals("tie")){
			return 0; 
		}
		
		
		if (max == true){
			int score = Integer.MIN_VALUE;
			for (int i = 0; i < 3; i++){
				for (int j = 0; j < 3; j++){
					if (board[i][j].getString().equals("")){
						board[i][j].getButton().setText(getCpuPick());
						int value = minimax(false);
						board[i][j].getButton().setText("");
						score = Math.max(value, score);
					}
				}
			}
			return score;
		}
		
		else{
			int score = Integer.MAX_VALUE;
			for (int i = 0; i < 3; i++){
				for (int j = 0; j < 3; j++){
					if (board[i][j].getString().equals("")){
						board[i][j].getButton().setText(getPlayerPick());
						int value = minimax(true);
						board[i][j].getButton().setText("");
						score = Math.min(value, score);
					}
				}
			}
			return score; 
			
		}
		
	}
	
		public String checkWin() {
			 
			for (int i = 0; i < 3; i++){
				if (board[i][0].getString().equals(getPlayer2Pick()) && board[i][0].getString().equals(board[i][1].getString()) && board[i][0].getString().equals(board[i][2].getString()))
					return "opponent";
			}
			for (int j = 0; j < 3; j++){
				if (board[0][j].getString().equals(getPlayer2Pick()) && board[0][j].getString().equals(board[1][j].getString()) && board[0][j].getString().equals(board[2][j].getString()))
					return "opponent";	
			}
			if (board[0][0].getString().equals(getPlayer2Pick()) && board[0][0].getString().equals(board[1][1].getString()) && board[0][0].getString().equals(board[2][2].getString()))
				return "opponent";
			if (board[0][2].getString().equals(getPlayer2Pick()) && board[0][2].getString().equals(board[1][1].getString()) && board[0][2].getString().equals(board[2][0].getString()))
				return "opponent";
			
			
			for (int i = 0; i < 3; i++){
				if (board[i][0].getString().equals(getPlayerPick()) && board[i][0].getString().equals(board[i][1].getString()) && board[i][0].getString().equals(board[i][2].getString()))
					return "Player";
			}
			for (int j = 0; j < 3; j++){
				if (board[0][j].getString().equals(getPlayerPick()) && board[0][j].getString().equals(board[1][j].getString()) && board[0][j].getString().equals(board[2][j].getString()))
					return "Player";	
			}
			if (board[0][0].getString().equals(getPlayerPick()) && board[0][0].getString().equals(board[1][1].getString()) && board[0][0].getString().equals(board[2][2].getString()))
				return "Player";
			if (board[0][2].getString().equals(getPlayerPick()) && board[0][2].getString().equals(board[1][1].getString()) && board[0][2].getString().equals(board[2][0].getString()))
				return "Player";
			
			 tie = true;
			 for (int i = 0; i < 3; i++){
				 for (int j = 0; j < 3; j++){
					 if (board[i][j].getString().equals("")){
						 tie = false;
						 break;  
					 }
				 }
			}
			 if (tie)
				 return "tie"; 
			 
			return "none"; 
		}
}