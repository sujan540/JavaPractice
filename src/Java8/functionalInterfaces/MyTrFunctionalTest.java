package Java8.functionalInterfaces;

/**
 * Created by sujan on 6/10/16.
 */
public class MyTrFunctionalTest {

    public static void main(String[] args){
        MyTriFunctionalInterface<String,String,String,String> triFunctionalInterface = (x,y,z)->x+y+z;
        System.out.println(triFunctionalInterface.test("My "," name is ","Sujan Maharjan"));
    }
}
