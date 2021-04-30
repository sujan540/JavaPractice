package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ContinuousSubArray {

    public static void main(String[] args) {

        //List<Integer> input = Arrays.asList(1, 3, 2, 4, 6, 7, 5, 10);
        //List<Integer> input = Arrays.asList(1, 5, 10);
        //List<Integer> input = Arrays.asList(11, 3, 2, 4, 6, 7, 5, 10, 9);
        List<Integer> input = Arrays.asList(11, 3, 2, 4, 6, 7, 5, 10);
        // List<Integer> input = Arrays.asList();

        System.out.println(subArray(input));
    }

    public static List<Integer> subArray(List<Integer> array) {
        List<Integer> result = new ArrayList<>();

        int start = -1;
        int end = -1;
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) > array.get(i + 1) && (start == -1)) {
                start = i;
                continue;
            }
        }
        for (int i = array.size() - 1; i > 0; i--) {
            if (array.get(i) < array.get(i - 1) && (end == -1)) {
                end = i;
                continue;
            }
        }
        System.out.println(start);
        System.out.println(end);
        if (start == -1 && end == -1) {
            return new ArrayList<>();
        }
        for (int i = start; i <= end; i++) {
            result.add(array.get(i));
        }
        return result;
    }

    public void subArrays(int[] array) {
        IntStream.range(0, array.length)
                .forEach(index -> System.out.println(index + " -> " + array[index]));
    }
}
