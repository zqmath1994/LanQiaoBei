
public class A
{
	// 分治
	public static int g(int n)
	{
		if(n==0) return 1;
		if(n==1) return 3;
		
		int m = n/2;
		int a = g(m);
		if(n%2==0)
			return a * a % 19;
		else
			return a * a * 3 % 19;
	}
	
	// 3的n次幂，对19模，暴力
	public static int f(int n)
	{
		int x = 1;
		for(int i=0; i<n; i++){
			x = (x*3)%19;
		}
		return x;
	}
	
	public static void main(String[] args)
	{
		System.out.println(f(1000000000));
		System.out.println("-------------------");
		System.out.println(g(1000000000));
	}
}

/*
  数论定理
  
  a = ka * p + a1
  b = kb * p + b1
  
  (a * b) % p === (a1*b1)%p 
*/