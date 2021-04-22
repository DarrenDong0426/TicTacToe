import javax.swing.JButton;


public class Button {

	private int index1;
	private int index2;
	private JButton button; 
		
	public Button(int i, int j){
		
		index1 = i;
		index2 = j;
		button = new JButton();
	}
	
	public JButton getButton(){return button;}
	
}
