package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

	public static int reverse(int number) {

		int reverse = 0;

		while (number != 0) {
			reverse = reverse * 10 + number % 10;
			number = number / 10;
		}
		return reverse;
	}

	public static void main(String[] args) {

		String test = "racecar";
		String test1 = "race car";
		String test2 = "i      i";
		String test3 = "a shoe a - not a palindrome";
		String test4 = "a race car a";

		System.out.println(isPalindrome(test));
		System.out.println(isPalindrome(test1));
		System.out.println(isPalindrome(test2));
		System.out.println(isPalindrome(test3));
		System.out.println(isPalindrome(test4));


		System.out.println(longestPalindrome("wow i am in racecar house around noon"));

	}

	public static boolean isPalindrome(String text) {

		int length = text.length();

		String inputText = "";

		for (int i = 0; i < length; i++) {
			char c = text.charAt(i);
			if (Character.isWhitespace(c)) {
				continue;
			}
			inputText += c;
		}
		String compareText = "";
		for (int j = length - 1; j >= 0; j--) {
			char c = text.charAt(j);
			if (Character.isWhitespace(c)) {
				continue;
			}
			compareText += c;
		}

		return inputText.equals(compareText);
	}


	public static int longestPalindrome(String text) {

		if (isPalindrome(text)) {
			return text.length();
		}

		int maxLength = -1;
		for (int i = 0; i < text.length(); i++) {
			for (int j = i; j < text.length(); j++) {
				String tempString = text.substring(i, j);
				if (isPalindrome(tempString) && tempString.length() > maxLength) {
					maxLength = tempString.length();
				}
			}
		}

		return maxLength;
	}
}

