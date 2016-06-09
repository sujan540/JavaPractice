package Multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sujan on 6/6/16.
 */
public class MyCountDownLatch {

    public static void main(String[] args){
        final CountDownLatch latch = new CountDownLatch(10);
        Thread t1 = new Thread(new MyThread("t1",2000,latch));
        Thread t2 = new Thread(new MyThread("t2",2000,latch));
        Thread t3 = new Thread(new MyThread("t3",2000,latch));
        Thread t4 = new Thread(new MyThread("t4",2000,latch));
        Thread t5 = new Thread(new MyThread("t5",2000,latch));
        Thread t6 = new Thread(new MyThread("t6",2000,latch));
        Thread t7 = new Thread(new MyThread("t7",2000,latch));
        Thread t8 = new Thread(new MyThread("t8",2000,latch));
        Thread t9 = new Thread(new MyThread("t9",2000,latch));
        Thread t10 = new Thread(new MyThread("t10",2000,latch));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        try{
            latch.await();
            System.out.println("Now starting the main thread t11");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }


}

class MyThread implements Runnable{

    private final String name;
    private final int timeToStart;
    private final CountDownLatch latch;

    public MyThread(String name, int timeToStart, CountDownLatch latch){
        this.name = name;
        this.timeToStart=timeToStart;
        this.latch=latch;
    }

    @Override
    public void run() {

        System.out.println("Thread started:"+name);
        try{
            Thread.sleep(timeToStart);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread ended:"+name);
        latch.countDown();

    }
}
