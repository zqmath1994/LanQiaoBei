
// 间接递归
/*
A B C D中取5次，每个字母都可以重复取出，形成一个串。
现在要求，串中A出现的次数必须为偶数（0次也算偶数）。
求可以形成多少种可能的串。
*/

// 递归思路：下一次取不取A

public class C
{
	// 取n次，A出现奇数次
	public static int g(int n)
	{
		if(n==1) return 1;
		
		return 3 * g(n-1) + f(n-1);
	}

	// 取n次，A出现偶次
	public static int f(int n)
	{
		if(n==1) return 3;
		return 3 * f(n-1) + g(n-1);
	}

	public static void main(String[] args)
	{
		System.out.println(f(5));
	}
}