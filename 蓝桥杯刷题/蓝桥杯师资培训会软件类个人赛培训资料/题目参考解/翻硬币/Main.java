
public class Main
{
	static void create(String s)
	{
		char[] aa = s.toCharArray();
		
		for(int i=0; i<30; i++)
		{
			int k = (int)(Math.random() * s.length());
			if(aa[k]=='*')
				aa[k] = 'o';
			else
				aa[k] = '*';
		}		
		
		System.out.println(s);
		System.out.println(new String(aa));
	}
	
	static void test(String a, String b)
	{
		boolean fan = false;
		int n = 0;
		int N = 0;
		for(int i=0; i<a.length(); i++)
		{
			if(a.charAt(i) != b.charAt(i)){	
				fan = !fan;
				N++;
			}				
			if(fan) n++;
		}
		
		System.out.println(a);
		System.out.println(b);
		System.out.println("fan=" + n);
		System.out.println("N=" + N);
	}
	
	public static void main(String[] args)
	{
		//create("*o***oo***o****o*****oo*****oooo***oo*o*ooooo*******");

			
		test("******************","***oo**oo***oo****");
		
		test("*o***oo***o****o*****oo*****oooo***oo*o*ooooo*******"
			,"*o***oo**oo****o*****oo****oo**o***oo*o*ooooo*******");	
			
		test("*o***oo***o****o*****oo*****oooo***oo*o*ooooo*******"
			,"*oo***oo*oo*****o****o****o*oo*o*oo***o*ooooo****o**");	
	}
}