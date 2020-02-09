package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingVallly {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int count = 0;
        boolean flag = true;
        int seaLevel = 0;
        for (int i = 0; i < n; i++) {
            if (flag && i + 2 < n && s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == 'D' && s.charAt(i + 2) == 'U') {
                count++;
                flag = false;
            }
            if (!flag && s.charAt(i) != s.charAt(i + 1) && i + 1 < n) {
                flag = true;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(result);

        scanner.close();
    }
}
