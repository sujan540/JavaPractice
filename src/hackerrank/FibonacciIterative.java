package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by root on 2020-01-23.
 */
public class FibonacciIterative {

    static int fib(int nth) {
        if(nth == 0){
            return 0;
        }

        int prev = 0;
        int current = 1;
        int prevPrev;

        for (int i = 1; i < nth; i++) {
            prevPrev = prev;
            prev = current;
            current = prevPrev + prev;
        }
        return current;
    }

    public static void main(String[] args) throws IOException{
        String number;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while ((number = bf.readLine()) != null) {
            if (number.isEmpty()) {
                break;
            }
            System.out.println(fib(Integer.parseInt(number)));
        }
    }
}
