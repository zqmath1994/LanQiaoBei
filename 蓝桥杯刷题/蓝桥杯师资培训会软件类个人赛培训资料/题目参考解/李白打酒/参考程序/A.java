
public class A
{
	static int n = 0;
	
	// v 当前酒中酒量，inn 遇到店的剩余次数，flower: 遇到花的剩余...
	// path: 历史经历
	static void f(int v, int inn, int flower, String path)
	{
		if(v<0) return;
		
		if(inn==0 && flower==0){
			if(v==0 && path.endsWith("b")){
			//if(v==0){
				System.out.println(path);
				n++;
			}
			return;
		}
		
		if(inn>0) f(v*2, inn-1, flower, path+"a");
		if(flower>0) f(v-1, inn, flower-1, path+"b");
	}
	
	public static void main(String[] args)
	{
		f(2,5,10,"");
		System.out.println("n=" + n);
	}
}