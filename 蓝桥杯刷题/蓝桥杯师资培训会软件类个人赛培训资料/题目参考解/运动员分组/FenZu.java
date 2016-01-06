
import java.math.*;
import java.io.*;

public class FenZu
{	
	public static void main(String[] args) throws Exception
	{
		int people_num = 25;  // 参数人数
		final int track_num = 8;  //跑道数
		
		// 计算分组数
		int group_num =  people_num / track_num;  
		if( people_num % track_num > 0 ) group_num++;
		
		int average_num = people_num / group_num; // 平均每组人数（弱近似）
		int remain = people_num % group_num; // 平均到每组后剩余人数
		
		for(int i=0; i<group_num; i++)
		{
			if(i<remain)
				System.out.println(average_num+1);
			else
				System.out.println(average_num);
		}
	}
}
