package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by root on 2020-01-23.
 */
public class mthtolastBufferReader {

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


    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Long mth= Long.parseLong(bf.readLine());

        String[] lists = bf.readLine().split(" ");

//        System.out.println(mth);
//        for(int i=0; i<lists.length; i++){
//            System.out.println(lists[i]);
//        }

        mthtolastBufferReader mthToLast = new mthtolastBufferReader();
        mthToLast.createList(lists);
        Node mthNode = mthToLast.mthToLast(mth);
        if (mthNode != null) {
            System.out.println(mthToLast.mthToLast(mth).value);
        } else {
            System.out.println("NIL");
        }
    }
}
