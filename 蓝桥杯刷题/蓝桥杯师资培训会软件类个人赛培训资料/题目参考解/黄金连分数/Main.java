import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/*
0.
6180339887 
4989484820 
4586834365 
6381177203 
0917980576 
2862135448 
6227052604 
6281890244 
9707207204 
1893911374
 
8475408807 
5386891752 
1266338622 
2353693179
3180060766 
7263544333
*/

public class Main
{
	public static void main(String[] args)
	{
		BigDecimal a = new BigDecimal(
			new BigInteger("16031593418561412247332727650013131485560413591546962950711890"
			+ "9263076087590471022644452597131283888029087109729"),110);
		BigDecimal b = new BigDecimal(
			new BigInteger("990806962649007214722085159567487591879198048406087340073676610"
			+ "59706052043279378932885908102386332543066271936"),110);
		BigDecimal c = b.divide(a, RoundingMode.HALF_DOWN);
		
		System.out.println(c.toPlainString().substring(0,103));		
	}
}