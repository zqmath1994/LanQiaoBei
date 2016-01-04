package 猜年龄;

public class Main {


//美国数学家维纳(N.Wiener)智力早熟，11岁就上了大学。他曾在1935~1936年应邀来中国清华大学讲学。
//
//一次他参加某个重要会议，年轻的脸孔引人注目。于是有人询问他的年龄，他回答说：
//
//“我年龄的立方是个4位数。我年龄的4次方是个6位数。
//	这10个数字正好包含了从0到9这10个数字，每个都恰好出现1次。

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		for(int i=10;i<=100;i++)
		{
			String n4=String.valueOf((int)Math.pow(i, 3));
			String n6=String.valueOf((int)Math.pow(i, 4));
			int n4len=n4.length();
			int n6len=n6.length();
			if(n4len==4&&n6len==6)
			{
				for(int j=0;j<n4len;j++)
				{
					if(n6.indexOf(n4.charAt(j))==-1)
					{
						if(j==n4len-1)
						{
							System.out.println(i);
							return;
						}
						continue;
					}
					else{
						break;
					}
					
				}
			}
		}
	}
}
