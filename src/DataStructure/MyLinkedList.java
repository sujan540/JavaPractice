package DataStructure;

/**
 * Created by sujan on 6/3/16.
 */
public class MyLinkedList {


    private Node head;
    private Node tail;

    public void add(Object value){
        Node newNode = new Node();
        newNode.setValue(value);

        if(head==null){
            //Since there is only one element, both head and tail points to the same object
            head = newNode;
            tail = newNode;
        }else{
            //set current tail next link to new node
            tail.setNext(newNode);
            //set tail as newly created node
            tail = newNode;
        }
    }

    public void addFront(Object value){
        Node newNode = new Node();
        newNode.setValue(value);
        if(head==null) {
            //Since there is only one element, both head and tail points to the same object
            head = newNode;
            tail = newNode;
        }else{
            newNode.setNext(head);
            head=newNode;
        }
    }

    public void addAfter(Object value, Object after){

        Node marker = head;

        Node newNode = new Node();
        newNode.setValue(value);

        while(!marker.getValue().equals(after)){
            if(marker.getNext()==null) {
                break;
            }

            marker = marker.getNext();

        }

        if(marker.getValue().equals(after)) {
            newNode.setNext(marker.getNext());
            marker.setNext(newNode);
        }else{
            System.out.println("Object not found...");
        }

    }

    public void deteteFront(){
        if(head==null){
            System.out.print("Linked list empty..");
        }else{
            System.out.println(head.getValue());
            Node temp = head.getNext();
            head = temp;
        }

    }

    public void traverse(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.getValue()+",");
            temp = temp.getNext();
        }
    }

    public static void main(String[] args){

        MyLinkedList list = new MyLinkedList();
        list.addFront(new Integer(77));
        for(int i=0;i<10;i++) {
            list.add(new Integer(i + 10));
        }

        list.addFront(new Integer(88));
        list.addAfter(new Integer(66),new Integer(12));

        list.traverse();
        list.deteteFront();

        list.traverse();
    }





    class Node{
        private Object value;
        private Node next;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
