package DataStructure.linkedlist;

import java.util.NoSuchElementException;

/**
 * Created by sujan on 6/3/16.
 */
public class MyDoublyLinkedList<E> {

    private Node head;
    private Node tail;
    private int size;

    public MyDoublyLinkedList(){
        size =0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addFirst(E element){
        Node temp = new Node(element,head,null);
        if(head !=null){
            head.previous=temp;
        }
        head = temp;
        if(tail==null){
            tail=temp;
        }
        size++;
    }

    public void addLast(E element){
        Node temp = new Node(element, null, tail);

        if(tail!=null){
            tail.next=temp;
        }
        tail = temp;
        if(head==null){
            head = temp;
        }
        size++;
    }

    public void traverseForward(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.element+",");
            temp = temp.next;
        }
    }

    public E removeFirst(){
        if(size==0)
            throw new NoSuchElementException();
        Node temp = head;
        head = head.next;
        head.previous=null;
        size--;
        return temp.element;
    }

    public E removeLast(){
        if(size==0)
            throw new NoSuchElementException();
        Node temp = tail;
        tail = tail.previous;
        tail.next=null;
        size--;
        return temp.element;
    }

    public static void main(String args[]){
        MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();

        for(int i=0;i<10;i++){
            list.addFirst(i);
        }

        list.addLast(111);

        list.traverseForward();
        list.removeFirst();
        list.removeLast();
        System.out.println();
        list.traverseForward();
    }



    class Node{
        Node previous;
        Node next;
        E element;

        Node(E element, Node next, Node previous){
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }
}
