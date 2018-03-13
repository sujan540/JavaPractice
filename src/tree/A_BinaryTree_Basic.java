package tree;

/**
 * Created by root on 2018-03-07.
 */
public class A_BinaryTree_Basic {

    Node root;

    A_BinaryTree_Basic() {
        this.root = null;
    }

    A_BinaryTree_Basic(int value) {
        this.root = new Node(value);
    }

    static class Node {
        int value;
        Node left = null;
        Node right = null;

        Node(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        A_BinaryTree_Basic binaryTree = new A_BinaryTree_Basic(1);

        binaryTree.root.left = new Node(2);

        binaryTree.root.right = new Node(3);

        System.out.println("Root:" + binaryTree.root.value);
        System.out.println("Left:" + binaryTree.root.left.value);
        System.out.println("Right:" + binaryTree.root.right.value);


    }
}
