
//手工计算日期差

public class B
{
	static boolean leap_year(int year){
		return year%4==0 && year%100!=0 || year%400==0;	
	}
	
	static int f(int year, int month, int day)
	{
		int sum = 0;
		
		for(int i=1; i<year; i++){
			sum += 365;
			if(leap_year(i)) sum++;
		}
		
		int[] M = {-999, 31,28,31,30,31,30,31,31,30,31,30,31};
		if(leap_year(year)) M[2]++;
		
		for(int i=1; i<month; i++){
			sum += M[i];
		}
		
		return sum + day;
	}
	
	public static void main(String[] args)
	{
		//int n = f(2015,11,21);
		int n = f(2,1,1);
		System.out.println(n);
	}
}