package Java8.functionalInterfaces;

/**
 * Created by sujan on 6/9/16.
 */

@FunctionalInterface
interface MyTriFunctionalInterface<T,U,S,R>{

    R test(T t,U u,S s);
}