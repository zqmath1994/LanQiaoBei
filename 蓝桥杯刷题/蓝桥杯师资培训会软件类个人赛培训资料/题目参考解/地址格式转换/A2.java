

import java.util.*;

public class A2
{
	public static String getExcelAddr(String s)
	{
		String[] ss = s.replaceAll("^R(\\d+)C(\\d+)$","$1,$2").split(",");
		int row = Integer.parseInt(ss[0]);
		int col = Integer.parseInt(ss[1]);
		
		int x = (col-1) / 26;
		int y = (col-1) % 26;
		
		String r = "";
		if(x>0) r += (char)('A'+ x - 1);
		r += (char)('A' + y);
		r += row;
		
		return  r;
	}
	
	public static void main(String[] args) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		
		int n = Integer.parseInt(scan.next());
		
		String[] data = new String[n];
		
		for(int i=0; i<n; i++)
		{
			data[i] = scan.next();
		}

		for(int i=0; i<n; i++)
		{
			System.out.println(getExcelAddr(data[i]));
		}
	}
}