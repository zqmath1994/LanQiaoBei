
// n个球，只能取：1，3，7或者8个

// 如何避免局面的重复计算
// 1. 类似动态规划
// 2. 缓存

// 动态规划：数学上递归思想，思想上等于递归
//    但，不使用递归手段，通过巧妙设计求解次序 尽量避开深递归

import java.util.*;

public class A
{
	public static Map map = new HashMap();
	public static boolean f(int n)
	{
		if(n==0) return true;
		
		Boolean t = (Boolean)map.get(n);
		if(t!=null) return t;
		
		if(n>=1 && f(n-1)==false){map.put(n,true); return true;}
		if(n>=3 && f(n-3)==false){map.put(n,true); return true;}
		if(n>=7 && f(n-7)==false){map.put(n,true); return true;}
		if(n>=8 && f(n-8)==false){map.put(n,true); return true;}
		map.put(n,false);
		return false; 
	}
	
	public static void main(String[] args)
	{
		System.out.println(f(508));
	}
}