
public class C
{
	static void f(int n)
	{
		int group = (n+7) / 8; // ����
	    int base = n / group;	  // ÿ����������
	    
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