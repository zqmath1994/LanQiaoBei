
// n����ֻ��ȡ��1��3��7����8��

// ��α��������ظ�����
// 1. ���ƶ�̬�滮
// 2. ����

// ��̬�滮����ѧ�ϵݹ�˼�룬˼���ϵ��ڵݹ�
//    ������ʹ�õݹ��ֶΣ�ͨ��������������� �����ܿ���ݹ�

import java.util.*;

public class A
{
	public static Map map = new HashMap();
	public static boolean f(int n)
	{
		if(n==0) return true;
		
		Boolean t = (Boolean)map.get(n);
		if(t!=null) return t;
		
		if(n>=1 && f(n-1)==false){map.put(n,true); return true;}
		if(n>=3 && f(n-3)==false){map.put(n,true); return true;}
		if(n>=7 && f(n-7)==false){map.put(n,true); return true;}
		if(n>=8 && f(n-8)==false){map.put(n,true); return true;}
		map.put(n,false);
		return false; 
	}
	
	public static void main(String[] args)
	{
		System.out.println(f(508));
	}
}