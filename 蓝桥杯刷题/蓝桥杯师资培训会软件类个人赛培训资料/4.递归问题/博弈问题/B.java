
public class B
{
	static boolean f(int n)
	{
		if(n==0) return true;
		
		if(n>=1 && f(n-1)==false) return true;
		if(n>=3 && f(n-3)==false) return true;
		if(n>=7 && f(n-7)==false) return true;
		if(n>=8 && f(n-8)==false) return true;
		
		return false;
	}
	
	// ÇóÕÐ·¨
	static int zhao(int n)
	{
		if(n==0) return 0;
		
		if(n>=1 && f(n-1)==false) return 1;
		if(n>=3 && f(n-3)==false) return 3;
		if(n>=7 && f(n-7)==false) return 7;
		if(n>=8 && f(n-8)==false) return 8;
		
		return -1;
	}	
	
	public static void main(String[] args)
	{
		System.out.println(zhao(10));
	}
}