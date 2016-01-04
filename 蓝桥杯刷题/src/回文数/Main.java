package 回文数;

import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		getHuiWen(n);
	}

	private static void getHuiWen(int num) {
		
		
		for(int i=11111;i<999999;i++)
		{
			String str=i+"";
			int len=str.length();
			int count=0;
			for(int j=0;j<len/2;j++)
			{
				if(str.charAt(j)==str.charAt(len-j-1)&&getSub(str, num))
				{
					count++;
				}
				if(count==len/2)
					System.out.println(str);
			}
		}
	}
	public static boolean getSub(String str,int num) {
		int sum=0;
		for (int i = 0; i < str.length(); i++) {
			sum+=Integer.parseInt(str.charAt(i)+"");
		}
		return num==sum;
	}
}
