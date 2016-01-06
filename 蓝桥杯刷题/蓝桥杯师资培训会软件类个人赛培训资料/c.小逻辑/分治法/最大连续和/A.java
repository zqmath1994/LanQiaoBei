
/*
   10 5 -3 12 -31 15 22 -7 6 -8 -9 10 ....
   ������O(n^3)
   ���Σ�[      mid   )  ������������
   ���߷��� O(n)
      2�����飺
      ���󵽱�λ�����ֵ�����ۼ�
      ���󵽱�λ���ۼӵ���Сֵ
      
   ���ѣ����������
*/


public class A
{
	// ��a, [p,q) ���������������
	public static int g(int[] a, int p, int q)
	{
		if(q-p==1){
			if(a[p]>0) return a[p];
			return 0;
		}
		
		int mid = (p+q)/2;
		
		int max = 0;
		int m1 = g(a,p,mid);
		if(m1>max) max = m1;
		
		int m2 = g(a,mid,q);
		if(m2>max) max = m2;
		
		// �м�������չ����
		int m3a=0;
		int sum = 0;
		for(int i=mid; i>=p; i--){
			sum += a[i];
			if(sum>m3a) m3a = sum;
		}
		
		// �м�������չ����
		int m3b=0;
		sum = 0;
		for(int i=mid+1; i<q; i++){
			sum += a[i];
			if(sum>m3b) m3b = sum;
		}
		
		int m3 = m3a + m3b;
		if(m3>max) max = m3;
		
		return max;
	}
	
	public static int f(int[] a)
	{
		int max = 0;
		for(int i=0; i<a.length; i++)
		for(int j=i+1; j<a.length+1; j++){
			int sum = 0;
			for(int k=i; k<j; k++) sum += a[k];
			if(sum > max) max = sum; 
		}
		return max;
	}
	
	
	public static void main(String[] args)
	{
		final int N = 2000; 
		
		int[] a = new int[N];
		
		for(int i=0; i<a.length; i++){
			a[i] = (int)(Math.random() * 100) - 50;
		}
		
		System.out.println(f(a));
		System.out.println("-----------------------");
		System.out.println(g(a,0,a.length));
	}
}