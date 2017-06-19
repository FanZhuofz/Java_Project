import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextField;


public class HandleClear implements ActionListener {

	LinkedList<String> list;
	JTextField showResult;
	JTextField showComputerProcess;
	
	public HandleClear(LinkedList<String> list, JTextField showResult,
			JTextField showComputerProcess) {
		this.list = list;
		this.showResult = showResult;
		this.showComputerProcess = showComputerProcess;		
	}

	public void actionPerformed(ActionEvent e) {
		list.clear();
		showResult.setText("0");
		showComputerProcess.setText(null);
	}

}
