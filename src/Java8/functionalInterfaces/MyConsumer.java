package Java8.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by sujan on 6/10/16.
 */
public class MyConsumer {


    public static void main(String[] args) {
        Consumer<String> consumer = x -> System.out.println(x.toUpperCase());

        consumer.accept("Sujan");

        BiConsumer<String, String> biConsumer = (x,y)-> System.out.println(x+y);
        biConsumer.accept("Sujan ","Maharjan");


        List<Person> persons = Arrays.asList(new Person("Sujan", 29), new Person("Rina", 26));

        acceptAllPerson(persons, p -> System.out.println(p.getName()));
        acceptAllPerson(persons, p -> System.out.println(p.getAge()));


    }

    public static void acceptAllPerson(List<Person> persons, Consumer<Person> printer) {
        for (Person p : persons) {
            printer.accept(p);
        }
    }

    static class Person {

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }


    }


}


