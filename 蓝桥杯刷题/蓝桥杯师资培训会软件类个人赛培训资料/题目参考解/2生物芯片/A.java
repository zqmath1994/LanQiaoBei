
/*
 2 操作一次
 3 操作一次
 4 操作一次
 。。。。
*/

import java.util.Scanner;

public class A
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		String[] ss = scan.nextLine().trim().split(" +");
		int n = Integer.parseInt(ss[0]);
		int l = Integer.parseInt(ss[1]);
		int r = Integer.parseInt(ss[2]);
		
		boolean[] da = new boolean[n];
		
		for(int i=2; i<n; i++){
			for(int k=0; k<da.length; k++){
				if((k+1)%i==0) da[k] = !da[k];
			}
		}
		
		int sum = 0;
		for(int i=l-1; i<=r-1; i++){
			if(da[i]) sum++;
		}
		
		System.out.println(sum);
	}
}