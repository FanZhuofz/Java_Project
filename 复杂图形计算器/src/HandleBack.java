import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextField;


public class HandleBack implements ActionListener {

	LinkedList<String> list;
	JTextField showResult;
	JTextField showComputerProcess;
	
	public HandleBack(LinkedList<String> list, JTextField showResult,
			JTextField showComputerProcess) {
		this.list = list;
		this.showResult = showResult;
		this.showComputerProcess = showComputerProcess;
	}

	public void actionPerformed(ActionEvent e) {
		if(list.size() == 1) {
			String num = list.getFirst();
			if(num.length() > 1) {
				num = num.substring(0, num.length()-1);
				list.set(0, num);
				showResult.setText(num);
				showComputerProcess.setText(num);
			} else {
				list.removeLast();
				showResult.setText("0");
				showComputerProcess.setText("0");
			}
		} else if(list.size() == 2) {
			list.removeLast();
			showResult.setText(list.getFirst());
			showComputerProcess.setText(list.getFirst());
		}
		else if(list.size() == 3) {
			String num = list.getLast();
			if(num.length() > 1) {
				num = num.substring(0, num.length()-1);
				list.set(2, num);
				showResult.setText(num);
				showComputerProcess.setText(list.getFirst() + list.get(1) + num);
			} else {
				list.removeLast();
				showResult.setText(list.getFirst());
				showComputerProcess.setText(list.getFirst() + list.get(1));
			}
		}
	}
}
