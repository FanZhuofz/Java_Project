import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class HandleOperation implements ActionListener {

	LinkedList<String> list;
	JTextField showResult;
	JTextField showComputerProcess;
	JTextArea saveComputerProcess;

	public HandleOperation(LinkedList<String> list, JTextField showResult,
			JTextField showComputerProcess, JTextArea saveComputerProcess) {
		this.list = list;
		this.showResult = showResult;
		this.showComputerProcess = showComputerProcess;
		this.saveComputerProcess = saveComputerProcess;
	}

	public void actionPerformed(ActionEvent e) {
		OperationButton b = (OperationButton) e.getSource();
		if(list.size() == 1) {
			String operator = b.getOperator();
			list.add(operator);
			showComputerProcess.setText(list.get(0) + operator);
		}
		else if(list.size() == 2) {
			String operator = (String) b.getOperator();
			list.set(1, operator);
			showComputerProcess.setText(list.get(0) + operator);
		}
		else if(list.size() == 3) {
			String numOne = list.getFirst();
			String numTwo = list.getLast();
			String operator = list.get(1);
			String middleProcess = numOne + operator + numTwo;
			try {
				double n1 = Double.parseDouble(numOne);
				double n2 = Double.parseDouble(numTwo);
				double result = 0;
				if(operator.equals("+")) {
					result = n1 + n2;
				} else if (operator.equals("-")) {
					result = n1 - n2;
				} else if (operator.equals("*")) {
					result = n1 * n2;
				} else if (operator.equals("/")) {
					result = n1 / n2;
				}
				String op = b.getOperator();
				list.clear();
				list.add("" + result);
				list.add(op);
				String process = middleProcess + "=" + result + op;
				showComputerProcess.setText(process);
				saveComputerProcess.append(middleProcess + "=" + result + "\n");
				showResult.setText("" + result);
			}
			catch (RuntimeException e1) {
				e1.printStackTrace();
			}
		}
	}

}
