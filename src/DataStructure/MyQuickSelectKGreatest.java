package DataStructure;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by sujan on 6/8/16.
 */
public class MyQuickSelectKGreatest {


    public int quickSelect(int[] array, int position) {
        return quickSelect(array, 0, array.length - 1, position - 1);
    }

    private int quickSelect(int[] array, int first, int last, int position) {
        if (first <= last) {
            int pivot = partition(array, first, last);
            if (pivot == position) {
                return array[position];
            }
            if (pivot > position) {
                return quickSelect(array, first, pivot - 1, position);
            }
            return quickSelect(array, pivot + 1, last, position);
        }
        return Integer.MIN_VALUE;
    }

    public int partition(int[] array, int first, int last) {
        int pivot = first + new Random().nextInt(last - first + 1);
        System.out.println(pivot);
        swap(array, last, pivot);
        display(array);
        for (int i = first; i < last; i++) {
            if (array[i] > array[last]) {
                swap(array, i, first);
                first++;
            }
            display(array);
        }
        swap(array, first, last);
        display(array);
        return first;
    }


    public void display(int[] array){
        System.out.println(Arrays.toString(array));
    }


    public static void main(String[] args) {
        MyQuickSelectKGreatest quickSelect = new MyQuickSelectKGreatest();

        System.out.println(quickSelect.quickSelect(new int[]{21, 3, 34, 5, 13, 8, 2, 55, 1, 19}, 4));
    }


    private void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
