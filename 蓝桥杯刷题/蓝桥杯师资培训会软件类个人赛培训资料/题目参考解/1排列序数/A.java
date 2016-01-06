
/*
  排列与所序号对应关系
  abcd  0
  abdc  1
  acbd  2
  acdb  3
  adbc  4
  adcb  5
  bacd  6
  badc  7
  bcad  8
  bcda  9
  bdac  10
  bdca  11
  cabd  12
  cadb  13
  cbad  14
  cbda  15
  cdab  16
  cdba  17
  
*/

import java.util.*;

public class A
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		String s = scan.nextLine();
		
		int[] quan = new int[10];
		quan[0] = 1;
		for(int i=1; i<quan.length; i++) quan[i] = i * quan[i-1];
		
		//
		//String s = "cedab";
	//	s = "bdca";
		
		int xu = 0;
		for(int i=0; i<s.length(); i++){
			int k = 0;  // 有多少个小的在本位前
			for(int j=0; j<i; j++) if(s.charAt(j)<s.charAt(i)) k++;
			xu += quan[s.length()-i-1] * (s.charAt(i)-'a'-k);
		}
		 	
		System.out.println(xu);
	}
}
