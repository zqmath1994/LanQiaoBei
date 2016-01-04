package 查找整数;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner1=new Scanner(System.in);
		int n=scanner1.nextInt();
		
		Scanner scanner2=new Scanner(System.in);
		String str=scanner2.nextLine();
		String arr[]=str.split("\\s+");
		
		Scanner scanner3=new Scanner(System.in);
		int a=scanner3.nextInt();
		
		int iArr[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			iArr[i]=Integer.parseInt(arr[i]);
		}
		for(int i=0;i<n;i++)
		{
			if(iArr[i]==a)
			{
				System.out.println(i+1);
				return;
			}
			
		}
		System.out.println(-1);
	}

}
