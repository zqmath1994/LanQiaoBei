package Hex2OctDemo;

import java.util.Scanner;

public class Main {

	/**
	 * 问题描述
	 * 给定n个十六进制正整数，输出它们对应的八进制数。
	 * 输入格式
	 * 输入的第一行为一个正整数n （1<=n<=10）。
	 * 接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。
	 * 输出格式
	 * 输出n行，每行为输入对应的八进制正整数。
	 * 【注意】
	 * 输入的十六进制数不会有前导0，比如012A。
	 * 输出的八进制数也不能有前导0。
	 * 
	 * 样例输入
	 * 2
	 * 39
	 * 123ABC
	 * 
	 * 样例输出
	 * 71
	 * 4435274
	 * 
	 * 【提示】
	 * 先将十六进制数转换成某进制数，再由某进制数转换成八进制。
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		for(int i=0;i<n;++i)
		{
		String hex=scan.next();
		hex2Oct(hex);
		}
		
	}
	public static void hex2Oct(String hex)
	{
		StringBuilder bin=new StringBuilder();
		for (int i = 0; i < hex.length(); ++i) {
			switch (hex.charAt(i)) {

			case '0':
			bin.append("0000");
			break;

			case '1':
				bin.append("0001");
			break;
			case '2':
				bin.append("0010");
			break;
			case '3':
				bin.append("0011");
			break;
			case '4':
				bin.append("0100");
			break;
			case '5':
				bin.append("0101");
			break;
			case '6':
				bin.append("0110");
			break;
			case '7':
				bin.append("0111");
			break;
			case '8':
				bin.append("1000");
			break;
			case '9':
				bin.append("1001");
			break;
			case 'A':
				bin.append("1010");
			break;
			case 'B':
				bin.append("1011");
			break;
			case 'C':
				bin.append("1100");
				break;
			case 'D':
				bin.append("1101");
			break;
			
			case 'E':
				bin.append("1110");
			break;
			
			case 'F':
				bin.append("1111");
			break;
			}//swtich
			
		}//for
		int len=bin.length();
		if(len%3==1)
		{
			bin.insert(0, "00");
		}else if(len%3==2) {
			bin.insert(0, "0");
		}
		boolean flag=false;
		for (int i = 0; i <= bin.length()-3; i+=3) {
			int num=4*(bin.charAt(i)-'0')+2*(bin.charAt(i+1)-'0')+(bin.charAt(i+2)-'0');
			
			if(num!=0)
				flag=true;
			if(flag)
			{
			System.out.print(num);
			}
		
		}
		System.out.println();
	}
}
