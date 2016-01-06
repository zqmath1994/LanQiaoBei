
// 取球问题  组合
/*
   1. 相似性 ----- 踢皮球
   2. 出口
*/


public class B
{
	// m个球中取n个球
	static int f(int m, int n)
	{
		if(m<n) return 0;
		if(n==0) return 1;
		
		return f(m-1, n-1) + f(m-1, n);
	}
	
	public static void main(String[] args)
	{
		System.out.println(f(5,3));
		System.out.println(f(5,2));
	}
}