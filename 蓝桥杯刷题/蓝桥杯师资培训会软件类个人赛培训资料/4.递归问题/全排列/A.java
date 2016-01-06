
public class A
{
	public static void test(char[] cc){
		for(char c: cc) System.out.print(c + " ");
		System.out.println();
	}
	
	// x: 待排列
	// k: 考虑当前位置的元素如何处理：和某个交换（包括自己）
	public static void g(char[] x, int k)
	{
		if(k==x.length-1){
			test(x);
			return;
		}
		
		for(int i=k; i<x.length; i++){
			//  所有元素都在k位置出现
			{ char t=x[i]; x[i]=x[k]; x[k]=t; }  //交换
			g(x, k+1);
			{ char t=x[i]; x[i]=x[k]; x[k]=t; }  //回溯
		}
	}
	
	public static void f(String s){
		char[] cc = s.toCharArray();
		
		g(cc, 0);
	}
	
	public static void main(String[] args)
	{
		f("ABCDE");
	}
}