import java.awt.Color;

import javax.swing.JButton;


public class NumberButton extends JButton{
	
	int number;
	
	public NumberButton(int number) {
		super("" + number);
		this.number = number;
		this.setForeground(Color.BLUE);
		this.setBackground(Color.YELLOW);
	}
	
	public int getNumber() {
		return number;
	}	
}
