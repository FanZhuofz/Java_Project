package dawn.java.demo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class myConnection{
	ResultSet re; 
	public myConnection(){}
	public ResultSet getResult(String sql) {
		try {
			Class.forName ("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqltest", "root", "0211");
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet re=stmt.executeQuery(sql);
			return re;}
		catch(Exception e) {
			System.out.println("getResult------"+e. toString ());
			return null;}}
	public boolean executeSql(String sql){
		try {Class.forName ("com.mysql.jdbc.Driver");
			Connection conn=DriverManager. getConnection ("jdbc:mysql://127.0.0.1:3306/mysqltest", "root", "0211");
			Statement stmt=conn.createStatement(); 
			stmt.executeUpdate(sql); 
			conn.commit(); 
			return true;} 
		catch(Exception e) {
			System.out.println("executeSql	"+e.toString());
			return false;}}}
class stuMainFrame extends JFrame implements ActionListener{
	JMenuBar jmb = new JMenuBar();
	JMenu Message = new JMenu("信息");
	JMenu Score = new JMenu ("査询");
	JMenuItem Iteml = new JMenuItem ("添加学生信息") ;
	JMenuItem mName=new JMenuItem("学生成绩査询");
	JMenuItem mScore=new JMenuItem("按成绩査询");
	JMenuItem mNaml=new JMenuItem("査询学生信息");
	JLabel label = new JLabel();
	public stuMainFrame(){
		ImageIcon icon = new ImageIcon("src/images/l.jpg");
		label.setIcon(icon);
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		add(label);
		setSize (label.getWidth(),label.getHeight());
		this.setJMenuBar(jmb);
		jmb.add(Message);
		jmb.add(Score);
		Message.add(Iteml);
		Score.add(mNaml);
		Score.add(mName);
		Score.add(mScore);
		Iteml.addActionListener(this);
		mName.addActionListener(this);
		mScore.addActionListener(this);
		mNaml.addActionListener(this); }
	@Override
	public void actionPerformed(ActionEvent e)
		{if(e.getSource()==Iteml)
			{ new addForm().setVisible(true);} 
		else if(e.getSource()==mName)
		{ 	dispose();
			new Scorel().setVisible(true);} 
		else if(e.getSource()==mScore)
		{new scoreQueryForm().setVisible(true);}
		else if(e.getSource()==mNaml)
		{	dispose ();
			new Serchl().setVisible(true);}}

class mainFrame extends JFrame implements ActionListener{
	JLabel label = new JLabel();
	JMenuBar mBar= new JMenuBar();
	JPanel p=new JPanel();
	private JMenu mSystem,mOperate,mQuery,mHelp,myMenuUser;
	private JMenuItem mFile,mNew,mOpen,mExit,mAdd,mDel,mModify,mName,miShow,mScore,mAbout,miUser,mAddSc;
	public mainFrame()
		{ this.setJMenuBar(mBar);
			ImageIcon icon = new ImageIcon ("src/images/1. jpg");
			label.setIcon(icon);
			label.setBounds(0, 0, icon.getIconWidth(),icon.getIconHeight());
			add(label);
			setSize(label.getWidth(),label.getHeight());
			myMenuUser=new JMenu ("用户");
			miUser=new JMenuItem("编辑用户");
			myMenuUser.add(miUser);
			mSystem=new JMenu("系统");
			mOperate=new JMenu ("数据操作");
			mQuery=new JMenu ("査询");
			mHelp=new JMenu ("帮助");
			mBar.add(mSystem);
			mBar.add(mOperate);
			mBar.add(mQuery);
			mBar.add(mHelp);
			mBar.add(myMenuUser);
			mFile=new JMenuItem("文件");
			mNew=new JMenuItem ("新建");
			
			mOpen=new JMenuItem("打开");
			mExit=new JMenuItem("退出");
			mSystem.add(mFile);
			mSystem.add(mNew);
			mSystem.add(mOpen);
			mSystem.addSeparator();
			mSystem.add(mExit);
			mAdd=new JMenuItem ("添加基本信息 ");
			mAddSc=new JMenuItem ("添加成绩信息");
			mDel=new JMenuItem("删除");
			mModify=new JMenuItem ("修改");
			mOperate.add(mAdd);
			mOperate.add(mAddSc);
			mOperate.add(mDel);
			mOperate.add(mModify);
			mName=new JMenuItem("査询学生信息");
			mScore=new JMenuItem("査询学生成绩");
			miShow=new JMenuItem("全部显示");
			mQuery.add(mName);
			mQuery.add(mScore);
			mQuery.addSeparator();
			mQuery.add(miShow);
			mAbout=new JMenuItem("软件信息");
			mHelp.add(mAbout);
			mExit.addActionListener(this);
			mAdd.addActionListener(this); 
			mDel.addActionListener(this);
			mModify.addActionListener(this);
			mName.addActionListener(this);
			mScore.addActionListener(this);
			mAbout.addActionListener(this);
			miShow.addActionListener(this);
			miUser.addActionListener(this);
			mAddSc.addActionListener(this);}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==mExit){ 
			dispose();
new CJ().setVisible(true);} else if(e.getSource()==mAbout){
JOptionPane• showMessagreDialog(this,"学生成绩管理系统\n\n电 信学院\n\n2012 年3 月软件信JOptionPane. JiVFORMAriOW一 MESSAGE) ; } else if(e.getSource()==mAdd){ dispose ();
new addForm().setVisible(true);}
else if(e.getSource()==mAddSc){ dispose ();
new addScore().setVisible(true);} else if(e.getSource()==mDel){ dispose ();
new deleteForm().setVisible(true);} else if(e.getSource()==mName){ dispose ();
new Serch().setVisible(true);} else if(e.getSource()==mScore){ dispose ();
new Score().setVisible(true);} else if(e.getSource()==mModify){
new modifyForm().setVisible(true);} else if(e.getSource()==miUser){ new userFrame().setVisible(true);} else if(e.getSource()==miShow){ new freshTable().setVisible(true);	}}}
class CJ extends JFrame implements ActionListener{ JLabel tl=new JLabel("ID号："> ;
JLabel t3=new JLabel ("密码："> ;
JLabel label = new JLabel(); public String zh=null;
JTextField t2=new JTextField(null,15); JTextField t4=new JPasswordField(nullf15); JRadioButton b=new JRadioButton("教师n>; JRadioButton bl=new JRadioButton("学生"）；
JButton jBl=new JButton (•’登录；
JButton jB2=new JButton ("取消">;
public CJ (){super (”学生生成绩管理系统
setLayout(null);
jBl•setBounds(110,170,60,20);
jBl.setBackground(Color.red);
add(jBl);
jB2•setBounds(210,170,60,20); jB2.setBackground(Color.red); add(jB2);
tl.setBounds(90,50,80,35); add(t1);
t2.setBounds(120,50,150,35); add(t2);
t3•setBounds(90,100,80,35); add(t3);
t4•setBounds(120,100,150,35);
add(t4);
b.setBounds(200,20,70,30); bl•setBounds(120,20,70,30);
ButtonGroup bg=new ButtonGroup();
b.setSelected(false);
bl.setSelected(true);
bl.setSelected(false);
add(b);bg.add(b);add(bl); bg.add(bl);
b.setContentAreaFilled(false);
bl.setContentAreaFilled(false);
Imagelcon icon = new Imagelcon (,fsrc/images/a. jpg"); label•setlcon(icon);
label.setBounds(0, 0, icon.getlconWidth(), icon•getlconHeight()); add(label);
setSize(label.getWidth(),label.getHeight()); setResizable(false); setVisible(true); setLocation (300,300);
setDefaultCloseOperation{JFrame.EXI T_ON_CLOSE); jBl.addActionListener(this); jB2.addActionListener(this);} public void actionPerformed(ActionEvent e) { if (e.getSource()==jB2){
System.exit(0);} else if (e.getSource()==jBl){
String username , password; username = t2.getText (); password = t4.getText(); if(b.isSelected())	{
if (username.toString().equals("")){
JOptionPane . showMessageDialog (nullf "请输入用户名”， ”温馨提示",JOptionPane. INFORMATION一MESSAGE);
}
else if (password.toString().equals("")){
JOptionPane. showMessageDialog {null,	f "
温馨提示",JOptionPane. INFORMATION-MESSAGE);
}
else {
myConnection conn=new myConnection();
ResultSet rs;
String sql="select * from 教师信息表 where 教师 ID= ’ ”+username • toString ()+•’1 and 登录密码=1 f,+password. toString () +f, ? ff; try{
rs=conn.getResult(sql);
rs . last ();
if(rs.getRow()==1)
{ setVisible(false); rs.beforeFirst();
while(rs.next()){ this.dispose(); sql="select * from 学籍信息表"； mainFrame mf=new mainFrame(); mf.setLayout(null); mf.setVisible(true); mf.setLocation(300,300); mf.setResizable(false);
mf .setTitle("学生成绩管理系统：教师登录界面"）；
mf.setDefaultCloseOperation{JFrame.EXI T_ON_CLOSE);
mf.addWindowListener(new WindowAdapter(){ public void windowclosing(WindowEvent e){ System.exit(0);
}
})；
JOptionPane . showMessageDialog( null , rs .getString ("教师姓名老师！您好！ 欢迎登录学生成绩管理系统！ ”	; }
}
else{
JOptionPane• showMessageDialog(null, n用户名或密码错 误","登录失败",JOptionPane. INFORMATION_MESSAGE);
}
}
catch(Exception er){
System.out.println(er.toString());
if(bl.isSelected())	{
if (username. toString () . equals ('*") ) {
JOptionPane. showMessageDialog (null,"请输入用户名", "温馨提示n, JOptionPane . INFORMATION_MESSAGE);
}
else if (password.toString().equals("")){
JOptionPane.	(null, •’请输入密码"，"
温馨提示",JOptionPane. INFORMATION-MESSAGE);
else{
myConnection conn=new myConnection();
ResultSet rs;
String sql="select * from 学籍信息表 where 学号 =,,f+t2 .getText () . toString () + H ' and 登录密码=
* n+t4 .getText () .toString ()+•’* "; try{
rs=conn.getResult(sql);
rs . last ();
if(rs.getRow()==1)
{ setVisible(false); rs.beforeFirst();
while(rs.next()){ this.dispose(); sql="select ★ from 学籍信息表"； stuMainFrame smf =new stuMainFrame(); smf.setSize(500,400);
smf.setVisible(true); smf.setResizable(false);
smf.setDefaultCloseOperation{JFrame.EXIT_ON_CLOSE);
smf.addWindowListener(new WindowAdapter(){
public void windowclosing(WindowEvent e){ System.exit(0);
}
})；
JOptionFane. showMessageDialog { null , rs . getString (n
学生姓名"）+"同学！您好！欢迎登录学生成绩管理系统！ "> ;	} }
else{
JOptionPane. showMessageDialog (null, ”用户名或密码错 误”,"登录失败,f, JOptionPane . INFORMATION_MESSAGE);
}}
catch(Exception er){
System.out.printIn(er.toString());
}} }}}

public static void main(String[] args) {
	try{
}
UIManager. setLookAndFeel (UIManager. getSystemLookAndFeelClassName ());
}
catch(Exception e){}
CJ frame=new CJ(); new mainFrame();
stuMainFrame stu = new stuMainFrame();}}