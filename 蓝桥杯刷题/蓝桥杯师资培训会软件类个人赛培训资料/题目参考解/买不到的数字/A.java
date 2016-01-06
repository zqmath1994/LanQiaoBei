
import java.util.*;

public class A
{
	static final int N = 1000 * 100;
	
	static int se(int[] da, int a)
	{
		int n=0;
		for(int i=0; i<da.length; i++)
		{
			if(da[i]==1){
				n++;
				if(n>=a) return i-a;
			}
			else
				n = 0;
		}
		
		return -1;
	}
	
	static void f(int a, int b)
	{
		int[] da = new int[N];
		
		for(int i=0; i<=N/a; i++)
		{
			for(int j=0; j<=(N-i*a)/b; j++)
			{
				if(i*a + b*j < N) da[i*a+b*j] = 1;
			}
		}
		
		System.out.println(se(da, a));
	}
	
	public static void main(String[] args)
	{
		//f(3,5);
		//f(4,7);
		f(10,13);
		f(30,41);
		f(257,191);
	}
}