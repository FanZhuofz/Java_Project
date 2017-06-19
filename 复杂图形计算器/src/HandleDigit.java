import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextField;


public class HandleDigit implements ActionListener {

	LinkedList<String> list;
	JTextField showResult;
	JTextField showComputerProcess;
	
	public HandleDigit(LinkedList<String> list, JTextField showResult,
			JTextField showComputerProcess) {
		this.list = list;
		this.showResult = showResult;
		this.showComputerProcess = showComputerProcess;
	}
	
	public void actionPerformed(ActionEvent e) {
		NumberButton b = (NumberButton) e.getSource();
		if(list.size() == 0) {
			int number = b.getNumber();
			list.add("" + number);
			showResult.setText(list.get(0));
			showComputerProcess.setText(list.get(0));
		}
		else if(list.size() == 1) {
			int number = b.getNumber();
			String num = list.getFirst();
			String s = num.concat("" + number);
			list.set(0, s);
			showResult.setText(s);
			showComputerProcess.setText(s);
		}
		else if(list.size() == 2) {
			int number = b.getNumber();
			list.add("" + number);
			showResult.setText(list.get(2));
			showComputerProcess.setText(list.get(0) + list.get(1) + list.get(2));
		}
		else if(list.size() == 3) {
			int number = b.getNumber();
			String num = list.getLast();
			String s = num.concat("" + number);
			list.set(2, s);
			showResult.setText(s);
			showComputerProcess.setText(list.get(0) + "" + list.get(1) + list.get(2));		
		}
	}
}
