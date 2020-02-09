package DataStructure.search;

/**
 * Created by root on 2020-02-09.
 */
public class BinarySearch {

    Node root;

    BinarySearch(int value) {
        root = new Node(value);
    }

    public static class Node {
        Node left;
        Node right;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    public void addNode(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node temp = root;

        Node parent;

        while (true) {
            parent = temp;
            if (value < temp.value) {
                temp = temp.left;
                if (temp == null) {
                    parent.left = node;
                    return;
                }
            } else {
                temp = temp.right;
                if (temp == null) {
                    parent.right = node;
                    return;
                }
            }
        }
    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + "->");
            inOrderTraversal(node.right);
        }
    }

    public void print(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        if (node.left != null && node.right != null) {
            print(node.left);
            print(node.right);
        } else if (node.left != null && node.right == null) {
            print(node.left);
        } else if (node.right != null && node.left == null) {
            print(node.right);
        }

    }

    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch(8);
        binarySearch.addNode(9);
        binarySearch.addNode(5);
        binarySearch.addNode(5);
        binarySearch.addNode(10);

        binarySearch.print(binarySearch.root);

        System.out.println("");
        binarySearch.inOrderTraversal(binarySearch.root);


    }

}
