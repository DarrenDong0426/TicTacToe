import javax.swing.*; 

public class Main {

	public static void main(String[] args) {
		
		/* Ask user if the opponent is another player or a computer 
		 * 
		 * opponent = 0 if User pick computer
		 * opponent = 1 if User pick player
		 * 
		 */
		
		String[] options1 = {"Computer", "Player"}; 
		int opponent = JOptionPane.showOptionDialog(null,"Who do you want to play against?: ", "Choose your opponent", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
		
		// Create a TicTacToe Board
		Board board = new Board(); 
		
		
		
	}

}
