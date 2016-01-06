
public class X
{
	static int f(int n)
	{
		if(n==1 || n==2) return 1;  // µÝ¹é³ö¿Ú
		return f(n-1) + f(n-2);
	}
	
	public static void main(String[] args)
	{
		System.out.println(f(50));
	}
}