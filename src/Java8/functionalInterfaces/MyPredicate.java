package Java8.functionalInterfaces;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Created by sujan on 6/9/16.
 */
public class MyPredicate {

    public static void main(String[] args){

        Predicate<String> predicate = x->x.contains("s");
        System.out.println(predicate.test("hello world"));


        BiPredicate<String,Integer> biPredicate = (x,y)->x.contains(y+"");

        System.out.println(biPredicate.test("Sujan540",540));

        myBiPredicate mbp = new myBiPredicate();
        System.out.println(mbp.test("sujan", "sujanm"));

        System.out.println();


    }


    static class myBiPredicate implements BiPredicate<String, String> {

        @Override
        public boolean test(String s, String s2) {
            return s.contains(s2);
        }
    }

}

