
import java.math.BigInteger;

public class A
{
	public static void main(String[] args)
	{
		BigInteger a = BigInteger.ONE;
		BigInteger k = BigInteger.valueOf(2);
		for(int i=0; i<11213; i++)
			a = a.multiply(k);
			
		System.out.println(a);
		System.out.println(a.toString().length());
		
		String s = a.toString();
		String s2 = s.substring(s.length()-100);
		System.out.println(s2);
		
		System.out.println(s2.length());
		
		System.out.println("别忘记最后 2^n-1");
	}
}