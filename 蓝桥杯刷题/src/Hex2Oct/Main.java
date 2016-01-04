package Hex2Oct;

import java.util.*;

public class Main
{
public static void hex2Oct(String input)
{
	StringBuilder sbBin=new StringBuilder();
	StringBuilder sbOct=new StringBuilder();
	for (int j=0;j < input.length();j++)
	{
		String bin=Integer.toBinaryString(Integer.valueOf("" + input.charAt(j), 16));
		if(input.length()>1&&j!=0)
		switch (bin.length()) {
		case 1:
			bin="000"+bin;
			break;

		case 2:
			bin="00"+bin;
			break;
		case 3:
			bin="0"+bin;
			break;
		}
		sbBin.append(bin);
		
	}
	
	if (sbBin.length() < 3)
	{
		sbOct.append(Integer.toOctalString(Integer.valueOf(sbBin.toString(), 2)));
	}
	else
	{
		int len=sbBin.length() ;
		String tString;
		
		if(len%3!=0){
			tString=Integer.toOctalString(
					Integer.valueOf(
							sbBin.toString().substring(0,len%3)
							, 2)
							);
		sbOct.append(tString);
		}
		for (int k=0 ;k<len/ 3;k++)
		{
			tString=Integer.toOctalString(
					Integer.valueOf(sbBin.toString().substring(k*3+len%3
							,k*3+len%3+3)
							, 2));
			sbOct.append(tString);
		}
System.out.println(sbOct);
		
	}
}
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		String input;

		for (int i=0;i < n;i++)
		{
			input = scan.next();
			hex2Oct(input);
		}

	}

}

