package DataStructure.linkedlist;

/**
 * Created by maharsu on 2019-12-05.
 */
public class DoublyCircularLinkedList {

    Node start = null;

    DoublyCircularLinkedList(int value) {
        start = new Node(value);
    }

    static class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
            if (this.next == null && this.prev == null) {
                this.prev = this;
                this.next = this;
            }
        }
    }

    Node getLastNode() {
        Node lastNode = start;
        while (lastNode.next != start) {
            lastNode = lastNode.next;
        }
        return lastNode;
    }

    void removeNode(int value) {
        Node prevNode = start.prev;
        Node removeNode = start;
        Node nextNode = start.next;
        if (prevNode == removeNode && removeNode == nextNode && removeNode.value == value) {
            start = null;
            return;
        }
        if (removeNode.value == value) {
            start = nextNode;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            return;
        }
        while (removeNode.value != value) {
            prevNode = removeNode;
            removeNode = removeNode.next;
            nextNode = nextNode.next;
        }
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    void addNode(int value) {
        Node newNode = new Node(value);
        Node lastNode = getLastNode();

        lastNode.next = newNode;
        newNode.prev = lastNode;

        newNode.next = start;
        start.prev = newNode;
    }

    int size() {
        Node startNode = start;
        if (startNode == null) {
            return 0;
        }
        int size = 1;
        while (startNode.next != start) {
            startNode = startNode.next;
            size++;
        }
        return size;
    }

    void print() {
        Node startNode = start;

        if (startNode == null) {
            System.out.print("List is Empty");
            return;
        }
        while (startNode.next != start) {
            print(startNode.value);
            startNode = startNode.next;
        }
        print(startNode.value);
    }

    void print(int value) {
        System.out.print(value + "->");
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList doublyCircularLinkedList = new DoublyCircularLinkedList(10);
        doublyCircularLinkedList.addNode(11);
        doublyCircularLinkedList.addNode(12);
        doublyCircularLinkedList.addNode(13);
        doublyCircularLinkedList.addNode(14);
        doublyCircularLinkedList.addNode(15);
        doublyCircularLinkedList.addNode(16);

        System.out.println("Size: " + doublyCircularLinkedList.size());
        doublyCircularLinkedList.removeNode(13);
        System.out.println("Size: " + doublyCircularLinkedList.size());
        doublyCircularLinkedList.removeNode(10);
        System.out.println("Size: " + doublyCircularLinkedList.size());
        doublyCircularLinkedList.removeNode(14);
        System.out.println("Size: " + doublyCircularLinkedList.size());
        doublyCircularLinkedList.removeNode(15);
        System.out.println("Size: " + doublyCircularLinkedList.size());

        doublyCircularLinkedList.print();

    }

}