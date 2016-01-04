package 运动员分组;
import java.util.*;

public class Main {

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