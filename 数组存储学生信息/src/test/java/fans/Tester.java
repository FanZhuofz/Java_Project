package test.java.fans;
/*下面声明测试类Tester1（其中Keyboard类的声明见第3章例3-14），为测试简单，
 仅生成具有5名学生的班级，5名学生的信息从键盘输入，为了避免以后再重复输入，可将输入的学生信息
 保存到文件夹中。代码如下：*/
//Tester1.java
import java.io.*;
public class Tester {
	public static void main(String[] args) {
		Student students[];
		StudentClass aClass = new StudentClass("软件 0201",5);
		students = new Student[aClass.getSize()];
		for(int i=0;i<aClass.getSize();i++){
			students[i] = new Student(getAstudent(i+1));
		}
		//StudentClasss的setStudents方法形参为可变长参数，传入实参为数组
		aClass.setStudents(students);
		//String sss = aClass.toString();
		System.out.println(aClass);
		//将学生信息保存到文件stu.ser中
		try{
			FileOutputStream fo = new FileOutputStream("stu.ser");
			ObjectOutputStream so = new ObjectOutputStream(fo);
			for(Student s:students){
				so.writeObject(s);
			}
			so.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	public static Student getAstudent(int i){
		Student studenti;
		System.out.println("输入第"+i+"学生的信息：");
		System.out.print("姓名：");
		String name = Keyboard.getString();
		
		System.out.print("学号：");
		String id = Keyboard.getString();
		
		System.out.print("英语成绩：");
		int eng = Keyboard.getInteger();
		
		System.out.print("数学成绩：");
		int math = Keyboard.getInteger();
		
		System.out.print("计算机成绩：");
		int comp = Keyboard.getInteger();
		
		studenti = new Student(id,name,eng,math,comp);
		return studenti;
	}

}
