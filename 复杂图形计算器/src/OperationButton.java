import java.awt.Color;

import javax.swing.JButton;


public class OperationButton extends JButton {
	String operator;
	public OperationButton(String operator) {
		super(operator);
		this.operator = operator;
		this.setForeground(Color.PINK);
		this.setBackground(new Color(0x00C957));
	}
	public String getOperator() {
		return operator;
	}
}
