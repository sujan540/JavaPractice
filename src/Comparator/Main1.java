package Comparator;

import java.util.*;

/**
 * Created by sujan on 6/6/16.
 */
public class Main1 {

    public static void main(String[] args){
        List<Employee1> employees = new ArrayList<>();
        Employee1 employee=null;
        for(int i=1; i<=100;i++){
            employee = new Employee1(i,"name"+i,1000*i);
            System.out.print("Contains?" + employees.contains(employee) + "|");
            employees.add(employee);
            System.out.println(i + ":Hashcode:" + employee.hashCode()+"|Salary:"+employee.getSalary());

        }



        Employee1 em = new Employee1(91,"name91",10);
        employees.add(em);
        System.out.println(em.equals(new Employee1(91,"name91",10)));
        System.out.println(em.hashCode());
        employees.add(new Employee1(91, "name91", 10));

        Collections.sort(employees, new SalaryComparator());


        Set<Employee1> sortedNonDuplicateSets = new LinkedHashSet<>(employees);
        sortedNonDuplicateSets.forEach(e -> System.out.println(e));
    }
}
