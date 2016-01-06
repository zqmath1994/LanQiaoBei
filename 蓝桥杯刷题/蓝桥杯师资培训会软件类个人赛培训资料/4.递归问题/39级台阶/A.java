
// 上楼问题的变种，必须偶数步
public class A
{
	// n 级台阶，奇数步
	static int g(int n)
	{
		if(n==1) return 1;
		if(n==2) return 1;
		
		return f(n-1) + f(n-2);
	}
	
	// n 级台阶，偶数步
	static int f(int n)
	{
		if(n==1) return 0;
		if(n==2) return 1;
		//if(n==3) return 2;
		
		return g(n-1) + g(n-2);
	}
	
	public static void main(String[] args)
	{
		System.out.println(f(39));
	}
}