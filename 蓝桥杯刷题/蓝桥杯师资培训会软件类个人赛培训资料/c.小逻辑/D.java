
// 数学家的年龄

public class D
{
	public static void main(String[] args)
	{
		int[] A = {2,3,5,7,11,13,17,19,23,29};
		
		long goal = 1;
		for(int i=0; i<A.length; i++) goal *= A[i]; 
		
		for(int i=1; i<60; i++){
			int a = i * i * i;
			int b = a * i;
			char[] cc = (""+a+b).toCharArray();
			long prod = 1;
			for(int k=0; k<cc.length; k++){
				prod *= A[cc[k]-'0'];
			}
			
			if(prod == goal) 
				System.out.println(i + "=" + a + b);
							
			/*
			int a = i * i * i;
			int b = a * i;
			if(a<1000 || a >9999) continue;
			if(b<100000 || a >999999) continue;
			System.out.println(i + "==" + a + b);
			*/
		}
	}
}