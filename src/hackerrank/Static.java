package hackerrank;

import java.util.Scanner;

public class Static {

	static int B;
	static int H;
	static boolean flag;

	static {

		Scanner scan = new Scanner(System.in);

		B = scan.nextInt();
		H = scan.nextInt();

		flag = (B > 0) && (H > 0);
		if (!flag) {
			try {
				throw new Exception("Breadth and height must be positive");
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void main(String[] args) throws Exception {

		if (flag) {
			int area = B * H;
			System.out.print(area);
		}

	}// end of main

}
