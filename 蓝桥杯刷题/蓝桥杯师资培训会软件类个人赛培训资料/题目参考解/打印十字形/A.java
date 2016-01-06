
import java.util.*;

public class A
{
	static char[][] Zu;
	
	static class Tur
	{
		int dr = 0;
		int di = -1;
		
		int x = 0;
		int y = 0;
		
		void left()
		{
			int dr2 = di;
			int di2 = -dr;
			dr = dr2;
			di = di2;
		}
		void right()
		{
			int dr2 = -di;
			int di2 = dr;
			dr = dr2;
			di = di2;
		}
		void dot()
		{
			//System.out.println(x+","+y);
			Zu[x][y] = '$';
		}
		void go()
		{
			x += dr;
			y += di;
		}
	}
	
	static void show()
	{
		for(int i=0; i<Zu.length; i++)
		{
			for(int j=0; j<Zu[i].length; j++)
			{
				if(Zu[i][j]>0)
					System.out.print(Zu[i][j]);
				else
					System.out.print('.');
			}
			System.out.println();
		}
	}
	
	static void f(int n, int x0, int y0)
	{
		Tur tur = new Tur();
		tur.x = x0+2;
		tur.y = y0+2;
		
		for(int k=0; k<4; k++)
		{
			for(int i=0; i<2; i++){
				tur.dot(); 
				tur.go();
			}
			tur.right();
			for(int i=0; i<4*n; i++){
				tur.dot(); 
				tur.go();
			}
			tur.right();
			for(int i=0; i<2; i++){
				tur.dot(); 
				tur.go();
			}
			tur.left();
		}		
	}
	
	static void test(int n)
	{
		Zu = new char[4*n+5][4*n+5];
		
		for(int i=n; i>=0; i--)
			f(i,2*n-i*2,2*n-i*2);
		
		show();		
	}
	
	public static void main(String[] args)
	{
		test(5);
		//test(13);	
	}
}