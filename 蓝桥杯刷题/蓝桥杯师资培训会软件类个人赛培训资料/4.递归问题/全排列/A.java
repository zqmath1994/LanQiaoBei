
public class A
{
	public static void test(char[] cc){
		for(char c: cc) System.out.print(c + " ");
		System.out.println();
	}
	
	// x: ������
	// k: ���ǵ�ǰλ�õ�Ԫ����δ�����ĳ�������������Լ���
	public static void g(char[] x, int k)
	{
		if(k==x.length-1){
			test(x);
			return;
		}
		
		for(int i=k; i<x.length; i++){
			//  ����Ԫ�ض���kλ�ó���
			{ char t=x[i]; x[i]=x[k]; x[k]=t; }  //����
			g(x, k+1);
			{ char t=x[i]; x[i]=x[k]; x[k]=t; }  //����
		}
	}
	
	public static void f(String s){
		char[] cc = s.toCharArray();
		
		g(cc, 0);
	}
	
	public static void main(String[] args)
	{
		f("ABCDE");
	}
}