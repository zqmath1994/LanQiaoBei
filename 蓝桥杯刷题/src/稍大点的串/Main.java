package 稍大点的串;
import java.util.*;
public class Main
{
	/* 
	 * 标题：稍大的串 
	 * 串可以按照字典序进行比较。例如： 
	 * abcd 小于 abdc 
	 * 如果给定一个串，打乱组成它的字母，重新排列，可以得到许多不同的串，在这些不同的串中，有一个串刚好比给定的串稍微大一些。 
	 * 科学地说：它是大于已知串的所有串中最小的串。你的任务就是求出这个“稍大的串”。 
	 * 例如： 
	 * 输入串： 
	 * abfxy 
	 * 程序应该输出： 
	 * abfyx 
	 * 再例如： 
	 * 输入串： 
	 * ayyyxxff 
	 * 程序应该输出： 
	 * fafxxyyy 
	 *  
	 *  数据规模约定： 
	 *  输入的串不超过1000个字符。 
	 *  特例： 
	 *  如果已知的串已经是所有重组串中最大的，则原样输出读入的那个串。
	 */	
	static String string="ayyyhbgfhgfjgfjgjghjghjhjhjjghjhgjhjhjhgjxxff";		
	static String min="";	
	static class Com implements Comparator<Character>
	{

		@Override
		public int compare(Character p1, Character p2)
		{
			// TODO: Implement this method
			return p2.compareTo(p1);
		}

		
	}
	public static void main(String[] args)
	{		
		// TODO Auto-generated method stub		
		
		Character ch[]=new Character[string.length()];
		char ch2[]=new char[string.length()];
	long t=	System.currentTimeMillis();
		for(int i=0;i<string.length();i++)
		{
			ch[i]=string.charAt(i);
		}
		Arrays.sort(ch,new Com());
		
		for(int i=0;i<string.length();i++)
		{
			ch2[i]=ch[i];
		}
		min = new String(new String(ch2));//将最大的字符串赋值给min
		
		
	    pailie(min.toCharArray(),0);

		System.out.println(min);	
		System.out.println(System.currentTimeMillis()-t);
	}
	
	public static void pailie(char[] ch, int index)//排列所有字符串
	{
		
		if (ch == null || index < 0)
			return;
		if (index == (ch.length - 1))
		{
			String tString=new String(ch);
			if (string.compareTo(tString) < 0 && tString.compareTo(min) < 0)		
			{					
				//string比较小,且比min还小，他就是min			
				min = tString;				
			}			
				
		}
		else
		{
			for (int i = index; i < ch.length; i++)
			{
				char temp = ch[i];
				ch[i] = ch[index];
				ch[index] = temp;

				pailie(ch, index + 1);

				temp = ch[i];
				ch[i] = ch[index];
				ch[index] = temp;

			}
		}
		
	}
}
