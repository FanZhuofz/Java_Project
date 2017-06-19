package xyz.dawnfan.pxdemo;

public class XuanZe {

	/**
	 * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
	 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
	 * 
	 * 选择排序算法
	 * 在未排序序列中找到最小元素，存放到排序序列的起始位置  
	 * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。 
	 * 以此类推，直到所有元素均排序完毕。 
	 * @param numbers
	 */
		public static void selectSort(int[] numbers)
		{
			int size = numbers.length; //数组长度
			int temp = 0 ; //中间变量

			for(int i = 0 ; i < size ; i++)
			{
				int k = i;   //待确定的位置
				//选择出应该在第i个位置的数
			    for(int j = size -1 ; j > i ; j--)
			    {
			    	if(numbers[j] < numbers[k])
			    	{
			    		k = j;
			    	}
			    }
			    //交换两个数
			    temp = numbers[i];
			    numbers[i] = numbers[k];
			    numbers[k] = temp;
			}
		}
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int numbers[]=new int[]{49,38,65,97,76,13,27,49,89,86,57};
			XuanZe.selectSort(numbers);
			for(int arr:numbers){
				System.out.print(arr+" ");
			}
		}

}
