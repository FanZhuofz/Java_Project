import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextField;


public class HandlePOrN implements ActionListener {

	LinkedList<String> list;
	JTextField showResult;
	JTextField showComputerProcess;
	
	public HandlePOrN(LinkedList<String> list, JTextField showResult,
			JTextField showComputerProcess) {
		this.list = list;
		this.showResult = showResult;
		this.showComputerProcess = showComputerProcess;
	}

	public void actionPerformed(ActionEvent e) {
		if (list.size() == 1) {
			String num = list.getFirst();
			try {
				double d = Double.parseDouble(num);
				d = -1 * d;
				num = String.valueOf(d);
				list.set(0, num);
				showResult.setText(num);
				showComputerProcess.setText(num);
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			}
		} else if (list.size() == 3) {
			String num = list.getLast();
			try {
				double d = Double.parseDouble(num);
				d = -1 * d;
				num = String.valueOf(d);
				list.set(2, num);
				showResult.setText(num);
				showComputerProcess.setText(list.get(0) + list.get(1) + list.get(2));
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			}
		}	
		
	}

}
