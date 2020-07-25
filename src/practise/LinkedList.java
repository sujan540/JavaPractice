package practise;

/**
 * Created by maharsu on 6/27/20.
 */
public interface LinkedList {
    void print();

    Node add(int value);

    Node findLast();

    Node findLastKth(int lastKth);

    Node[] findMiddle();

    int length();
}