package Comparable;

import java.util.*;

/**
 * Created by sujan on 6/6/16.
 */
public class Main {

    public static void main(String[] args){
        Set<Employee> employees = new TreeSet<>();
        Employee employee=null;
        for(int i=1; i<=100;i++){
            employee = new Employee(i,"name"+i,1000/i);
            System.out.print("Contains?" + employees.contains(employee) + "|");
            employees.add(employee);
            System.out.println(i + ":Hashcode:" + employee.hashCode()+"|Salary:"+employee.getSalary());

        }

/*        Employee em = new Employee(91,"name91",10);
        employees.add(em);
        System.out.println(em.equals(new Employee(91,"name91",10)));
        System.out.println(em.hashCode());
        employees.add(new Employee(91, "name91", 10));*/
        employees.forEach(e -> System.out.println(e));
    }
}
