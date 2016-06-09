package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class VeryBigSum {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		BigInteger sum = BigInteger.valueOf(0);
		for(int i=0;i<count;i++){
			sum = sum.add(scan.nextBigInteger());
		}
		
		System.out.println(sum);
	}

}
