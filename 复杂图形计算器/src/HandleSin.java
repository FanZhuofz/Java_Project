import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class HandleSin implements ActionListener {

	LinkedList<String> list;
	JTextField showResult;
	JTextField showComputerProcess;
	JTextArea saveComputerProcess;
	
	public HandleSin(LinkedList<String> list, JTextField showResult,
			JTextField showComputerProcess, JTextArea saveComputerProcess) {
		this.list = list;
		this.showResult = showResult;
		this.showComputerProcess = showComputerProcess;
		this.saveComputerProcess = saveComputerProcess;
	}

	public void actionPerformed(ActionEvent e) {
		if(list.size() == 1 || list.size() == 2) {
			String num = list.getFirst();
			try {
				double n1 = Double.parseDouble(num);
				n1 = Math.sin(n1*Math.PI/180);
				String result = String.valueOf(n1);
				list.set(0, result);
				showResult.setText(result);
				String process = "sin(" + num + ")=" + result;
				showComputerProcess.setText(process);
				saveComputerProcess.append(process + "\n");
				if(list.size() == 2) {
					list.removeLast();
				}
			}
			catch(RuntimeException e1) {
				e1.printStackTrace();
			}
		} else if (list.size() == 3) {
			String num = list.getLast();
			try {
				double d = Double.parseDouble(num);
				d = Math.sin(d*Math.PI/180);
				String num2 = String.valueOf(d);
				list.set(2, num2);
				String numOne = list.getFirst();
				String numTwo = list.getLast();
				String operator = list.get(1);
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
				String process = numOne + operator + "sin(" + num + ")" + "=" + result;
				showResult.setText("" + result);
				showComputerProcess.setText(process);
				saveComputerProcess.append(process + "\n");
				list.clear();
				list.add("" + result);
			} catch(RuntimeException e2) {
				e2.printStackTrace();
			}
		}
	}

}
