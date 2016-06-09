package DataStructure;

import java.util.Scanner;

/**
 * Created by sujan on 6/4/16.
 */
public class MyStack {

    private int size;
    private int[] array;
    private int pointer;

    public MyStack(int size) {
        this.size = size;
        this.array = new int[size];
        pointer = -1;
    }

    public void push(int i) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        array[++pointer] = i;
    }

    public int pop() {
        if (pointer == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return array[pointer--];
    }

    public int peek() {
        if (pointer == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return array[pointer];
    }

    public boolean isFull() {
        return size - 1 == pointer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        MyStack stack = new MyStack(size);
        for (int i = 0; i < size; i++) {
            stack.push(scan.nextInt());
        }

        stack.push(10);
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
    }
}


