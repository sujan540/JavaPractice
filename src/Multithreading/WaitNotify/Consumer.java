package Multithreading.WaitNotify;

import java.util.List;

/**
 * Created by sujan on 6/13/16.
 */
public class Consumer implements Runnable {

    private final List<Integer> taskQueue;

    public Consumer(List<Integer> sharedQueue) {
        this.taskQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.isEmpty()) {
                System.out.println("Queue is Empty :" + Thread.currentThread().getName());
                taskQueue.wait();
            }
            Thread.sleep(1000);
            int i = (Integer) taskQueue.remove(0);
            System.out.println("Consumed :" + i);
            taskQueue.notifyAll();
        }
    }
}
