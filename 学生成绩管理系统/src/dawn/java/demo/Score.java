package dawn.java.demo;

import j ava.awt.*; 
import j avax.swing.*; 
import java.awt.event;
import java.awt.font.*
import java.sql.*;
public class Score extends JFrame implements ActionListener { static Score s;
JLabel title = new JLabel ("査询成绩"，JLabel •	;
Font f = new Font	Font .BOLD+Font. ITALIC, 16);
JPanel jpl = new JPanel();
JLabel labell = new JLabel (n请输入学号：n, JLabel. CENTER); new JTextField(); new JButton ("査询成绩"）； new JButton("重置
new JLabel ("计算机网络：M, JLabel. LEFT); new JLabel ("Linux操作系统：",JLabel. LEFT); new JLabel (••计算机专业英语：JLabel • LEfT); new JLabel ("计算机信息技术基础："，JLabel • LEFT); new JLabel ("Java 程序设计："，JLabel • LEJFT); new JLabel ("数据库：", JLabel • LEFT); new JLabel ("高等数学：n, JLabel. LEFT); 
JLabel label9 = new JLabel (,fXML： ", JLabel.LEFT);
JButton Cancel=new JButton("返回
JTextField[] txt ={ new JTextFieldO , new JTextField() , new JTextField () , new JTextField () , new JTextField () , new JTextField () JTextField() , new JTextFieldO); static int p = 140; public Score()
{	super (n査询分数"）；
this•setResizable(false);
this.setSize(500,550);
this.setVisible(true);
title.setForeground(Color.red);
jpl.setBackground(Color.LIGHT_GRAY);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
title.setFont(f);
this.add(jpl);
jpl.setLayout(null);
title.setBounds(100,20,300,20);
jpl.add(title);
label1.setBounds(100,60,90,20); jpl.add(label1); num.setBounds(210, 60,140,20); jpl.add(num);
serch.setBounds(100,100,90,20); reset•setBounds(200,100,90,20);
Cancel.setBounds(300,100, 90,20);
jpl.add(serch);
jpl.add(reset);
jpl.add(Cancel);
serch.addActionListener(this);
reset.addActionListener(this);
Cancel.addActionListener(this); label2.setBounds(100,140,140,20); label3.setBounds(100,180,140,20); label4•setBounds(100,220,140,20); label5.setBounds(100,260,140,20); label6.setBounds(100,300,140,20); label7•setBounds(100,340,140,20); label8•setBounds(100,380,140,20); label9•setBounds(100,420,140,20); jpl.add(label2); jpl.add(label3); jpl.add(label4); jpl.add(label5); 
jpl.add(label6); jpl.add(label7); jpl.add(label8); jpl.add(label9);
for(int i = 0 ;i<txt.length ; i++)
{txt [i] . setBounds (260,p, 140,20) ,• jpl.add(txt[i]); p=p+40;}}
public void actionPerformed(ActionEvent e)
{if(e.getSource()==Cancel){ dispose();
new mainFrameO . setVisible (true) ;	}
if(e.getSource()==serch)
{String id = num.getText();
try {Class . ToriVa/ne (,f sun. jdbc. odbc. JdbcOdbcDriver1') ; } catch (ClassNotFoundException ce)
{JOptionPane.showMessageDialog{srce.getMessage());} try {Connection con = DriverManager. getConnection (T, jdbc: odbc: 学生成绩管理系统"，"而”，"123");
Statement stmt = con.createStatement();
ResultSet rs = stmt. executeQuery ("select * from 成绩信息 表 where 学号=’"+ 土(1+"’"）； while(rs.next())
{for(int i = 0 ; i<txt.length ; i++)
{txt[i].setText(rs.getString(i+2));}}} catch (SQLException se)
{JOptionPane.showMessageDialog(s, se.getMessage());}} else
{for(int i = 0;i<txt.length ; i++)
{txt [ i ]• setText ('"’）； } num. setText ('"’）；} }
public static void main(String[] args)
{Score s = new Score();}}
