
// 斐波那契
// 效率问题： 缓冲机制

import java.util.*;

public class D
{
	static Map map = new HashMap();
	
	static long f(int n)
	{
		// 一刀切法
		if(map.get(n)==null){
			long x = f(n-1) + f(n-2);
			map.put(n, x); 
		}
		return (Long)map.get(n);
	}
	
	public static void main(String[] args)
	{
		map.put(0,1L);
		map.put(1,1L);
		
		for(int i=0; i<50; i++){
			System.out.println(f(i));
		}
	}
}