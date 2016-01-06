

// 拉丁方块问题

import java.util.*;

public class A
{
/*	
	static char[][] x = new char[6][6];
	static{
		x[0][4] = 'B';
		x[0][5] = 'A';
		x[1][3] = 'D';
		x[1][4] = 'C';
		x[2][4] = 'E';
		x[4][5] = 'F';
	}

	static int[][][] group = {
		{{0,0},{0,1},{1,0},{1,1},{2,0},{3,0}},
		{{0,2},{0,3},{0,4},{0,5},{1,3},{1,4}}, 
		{{1,2},{2,1},{2,2},{2,3},{3,1},{3,2}},
		{{1,5},{2,5},{3,5},{4,5},{5,5},{4,4}},
		{{2,4},{3,3},{3,4},{4,1},{4,2},{4,3}},
		{{4,0},{5,0},{5,1},{5,2},{5,3},{5,4}}
	};
	
	static int[][] groupNo = {
		{0,0,1,1,1,1},
		{0,0,2,1,1,3},
		{0,2,2,2,4,3},
		{0,2,2,4,4,3},
		{5,4,4,4,3,3},
		{5,5,5,5,5,3}
	};
*/

	static char[][] x = new char[6][6];

//	static {
//		x[0][2] = 'C';
//		x[0][3] = 'B';
//		x[0][5] = 'A';
//		x[2][0] = 'D';
//		x[3][5] = 'E';
//		x[5][3] = 'F';
//	}

	static int[][][] group = new int[6][6][2];
//      {
//		{{0,0},{0,1},{0,2},{0,3},{1,0},{1,3}},
//		{{0,4},{0,5},{1,4},{2,2},{2,3},{2,4}}, 
//		{{1,1},{1,2},{2,0},{2,1},{3,0},{4,0}},
//		{{1,5},{2,5},{3,2},{3,3},{3,4},{3,5}},
//		{{3,1},{4,1},{4,2},{4,3},{5,0},{5,1}},
//		{{4,4},{4,5},{5,2},{5,3},{5,4},{5,5}}
//	};
	
	static int[][] groupNo = new int[6][6];
//      {	
//		{0,0,0,0,1,1},
//		{0,2,2,0,1,3},
//		{2,2,1,1,1,3},
//		{2,4,3,3,3,3},
//		{2,4,4,4,5,5},
//		{4,4,5,5,5,5}
//	};

	
	static int N = 0;

	public static void createGroupData()
	{
		int[] k = new int[6];
		
		for(int i=0; i<6; i++)
		{
			for(int j=0; j<6; j++)
			{
				int g = groupNo[i][j];
				group[g][k[g]][0] = i;
				group[g][k[g]][1] = j;
				k[g]++;
			}
		}
	}

	public static void read()
	{
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<6; i++)
		{
			String s = scan.nextLine();
			for(int j=0; j<6; j++)
				groupNo[i][j] = s.charAt(j)-'0'; 
		}
		
		int n = Integer.parseInt(scan.nextLine());
		for(int i=0; i<n; i++)
		{
			String s = scan.nextLine();
			x[s.charAt(0)-'0'][s.charAt(1)-'0'] = s.charAt(2);
		}
		
		createGroupData();
	}
	
	public static void show()
	{
		N++;
		System.out.println(N);
		for(int i=0; i<6; i++)
		{
			for(int j=0; j<6; j++)
			{
				System.out.print(x[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
	public static char check(int r, int c, int k)
	{
		int n = groupNo[r][c];
		int[] p = group[n][k];
		return x[p[0]][p[1]];
	}
	
	public static void f(int r, int c)
	{		
		if(r==6)
		{
			show();
			System.out.println("");
			return;
		}
		
		if(x[r][c]>0)
		{
			if(c==5)
				f(r+1,0);
			else
				f(r,c+1);
			return;
		}
		
		
		int[] pos = new int[6];
		
		// 可填写范围
		for(int i=0; i<6; i++)
		{
			if(x[r][i] > 0) pos[x[r][i]-'A'] = 1;
			if(x[i][c] > 0) pos[x[i][c]-'A'] = 1;
			char t = check(r,c,i);
			if(t>0) pos[t-'A'] = 1;
		}
		
		
		for(int i=0; i<6; i++)
		{
			if(pos[i]==1) continue;
			
			x[r][c] = (char)('A' + i);
			if(c==5)
				f(r+1,0);
			else
				f(r,c+1);
			x[r][c] = 0;  // 回溯
		}	
	}
	
	public static void main(String[] args)
	{
		read();		
		f(0,0);
	}
}