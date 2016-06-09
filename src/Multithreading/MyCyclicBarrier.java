package Multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sujan on 6/6/16.
 */
public class MyCyclicBarrier {



    public static void main(String[] args){
        final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("All parties are arrived at barrier, lets started");
            }
        });

        Thread t1 = new Thread(new MyThread(cb),"t1");
        Thread t2 = new Thread(new MyThread(cb),"t2");
        Thread t3 = new Thread(new MyThread(cb),"t3");

        t1.start();
        t2.start();
        t3.start();
    }


    private static class MyThread implements Runnable{

        private CyclicBarrier barrier;

        public MyThread(CyclicBarrier barrier){
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try{
                System.out.println(Thread.currentThread().getName()+" is waiting on Barrier");
                Thread.sleep(3000);
                barrier.await();
                System.out.println(Thread.currentThread().getName()+" has closed the barrier");
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch(BrokenBarrierException ex){
                ex.printStackTrace();
                Logger.getLogger(MyCyclicBarrier.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
}
