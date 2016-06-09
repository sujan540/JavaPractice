package DataStructure.search;

/**
 * Created by sujan on 6/7/16.
 */
public class MyBinarySearch {

    private int[] array;
    private int key;

    public MyBinarySearch(int[] array, int key) {
        this.array = array;
        this.key = key;
    }

    public int binarySearch() {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key == array[mid])
                return mid;
            if (key < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MyBinarySearch search = new MyBinarySearch(new int[]{1, 2, 3, 4, 5, 6, 10, 20, 34, 45, 56, 67, 78}, 78);
        System.out.println("Position of search key is :" + search.binarySearch());
    }

}
