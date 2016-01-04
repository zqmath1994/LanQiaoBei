package 猜年龄;

public class Main {

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
