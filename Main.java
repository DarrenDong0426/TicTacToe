import javax.swing.*; 

public class Main {
	
	private static String Player1;
	private static int opponent; 
	private static String Player2; 
	private static Board board; 
	
	public static void main(String[] args) {
		
		//Ask the user for name
		Player1 = JOptionPane.showInputDialog("Enter the name of Player 1: ");
		
		/* Ask user if the opponent is another player or a computer 
		 * 
		 * opponent = 0 if User pick Computer
		 * opponent = 1 if User pick Player
		 * 
		 */
		String[] opponentOption = {"Computer", "Player"}; 
		opponent = JOptionPane.showOptionDialog(null,"Who do you want to play against?: ", "Choose your opponent", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opponentOption, null);
		
		
		// If the opponent is another player, ask user the name of that player
		if (opponent == 1){
			Player2 = JOptionPane.showInputDialog("Enter the name of Player 2: ");
		}
			
		/* If the opponent is a computer, ask user who gets to play first
		 * 
		 * order = 0 if Computer plays first 
		 * order = 1 if Player plays first
		 * 
		 */
		if (opponent == 0){
			String[] orderOption = {"Computer", "Player"}; 
			int order = JOptionPane.showOptionDialog(null,"Who do you want to have the first move?: ", "Choose who gets the first move", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, orderOption, null); 
		}
		
		// Create a TicTacToe Board
		board = new Board(); 	
	}

	// Accessor Methods
	public int getOpponent(){return opponent;}
	public String getPlayer2(){return Player2;}
	
	
}
