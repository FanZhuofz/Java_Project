package dawn.java.demo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
public class addForm extends JFrame implements ActionListener
JLabel labell = new JLabel ("添力口基本信息，•，JLabel • CEi\/TEiR); JLabel labxuehao=new JLabel ("学号："r JLabel. CENTER); JLabel labyear=new JLabel ("年龄："r JLabel. CENTER);
JLabel labName=new JLabel ("姓名：n, JLabel. CENTER);
JLabel labDate=new JLabel ("出生H期：", JLabel. CENTER); JLabel labclass=new JLabel (n班级："r JLabel. CENTER); JLabel labzy=new JLabel ("专业："r JLabel. CENTER);
JLabel labmz=new JLabel (” 民族："r JLabel. CENTER);
JLabel labsex = new JLabel (…性另【J: " r JLabel. CENTER); JTextField txtName=new JTextField(20);
JTextField txtDate=new JTextField(18);
JTextField txtXueHao=new JTextField(20);
JTextField txtYear=new JTextField(20);
JTextField txtClass=new JTextField(20);
JTextField txtZY=new JTextField(20);
JTextField txtMZ=new JTextField(20);
ButtonGroup bgp = new ButtonGroup();
JRadioButton man = new JRadioButton("^");
JRadioButton women = new JRadioButton(n^C");
JButton btnAdd=new JButton(”添力口"
JButton btnCancel=new JButton (,fMini");
JButton btnReset = new JButton (,f；##");
JPanel jpl=new JPanel () ;	//创建而板对象
Connection con;
Statement sql; ResultSet rs;
addForm()
{	super ("添加学生信息");
this.setResizable(false); this•setSize(550,450); this.setVisible(true); this•setLocation(300,300> ;
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.add(jpl);
jpl.setLayout(null);
btnAdd.addActionListener(this);
btnReset.addActionListener(this);
btnCancel.addActionListener(this);
jpl.setBackground(Color.cyan);
man.setBackground(Color.cyan);
women.setBackground(Color.cyan);
labell•setBounds(100,20,300,20);
jpl.add(labell);
labxuehao.setBounds(100,50,70,20); jpl.add(labxuehao);
txtXueHao•setBounds(190,50,140,20>; jpl.add(txtXueHao); labName.setBounds(100, 90,70,20); jpl.add(labName);
txtName.setBounds(190,90,140,20);
jpl.add(txtName);
labsex.setBounds(110,130, 60,20);
jpl.add(labsex);
man.setBounds(190,130,60f20);
women.setBounds(270,130,60f20);
jpl.add(man);
jpl.add(women);
bgp.add(man);
bgp.add(women);
labyear.setBounds(100,180,70,20); jpl.add(labyear);
txtYear.setBounds(190,180,140,20); jpl.add(txtYear);
labDate.setBounds(100,210,70,20); jpl.add(labDate);
txtDate•setBounds(190,210,140,20); jpl.add(txtDate); labmz•setBounds(100,240,70,20); jpl.add(labmz);
txtMZ.setBounds(190,240,140,20); jpl.add(txtMZ);
labclass.setBounds(100,270,70,20); jpl.add(labclass);
txtClass•setBounds(190,270,140,20); jpl.add(txtClass); labzy.setBounds(100,300,70,20); jpl.add(labzy);
txtZY•setBounds(190,300,140,20); jpl.add(txtZY);
btnReset•setBounds(80,350,90,20); btnAdd.setBounds(200,350, 90,20); btnCancel•setBounds(320,350, 90,20); jpl•add(btnReset); jpl.add(btnAdd); jpl.add(btnCancel) ; }
public void actionPerformed(ActionEvent e> 
{ if(e.getSource()==btnCancel){ dispose();
new mainFrameO . setVisible (true) ; } if(e.getSource()==btnAdd)
{if (txtXueHao.getText().toString().equals("")){
JOptionPane . showMessageDialog{nullf n请输入学号"，"温馨提不 ，，，JOptionPane . INFORMATION_MESSAGE);
}else if (txtName.getText().toString().equals("")){
JOptionPane .showMessageDialog (null, n请输入姓名■温馨提示 ", JOptionPane . IN FORMAT I ONJAES SAGE);
}else if (txtYear.getText() .toString () .equals("")) {
JOptionPane. showMessageDialog {null r "请输入年龄"，"温馨提示 ”，JOptionPane . INFORMATION_MESSAGE);
}else if (txtDate.getText().toString().equals("")){
JOptionPane . showMessageDialog (null,"出生日期’•，n温馨提示 ，’，JOptionPane . INFORMATION_MESSAGE);
}else if (txtZY.getText().toString().equals("")){
JOptionPane. showMessageDialog (null, ”请输入专业"，"温馨提不 ，，，JOptionPane . INFORMATION_MESSAGE);
}else if (txtMZ.getText().toString().equals("")){
JOptionPane. showMessageDialog {null r "请输入民族"，"温馨提示 ，’，JOptionPane . INFORMATION_MESSAGE);
}else if (txtClass.getText().toString().equals(n")){
JOptionPane. showMessageDialog (null,"请输入班级"，"温馨提示 ", JOptionPane.INFORMATION_MESSAGE);} else{
String sex;
if(man.isSelected())
{ sex="男"；} else
{ sex=” 女"；} try
{Class . f'oriVa/ne (,fsun. jdbc.odbc.JdbcOdbcDriver") ; } catch (ClassNotFoundException ce)
{JOptionPane.showMessageDialog(null, ce.getMessage() ) ; } try{
Connection con = DriverManager. getConnection (f, jdbc: odbc:
学生成绩管理系统"，"而”，"123");
Statement stmt = con.createStatement(); int a = stmt. executeUpdate ("insert into 学籍信息表（学号， 登录密码，姓名，年龄，出生日期，性别，班级，专业，民
5^) values (f ,T+txtXueHao. getText () +ff f, f ,?+00000+,f', ' u+txtName. getText () + ’"，* ”+txtYear•getText()+•" ,f"+txtDate•getText|"+sex+n|"+txtCl ass . getText () +ff f f f ff+txtZY. getText () +n ', 1 "+txtMZ . getText ()+"')")；
if(a==l)
{JOptionPane.s/i〇pWVfessageDialog(null, n已成功添力口”，’’温馨提不 ,f, JOptionPane . INFORMATION_MESSAGE) ; } else
{JOptionPane .showMessageDialog (null,"添加失败n,"温馨提不 ,f, JOptionPane . INFORMATION_MESSAGE) ; } stmt.close();} catch (SQLException se)
{JOptionPane.showMessageDialog(null,se.getMessage());}}} else{ txtClass . setText (; txtZY. setText (,f ,f); txtMZ . setText (,? ,f); txtName . setText (,f ,f); txtDate . setText (,f,?); txtXueHao. setText (,f ,f); txtYear. setText (’"’）； txtXueHao.requestFocus();}} public static void main(String[] args)
{addForm amg = new addForm();}}
