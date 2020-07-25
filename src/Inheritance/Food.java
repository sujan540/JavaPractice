package Inheritance;

public interface Food {
    default void types(){
        System.out.println("Food call");
    }
}
