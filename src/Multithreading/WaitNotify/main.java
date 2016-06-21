package Multithreading.WaitNotify;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sujan on 6/13/16.
 */
public class main {

    public static void main(String[] args) {

        List<Integer> taskQueue = new ArrayList<>();
        int MAX_CAPACITY = 5;
        Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
        Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");

        tProducer.start();
        tConsumer.start();

    }
}
