package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by root on 2020-01-23.
 */
public class factorial {

    static Long fact(Long n) {
        return n == 0 ? 1 : n * fact(n - 1);
    }

    static Long factIte(Long n) {
        Long fact = 1L;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            Long number = Long.parseLong(bufferedReader.readLine());

            System.out.println(fact(number));

            System.out.println(factIte(number));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
