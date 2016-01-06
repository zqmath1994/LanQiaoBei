
import java.util.Scanner;

public class A
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		String s = scan.nextLine();
				
		String[] ss = s.split(" ");
		int a = Integer.parseInt(ss[0]);
		int b = Integer.parseInt(ss[1]);
		System.out.println(a+b);		
	}
}