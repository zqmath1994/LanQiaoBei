
/*
  递归思想：某些国营的“踢皮球”

1. 找相似性
2. 出口

故事：从前有个山，山上有个庙，庙里有个和尚，。。。。

做梦  还在做梦。。。。
*/

public class A
{
	// 打印从0~n
	static void f(int n)
	{
		if(n>0) f(n-1);
		System.out.println(n);		
	}
	
	// 打印从begin到end
	static void g(int begin, int end)
	{
		if(begin>end) return;
		System.out.println(begin);
		g(begin+1,end);
	}
	
	public static void main(String[] args)
	{
		g(0,9);
		//f(9);
		//for(int i=0; i<10; i++){
		//	System.out.println(i);
		//}
	}	
}