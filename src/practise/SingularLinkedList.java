package practise;

/**
 * Created by maharsu on 6/27/20.
 */
public class SingularLinkedList implements LinkedList {

    Node root;

    @Override
    public Node add(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return root;
        }
        Node lastNode = findLast();
        lastNode.next = newNode;
        return newNode;
    }

    @Override
    public void print() {
        if (root == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = root;

        while (current.next != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print(current.value);
    }

    @Override
    public Node findLast() {
        if (root == null) {
            System.out.println("List is empty!");
            return null;
        }
        Node current = root;

        while (current.next != null) {
            current = current.next;
        }

        return current;
    }

    @Override
    public Node findLastKth(int lastKth) {
        if (root == null) {
            System.out.println("List is empty!");
            return null;
        }
        Node pointer1 = root;
        Node pointer2 = root;

        int length = length();
        if (length == lastKth) {
            return root;
        } else if (lastKth > length) {
            System.out.println("There is not valid " + lastKth + " Kth element!");
            return null;
        }

        int counter = 0;
        while (pointer1.next != null) {
            pointer1 = pointer1.next;
            if (counter >= lastKth) {
                pointer2 = pointer2.next;
            }
            counter++;
        }
        return pointer2.next;
    }

    @Override
    public Node[] findMiddle() {
        if (root == null) {
            System.out.println("List is empty!");
            return null;
        }

        Node pointer1 = root;
        Node pointer2 = root;

        if (length() % 2 == 0) {
            System.out.println("There are two middle node!");
            while (pointer1.next.next != null) {
                pointer2 = pointer2.next;
                pointer1 = pointer1.next.next;
            }
            return new Node[]{pointer2, pointer2.next};
        }


        while (pointer1.next != null) {
            pointer2 = pointer2.next;
            pointer1 = pointer1.next.next;
        }
        return new Node[]{pointer2};
    }

    @Override
    public int length() {
        if (root == null) {
            return 0;
        }

        int counter = 0;
        Node current = root;

        while (current.next != null) {
            counter++;
            current = current.next;
        }
        return counter + 1;
    }


    public static void main(String[] args) {
        SingularLinkedList singularLinkedList = new SingularLinkedList();
        singularLinkedList.add(5);
        singularLinkedList.add(6);
        singularLinkedList.add(7);
        singularLinkedList.add(8);
        singularLinkedList.add(9);
        singularLinkedList.print();
        System.out.println("\n");
        System.out.println("Length: " + singularLinkedList.length());

        Node[] middle = singularLinkedList.findMiddle();
        System.out.println("Middle node: ");
        if (middle.length == 2) {
            System.out.println(middle[0].value);
            System.out.println(middle[1].value);
        } else {
            System.out.println(middle[0].value);
        }

        System.out.println("5th node: ");
        System.out.println(singularLinkedList.findLastKth(5).value);

    }

}
