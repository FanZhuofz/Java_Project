package dawn.java.demo;

import j ava.awt.*; import j avax.swing.*; import java.awt.event. import java.sql.*;
public class Serch extends JFrame implements ActionListener { static Serch s;
JPanel jpl = new JPanel();
JLabel SCH = new JLabel ("査询学生信息，、JLabel • CEATTE只）； JLabel labell = new JLabel ("请输入学号：M f JLabel. CENTER); JButton serch = new JButton (”査询n > ;
JLabel label2 = new JLabel ("姓名：",JLabel. CENTER); JLabel labyear=new JLabel ("年龄："r JLabel. CENTER);
JLabel labDate=new JLabel ("出生日期："r JLabel. CENTER); JLabel label5 = new JLabel (…性另U: \ JLabel. CENTER); JLabel label3 = new JLabel ("班级•• ", JLabel. CENTER); JLabel label4 = new JLabel ("专业："r JLabel. CENTER); JLabel labmz=new JLabel (” 民族："f JLabel. CENTER);
ButtonGroup bgp = new ButtonGroup(); JRadioButton man = new JRadioButton("男"）； JRadioButton women = new JRadioButton(); JTextField tyear = new JTextField(); JTextField tDate = new JTextField(); JTextField tmz = new JTextField(); JTextField num = new JTextField(); JTextField nam = new JTextField(); JTextField clas = new JTextField(); JTextField scl = new JTextField();
JButton reset = new JButton ("重置;
JButton caln = new JButton ("取消n); public Serch()
{ this.setSize(560,4 60); this.setVisible(true);
this.setResizable(false);
this.setDefaultCloseOperation{JFrame.EXIT_ON_CLOSE); this.add(jpl);
jpl.setBackground(Color.cyan); man.setBackground(Color.cyan); women.setBackground(Color.cyan); jpl.setLayout(null); serch.addActionListener(this); reset.addActionListener(this); caln.addActionListener(this);
SCH.setBounds(100,20,300,20); jpl.add(SCH);
label1.setBounds(100, 60,100,20); jpl.add(label1); num.setBounds(220, 60,140,20); jpl.add(num);
serch.setBounds(120,100,90,20); reset•setBounds(230,100, 90,20); caln•setBounds(340,100,90,20); jpl.add(serch); jpl.add(reset); jpl.add(caln);
label2.setBounds(100,150,70,20); jpl.add(label2); nam.setBounds(190,150,140,20); jpl.add(nam);
labyear.setBounds(100,180,70,20);
jpl.add(labyear);
tyear•setBounds(190,180,140,20〉； jpl.add(tyear);
labDate•setBounds(100,210,70,20); jpl.add(labDate); tDate•setBounds(190,210,140,20〉； jpl.add(tDate);
label5 • setBounds (100,250,70,20) ,•
jpl.add(label5);
man.setBounds(205,250, 60,20);
women.setBounds(285,250, 60,20);
bgp.add(man);
bgp.add(women);
jpl.add(man);
jpl.add(women);
label3•setBounds(100,290,70,20〉； jpl.add(label3); clas . setBounds (190,290,140,20) ,• jpl.add(clas);
label4.setBounds(100,320,70,20); jpl.add(label4); scl.setBounds(190,320,140,20); jpl.add(scl);
labmz•setBounds(100,350,70,20); jpl.add(labmz);
tmz•setBounds(190,350,140,20); jpl.add(tmz);}
public void actionPerformed(ActionEvent e)
{if(e.getSource()==caln){ dispose();
new mainFrame().setVisible(true);} else if(e.getSource()== serch){
try{Class. f'orNa/neC1 sun. jdbc.odbc.JdbcOdbcDrivern) ; } catch(ClassNotFoundException se){}
try {Connection con=DriverManager. getConnection (fl jdbc: odbc: 学生成绩管理系统"，"ww", ”123");
Statement stmt=con.createStatement();
ResultSet rs = stmt. executeQuery ("select * from 学籍信息表 where 学号=* n +num • get Text () + ” * n);
if (rs .next () > {num. setText (rs .getString ("学号"））； nam • setText (rs • get String ("姓名 n)); tyear.setText (rs.getString ("年龄"）.1:〇31:：1：:1119()>; tDate • setText (rs .getString ("出生日期’’））； if (rs .getString ("性另！J") .equals ("男n))
{man.setSelected(true);} else 
{women.setSelected(true);} clas • setText (rs .getString ("班级">>; scl • setText (rs .getString ("专业"））； tmz.setText (rs.getString ("民族n> ); }else{JOptionPane.showMessageDialog{nullr ”,，，温馨提示",JOptionPane. INFORMATION一MESSAGE);
tyear.setText("n); tDate . setText (f, T,); tmz . setText (f, 11); num.setText(""); nam.setText(""); clas • setText (’"’）； scl • setText (’"’）； num.requestFocus();}
}catch(SQLException se){}}} public static void main(String[] args)
{Serch sch = new Serch();}}
