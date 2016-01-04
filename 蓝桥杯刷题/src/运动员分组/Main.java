package 运动员分组;
import java.util.*;

public class Main {
	
	//	有N个人参加100米短跑比赛。跑道为8条。程序的任务是按照尽量使每组的人数相差最少的原则分组。
	//	例如：
	//	N=8时，分成1组即可。
	//	N=9时，分成2组：一组5人，一组4人。
	//	N=25时，分4组：7、6、6、6。
	//	请编程计算分组数字。要求从键盘输入一个正整数（1~100之间，不必考虑输入错误的情况），表示参赛的人数。程序输出每个组的人数。从大到小顺序输出，每个数字一行。
	//	比如，用户输入：25
	//	程序输出：
	//	7
	//	6
	//	6
	//	6

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[100];
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		if(a%8==0)
		{
			for(int i=0;i<a/8;i++)
			{
				System.out.println(8);
			}
			return;
		}
		for(int j=(a/8+1);;j++)
		{
			if(a%j>j)
				continue;
			for(int i=0;i<j;i++)
			{
				arr[i]=a/j;
			}

			for(int i=0;i<a%j;i++)
			{
				arr[i]=arr[i]+1;
			}

			for (int i = 0; i <j; i++) {//��ӡ
				System.out.println(arr[i]);
			}
			
			break;
		}
	}

}