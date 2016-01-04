package 杨辉三角;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue=new LinkedList<Integer>();
		int temp;
		int x;
		Scanner scanner=new Scanner(System.in);
		int m=scanner.nextInt();
		queue.offer(1);
		for(int n=2;n<=m;n++)
		{
			queue.offer(1);
			for(int i=1;i<=n-2;i++)
			{
			 temp=queue.poll();
			System.out.print(temp+" ");
			x=queue.peek();
			temp=temp+x;
			queue.offer(temp);
			}
			x=queue.poll();
			System.out.println(x+" ");
			queue.offer(1);
		}
		while(!queue.isEmpty())
		{
			x=queue.poll();
			System.out.print(x+" ");
		}
	}

}
