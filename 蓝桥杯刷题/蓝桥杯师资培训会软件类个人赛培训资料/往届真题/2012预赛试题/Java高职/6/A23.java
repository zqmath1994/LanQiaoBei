
// 扑克牌 A,2,3,4,5,6,7,8,9,10,J,Q,K
// 从前面拿走一张放到后面
// 再从前边拿走一张牌放桌上，重复，直到剩下最后一张牌，放桌上。
// 

import java.util.*;

public class A23
{
	public static List moveCard(List src)
	{
		if(src==null) return null;
		
		List dst = new Vector();
		for(;;)
		{
			if(src.size()==0) break;  // 填空1
			src.add(src.remove(0));
			dst.add(src.remove(0));  // 填空2
		}
		
		return dst;
	}
	
	public static void main(String[] args)
	{
		List a = new Vector();
		a.addAll(Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K"));
		System.out.println(moveCard(a));
	}
}