
/*
  如果进栈次序为：1 2 3 4 5 。。。
  出栈次序有多少种情况？
  
*/

public class A
{
	// n 个等着进栈，栈中有m个
	static int f(int n, int m)
	{
		if(n==0) return 1;
		if(m==0) return f(n-1,1);
		return f(n,m-1) + f(n-1, m+1);
	}
	
	static int f(int n)
	{
		return f(n, 0);
	}
	
	public static void main(String[] args)
	{
		for(int i=1; i<17; i++){
			System.out.println(i + ": " + f(i));
		}
	}
}