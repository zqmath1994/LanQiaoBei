package Hex2Dec;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String hexString=scanner.next();
		BigInteger hex=new BigInteger(hexString);
		
		System.out.println((hex.toString(16)).toUpperCase());
	}

}
