import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;


public class CalculatorWindow extends JFrame implements ActionListener {

	NumberButton[]  numberButton;
	OperationButton[] operationButton;
	JButton dot,sign,backSpace,equal,reset,sin;
	JTextField showResult;
	JTextField showComputerProcess;
	JTextArea saveComputerProcess;
	JButton saveButton,copyButton,clearButton;
	LinkedList<String> list;
	HandleDigit handleDigit;
	HandleOperation handleOperation;
	HandleBack handleBack;
	HandleClear handleClear;
	HandleEquality handleEquality;
	HandleDot handleDot;
	HandlePOrN handlePOrN;
	HandleSin handleSin;
	
	public CalculatorWindow() {
		this.setTitle("计算器");
		
		JPanel panelLeft,panelRight;
		list = new LinkedList<String>();
		Font font1 = new Font("Arial", Font.BOLD, 20);
		showResult = new JTextField(10);
		showResult.setHorizontalAlignment(JTextField.RIGHT);
		showResult.setForeground(Color.BLACK);
		showResult.setFont(new Font("Arial", Font.ITALIC, 20));
		showResult.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		showResult.setEditable(false);
		showResult.setBackground(new Color(0xBDFCC9));
		showResult.setText("0");
		showComputerProcess = new JTextField();
		showComputerProcess.setHorizontalAlignment(JTextField.CENTER);
		showComputerProcess.setFont(new Font("Arial", Font.HANGING_BASELINE, 20));
		showComputerProcess.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		showComputerProcess.setBackground(new Color(0xF5DEB3));
		showComputerProcess.setForeground(new Color(0xFF6100));
		showComputerProcess.setEditable(false);
		saveComputerProcess = new JTextArea();
		saveComputerProcess.setEditable(false);
		saveComputerProcess.setFont(new Font("Arial", Font.HANGING_BASELINE, 14));	
		saveComputerProcess.setBackground(new Color(0x87CEEB));
		saveComputerProcess.setForeground(Color.BLUE);
		
		
		numberButton = new NumberButton[10];
		handleDigit = new HandleDigit(list, showResult, showComputerProcess);
		for(int i = 0; i <= 9; i++) {
			numberButton[i] = new NumberButton(i);
			numberButton[i].setFont(font1);
			numberButton[i].addActionListener(handleDigit);
		}
		
		operationButton = new OperationButton[4];
		handleOperation = new HandleOperation(list, showResult, showComputerProcess, saveComputerProcess);
		String[] operator = {"+","-","*","/"};
		for(int i = 0; i < 4; i++) {
			operationButton[i] = new OperationButton(operator[i]);
			operationButton[i].setFont(font1);
			operationButton[i].addActionListener(handleOperation);
		}
		
		dot = new JButton(".");
		dot.setFont(font1);
		handleDot = new HandleDot(list, showResult, showComputerProcess);
		dot.addActionListener(handleDot);
		
		sign = new JButton("+/-");
		sign.setFont(font1);
		handlePOrN = new HandlePOrN(list, showResult, showComputerProcess);
		sign.addActionListener(handlePOrN);
		
		equal = new JButton("=");
		equal.setFont(font1);
		handleEquality = new HandleEquality(list, showResult, showComputerProcess, saveComputerProcess);
		equal.addActionListener(handleEquality);
		
		sin = new JButton("sin");
		sin.setFont(font1);
		handleSin = new HandleSin(list, showResult, showComputerProcess, saveComputerProcess);
		sin.addActionListener(handleSin);
		
		backSpace = new JButton("back");
		handleBack = new HandleBack(list, showResult, showComputerProcess);
		backSpace.addActionListener(handleBack);
		
		reset = new JButton("c");
		reset.setFont(font1);
		handleClear = new HandleClear(list, showResult, showComputerProcess);
		reset.addActionListener(handleClear);
		
		reset.setForeground(Color.RED);
		reset.setBackground(Color.WHITE);
		backSpace.setForeground(Color.RED);
		backSpace.setBackground(Color.WHITE);
		equal.setForeground(Color.RED);
		equal.setBackground(Color.WHITE);	
		sin.setForeground(Color.RED);
		sin.setBackground(Color.WHITE);
		sign.setForeground(Color.BLUE);
		sign.setBackground(Color.YELLOW);
		dot.setForeground(Color.BLUE);
		dot.setBackground(Color.YELLOW);
		
		panelLeft = new JPanel();		
		panelLeft.setLayout(new BorderLayout());
		panelLeft.add(showResult, BorderLayout.NORTH);
		
		JPanel centerInLeft = new JPanel();		
		centerInLeft.setLayout(new GridLayout(4,5));
		for(int i = 1; i <= 3; i++) {
			centerInLeft.add(numberButton[i]);
		}
		centerInLeft.add(operationButton[0]);
		centerInLeft.add(backSpace);
		
		for(int i = 4; i <= 6; i++) {
			centerInLeft.add(numberButton[i]);
		}
		centerInLeft.add(operationButton[1]);
		centerInLeft.add(reset);
		
		for(int i = 7; i <= 9; i++) {
			centerInLeft.add(numberButton[i]);
		}
		centerInLeft.add(operationButton[2]);
		centerInLeft.add(sin);
		
		centerInLeft.add(numberButton[0]);
		centerInLeft.add(sign);
		centerInLeft.add(dot);
		centerInLeft.add(operationButton[3]);
		centerInLeft.add(equal);
		panelLeft.add(centerInLeft, BorderLayout.CENTER);
		
		panelRight = new JPanel();
		panelRight.setLayout(new BorderLayout());
		panelRight.add(showComputerProcess, BorderLayout.NORTH);		
		panelRight.add(new JScrollPane(saveComputerProcess), BorderLayout.CENTER);
		
		saveButton = new JButton("保存");
		copyButton = new JButton("复制");
		clearButton = new JButton("清除");
		saveButton.setToolTipText("保存计算过程到文件…");
		copyButton.setToolTipText("复制选中的计算过程");
		clearButton.setToolTipText("清除计算过程");
		saveButton.addActionListener(this);
		copyButton.addActionListener(this);
		clearButton.addActionListener(this);
		saveButton.setBackground(Color.CYAN);
		copyButton.setBackground(Color.CYAN);
		clearButton.setBackground(Color.CYAN);
		JPanel southInPanelRight = new JPanel();
		southInPanelRight.add(saveButton);
		southInPanelRight.add(copyButton);
		southInPanelRight.add(clearButton);
		panelRight.add(southInPanelRight, BorderLayout.SOUTH);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelLeft,panelRight);
		split.setDividerSize(6);
		split.setEnabled(false);
		
		this.add(split, BorderLayout.CENTER);
		this.pack();
		this.setResizable(false);
		this.setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(528, 258);
		this.setLocationRelativeTo(this);
		this.setVisible(true);
		this.validate();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == copyButton) {
			saveComputerProcess.copy();
		}
		if(e.getSource() == clearButton) {
			saveComputerProcess.setText(null);
		}
		if(e.getSource() == saveButton) {
			JFileChooser chooser = new JFileChooser();
			int state = chooser.showSaveDialog(null);
			File file = chooser.getSelectedFile();
			if(file != null && state ==JFileChooser.APPROVE_OPTION) {
				try {
					Date date = new Date(System.currentTimeMillis());
					//常规方案
					String content = saveComputerProcess.getText();
					StringReader sReader = new StringReader(content);
					BufferedReader bReader = new BufferedReader(sReader);
					FileWriter fWriter = new FileWriter(file,true);
					BufferedWriter bWriter = new BufferedWriter(fWriter);
					String str = null;
					bWriter.newLine();
					bWriter.newLine();
					bWriter.write("保存时间：" + date.toLocaleString());
					bWriter.newLine();
					while((str = bReader.readLine()) != null) {
						bWriter.write(str);
						bWriter.newLine();
					}
					bReader.close();
					bWriter.close();
					JOptionPane.showMessageDialog(this, "计算过程已保存到\n\" " + file.getAbsolutePath() + " \"!", "保存", JOptionPane.INFORMATION_MESSAGE);
					
				/*	//方案2
					String content = saveComputerProcess.getText();
					FileOutputStream out = new FileOutputStream(file);
					out.write(content.getBytes(), 0, content.getBytes().length);
				  	//out.write(content.getBytes());
					out.close();
				*/
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new CalculatorWindow();
	}
}
