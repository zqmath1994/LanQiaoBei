
// Êý×Ö¼äÌîÐ´·ûºÅ + -
// 1 2 3 4 5 6 7 8 9 = 110;


import java.util.*;

public class A
{
	public static void f(String cur, int goal, List<Integer> lst)
	{	
		if(lst.size()==0) return;
		
		int a = lst.remove(lst.size()-1);
		if(lst.size()==0)
		{
			if(goal==a) System.out.println(a + cur);
			return;
		}
	
		List<Integer> lst2 = new Vector<Integer>();
		lst2.addAll(lst);
		List<Integer> lst3 = new Vector<Integer>();
		lst3.addAll(lst);
				
		f("+" + a + "" + cur, goal-a, lst2);
		f("-" + a + "" + cur, goal+a, lst3);
		
		int b = lst.remove(lst.size()-1);
		lst.add(Integer.parseInt(b+""+a));
		f(cur, goal, lst);
	} 
	
	public static void main(String[] args)
	{
		List<Integer> lst = new Vector<Integer>();
		for(int i=1; i<=9; i++) lst.add(i);
		
		f("", 110, lst);
	}
}