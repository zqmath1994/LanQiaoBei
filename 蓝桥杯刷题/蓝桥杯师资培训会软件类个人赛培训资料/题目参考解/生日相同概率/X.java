
import java.util.*;

public class X
{
	// n个人出现生日相同概率
	static double f(int n)
	{
		final int W = 1000 * 100;  //总的实验次数
		
		int w = 0; // 出现相同生日的次数
		for(int i=0; i<W; i++)
		{
			Set set = new HashSet();
			for(int j=0; j<n; j++)
			{
				int r = (int)(Math.random() * 365);	 // 随机的生日
				set.add(r);
			}
			
			if(set.size()<n) w++;
		}
		
		return 1.0 * w / W;
	}
	
	public static void main(String[] args)
	{
		System.out.println(f(30));	
	}
}