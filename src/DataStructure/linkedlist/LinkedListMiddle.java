package DataStructure.linkedlist;

/**
 * Created by maharsu on 2019-12-05.
 */
public class LinkedListMiddle {

    public static void main(String[] args) {
        LinkedList.SingleLinkedList singleLinkedList = new LinkedList.SingleLinkedList(100);
        singleLinkedList.addNode(12);
        singleLinkedList.addNode(43);
        singleLinkedList.addNode(74);
        singleLinkedList.addNode(112);
        singleLinkedList.addNode(413);
        singleLinkedList.addNode(714);
        singleLinkedList.addNode(212);
        singleLinkedList.addNode(243);

        singleLinkedList.print();

        System.out.println("\nMiddle: " + singleLinkedList.getMiddle().value);


    }
}
