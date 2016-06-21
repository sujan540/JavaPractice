package Multithreading.Volatile;

/**
 * Created by sujan on 6/10/16.
 */
public class VolatileData {

    private volatile int counter =0;

    public int getCounter() {
        return counter;
    }

    public void incrementCounter(){
        ++counter;
    }

}
