
// 用割圆术来逼近 圆周率

public class B21
{
	public static void main(String[] args)
	{
		System.out.println("标准 " + Math.PI);
		
		double a = 1; // 弦长 
		int n = 6;  // 边数
		
		for(int i=0; i<10; i++)
		{
			double b = Math.sqrt(1-(a/2)*(a/2));
			a = Math.sqrt((1-b)*(1-b) + (a/2)*(a/2));
			
			n = n * 2;
			
			System.out.println(n + "  " + a*n/2);
		}
	}
}
