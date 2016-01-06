
public class C
{
	static void f(int n)
	{
		int group = (n+7) / 8; // 组数
	    int base = n / group;	  // 每组至少人数
	    
	    for(int i=0; i<group; i++){
	    	if(i<n%group)
	    		System.out.println(base+1);
	    	else
	    		System.out.println(base);
	    }
	}
	
	public static void main(String[] args)
	{
		f(25);
	}
}