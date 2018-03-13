package tree;

/**
 * size(tree)
 * 1. If tree is empty then return 0
 * 2. Else
 * (a) Get the size of left subtree recursively  i.e., call
 * size( tree->left-subtree)
 * (a) Get the size of right subtree recursively  i.e., call
 * size( tree->right-subtree)
 * (c) Calculate size of the tree as following:
 * tree_size  =  size(left-subtree) + size(right-
 * subtree) + 1
 * (d) Return tree_size
 */
public class B_BinaryTree_Size {

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    Node root;

    int size() {
        return size(root);
    }

    int size(Node node) {
        if (node == null)
            return 0;

        return size(node.left) + 1 + size(node.right);
    }

    B_BinaryTree_Size(int value) {
        root = new Node(value);
    }

    public static void main(String[] args) {
        B_BinaryTree_Size btree = new B_BinaryTree_Size(1);
        btree.root.left = new Node(2);
        btree.root.right = new Node(3);
        btree.root.left.left = new Node(4);
        btree.root.left.right = new Node(5);

        System.out.println(btree.size());
    }


}
