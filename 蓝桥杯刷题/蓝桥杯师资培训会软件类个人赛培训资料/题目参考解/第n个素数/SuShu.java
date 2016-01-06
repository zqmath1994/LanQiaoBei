
/*
  筛法
  2 3 4 5 6 7 8 9 10 11 12 。。。。。
  2 3 _ 5 _ 7 _ 9 _ 11 _ ....
  2 3 _ 5 _ 7 _ _ _ 11 _ ....
  ...
*/

public class SuShu
{
	public static void main(String[] args)
	{
		int N = 1000 * 1000 * 10;
		int x = 100001;
		
		byte[] a = new byte[N];
		
		for(int i=2; i<N/2; i++)
		{
			if(a[i]==1) continue;  //  和数没有资格参加筛法
			
			for(int k=2; k<=N/i; k++)
			{
				if(i*k<N) a[i*k] = 1;
			}
		}
		
		
		int m = 0;
		for(int i=2; i<N; i++)
		{
			if(a[i]==0)
			{
				m++;
				if(m==x) System.out.print(i + " "); 
			}
		}
		
		
		System.out.println("m=" + m);
	}
}

