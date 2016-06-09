package DataStructure;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by sujan on 6/6/16.
 */
public class MyQueueWith2Stack {

    Stack<Integer> s;
    Stack<Integer> temp;

    public MyQueueWith2Stack(){
        this.s= new Stack<>();
        this.temp= new Stack<>();
    }

    public void enqueue(int data){
        if(s.size()==0){
            s.push(data);
        }else{
            int l = s.size();
            for(int i=0;i<l;i++){
                temp.push(s.pop());
            }
            s.push(data);
            for(int i=0;i<l;i++){
                s.push(temp.pop());
            }
        }
    }

    public int dequeue(){
        if(s.size()==0)
            throw new NoSuchElementException("Underflow Exception");
        return s.pop();
    }

    public boolean isEmpty(){
        return s.size()==0;
    }

    public int peek(){
        if(isEmpty())
            throw new NoSuchElementException("UnderflowException");
        return s.peek();
    }

    public int getSize(){
        return s.size();
    }

    public void display(){
        System.out.println("\n Queue=");
        int l=s.size();
        if(l==0)
            System.out.println("Empty\n");
        else{
            for(int i=l-1;i>=0;i--){
                System.out.print(s.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        MyQueueWith2Stack queue = new MyQueueWith2Stack();
        char ch;
        do{

            System.out.println("\n Queue Opertions");
            System.out.println("1. Insert");
            System.out.println("2. Remove");
            System.out.println("3. Peek");
            System.out.println("4. Check empty");
            System.out.println("5. size");

            int choice = scan.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter integer to enqueue");
                    queue.enqueue(scan.nextInt());
                    break;
                case 2:
                    try {
                        System.out.println("Removed Element:" + queue.dequeue());
                    }catch(Exception e){
                        System.out.println("Error"+e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Peek Element"+queue.peek());
                    }catch(Exception e){
                        System.out.println("Error"+e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Empty Status ="+queue.isEmpty());
                    break;
                case 5:
                    System.out.println("Size : "+queue.getSize());
                    break;
                default:
                    System.out.println("wrong Entry\n");
                    break;


            }
            queue.display();
            System.out.println("\n Do you want to contiue(Type y or n)");
            ch = scan.next().charAt(0);

        }while(ch=='Y'||ch=='y');
    }
}
