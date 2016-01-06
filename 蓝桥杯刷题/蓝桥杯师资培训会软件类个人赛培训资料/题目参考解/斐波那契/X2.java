
import java.math.BigInteger;
import java.util.*;

public class X2
{
	static Map map = new HashMap();  //缓冲  动态（自动）规划
	
	static BigInteger f(int n)
	{
		if(map.get(n)!=null) return (BigInteger)map.get(n);
		BigInteger x = f(n-1).add(f(n-2));
		map.put(n,x);
		return x;
	}
	
	public static void main(String[] args)
	{
		map.put(1,BigInteger.ONE);
		map.put(2,BigInteger.ONE);
		
		System.out.println(f(1140));
	}
}