package hackerrank;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by root on 2020-01-27.
 */
public class CoinChange {

    static long getWays(int n, List<Long> c) {

        long[][] A = new long[n + 1][c.size()];

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y < c.size(); y++) {
                if (x == 0 && y == 0) {
                    A[x][y] = 0;
                } else if (y == 0 && x > 0) {
                    A[x][y] = x % c.get(y) == 0 ? 1 : 0;
                } else {
                    if (x < c.get(y)) {
                        A[x][y] = A[x][y - 1];
                    } else if (x == c.get(y)) {
                        A[x][y] = A[x][y - 1] + 1;
                    } else {
                        A[x][y] = A[x - c.get(y).intValue()][y] + A[x][y - 1];
                    }
                }
            }
        }

        return A[n][c.size()-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        System.out.println(getWays(n, c));

//        bufferedWriter.write(String.valueOf(ways));
//        bufferedWriter.newLine();

        bufferedReader.close();
        //      bufferedWriter.close();
    }
}
