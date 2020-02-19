package DataStructure.search;

/**
 * Created by sujan on 6/7/16.
 */
public class MyBinaryTree {

    static class Node {
        int key;
        String name;

        Node left;
        Node right;

        Node(int key, String name) {
            this.key = key;
            this.name = name;
        }

        public String toString() {
            return name + " has a key " + key;
        }
    }

    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;

            Node parent;

            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.left;

                    if (focusNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;

                    if (focusNode == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node findNode(int key) {
        Node focusNode = root;
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.left;

            } else {
                focusNode = focusNode.right;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.left);
            System.out.print(focusNode.key + "->");
            inOrderTraverseTree(focusNode.right);
        }
    }

    public void preOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.print(focusNode.key + "->");
            preOrderTraverseTree(focusNode.left);
            preOrderTraverseTree(focusNode.right);
        }
    }

    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.left);
            postOrderTraverseTree(focusNode.right);
            System.out.print(focusNode.key + "->");
        }
    }

    public boolean remove(int key) {
        Node focusNode = root;
        Node parent = root;

        boolean isItAleft = true;
        while (focusNode.key != key) {
            parent = focusNode;

            if (key < focusNode.key) {
                isItAleft = true;
                focusNode = focusNode.left;
            } else {
                isItAleft = false;
                focusNode = focusNode.right;
            }

            if (focusNode == null) {
                return false;
            }
        }
        if (focusNode.left == null && focusNode.right == null) {
            if (focusNode == root) {
                root = null;
            } else if (isItAleft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (focusNode.right == null) {
            if (focusNode == root)
                root = focusNode.left;
            else if (isItAleft)
                parent.left = focusNode.left;
            else
                parent.right = focusNode.right;
        } else if (focusNode.left == null) {
            if (focusNode == root)
                root = focusNode.right;
            else if (isItAleft)
                parent.left = focusNode.right;
            else
                parent.right = focusNode.left;
        } else {
            Node replacement = getReplacementNode(focusNode);
            if (focusNode == root)
                root = replacement;
            else if (isItAleft)
                parent.left = replacement;
            else
                parent.right = replacement;

            replacement.left = focusNode.left;
        }

        return true;
    }

    public Node getReplacementNode(Node replaceNode) {
        Node replacementParent = replaceNode;
        Node replacement = replaceNode;

        Node focusNode = replaceNode.right;

        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.left;
        }
        if (replacement != replaceNode.right) {
            replacementParent.left = replacement.right;
            replacement.right = replaceNode.right;
        }
        return replacement;
    }

    public static void main(String[] args) {
        MyBinaryTree theTree = new MyBinaryTree();

        theTree.addNode(50, "Boss");
        theTree.addNode(25, "Vice president");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Secreatary");
        theTree.addNode(75, "Sales Manager");
        theTree.addNode(70, "Salesman 2");
        theTree.addNode(85, "Salesman 1");
        theTree.addNode(89, "Salesman 3");
        theTree.addNode(80, "Salesman 4");
        theTree.addNode(73, "Salesman 5");
        //theTree.addNode(69, "Salesman 6");

//        System.out.println("Remove key 25");
//        theTree.remove(25);

        System.out.println("");
        theTree.inOrderTraverseTree(theTree.root);
        System.out.println("");

        theTree.preOrderTraverseTree(theTree.root);
        System.out.println("");

        theTree.postOrderTraverseTree(theTree.root);
        System.out.println("");

        theTree.remove(50);

        System.out.println("");
        theTree.inOrderTraverseTree(theTree.root);
        System.out.println("");

        theTree.preOrderTraverseTree(theTree.root);
        System.out.println("");

        theTree.postOrderTraverseTree(theTree.root);
        System.out.println("");

        // System.out.println(theTree.findNode(30));

    }
}


