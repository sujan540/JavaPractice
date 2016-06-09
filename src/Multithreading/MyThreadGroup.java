package Multithreading;

/**
 * Created by sujan on 6/6/16.
 */
public class MyThreadGroup{


    public static void main(String[] args){
        ThreadGroup tg = new ThreadGroup("group 1");
        Thread t1 = new Thread(tg,new MyThread(),"t1");


    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread started:::"+Thread.currentThread().getName());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread ended:::"+Thread.currentThread().getName());
        }
    }
}
