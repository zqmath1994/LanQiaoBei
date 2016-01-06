
/*
  �ҵ�ĳ�����е���һ����������
  �ȱ����д�����������У�ѡ�ֵ�����С��
  
  1. ��������һ�����ڵ�Ԫ�أ�[x1,x2] ���� [x1] < [x2], ��ʧ�ܣ��򲻴�����һ�����У����������
  2. ��������һ��Ԫ�� [y] ���� [y]>[x1], ��Ȼ�������£�x2����y������һ�����ҵ�
  3. ����: [x1] <--> [y]
  4. [x2,...] x2�Ժ�����з�ת
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

