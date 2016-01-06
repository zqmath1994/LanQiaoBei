
// 罗马数字

public class A
{
	static int f(String s)
	{
		int sum = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='I') sum += 1;
			if(s.charAt(i)=='V') sum += 5;
			if(s.charAt(i)=='X') sum += 10;
			if(s.charAt(i)=='L') sum += 50;
			if(s.charAt(i)=='C') sum += 100;
			if(s.charAt(i)=='D') sum += 500;
			if(s.charAt(i)=='M') sum += 1000;
		}
		
		// 一刀切之后再修正
		if(s.indexOf("IV")>=0) sum -= 2;
		if(s.indexOf("IX")>=0) sum -= 2;
		if(s.indexOf("XL")>=0) sum -= 20;		
		if(s.indexOf("XC")>=0) sum -= 20;
		if(s.indexOf("CD")>=0) sum -= 200;
		if(s.indexOf("CM")>=0) sum -= 200;
		
		
		return sum;
	}
	
	public static void main(String[] args)
	{
		System.out.println(f("CMXCIX"));
	}
}