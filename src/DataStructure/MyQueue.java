package DataStructure;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by sujan on 6/4/16.
 */
public class MyQueue {

    private int queue[];
    private int front, rear, size, len;

    public MyQueue(int capacity) {
        this.size = capacity;
        this.front = -1;
        this.rear = -1;
        this.len = 0;
        this.queue = new int[capacity];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return front == 0 && rear == size - 1;
    }

    public int getSize() {
        return len;
    }

    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return queue[front];
    }

    public void enqueue(int value) {
        if (rear == -1) {
            front = 0;
            rear = 0;
            queue[rear] = value;
        } else if (rear + 1 >= size) {
            throw new IndexOutOfBoundsException("Overflow Exception");
        } else if (rear + 1 < size) {
            queue[++rear] = value;
        }
        len++;

    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        else {
            len--;
            int item = queue[front];
            if (rear == front) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            return item;
        }

    }

    public void display() {
        System.out.println("\n Queue=");
        if (len == 0) {
            System.out.println("Empty\n");
            return;
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        MyQueue queue = new MyQueue(10);
        char ch;
        do {

            System.out.println("\n Queue Opertions");
            System.out.println("1. Insert");
            System.out.println("2. Remove");
            System.out.println("3. Peek");
            System.out.println("4. Check empty");
            System.out.println("5. size");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer to enqueue");
                    queue.enqueue(scan.nextInt());
                    break;
                case 2:
                    try {
                        System.out.println("Removed Element:" + queue.dequeue());
                    } catch (Exception e) {
                        System.out.println("Error" + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Peek Element" + queue.peek());
                    } catch (Exception e) {
                        System.out.println("Error" + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Empty Status =" + queue.isEmpty());
                    break;
                case 5:
                    System.out.println("Size : " + queue.getSize());
                    break;
                default:
                    System.out.println("wrong Entry\n");
                    break;


            }
            queue.display();
            System.out.println("\n Do you want to contiue(Type y or n)");
            ch = scan.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }
}
