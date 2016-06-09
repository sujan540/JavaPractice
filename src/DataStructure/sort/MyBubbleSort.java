package DataStructure.sort;

/**
 * Created by sujan on 6/7/16.
 */
public class MyBubbleSort {

    private int[] array;

    public MyBubbleSort(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    array[j - 1] = array[j - 1] + array[j];
                    array[j] = array[j - 1] - array[j];
                    array[j - 1] = array[j - 1] - array[j];
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        MyBubbleSort sort = new MyBubbleSort(new int[]{4, 3, 2, 5, 7, 6, 4, 3, 7, 8, 9, 1, 2, 3, 1, 0});
        int[] sorted = sort.sort();

        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + " ");
        }
    }
}
