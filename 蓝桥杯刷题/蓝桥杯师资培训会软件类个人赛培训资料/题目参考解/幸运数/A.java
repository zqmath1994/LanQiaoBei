
import java.util.*;

public class A
{
	static List T = new Vector();
	
	static void f(int N)
	{
		for(int i=1; i<=N; i++) T.add(i);
		
		int p = 2;
		for(int i=1;;i++)
		{
			for(int k=T.size()-1; k>=0; k--) 
				if((k+1) % p == 0) T.remove(k);
			if(i>=T.size()) break;
			p = (Integer)T.get(i);
		}
	}
	
	static void test(int m, int n)
	{
		int count = 0;
		
		for(int i=0; i<T.size(); i++)
		{
			int k = (Integer)T.get(i);
			if(k>=n) break;
			
			if(k>m) count++;
		}
		
		System.out.println(count);
	}
	
	static void show(int n)
	{
		for(int i=0; i<n; i++) System.out.print(T.get(i) + " ");
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		f(1000 * 50);
		show(100);
		
		test(1,20);
		test(30,69);
		test(50,100);
		test(99,300);
		test(100,1000);
		test(5000,15000);
	}
}

