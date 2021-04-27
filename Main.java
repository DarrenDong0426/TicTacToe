import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main {
	
	public static String Player1;
	private static int opponent; 
	public static String Player2; 
	public static Board board; 
	private static int order;
	private static int choice;
	private static String playerPick;
	private static String player2Pick;
	private static String cpuPick;
	private static boolean isPlayer1;
	private static boolean isPlayer2;
	private static boolean isCPU;
	private static boolean vsCPU;
	
	public static void main(String[] args) {
		
		//Ask the user for name
	
		/* Ask user if the opponent is another player or a computer 
		 * 
		 * opponent = 0 if User pick Computer
		 * opponent = 1 if User pick Player
		 * 
		 */
		String[] opponentOption = {"Computer", "Player"}; 
		opponent = JOptionPane.showOptionDialog(null,"Who do you want to play against?", "Choose your opponent", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opponentOption, null);
		
		Player1 = JOptionPane.showInputDialog("Enter the name of Player 1: ");
		
		
		// If the opponent is another player, ask user the name of that player
		if (opponent == 1){
			vsCPU = false;
			Player2 = JOptionPane.showInputDialog("Enter the name of Player 2: ");
			String[]choices = {"X", "O"};
			choice = JOptionPane.showOptionDialog(null, Player1 + ", do you want to be X or O?", "Choose", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, null); 
			if (choice == 0) {
				JOptionPane.showMessageDialog(null, Player1 + " is X and " + Player2 + " is O");
				playerPick = "X";
				player2Pick = "O";
			}
			if (choice == 1) {
				JOptionPane.showMessageDialog(null, Player1 + " is O and " + Player2 + " is X");
				playerPick = "O";
				player2Pick = "X";
			}
			String[] orderOption = {Player1, Player2}; 
			order = JOptionPane.showOptionDialog(null,"Who do you want to have the first move?: ", "Choose who gets the first move", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, orderOption, null); 
			 if(order == 0) {
				 JOptionPane.showMessageDialog(null, Player1 + " goes first!");
				 isPlayer1 = true;
				 isPlayer2 = false;
			 }
			 if(order == 1) {
				 JOptionPane.showMessageDialog(null, Player2 + " goes first!");
				 isPlayer2 = true;
				 isPlayer1 = false; 
			 }
		}
			
		/* If the opponent is a computer, ask user who gets to play first
		 * 
		 * order = 0 if Computer plays first 
		 * order = 1 if Player plays first
		 * 
		 */
		if (opponent == 0){
			vsCPU = true;
			String[]choices = {"X", "O"};
			choice = JOptionPane.showOptionDialog(null, Player1 + ", do you want to be X or O?", "Choose", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, null); 
			if (choice == 0) {
				JOptionPane.showMessageDialog(null, Player1 + " is X and " + "the Computer is O");
				playerPick = "X";
				cpuPick = "O";
			}
			if (choice == 1) {
				JOptionPane.showMessageDialog(null, Player1 + " is O and " + "the Computer is X");
				playerPick = "O";
				cpuPick = "X";
			}
			String[] orderOption = {"Computer", "Player"}; 
			order = JOptionPane.showOptionDialog(null,"Who do you want to have the first move?: ", "Choose who gets the first move", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, orderOption, null);
			 if(order == 0) {
				 JOptionPane.showMessageDialog(null, "Computer goes first!");
				 isCPU = true;
				 isPlayer1 = false;	
			 }
			 if(order == 1) {
				 JOptionPane.showMessageDialog(null, Player1 + " goes first!");
				 isCPU = false;
				 isPlayer1 = true;
				 
			 }
		}
		
		
		
		
		// Create a TicTacToe Board
		board = new Board(); 	
	}

	// Accessor/Setter Methods
	public int getOpponent(){return opponent;}
	public String getPlayer2(){return Player2;}
	public String getPlayer1(){return Player1;}
	public String getPlayerPick(){return playerPick;}
	public String getPlayer2Pick(){return player2Pick;}
	public String getCpuPick(){return cpuPick;}
	public boolean getIsPlayer1(){return isPlayer1;}
	public boolean getIsPlayer2(){return isPlayer2;}
	public boolean getIsCpu(){return isCPU;}
	public boolean getVsCpu(){return vsCPU;}
	public void setIsCpu(boolean b){isCPU = b;}
	public void setIsPlayer1(boolean b){isPlayer1 = b;}
	public void setIsPlayer2(boolean b){isPlayer2 = b;}

	
	
}