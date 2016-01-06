

// 递归法求最大5个元素（不要求排序）

import java.util.*;
public class B23
{
	public static List<Integer> max5(List<Integer> lst)
	{
		if(lst.size()<=5) return lst;
		
		int a = lst.remove(0);  // 填空
		List<Integer> b = max5(lst);
		
		for(int i=0; i<b.size(); i++)
		{
			int t = b.get(i);
			if(a>t)
			{
				b.set(i,a);  
				a = t;  // 填空
			}
		}
		
		return b;
	}
	
	public static void main(String[] args)
	{
		List<Integer> lst = new Vector<Integer>();
		lst.addAll(Arrays.asList(12,127,85,66,27,34,15,344,156,344,29,47));		
		System.out.println(max5(lst));
	}
}