
/*
 2 ����һ��
 3 ����һ��
 4 ����һ��
 ��������
*/

import java.util.Scanner;

public class B
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		String[] ss = scan.nextLine().trim().split(" +");
		long  n = Long.parseLong(ss[0]);
		long  l = Long.parseLong(ss[1]);
		long  r = Long.parseLong(ss[2]);
		
		
		if(n<r) return;
		
		long ql = Math.round(Math.sqrt(l));
		long qr = Math.round(Math.sqrt(r));
		
		long sum = qr-ql+1;
		
		if(ql*ql<l) sum--;
		if(r<qr*qr) sum--;
		
		System.out.println((r-l+1)-sum);
	}
}