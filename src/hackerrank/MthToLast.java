package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by root on 2020-01-22.
 */
public class MthToLast {

    Node head;

    static class Node {
        Long value;
        Node next;
        Node previous;

        Node(Long value) {
            this.value = value;
        }
    }

    void createList(Long[] lists) {
        for (int i = 0; i < lists.length; i++) {
            addNode(lists[i]);
        }
    }

    void createList(String[] lists) {
        for (int i = 0; i < lists.length; i++) {
            addNode(Long.parseLong(lists[i]));
        }
    }

    void addNode(Long value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }

        Node last = lastNode();

        if (last == null) {
            head = newNode;
            return;
        }
        last.next = newNode;
        newNode.previous = last;
    }

    Node mthToLast(Long m) {
        int index = 1;
        Node pointer1 = head;
        Node pointer2 = null;
        while (pointer1.next != null) {
            if (index >= m) {
                if (index == m) {
                    pointer2 = head;
                }
                pointer2 = pointer2.next;
            }
            pointer1 = pointer1.next;
            index++;
        }
        if (index == m) {
            pointer2 = head;
        }
        return pointer2;
    }


    Node lastNode() {
        if (head == null) {
            return null;
        }
        Node end = head;
        while (end.next != null) {
            end = end.next;
        }
        return end;
    }

    void print() {
        if (head == null) {
            System.out.println("Emtpy!");
        }
        Node start = head;

        while (start.next != null) {
            System.out.print(start.value + "->");
            start = start.next;
        }
        System.out.print(start.value);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long mth = Long.parseLong(in.nextLine());
        String[] lists = in.nextLine().split(" ");

        in.close();

        MthToLast mthToLast = new MthToLast();
        mthToLast.createList(lists);
        Node mthNode = mthToLast.mthToLast(mth);
        if (mthNode != null) {
            System.out.println(mthToLast.mthToLast(mth).value);
        } else {
            System.out.println("NIL");
        }
    }
}
