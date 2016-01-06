
public class A
{
	static void f(int n)
	{
		if(n>1) f(n-1);
		System.out.println(n); 
	}
	
	public static void main(String[] args)
	{
		f(10);
	}
}