package Multithreading.Volatile;

/**
 * Created by sujan on 6/10/16.
 */
public class VolatileThread implements Runnable {


    private final VolatileData data;

    public VolatileThread(VolatileData data) {
        this.data = data;
    }

    @Override
    public void run() {
        int oldValue = data.getCounter();
        System.out.println("[Thread] " + Thread.currentThread().getId() + "]: Old value = " + oldValue);
        data.incrementCounter();

        int newValue = data.getCounter();
        System.out.println("[Thread] " + Thread.currentThread().getId() + "]: New value = " + newValue + "\n");

    }

    public static void main(String[] args) {
        VolatileData volatileData = new VolatileData();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 4; i++) {
            threads[i] = new Thread(new VolatileThread(volatileData));
        }

    }
}
