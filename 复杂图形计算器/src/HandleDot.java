import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextField;


public class HandleDot implements ActionListener {

	LinkedList<String> list;
	JTextField showResult;
	JTextField showComputerProcess;
	
	public HandleDot(LinkedList<String> list, JTextField showResult,
			JTextField showComputerProcess) {
		this.list = list;
		this.showResult = showResult;
		this.showComputerProcess = showComputerProcess;
	}

	public void actionPerformed(ActionEvent e) {
		
		String dot = e.getActionCommand();
		if (list.size() == 0) {
			list.add("0.");
			showResult.setText("0.");
			showComputerProcess.setText(list.get(0));
		} else if (list.size() == 1) {
			String num = list.getFirst();
			if (num.indexOf(dot) == -1) {
				num = num.concat(dot);
				list.set(0, num);
				showResult.setText(num);
				showComputerProcess.setText(list.get(0));
			}
		} else if (list.size() == 2) {
			list.add("0.");
			showResult.setText("0.");
			showComputerProcess.setText(list.get(0) + list.get(1) + list.get(2));
		} else if (list.size() == 3) {
			String num = list.getLast();
			if (num.indexOf(dot) == -1) {
				num = num.concat(dot);
				list.set(2, num);
				showResult.setText(num);
				showComputerProcess.setText(list.get(0) + list.get(1) + list.get(2));
			}
		}	
	}
}
