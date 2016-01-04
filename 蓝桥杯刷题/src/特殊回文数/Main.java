package 特殊回文数;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getHuiWen();
	}

	private static void getHuiWen() {
		
		for(int i=1000;i<=9999;i++)
		{
			String str=i+"";
			int len=str.length();
			int count=0;
			for(int j=0;j<len/2;j++)
			{
				if(str.charAt(j)==str.charAt(len-j-1))
				{
					count++;
				}
				if(count==len/2)
					System.out.println(str);
			}
		}
	}

}