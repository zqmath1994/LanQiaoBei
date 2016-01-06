
import java.math.BigInteger;

public class A
{
	/*
	public static BigInteger f(int[] x,int k,int num)
	{
		if(num<0) return BigInteger.ZERO;
		if(num==0) return BigInteger.ONE;
		
		if(k==x.length) return BigInteger.ZERO; 
		
		BigInteger r = BigInteger.ZERO;
		
		for(int i=0; i<=x[k]; i++){
			r = r.add(f(x,k+1,num-i));
		}
		
		return r;
	}
	*/
	
	// x: 每种牌的个数
	// k: 当前考虑的位置
	// num: 还有多个名额剩余
	public static int g(int[] x,int k,int num)
	{
		if(num<0) return 0;
		if(num==0) return 1;		
		if(k==x.length) return 0; 
		
		int r = 0;
		
		for(int i=0; i<=x[k]; i++){
			r += g(x,k+1,num-i);
		}
		
		return r;
	}	
	
	public static void main(String[] args)
	{
		int[] x = {4,4,4,4,4,4,4,4,4,4,4,4,4};
		//int[] x = {4,4,4,4};
		//BigInteger a = f(x, 0, 13);
		//System.out.println(a);
		System.out.println(g(x,0,13));
	}
}