package practise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by maharsu on 6/27/20.
 */
public class FindDuplicate {

    public static int findDuplicate(int[] arrays) {

        final Map<Integer, Integer> integer = new HashMap<>();

        for (int i = 0; i < arrays.length; i++) {
            int count = 1;
            if (integer.containsKey(arrays[i])) {
                count = integer.get(arrays[i]) + 1;
            }
            integer.put(arrays[i], count);
        }
        return integer.keySet()
                .stream()
                .filter(key -> integer.get(key) == 2)
                .findFirst()
                .get();
    }

    public static int findDuplicate2(int[] arrays) {
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < arrays.length; i++) {
            if (integers.contains(arrays[i])) {
                return arrays[i];
            }
            integers.add(arrays[i]);
        }
        return -1;
    }

    public static int findDuplicate3(int[] arrays) {

        int[] integers = new int[arrays.length];

        for (int i = 0; i < arrays.length; i++) {
            if(i==77){
                System.out.println(arrays[i]);
            }
            if (integers[i] == 0) {
                integers[i] = arrays[i];
            } else {
                return arrays[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] integers = new int[100];
        for (int i = 0; i < 99; i++) {
            integers[i] = i+1;
        }
        integers[99] = 77;

        System.out.println(findDuplicate3(integers));

    }
}
