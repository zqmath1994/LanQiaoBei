
import java.util.*;

public class A
{
	static int N;
	static int COUNT;
	
	static int col(int[] zu, int a, int b)
	{
		int t = 0;
		for(int i=a; i<b; i++) t = t*10 + zu[i];
		return t;
	}
	
	static void g(int[] zu)
	{		
		for(int i=1; i<zu.length-1; i++)
		for(int j=i+1; j<zu.length; j++)
		{
			int a = col(zu,0,i);
			int b = col(zu,i,j);
			int c = col(zu,j,zu.length);
			
			if(b%c!=0) continue;
			
			if(a+b/c==N){
				System.out.println(a + " + " + b + " / " + c);
				COUNT++;
			}
		}
	}
	
	static void pai(int[] zu, int k)
	{
		if(k==zu.length-1)
		{
			g(zu);
			return;
		}
		
		for(int i=k; i<zu.length; i++)
		{
			{int t=zu[k]; zu[k]=zu[i]; zu[i]=t;}
			pai(zu,k+1);
			{int t=zu[k]; zu[k]=zu[i]; zu[i]=t;}
		}
	}
	
	static void test(int n)
	{
		N = n;
		COUNT = 0;
		int[] t = {1,2,3,4,5,6,7,8,9};
		pai(t,0);
		System.out.println("COUNT == " + COUNT);
	}
	
	public static void main(String[] args)
	{	
		test(10);
		test(1111);
		test(2013);	
	}
}
