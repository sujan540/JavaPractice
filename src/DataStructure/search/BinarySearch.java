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

    public void removeNode(int value) {

        Node find = root;
        Node findParent = null;
        boolean isLeft = false;

        while (find.value != value) {
            if (value < find.value) {
                findParent = find;
                find = find.left;
                isLeft = true;
            } else {
                findParent = find;
                find = find.right;
                isLeft = false;
            }
        }

        if (find.left == null && find.right == null) {
            if (isLeft) {
                findParent.left = null;
            } else {
                findParent.right = null;
            }
        } else if(find.right != null){

            Node replacement = find.right;
            Node replacementParent = find;

            while (replacement.left != null) {
                replacementParent = replacement;
                replacement = replacement.left;
            }

            if (replacement.right != null) {
                replacementParent.left = replacement.right;
            } else {
                replacementParent.left = null;
            }
            replacement.left = find.left;
            replacement.right = find.right;
            root = replacement;
        }

    }

    public Node findNode(int value) {
        Node focus = root;
        if (focus == null) {
            return null;
        }
        while (focus.value != value) {
            if (value < focus.value && focus.left != null) {
                focus = focus.left;
            } else if (value > focus.value && focus.right != null) {
                focus = focus.right;
            } else {
                return null;
            }
        }
        return focus;
    }

    public void addNode(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node focus = root;

        Node parent;

        while (true) {
            parent = focus;
            if (value < focus.value) {
                focus = focus.left;
                if (focus == null) {
                    parent.left = node;
                    return;
                }
            } else {
                focus = focus.right;
                if (focus == null) {
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

    public void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.value + "->");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.value + "->");
        }
    }

    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch(50);
        binarySearch.addNode(100);
        binarySearch.addNode(40);
        binarySearch.addNode(30);
        binarySearch.addNode(45);
        binarySearch.addNode(80);
        binarySearch.addNode(200);
        binarySearch.addNode(25);
        binarySearch.addNode(35);
        binarySearch.addNode(43);
        binarySearch.addNode(46);
        binarySearch.addNode(70);
        binarySearch.addNode(90);
        binarySearch.addNode(150);
        binarySearch.addNode(300);

        System.out.println("In-order");
        binarySearch.inOrderTraversal(binarySearch.root);
        System.out.println("");
        System.out.println("Pre-order");
        binarySearch.preOrderTraversal(binarySearch.root);
        System.out.println("");
        System.out.println("Post-order");
        binarySearch.postOrderTraversal(binarySearch.root);
        System.out.println("");
        binarySearch.removeNode(100);

        System.out.println("In-order");
        binarySearch.inOrderTraversal(binarySearch.root);


    }

}
