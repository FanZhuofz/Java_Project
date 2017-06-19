package dawn.java.demo;

import j avax.swing.*; import j ava.awt.*; import java.awt.event. import java.sql.*;
public class deleteForm extends JFrame implements ActionListener { JPanel jpl = new JPanelO;
JLabel SCH = new JLabel (”删除学生信息，'，JLabel • CEATrEiR);
Font f = new Font (f Font. BOLD+Font. ITALIC, 30);
JLabel labell = new JLabel ("请输入学号：M, JLabel. CENTER); JButton btnQuery = new JButton("査询’’）；
JLabel label2 = new JLabel ("姓名：",JLabel. CENTER);
JLabel labyear=new JLabel (”年龄："r JLabel. CENTER);
JLabel labDate=new JLabel ('’出生日期："r JLabel. CENTER);
JLabel label5 = new JLabel (M,性另U: u r JLabel. CENTER);
JLabel label3 = new JLabel ("班级："r JLabel. CENTER);
JLabel label4 = new JLabel ("专业：”，JLabel. CENTER);
JLabel labmz=new JLabel ("民族：n, JLabel. CENTER);
ButtonGroup bgp = new ButtonGroup();
JRadioButton man = new JRadioButton("男n);
JRadioButton women = new JRadioButton("女"）；
JTextField tyear = new JTextField();
JTextField tDate = new JTextField();
JTextField tmz = new JTextField();
JTextField num = new JTextField();
JTextField nam = new JTextField();
JTextField clas = new JTextField();
JTextField scl = new JTextField();
JButton btnDelete = new JButton(n删除">;
JButton btnCancel = new JButton("取消"）；
Connection con;
Statement sql;
ResultSet rs; int re; deleteForm()
{ this.setSize(560,460); this.setVisible(true); this.setResizable(false);
SCH.setForeground(Color.red);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); this.add(jpl);
jpl.setBackground(Color.cyan); man.setBackground(Color.cyan); women.setBackground(Color.cyan); jpl.setLayout(null); btnQuery.addActionListener(this); btnDelete.addActionListener(this); btnCancel.addActionListener(this);
SCH.setBounds(100,20,300,20); jpl.add(SCH);
label1.setBounds(100,60,100,20); jpl.add(label1); num.setBounds(220,60,140,20); jpl.add(num);
btnQuery•setBounds(120,100, 90,20);
btnDelete•setBounds(230,100,90,20);
btnCancel•setBounds(340,100,90,20〉；
jpl.add(btnQuery);
jpl.add(btnDelete);
jpl.add(btnCancel);
label2•setBounds(100,150,70,20);
jpl.add(label2);
nam.setBounds(190,150,140,20);
jpl.add(nam);
labyear.setBounds(100,180,70,20);
jpl.add(labyear);
tyear.setBounds(190,180,140,20);
jpl•add(tyear);
labDate•setBounds(100,210,70,20); jpl.add(labDate); tDate.setBounds(190,210,140,20); jpl.add(tDate);
label5.setBounds(100,250,70,20);
jpl.add(label5);
man.setBounds(205,250, 60,20);
women.setBounds(285,250, 60,20);
bgp.add(man);
bgp.add(women);
jpl.add(man);
jpl.add(women);
label3•setBounds(100,290,70,20); jpl.add(label3); clas.setBounds(190,290,140,20); jpl.add(clas);
label4.setBounds(100,320,70,20); jpl.add(label4); scl.setBounds(190,320,140,20); jpl.add(scl);
labmz•setBounds(100,350,70,20); jpl.add(labmz);
tmz.setBounds(190,350,140,20); jpl.add(tmz);
btnDelete . setEnabled (false) ;//取消删除按钮的功能
nam.setEditable(false);
tyear.setEditable(false);
tDate.setEditable(false);
clas.setEditable(false);
scl.setEditable(false);
tmz.setEditable(false);
setVisible(true);
num.requestFocus();
}
public void actionPerformed(ActionEvent ae)
{ if(ae.getSource()==btnCancel){
dispose();new mainFrame().setVisible(true);} else if(ae.getSource()==btnQuery){
try {Class. ^oriVa/ne (,f sun. jdbc. odbc. JdbcOdbcDriver") ; } catch(ClassNotFoundException e){} try {con=DriverManager • getCannectioii ("jdbc: odbc:学生成绩管理系统
sql=con.createStatement();
rs=sql. executeQuery ("select * from 学籍信息表 where 学号 =，”+num.getText ()+"，’’）；
if(rs.next()){
num. setText (rs .getString ("学号’’））；
nam. setText (rs .getString ("姓名"> );
tyear • setText (rs .getString ("年龄"）• toString (> > ;
tDate.setText (rs.getString ("出生日期’’））；
if (rs .getString ("性另丨J") .equals ("男"> >
{man.setSelected(true);} else
{women.setSelected(true);} clas • setText (rs .getString ("班级n)); scl • setText (rs .getString ("专业"））； tmz • setText (rs . getString ("民族"> ); btnDelete.setEnabled(true); nam.setEditable(true); tyear.setEditable(true); tDate.setEditable(true); clas.setEditable(true); scl.setEditable(true); tmz.setEditable(true);
} else {JOptionPane. showMessageDialog {null, ’’不存在该记录！ ", ,T 温馨提示",JOptionPane. INFORMATION一MESSAGE);
btnDelete.setEnabled(false); tyear. setText (,f ,f); tDate. setText (11 n); tmz . setText (f, n); num. setText (f? n); nam • set Text (’’"）； clas • setText (’"’）； scl • setText (’"’）； num.requestFocus(); nam.setEditable(false); tyear.setEditable(false); tDate.setEditable(false); clas.setEditable(false); scl.setEditable(false); tmz.setEditable(false);}
}catch(SQLException e){}}
else if (ae .getSource () == btnDelete)	//实现删除功能
{try{
con=DriverManager. getConnection (" jdbc: odbc:
理系统"，"ww", "123
sql=con.createStatement();
re=sql. executeUpdate ("DELETE FROM 学籍信息 表 where 学号=* "+num. get Text ()+"•"> ;
if(re==l)
{JOptionPane. showMessageDialog (null,
JOptionPane . INFORMATION_MESSAGE) ; } else
{JOptionPane• showMessageDialogr(null,"记录删除失败！
, JOptionPane . INFORMATION_MESSAGE);) sql.close();} catch (SQLException se)
{JOptionPane.showMessageDialog{null,se.getMessage());}} else{ btnDelete.setEnabled(false); tyear•setText(”"）； tDate. setText (,f ,f); tmz•setText; num. setText ('"’）； nam. setText (,f ,f); clas • setText (•"’）； scl. setText (,,H); num.requestFocus (); nam.setEditable(false); tyear.setEditable(false); tDate.setEditable(false); clas.setEditable(false); scl.setEditable(false); tmz.setEditable(false); }} public static void main(String[] args)
{ new deleteForm();}}