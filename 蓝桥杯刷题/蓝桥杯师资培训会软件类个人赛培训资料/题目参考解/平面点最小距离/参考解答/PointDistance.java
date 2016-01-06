
import java.io.*;
import java.util.*;

public class PointDistance
{	
	static class PP
	{
		public int x;
		public int y;
		
		public String toString()
		{
			return x + ", " + y;
		}
		
		public PP(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	static class RR
	{
		double x1;
		double x2;
		double y1;
		double y2;
		
		boolean isIn(PP p)
		{
			return (x1 < p.x && p.x < x2 && y1 < p.y && p.y < y2);
		}
	}
	
	public static double f(List<PP> lst, double x1, double x2, double y1, double y2)
	{
		if(lst.size()<4) return 10000;
		
		if(lst.size()<10)
		{
			double min = 10000;
			for(int i=0; i<lst.size(); i++)
			for(int j=i+1; j<lst.size(); j++)	
			for(int k=j+1; k<lst.size(); k++)
			for(int m=k+1; m<lst.size(); m++)
			{
				double d = distance(lst.get(i),lst.get(j),lst.get(k),lst.get(m));
				if( d < min ) min = d;
			}
			
			return min;
		}
		
		// 缩小边界
		double x1a = x2;
		double x2a = x1;
		double y1a = y2;
		double y2a = y1;
		for(int i=0; i<lst.size(); i++)
		{
			PP p = lst.get(i);
			if(p.x < x1a) x1a = p.x;
			if(p.x > x2a) x2a = p.x;
			if(p.y < y1a) y1a = p.y;
			if(p.y > y2a) y2a = p.y;
		}
		x1 = x1a;
		x2 = x2a;
		y1 = y1a;
		y2 = y2a;
		
		
		// 拆分lst 为4块
		RR r1 = new RR();
		RR r2 = new RR();
		RR r3 = new RR();
		RR r4 = new RR();		

		r1.x1 = x1;
		r1.y1 = y1;
		r1.x2 = x1 * 0.25 + x2 * 0.75;
		r1.y2 = y1 * 0.25 + y2 * 0.75;
		
		r2.x1 = x1 * 0.75 + x2 * 0.25;
		r2.y1 = y1 * 0.75 + y2 * 0.25;
		r2.x2 = x2;
		r2.y2 = y2;
		
		r3.x1 = x1;
		r3.y1 = y1 * 0.75 + y2 * 0.25;
		r3.x2 = x1 * 0.25 + x2 * 0.75;
		r3.y2 = y2;
		
		r4.x1 = x1 * 0.75 + x2 * 0.25;
		r4.y1 = y1;
		r4.x2 = x2;
		r4.y2 = y1 * 0.25 + y2 * 0.75;	
		
		List<PP> t1 = new Vector<PP>();
		List<PP> t2 = new Vector<PP>();
		List<PP> t3 = new Vector<PP>();
		List<PP> t4 = new Vector<PP>();
		
		for(int i=0; i<lst.size(); i++)
		{
			PP p = lst.get(i);
			if(r1.isIn(p)) t1.add(p);
			if(r2.isIn(p)) t2.add(p);
			if(r3.isIn(p)) t3.add(p);
			if(r4.isIn(p)) t4.add(p);
		}
		
		double d1 = f(t1, r1.x1, r1.x2, r1.y1, r1.y2);
		double d2 = f(t2, r2.x1, r2.x2, r2.y1, r2.y2);
		double d3 = f(t3, r3.x1, r3.x2, r3.y1, r3.y2);
		double d4 = f(t4, r4.x1, r4.x2, r4.y1, r4.y2);
		
		double d = d1;
		if(d2<d) d = d2;
		if(d3<d) d = d3;
		if(d4<d) d = d4;
		
		return d;
	}
	
	public static double distance(PP a, PP b, PP c, PP d)
	{
		double dis = 
		(distance(a,b) + distance(a,c) + distance(a,d) +
		distance(b,c) + distance(b,d) +
		distance(c,d)) / 6.0; 
		
		return dis;
	}
	
	public static double distance(PP a, PP b)
	{
		double dx = a.x - b.x;
		double dy = a.y - b.y;
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	
	public static List<PP> readPoints(String fname) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fname)));
		List<PP> lst = new Vector<PP>();
		
		for(;;)
		{
			String s = br.readLine();
			if(s==null) break;
			
			String[] ss = s.split(",");	
			PP a = new PP(0,0);
			a.x = Integer.parseInt(ss[0]);
			a.y = Integer.parseInt(ss[1]);
			lst.add(a);
		}
		
		br.close();
		
		return lst;
	}
	

	
	public static void main(String[] args) throws Exception
	{
		List<PP> lst = readPoints("in.txt");		
		double x = f(lst,0,1000,0,1000);
		System.out.println(x);
	}	
}