
/*
  找到某个排列的下一个相邻排列
  比本排列大的所有排列中，选字典序最小的
  
  1. 逆向搜索一对相邻的元素，[x1,x2] 满足 [x1] < [x2], 若失败，则不存在下一个排列（本排列最大）
  2. 逆向搜索一个元素 [y] 满足 [y]>[x1], 显然，最坏情况下，x2就是y，所以一定能找到
  3. 交换: [x1] <--> [y]
  4. [x2,...] x2以后的序列翻转
*/

import java.util.*;

public class Pai
{
	static boolean f_next(char[] a){
		int x1 = -1;
		for(int i=a.length-1; i>0; i--){
			if(a[i-1]<a[i]){
				x1 = i-1;
				break;
			}
		}
		
		if(x1<0) return false;
		
		int x2 = x1 + 1;
		int y = -1;
		
		for(int i=a.length-1; i>0; i--){
			if(a[i]>a[x1]){
				y = i;
				break;
			}
		}
		
		{char t = a[x1]; a[x1] = a[y]; a[y] = t;}
		
		y = a.length-1;
		while(true){
			if(x2>=y) break;
			char t = a[x2];
			a[x2] = a[y];
			a[y] = t;
			x2++;
			y--;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		char[] a = scan.nextLine().trim().toCharArray();
		
		
		f_next(a);
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]);
		}
		System.out.println();
	}
}

