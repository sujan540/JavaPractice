package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {

    public static int fibonacci(int number) {

        return number == 0 ? 0 : number == 1 ? 1 : fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static void main(String[] args) {

        List<Integer> lists = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        System.out.println(fibonacci(input));

        scanner.close();
    }

}
