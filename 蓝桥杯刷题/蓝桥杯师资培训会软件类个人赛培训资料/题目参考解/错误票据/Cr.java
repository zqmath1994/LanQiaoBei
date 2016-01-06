
import java.util.*;

public class Cr
{
	static void f(int a, int b, int c, int d)
	{
		List lst = new Vector();
		
		for(int i=a; i<b; i++)
		{
			if(i!=c) lst.add(i);
		}
		lst.add(d);
		
		Collections.shuffle(lst,new Random());
		
		for(int i=0; i<lst.size(); i++)
		{
			System.out.print(lst.get(i) + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args)
	{
		f(10,30,15,19);
		f(2001,2100,2096,2013);
	}
}