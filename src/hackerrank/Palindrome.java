package hackerrank;

public class Palindrome {

	public static int reverse(int number) {

		int reverse = 0;

		while (number != 0) {
			reverse = reverse * 10 + number % 10;
			number = number / 10;
		}
		return reverse;
	}

}
