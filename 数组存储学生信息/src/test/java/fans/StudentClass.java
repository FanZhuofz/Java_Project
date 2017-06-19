package test.java.fans;

/*声明班级类StudentClass：
属性包括     班级名称（name）、容量（capacity）、学生（student）、实际人数（size）
方法包括     构造方法、get方法、set方法、toString方法。 
*/
//声明学生班级类StudentClass
public class StudentClass {
	private String name;						//班级名称
	static int capacity;						//最大容量
	private Student students[];					//学生
	private int size;							//实际人数
	
												//构造方法
	public StudentClass(String name,int size) {
		this.name=name;
		this.size=size;
		students = new Student[capacity];
	}

	public String getName() {
		return name;
	}
	
	public static int getCapacity() {
		return capacity;
	}
	
	public Student[] getStudents() {
		return students;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	

	@SuppressWarnings("static-access")
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setSize(int size) {
		if(size>capacity){
			System.out.println("size为"+size+"不能超过"+capacity);
			return;
		}
		this.size = size;
	}
	//可变节参数的方法，需在JDK5及以上版本运行
	public void setStudents(Student...students) {
		for(int i=0;i<size;i++){
			this.students[i]=new Student(students[i]);
		}
		this.size=students.length;
	}

	@Override
	public String toString() {
		String s;
		s = "班级：" + name + "\t" + "容量：" + capacity + "\t" + "实际人数：" + size + "\n\n";
		s = s + "学号" + "\t" + "姓名" + "\t" + "英语" + "\t" + "数学" + "\t" + "计算机" + "\t" + "总成绩\n";
		for(int i=0;i<size;i++){
			s = s + students[i].getId()+"\t"+students[i].getName()+"\t"+students[i].getEng()+"\t"+students[i].getMath()+"\t"+students[i].getComp()+"\t"+students[i].getSum()+"\n";
		}
		return s;
	}
}
