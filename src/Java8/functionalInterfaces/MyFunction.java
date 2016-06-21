package Java8.functionalInterfaces;

import java.util.function.Function;

/**
 * Created by sujan on 6/10/16.
 */
public class MyFunction {

    public static void main(String[] args){
        Function<String,String> function = x->x;

        System.out.println(function.apply("Sujan"));
    }


}
