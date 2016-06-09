package Comparator;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by sujan on 6/6/16.
 */
public class Main2 {


    public static void main(String[] args) {
        Set<Employee1> sets = new TreeSet<>(new SalaryComparator());
        Employee1 employee = null;
        for (int i = 1; i <= 100; i++) {
            employee = new Employee1(i, "name" + i, 1000/i);
            sets.add(employee);
        }
        sets.forEach(e->System.out.println(e));
    }
}
