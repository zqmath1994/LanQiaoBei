
public class X
{
	public static void main(String[] args)
	{
		int n = 50;  // 硬币个数
		int z = 20 * 100; //总币值
		
		int k = 0;  // 方案计数
		
		for(int a=0; a<=50; a++)
		for(int b=0; b<=50; b++)
		for(int c=0; c<=50; c++)
		for(int d=0; d<=50; d++)
		{
			if(a+b+c+d==n && a*100+b*50+c*10+d*5==z) k++;
		}
		
		System.out.println(k);
	}
}