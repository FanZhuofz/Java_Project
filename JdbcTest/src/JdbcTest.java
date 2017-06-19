import java.sql.*;
public class JdbcTest
{
public static void main(String[] args) 
{
    String JDriver="com.mysql.jdbc.Driver";//SQL数据库引擎
    String connectDB="jdbc:mysql://127.0.0.1:3306/mysqltest";//数据源注意IP地址和端口号，数据库名字
    try  
    {
        Class.forName(JDriver);//加载数据库引擎，返回给定字符串名的类
    }
    catch(ClassNotFoundException e)
    {
        //e.printStackTrace();
        System.out.println("加载数据库引擎失败");
        System.exit(0);
    } 
    System.out.println("数据库驱动成功");
    try
    {
        String user="root";//你自己创建的用户名字和密码
        String password="0211";
        Connection con=DriverManager.getConnection(connectDB,user,password);//连接数据库对象
        //Connection con=DriverManager.getConnection(connectDB);
        System.out.println("连接数据库成功");
        Statement stmt=con.createStatement();//创建SQL命令对象
        //创建表
        System.out.println("查询");
        System.out.println("开始读取数据");
        ResultSet rs=stmt.executeQuery("SELECT * FROM user where age=21");//返回SQL语句查询结果集(集合)
        //循环输出每一条记录
        while(rs.next())
        {
              //输出每个字段
             System.out.println(rs.getString("id")+"\t"+rs.getString("name"));
        }
        System.out.println("读取完毕");


        //增加数据
        System.out.println("增加");
        stmt.executeUpdate("insert into StuDate values(5,'王芳','女',19,'光电')");//增加一条记录
        System.out.println("增加后的数据是：");
        ResultSet rs1=stmt.executeQuery("SELECT * FROM StuDate" );//返回SQL语句查询结果集(集合)
       //循环输出每一条记录
        while(rs1.next())
        {
        //输出每个字段
              System.out.println(rs1.getString("id")+"\t"+rs1.getString("name"));
        }
        System.out.println("读取完毕");


       //修改数据
        System.out.println("修改");
        stmt.executeUpdate("Update StuDate set age=13 where id=3 ");//修改记录
        System.out.println("修改后的数据是：");
        ResultSet rs2=stmt.executeQuery("SELECT * FROM StuDate where id=3" );//返回SQL语句查询结果集(集合)
       //循环输出每一条记录
        while(rs2.next())
        {
         //输出每个字段
             System.out.println(rs2.getString("id")+"\t"+rs2.getString("age"));
        }
        System.out.println("读取完毕");


        //删除数据
        System.out.println("删除");
        stmt.executeUpdate("Delete From StuDate where id='4' ");//修改记录
        System.out.println("删除后的数据是：");
        ResultSet rs3=stmt.executeQuery("SELECT * FROM StuDate " );//返回SQL语句查询结果集(集合)
        //循环输出每一条记录
        while(rs3.next())
        {
         //输出每个字段
           System.out.println(rs3.getString("id")+"\t"+rs3.getString("age"));
        }
        System.out.println("读取完毕");


       //关闭连接
        stmt.close();//关闭命令对象连接
        con.close();//关闭数据库连接
    }
    catch(SQLException e)
    {
       e.printStackTrace();
       //System.out.println("数据库连接错误");
       System.exit(0);
    }
}
}