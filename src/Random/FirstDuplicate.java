package Random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by root on 2020-02-09.
 */
public class FirstDuplicate {

    public static Integer firstDuplicate_1(Integer[] values) {
        Set<Integer> collection = new HashSet<>();
        for (Integer value : values) {
            if (collection.contains(value)) {
                return value;
            } else {
                collection.add(value);
            }
        }
        return -1;
    }


    //brute force
    public static Integer firstDuplicate(Integer[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 1; j < values.length; j++) {
                if (values[i] == values[j] && i != j) {
                    return values[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        //final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //final String[] array = bf.readLine().replaceAll("\\s+$", "").split(",");
        final String[] array = "2,3,4,5,5,6".split(",");

        Integer[] values = Stream.of(array)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        System.out.println(firstDuplicate(values));

        System.out.println(firstDuplicate_1(values));

        //bf.close();
    }
}
