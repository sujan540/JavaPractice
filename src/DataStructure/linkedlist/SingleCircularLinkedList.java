package DataStructure.linkedlist;

/**
 * Created by sujan on 6/4/16.
 */
public class SingleCircularLinkedList {

    Node root = null;

    SingleCircularLinkedList(Employee rootEmployee) {
        this.root = new Node(rootEmployee);
    }

    Node getLastNode() {
        Node lastNode = root;
        while (lastNode.forward != root) {
            lastNode = lastNode.forward;
        }
        return lastNode;
    }

    void removeNode(int employeeId) {
        if (root == root.forward && employeeId == root.employee.id) {
            root = null;
            return;
        }
        Node prevNode = getLastNode();
        Node removeNode = root;
        Node nextNode = root.forward;

        if (root.employee.id == employeeId) {
            root = nextNode;
            prevNode.forward = nextNode;
            return;
        }

        while (removeNode.employee.id != employeeId) {
            prevNode = removeNode;
            removeNode = nextNode;
            nextNode = nextNode.forward;
        }
        prevNode.forward = nextNode;
    }

    Node addNode(Employee employee) {
        Node newNode = new Node(employee);

        Node lastNode = getLastNode();

        lastNode.forward = newNode;
        newNode.forward = root;

        return newNode;
    }

    void print() {

        Node node = root;

        if (node == null) {
            print("List is empty");
            return;
        }

        while (node.forward != root) {
            node.employee.print();
            node = node.forward;
        }
        node.employee.print();
        node.forward.employee.print();

    }

    void print(String message) {
        System.out.println(message);
    }

    static class Employee {
        int id;
        String name;

        Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        void print() {
            System.out.print("Id: " + id + " Name: " + name + "\n");
        }
    }

    static class Node {
        Node forward;
        Employee employee;

        Node(Employee employee) {
            this.employee = employee;
            if (this.forward == null) {
                this.forward = this;
            }
        }

    }

    public static void main(String[] args) {
        SingleCircularLinkedList singleCircularLinkedList = new SingleCircularLinkedList(new Employee(1, "Sujan"));
        singleCircularLinkedList.addNode(new Employee(2, "Manoj"));
        singleCircularLinkedList.addNode(new Employee(3, "Sajala"));
        singleCircularLinkedList.addNode(new Employee(4, "Aman"));

        singleCircularLinkedList.removeNode(1);
        singleCircularLinkedList.removeNode(2);
        singleCircularLinkedList.removeNode(3);

        singleCircularLinkedList.print();

    }
}
