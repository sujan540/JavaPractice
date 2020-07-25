package DataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by sujan on 6/3/16.
 */
public class MyArrayList {

    private Object[] arrays;
    private int size = 0;

    public MyArrayList() {
        arrays = new Object[10];
    }

    public Object get(int index) {
        if (index < size)
            return arrays[index];

        throw new ArrayIndexOutOfBoundsException();

    }

    public void add(Object value) {
        if (arrays.length - size <= 5) {
            incrementArraySize();
        }
        arrays[size++] = value;
    }

    public void incrementArraySize() {
        arrays = Arrays.copyOf(arrays, arrays.length * 2);
    }

    public Object remove(int index) {
        if (index < size) {
            Object obj = arrays[index];
            arrays[index] = null;
            int temp = index;
            while (temp < size) {
                arrays[temp] = arrays[temp + 1];
                arrays[temp + 1] = null;
                temp++;

            }
            size--;
            return obj;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyArrayList array = new MyArrayList();
        for (int i = 0; i < 10; i++) {
            array.add(new Integer(10 + i));
        }

        System.out.println("Size:" + array.size());

        for (int i = 0; i < array.size(); i++) {
            System.out.println("Out array[" + i + "]:" + array.get(i));
        }

        System.out.println("Remove array[5]:" + array.remove(5));
        for (int i = 0; i < array.size(); i++) {
            System.out.println("Out again array[" + i + "]:" + array.get(i));
        }
    }
}
