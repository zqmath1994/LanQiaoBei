
/*
  a   b
  20  15
  
  15  20
  20  15
  
  a = x * k1
  b = x * k2
  b-a = (k2-k1) * x
  b-a-a ...
  b % a
  
*/

public class A
{
	// a,b ����С������ = a * b / gcd(a,b)
	
	// ��a,b���Լ��
	public static int gcd(int a, int b)
	{
		if(b==0) return a;
		return gcd(b, a%b);
	}
	
	
	public static void main(String[] args)
	{
		System.out.println(gcd(20,15));	
		System.out.println(gcd(15,20));	
		
	}
}