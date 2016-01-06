
import java.util.*;

public class A
{
	static Set distinct(long x)
	{
		Set t = new HashSet();
		String s = "" + x;
		for(int i=0; i<s.length(); i++) t.add(s.charAt(i));
		return t; 
	}

	static boolean f(int x)
	{
		long y = (long)x * x;
		
		Set a = distinct(x);
		Set b = distinct(y);
		
		if(a.size() != 6) return false;
		
		a.retainAll(b);
		return a.isEmpty(); 
	}
	
	public static void main(String[] args)
	{
		final int A = 1000 * 100;
		final int B = A * 10;
		
		for(int i=A; i<B; i++)
		{
			if(f(i)) 
				System.out.println(i);
		}
	}
}