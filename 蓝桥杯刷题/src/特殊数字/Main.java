package 特殊数字;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=100;i<=999;i++)
		{
			if(i==(Math.pow(i/10/10, 3)+Math.pow(i/10%10, 3)+Math.pow(i%10, 3)))
			{
				System.out.println(i);
			}
		}
	}

}
