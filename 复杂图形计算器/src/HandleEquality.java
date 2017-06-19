import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class HandleEquality implements ActionListener {
	
	LinkedList<String> list;
	JTextField showResult;
	JTextField showComputerProcess;
	JTextArea saveComputerProcess;
	
	HandleEquality(LinkedList<String> list, JTextField showResult,
			JTextField showComputerProcess, JTextArea saveComputerProcess) {
		this.list = list;
		this.showResult = showResult;
		this.showComputerProcess = showComputerProcess;
		this.saveComputerProcess = saveComputerProcess;
	}

	public void actionPerformed(ActionEvent e) {
		if(list.size() == 2) {
			String num = list.getFirst();
			String op = list.getLast();
			try {
				double n1 = Double.parseDouble(num);
				double n2 = Double.parseDouble(num);
				double result = 0;
				if(op.equals("+")) {
					result = n1 + n2;
				} else if (op.equals("-")) {
					result = n1 - n2;
				} else if (op.equals("*")) {
					result = n1 * n2;
				} else if (op.equals("/")) {
					result = n1 / n2;
				}
				showResult.setText("" +result);
				String process = num + op + num + "=" + result;
				showComputerProcess.setText(process);
				saveComputerProcess.append(process + "\n");
				list.set(0, result + "");
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			}
		}
		else if(list.size() == 3) {
			String numOne = list.getFirst();
			String numTwo = list.getLast();
			String operator = list.get(1);
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
				String process = numOne + operator + numTwo + "=" + result;
				showResult.setText("" + result);
				showComputerProcess.setText(process);
				saveComputerProcess.append(process + "\n");
				list.clear();
				list.add("" + result);
			}
			catch (RuntimeException e1) {
				e1.printStackTrace();
			}
		}
	}
}
