
/*
  �ݹ�˼�룺ĳЩ��Ӫ�ġ���Ƥ��

1. ��������
2. ����

���£���ǰ�и�ɽ��ɽ���и��������и����У���������

����  �������Ρ�������
*/

public class A
{
	// ��ӡ��0~n
	static void f(int n)
	{
		if(n>0) f(n-1);
		System.out.println(n);		
	}
	
	// ��ӡ��begin��end
	static void g(int begin, int end)
	{
		if(begin>end) return;
		System.out.println(begin);
		g(begin+1,end);
	}
	
	public static void main(String[] args)
	{
		g(0,9);
		//f(9);
		//for(int i=0; i<10; i++){
		//	System.out.println(i);
		//}
	}	
}