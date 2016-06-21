package Multithreading.Singleton;

/**
 * Created by sujan on 6/13/16.
 */
public class StaticSingleTon {

    private static final StaticSingleTon INSTANCE = new StaticSingleTon();

    private StaticSingleTon() {
    }

    public static StaticSingleTon getInstance() {
        return INSTANCE;
    }

    public void show() {
        System.out.println("Singleton using static initialization in Java");
    }
}
