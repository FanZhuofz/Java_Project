package dawn.java.demo;

import j ava.awt.*;
import javax.swing. import java.awt.event. import java.sql.*;
public class addScore extends JFrame implements ActionListener {static addScore ss;
JLabel[] label = {new JLabel ("学号："），new JLabel ("it•算机网络："), new JLabel ("Linux操作系统："),new JLabel ("计算机专业英语："）,new JLabel (,f 计算机信息技术基础："> ,new JLabel(”Java程序设计："> ,new JLabel ("数据库应 用实训教程：, new JLabel ("高等数学：，•），new JLabel ("XML: ")};
JTextField[] txt = {new JTextField() , new JTextFieldO , new JTextField() , new JTextFieldO , new JTextFieldO ,new JTextFieldO , new JTextFieldO , new JTextFieldO , new JTextFieldO };
JButton add = new JButton (n添力lln);
JButton reset = new JButton ("重置"）；
JButton Cancel=new JButton ("返[H]");
JPanel jpl = new JPanel();
JLabel title = new JLabel ("添加学生成绩"，JLabel. CENTER);
Font f = new Font (” 黑体"，Font. BOLD , 16 ); int s=100; public addScore()
{
super ("添加学生信息”); this.setResizable(false); this.setSize(500, 600);
this.setDefaultCloseOperation(EXIT_ON_CLOSE); this.setVisible(true); this.add(jpl);
Cancel.addActionListener(this);
add.addActionListener(this);
reset.addActionListener(this);
jpl.setLayout(null);
title.setBounds(150,40,200,20);
title.setFont(f);
title.setForeground(Color.red);
jpl.setBackground(Color.LIGHT_GRAY);
jpl.add(title);
for(int i = 0 ; i <label.length ; i++)
{
label[i].setBounds(100,3,140,20); jpl.add(label[i]); txt[i].setBounds(260,s,140,20>; jpl.add(txt[i]); s=s+40;
add.setBounds(100,s,80,20); reset.setBounds(200,3,80,20);
Cancel•setBounds(300,s,80,20); jpl.add(add); jpl.add(reset); jpl.add(Cancel);
}
public void actionPerformed(ActionEvent e)
{
if (e.getSource()==Cancel){ dispose();
new mainFrameO . setVisible (true);
}
else if(e.getSource()==add)
{try
{Class . r〇riVa/ne (,fsun. jdbc. odbc. JdbcOdbcDriver") ; } catch (ClassNotFoundException ce)
{JOptionPane.showMessageDialog(ss/ce.getMessage());} try {Connection con = DriverManager. getConiiection (f, jdbc:odbc: 学生成绩管理系统"，"ww", ”123");
Statement stmt = con.createStatement(); int a = stmt • executeUpdate ("insert into 成绩信息表（学号,计 算机网络，Limix操作系统，计算机专业英语，计算机信息技术基础，Java程序设计， 数据库应用实训教程，高等数学，
Xml) values (f f?+txt [0] .getText () +,f', ' ,f+txt [1] .getText ()+"', ' "+txt [2] .ge tText () +f, 1 / 1 n+txt [3] .getText () +,f', ' u+txt [4] .getText () +" ' f ' "+txt [5] .ge tText () +,f 1, 1 ,f+txt [6] .getText () +,f', ' ,f+txt [7] .getText () +" ', ' "+txt [8] .ge tText ()+，">，，）； if (a==l)
{JOptionFane. showMessageDialog{ssr	) ; }
else
{JOptionPane • s/iopWVfessageDialog(ss,"添加失败n) ;}} catch (SQLException se)
{JOptionPane.showMessageDialog(ssfse.getMessage() ) ;	}}
else
{for(int i = 0 ; i<txt.length ; i++)
{txt [ i ] . setText (,f H); txt[0].requestFocus();	}}}
public static void main(String[] args)
{addScore as = new addScore();}}
