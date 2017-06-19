package dawn.java.demo;

import javax.swing. import j ava.awt.*; import java.awt.event import java.sql.*;
public class modifyForm extends JFrame implements ActionListener
JPanel jpl = new JPanel();
JLabel SCH = new JLabel ("修改学生信息"，JLabel • CEA/T邮； Font f = new Font ("梢体"，Font. BOLD+Font. ITALIC, 30); JLabel labell = new JLabel ("请输入学号：M, JLabel. CENTER); JButton btnQuery = new JButton(n査询’•>;
JLabel label2 = new JLabel ("姓名：\ JLabel. CENTER); JLabel lat»year=new JLabel ("年龄："r JLabel. CENTER);
JLabel labDate=new JLabel ("出生日期："r JLabel. CENTER);
JLabel label5 = new JLabel (…性另lj: ", JLabel. CENTER); JLabel label3 = new JLabel ("班级：", JLabel. CENTER); JLabel label4 = new JLabel (”专业：",JLabel. CENTER); JLabel labmz=new JLabel ('▼民族：",JLabel. CENTER); ButtonGroup bgp = new ButtonGroup();
JRadioButton man = new JRadioButton("男"）；
JRadioButton women = new JRadioButton("^C");
JTextField tyear = new JTextField();
JTextField tDate = new JTextField();
JTextField tmz = new JTextField();
JTextField num = new JTextField();
JTextField nam = new JTextField();
JTextField clas = new JTextField();
JTextField scl = new JTextField();
JButton btnModify = new JButton("修改"）；
JButton btnCancel = new JButton("取消"）；
Connection con;
Statement sql;
ResultSet rs; int re;
public modifyForm()
{ this.setSize(560,460); this.setVisible(true); this.setResizable(false);
SCH.setForeground(Color.red);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); this.add(jpl)；
jpl.setBackground(Color.cyan); man.setBackground(Color.cyan); women.setBackground(Color.cyan); jpl.setLayout(null); btnQuery.addActionListener(this); btnModify.addActionListener(this); btnCancel.addActionListener(this);
SCH. setBounds (100,20,300,20" jpl.add(SCH);
label1.setBounds(100, 60,100,20); jpl.add(label1); num.setBounds(220, 60,140,20); jpl.add(num);
btnQuery.setBounds(120,100, 90,20); btnModify•setBounds(230,100,90,20); btnCancel•setBounds(340,100,90,20); jpl.add(btnQuery); 
jpl.add(btnModify);
jpl•add(btnCancel);
label2•setBounds(100,150,70,20);
jpl.add(label2);
nam.setBounds(190,150,140,20);
jpl.add(nam);
labyear.setBounds(100,180,70,20); jpl.add(labyear); tyear.setBounds(190,180,140,20); jpl.add(tyear);
labDate•setBounds(100,210,70,20); jpl.add(labDate); tDate.setBounds(190,210,140,20); jpl.add(tDate);
label5•setBounds(100,250,70,20);
jpl.add(label5);
man.setBounds(205,250, 60,20);
women•setBounds(285,250,60,20);
bgp.add(man);
bgp.add(women);
jpl.add(man);
jpl.add(women);
label3•setBounds(100,290,70,20); jpl.add(label3); clas • setBounds (190,290,140,20) ,• jpl.add(clas);
label4.setBounds(100,320,70,20); jpl.add(label4); scl.setBounds(190,320,140,20); jpl.add(scl);
labmz.setBounds(100,350,70,20); jpl.add(labmz);
tmz•setBounds(190,350,140,20); jpl.add(tmz);
}
public void actionPerformed(ActionEvent ae>{ if(ae.getSource()==btnCancel){
dispose();new mainFrame().setVisible(true);} else if(ae.getSource()==btnQuery){
try{
Class . forName ("sun. jdbc. odbc. JdbcOdbcDriver1') ; }
catch(ClassNotFoundException e){	} 
sql=con.createStatement();
rs=sql. executeQuery (,fselect * from 学籍信息表 where 学号 =’ "+num.getText ()+’’’"）；
if(rs.next()){
num. setText (rs .getString ("学号’'））；
nam. setText (rs .getString ("姓名"））；
tyear • setText (rs .getString ("年龄"）• toString (> );
tDate.setText (rs.getString ("出生日期”））；
if (rs .getString ("性另丨Jn) .equals ("男"> )
{man.setSelected(true);} else
{women.setSelected(true);} clas • setText (rs .getString ("班级，'））； scl • setText (rs .getString ("专业">); tmz . setText (rs . getString ("民族"））； btnModify.setEnabled(true); nam.setEditable(true); tyear.setEditable(true); tDate.setEditable(true); clas.setEditable(true); scl.setEditable(true); tmz.setEditable(true);
}else{
JOptionPane. showMessageDialog (null, ,f不存在该记衆！ " r "温馨 提示•，，JOptionPane. INFORMATION-MESSAGE);
btnModify.setEnabled(false); tyear • setText ('•"); tDate • setText ; tmz . setText (,,,?); num. setText (flf,); nam• setText (’"’）； clas . setText (’"’）； scl • setText ; num.requestFocus(); nam.setEditable(false); tyear.setEditable(false); tDate.setEditable(false); clas.setEditable(false); scl.setEditable(false); tmz.setEditable(false);
}}catch(SQLException e){	} }
else if(ae.getSource()==btnModify)
{ try
{con=DriverManager. getConnection (" jdbc: odbc:
，V’ww", "123");
sql=con.createStatement(); re=sql • executeUpdate ("Update 学籍信息表 set 姓名 =,"+nam.getText () +’’ ’，年龄='"+tyear.getText () +" 1,出生曰期 =,"+tDate . getText () +’’、班级=1 "+clas • getText (> +" •,专业 =’’’+scl • getText ()+”、民族=1 "+tmz • getText (>+" * where 学号 =*,f +num. get Text () +f, f f,);
if(re==l)
{JOptionPane• showMessageDia_Iog(null,"记录修改完毕！ ”，"温馨提示 n,JOptionPane.INFORMATION_MESSAGE);} else
{JOptionPane .siiowMessageDialogr (null,"记录修改失败！"，"温馨提示 ff, JOptionPane . INFORMATION_MESSAGE);
}sql.close ();)
catch (SQLException se)
{JOptionPane.showMessageDialog(null,se.getMessage());}} else{btnModify.setEnabled(false); tyear • setText (•"’）； tDate. setText (?, 11); tmz . setText (ff n); num • set Text (’"’）； nam • set Text (’"’）； clas • setText (’"’）； scl • setText (’"’）； num.requestFocus(); nam.setEditable(false); tyear.setEditable(false); tDate.setEditable(false); clas.setEditable(false); scl.setEditable(false); tmz.setEditable(false);	} }
public static void main(String[] args) { new modifyForm(); }}