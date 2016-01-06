
public class RiCheng
{
	static int N = 0;
	
	public static void show(int[][] a)
	{
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<7; j++)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void ping_jia(int[][] a)
	{
		// 连续工作不多于3天
		for(int i=0; i<5; i++)
		{
			int sum = 0;
			for(int j=0; j<14; j++)
			{
				if(a[i][j%7]==0)
					sum = 0;
				else
				{
					sum++;
					if(sum>3) return;
				}
			}
		}
		
		
		// 至少有3天所有人都上班
		int k = 0;
		for(int i=0; i<7; i++)
		{
			if(a[0][i]==0 || a[1][i]==0 || a[2][i]==0 || a[3][i]==0 || a[4][i]==0) k++;
		}
		if(k==7||k==6||k==5) return;
		
		
		// A B C D 中保证有2人上班
		for(int i=0; i<7; i++)
		{
			int m = 0;
			if(a[0][i]==1) m++;
			if(a[1][i]==1) m++;
			if(a[2][i]==1) m++;
			if(a[3][i]==1) m++;
			if(m<2) return;
		}
		
		// B D E 周日必须休息
		if(a[1][6]==1 || a[3][6]==1 || a[4][6]==1) return;
		
		// A E 周三必须上班
		if(a[0][2]==0 || a[4][2]==0) return;
		
		// A 与 C 一周中必须至少有4天能见面
		k=0;
		for(int i=0; i<7; i++)
		{
			if(a[0][i]==1 && a[2][i]==1) k++;
		}
		if(k<4) return;
		
		N++;
		
		show(a);
		System.out.println("");	
	}
	
	public static void f(int[][] a, int row)
	{
		if(row==5)
		{
			ping_jia(a);
			return;
		}
		
		for(int i=0; i<7; i++)
		{
			for(int j=i+1; j<7; j++)
			{
				for(int k=0; k<7; k++) a[row][k] = 1;
				a[row][i] = 0;
				a[row][j] = 0;
				
				f(a, row+1);
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		int[][] a = {{1,1,1,1,1,0,0},{1,1,1,1,1,0,0},{1,1,1,1,1,0,0},
		{1,1,1,1,1,0,0},{1,1,1,1,1,0,0},};
		
		f(a,0);
		
		System.out.println("N=" + N);
	}
}