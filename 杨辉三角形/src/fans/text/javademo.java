package fans.text;

/*半三角*//*
public class javademo{
	 public static void main(String args[]){
	  int i,j;
	  //int h=7;
	  int yanghui[][]=new int[7][];
	  System.out.println("杨辉三角形");
	  for(i=0;i<yanghui.length;i++){yanghui[i]=new int[i+1];yanghui[0][0]=1;}
	  for(i=1;i<yanghui.length;i++){
	    yanghui[i][0]=1;
	    for(j=1;j<yanghui[i].length-1;j++){yanghui[i][j]=yanghui[i-1][j-1]+yanghui[i-1][j];}
	    yanghui[i][yanghui[i].length-1]=1;
	  }
	  for(i=0;i<yanghui.length;i++){
	    for(j=0;j<yanghui[i].length;j++)
	      System.out.print(yanghui[i][j]+" ");
	    System.out.println();
	  }
	  }
	}*/

/*全三角*/
public class javademo{
	 public static void main(String args[]){
	  int i,j;
	 // int h=7;
	  int yanghui[][]=new int[7][];
	  System.out.println("杨辉三角形");
	  for(i=0;i<yanghui.length;i++){yanghui[i]=new int[i+1];yanghui[0][0]=1;}
	  for(i=1;i<yanghui.length;i++){
	    yanghui[i][0]=1;
	    for(j=1;j<yanghui[i].length-1;j++){yanghui[i][j]=yanghui[i-1][j-1]+yanghui[i-1][j];}
	    yanghui[i][yanghui[i].length-1]=1;
	  }
	  for(i=0;i<yanghui.length;i++){
	    for(int k=0;k<2*(yanghui.length-i)-1;k++)
	    {System.out.print(" ");}
	    for(j=0;j<yanghui[i].length;j++)
	    	System.out.print(yanghui[i][j]+"   ");
	    System.out.println();
	  		}
	  }
	 }
