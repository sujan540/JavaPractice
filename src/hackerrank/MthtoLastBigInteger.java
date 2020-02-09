package hackerrank;


import java.math.BigInteger;
import java.util.Scanner;

public class MthtoLastBigInteger {

    Node head;

    static class Node {
        BigInteger value;
        Node next;
        Node previous;

        Node(BigInteger value) {
            this.value = value;
        }
    }

    void createList(String[] lists) {
        for (int i = 0; i < lists.length; i++) {
            addNode(new BigInteger(lists[i]));
        }
    }

    void addNode(BigInteger value) {
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

    Node mthToLast(BigInteger m) {
        BigInteger index = BigInteger.valueOf(1);
        Node pointer1 = head;
        Node pointer2 = null;
        while (pointer1.next != null) {
            if (index.compareTo(m) >= 0) {
                if (index.compareTo(m) == 0) {
                    pointer2 = head;
                }
                pointer2 = pointer2.next;
            }
            pointer1 = pointer1.next;
            index = index.add(BigInteger.ONE);
        }
        if (index.compareTo(m) == 0) {
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

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        BigInteger mth = new BigInteger(in.nextLine());
        String[] lists = in.nextLine().split(" ");

        in.close();

        MthtoLastBigInteger mthToLast = new MthtoLastBigInteger();
        mthToLast.createList(lists);
        Node mthNode = mthToLast.mthToLast(mth);
        if (mthNode != null) {
            System.out.println(mthToLast.mthToLast(mth).value);
        } else {
            System.out.println("NIL");
        }
    }
}

