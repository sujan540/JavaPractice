package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by root on 2020-01-27.
 */
public class FizzBuzz {

    static String fizzBuzz(int value) {
        if (value % 3 == 0 && value % 5 == 0) {
            return "FizzBuzz";
        } else if (value % 3 == 0) {
            return "Fizz";
        } else if (value % 5 == 0) {
            return "Buzz";
        }
        return "" + value;
    }

//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//    int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        Result.fizzBuzz(n);
//
//        bufferedReader.close();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        scanner.close();

        for (int i = 1; i <= input; i++) {
            System.out.println(fizzBuzz(i));
        }
    }
}
