package DataStructure.linkedlist;

/**
 * Created by maharsu on 2019-12-05.
 */
public class LinkedList {

    static class SingleLinkedList {

        Node start = null;

        SingleLinkedList(int value) {
            start = new Node(value);
        }

        static class Node {
            Node next;
            int value;
            Node(int value) {
                this.value = value;
            }
        }

        Node getNodeWithIndex(int index) {
            int count = 0;
            Node node = start;
            while (node.next != null && count != index) {
                count++;
                node = node.next;
            }
            return node;
        }

        Node getMthToLastElement(int mth) throws Exception {
            int size = size();
            if (mth > size) {
                throw new Exception("Invalid mth");
            }
            Node mthNode = start;
            for (int i = 1; i <= mth; i++) {
                mthNode = mthNode.next;
            }
            if (mthNode == null) {
                return start;
            }
            Node startNode = start;
            while (mthNode.next != null) {
                startNode = startNode.next;
                mthNode = mthNode.next;
            }
            return startNode.next;
        }

        Node getLastNode() {
            Node lastNode = start;

            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            return lastNode;
        }

        void insertAfter(int value, int newValue) {
            Node insertAfter = start;

            while (insertAfter.value != value) {
                insertAfter = insertAfter.next;
            }
            Node afterNew = insertAfter.next;

            Node newNode = new Node(newValue);

            insertAfter.next = newNode;
            newNode.next = afterNew;
        }

        void delete(int value) {
            //if only one node
            if (start.value == value && start.next == null) {
                start = null;
                return;
            }
            //if is head node and more than 2 node
            if (start.value == value) {
                start = start.next;
                return;
            }
            Node prevNode = start;
            Node deleteNode = start.next;
            while (deleteNode.value != value) {
                prevNode = deleteNode;
                deleteNode = deleteNode.next;
            }
            prevNode.next = deleteNode.next;
        }

        Node middleNode() {
            int size = size();
            if (size % 2 == 0) {
                System.out.println("There is no middle node");
                return null;
            }
            int middle_position = size / 2;
            return getNodeWithIndex(middle_position);
        }

        void sort(){
            start = mergeSort(start);
        }

        Node mergeSort(Node node) {
            if (node == null || node.next == null) {
                return node;
            }
            Node middle = getMiddle(node);
            Node nextMiddle = middle.next;

            middle.next = null;

            Node left = mergeSort(node);
            Node right = mergeSort(nextMiddle);

            return sortedMerge(left, right);
        }

        Node sortedMerge(Node a, Node b) {
            Node result;
            if (a == null) {
                return b;
            }
            if (b == null) {
                return a;
            }
            if (a.value <= b.value) {
                result = a;
                result.next = sortedMerge(a.next, b);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next);
            }
            return result;
        }

        Node middleNodeWithPointers() {
            if (start == null) {
                return start;
            }
            Node slow = start, fast = start;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        Node getMiddle(){
            return getMiddle(start);
        }

        Node getMiddle(Node head) {
            if (head == null) {
                return head;
            }
            Node slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        void addNode(int value) {
            Node newNode = new Node(value);
            Node lastNode = getLastNode();
            lastNode.next = newNode;
        }

        void push(int new_data) {
            Node new_node = new Node(new_data);
            new_node.next = start;
            start = new_node;
        }

        int size() {
            Node lastNode = start;
            if (start == null) {
                return 0;
            }
            int size = 1;
            while (lastNode.next != null) {
                size++;
                lastNode = lastNode.next;
            }
            return size;
        }

        void print() {
            Node lastNode = start;
            while (lastNode.next != null) {
                System.out.print(lastNode.value + "->");
                lastNode = lastNode.next;
            }
            System.out.print(lastNode.value + "->");
        }
    }

    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList(100);
        singleLinkedList.addNode(12);
        singleLinkedList.addNode(43);
        singleLinkedList.addNode(74);
//        singleLinkedList.addNode(5);
//        singleLinkedList.addNode(6);
//        singleLinkedList.addNode(18);
//        singleLinkedList.addNode(1);

//        System.out.println("\nNode with Index 0 : " + singleLinkedList.getNodeWithIndex(0).value);
//        System.out.println("\nNode with Index 1 : " + singleLinkedList.getNodeWithIndex(1).value);
//        System.out.println("\nNode with Index 2 : " + singleLinkedList.getNodeWithIndex(2).value);

//        if (singleLinkedList.middleNode() != null) {
//            System.out.println("\nMiddle Node : " + singleLinkedList.middleNode().value);
//        }
//
//        if (singleLinkedList.middleNodeWithPointers() != null) {
//            System.out.println("\nMiddle Node With Pointer : " + singleLinkedList.middleNodeWithPointers().value);
//        }

//        singleLinkedList.start = singleLinkedList.mergeSort(singleLinkedList.start);

        singleLinkedList.insertAfter(43, 120);
        singleLinkedList.insertAfter(74, 1);
        singleLinkedList.insertAfter(100, 1123);
        singleLinkedList.delete(100);
        singleLinkedList.delete(1);

        singleLinkedList.print();

        System.out.println("\nSize: " + singleLinkedList.size());
    }
}
