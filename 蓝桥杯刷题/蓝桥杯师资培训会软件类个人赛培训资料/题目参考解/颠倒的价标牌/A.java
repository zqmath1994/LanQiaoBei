
import java.util.*;

public class A
{
	public static void main(String[] args)
	{
		Set set = new TreeSet();
		
		int[] M = {0,1,2,5,6,8,9};
		int[] W = {0,1,2,5,9,8,6};
		
		for(int a=1; a<7; a++)
		for(int b=0; b<7; b++)
		for(int c=0; c<7; c++)
		for(int d=1; d<7; d++){
			int x = M[a] * 1000 + M[b] * 100 + M[c] * 10 + M[d];
			int y = W[d] * 1000 + W[c] * 100 + W[b] * 10 + W[a];
			
			int cha = Math.abs(x-y); 
			set.add(cha);
			
			if(cha==282) System.out.println(x + " ------- " + y);
 		}
 		
 		
 		Object[] t = set.toArray();
 		
 		Set set2 = new TreeSet();
 		
 		for(int i=0; i<t.length; i++)
 		for(int j=i+1; j<t.length; j++) {
 			int k = (Integer)t[j] - (Integer)t[i];
 			if(k<2000){ 
 				set2.add(k);
 				if(k==558) System.out.println(t[i] + ", " + t[j]);
 			}
 			else
 				break;
 		}
 		
 		//System.out.println(set2);
 		
	}
}