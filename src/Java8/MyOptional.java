package Java8;

import java.util.Optional;

/**
 * Created by sujan on 6/9/16.
 */
public class MyOptional {

    public static Integer sum(Optional<Integer> a, Optional<Integer> b){
        System.out.println("First parameter is present :"+a.isPresent());
        System.out.println("Second parameter is present :"+b.isPresent());

        Integer value1= a.orElse(new Integer(0));
        Integer value2 = b.get();

        return value1+value2;
    }

    public static void main(String[] args){
        System.out.println(sum(Optional.ofNullable(null), Optional.of(new Integer(10))));
    }
}
