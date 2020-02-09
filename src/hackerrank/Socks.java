package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by root on 2020-02-02.
 */
public class Socks {

    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> socks = new HashMap<>();

        for (int i = 0; i < ar.length; i++) {
            if (socks.containsKey(ar[i])) {
                socks.put(ar[i], socks.get(ar[i]) + 1);
            } else {
                socks.put(ar[i], 1);
            }
        }
        int result = 0;
        for (Integer sockCount : socks.values()) {
            result += sockCount / 2;
        }

        return result;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] number = bf.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(number[0]);
        String[] str = bf.readLine().replaceAll("\\s+$", "").split(" ");
        int size = str.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

//        Integer[] colors = Stream.of(bf.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .toArray(Integer[]::new);

        System.out.println(sockMerchant(n, arr));
    }
}
