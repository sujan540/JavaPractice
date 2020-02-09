package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 2020-01-27.
 */
public class UncoupleInteger {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> maps = new HashMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line = bf.readLine();

        String[] values = line.split(",");

        for (String value : values) {
            if (maps.containsKey(value.trim())) {
                maps.put(value.trim(), maps.get(value.trim()) + 1);
            } else {
                maps.put(value.trim(), 1);
            }
        }

        for (String value : maps.keySet()) {
            if (maps.get(value) == 1) {
                System.out.println(value);
            }
        }
    }
}
