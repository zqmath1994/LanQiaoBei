
// ÖøÃûµÄÄáÄ·ÓÎÏ·
// 3,4,5 Ó²±Ò¶Ñ

public class C
{
	static boolean f(int a, int b, int c)
	{
		if(a==0 && b==0 && c==0) return false;
		
		for(int i=1; i<=a; i++){
			if(f(a-i,b,c)==false) return true;
		}
		for(int i=1; i<=b; i++){
			if(f(a,b-i,c)==false) return true;
		}
		for(int i=1; i<=c; i++){
			if(f(a,b,c-i)==false) return true;
		}
		
		return false;
	}
	
	static String zhao(int a, int b, int c)
	{
		if(a==0 && b==0 && c==0) return "Êä";
		
		for(int i=1; i<=a; i++){
			if(f(a-i,b,c)==false) return "aÖĞÄÃ " + i;
		}
		for(int i=1; i<=b; i++){
			if(f(a,b-i,c)==false) return "bÖĞÄÃ " + i;
		}
		for(int i=1; i<=c; i++){
			if(f(a,b,c-i)==false) return "cÖĞÄÃ " + i;
		}
		
		return "Êä";
	}	
	
	public static void main(String[] args)
	{
		System.out.println(zhao(3,4,5));
	}
}