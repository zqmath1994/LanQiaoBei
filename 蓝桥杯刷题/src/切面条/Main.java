package 切面条;

public class Main {
	
//	标题：切面条
//
//    一根高筋拉面，中间切一刀，可以得到2根面条。
//
//    如果先对折1次，中间切一刀，可以得到3根面条。
//
//    如果连续对折2次，中间切一刀，可以得到5根面条。
//
//    那么，连续对折10次，中间切一刀，会得到多少面条呢？

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=2;
		for (int i = 1; i <= 10; i++) {
			num=num*2-1;
		}
		System.out.println(num);
	}

}
