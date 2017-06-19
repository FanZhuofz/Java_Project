package test.java.fans;
/*使用数组存储一个班的学生信息及考试成绩
 * 学生信息包括学号、姓名、三门课（英语、数学、计算机）的成绩及总成绩
 * 首先声明学生类Student：
 * ----属性包括   学号（id）、姓名（name）、英语成绩（math）、计算机成绩（comp）、总成绩（sum）
 * ----方法包括   构造方法、get方法、set方法、toString方法、equals方法、compare方法（比较两个学生的总成绩、结果分大于、小于、等于）、sum方法（计算总成绩）。
 * 为了能够将Student类对象持久化，也就是存储到磁盘，应使其加入串行化协议，实现Serializable接口。代码如下：*/
//Student.java
import java.io.*;

@SuppressWarnings("serial")
public class Student implements Serializable{
	private String id;				//学号
	private String name;			//姓名
	private int eng;				//英语成绩
	private int math;				//数学成绩
	private int comp;				//计算机成绩
	private int sum;				//总成绩
	//构造方法
	public Student(String id,String name,int eng,int math,int comp){
		this.id=id;
		this.name=name;
		this.eng=eng;
		this.math=math;
		this.comp=comp;
		sum();						//计算总成绩
	}
	public Student(Student s) {
		this.id=s.id;
		this.name=new String(s.name);
		this.eng=s.eng;
		this.math=s.math;
		this.comp=s.comp;
		sum();
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEng(int eng) {
		this.eng = eng;
		sum();
	}
	public void setMath(int math) {
		this.math = math;
		sum();
	}
	public void setComp(int comp) {
		this.comp = comp;
		sum();
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public int getComp() {
		return comp;
	}
	public int getSum() {
		return sum;
	}
	//计算总成绩
	void sum(){
		this.sum=eng+math+comp;
	}
	public String toString() {
		return getId()+"\t"+getName()+"\t"+getEng()+"\t"+getMath()+"\t"+getComp()+"\t"+getSum();
	}
	//比较两个Student对象的值是否相等
	public boolean equals(Object x){
		if(this.getClass()!=x.getClass()){
			return false;
		}
		Student b = (Student) x;
		return(this.getId().equals(b.getId()));
	}
	//比较成绩大小，当前对象成绩比参数成绩大时返回1，相等时返回0，其他返回-1
	public int compare(Student A){
		if(this.getSum()>A.getSum()){
			return 1;
		}
		else if(this.getSum()==A.getSum()){
			return 0;
		}
		else {
			return -1;
		}
	}
}
