package DataStructure.linkedlist;

/**
 * Created by maharsu on 2019-12-05.
 */
public class MthToLastElement {

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
        singleLinkedList.addNode(274);

        singleLinkedList.print();

        try {
            System.out.println("\n" + singleLinkedList.getMthToLastElement(3).value);
            System.out.println(singleLinkedList.getMthToLastElement(7).value);
            System.out.println(singleLinkedList.getMthToLastElement(9).value);
            System.out.println(singleLinkedList.getMthToLastElement(10).value);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
