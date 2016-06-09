package Comparator;

import java.util.Comparator;

/**
 * Created by sujan on 6/6/16.
 */
public class SalaryComparator implements Comparator<Employee1> {

    @Override
    public int compare(Employee1 o1, Employee1 o2) {
        return o1.getSalary()-o2.getSalary();
    }
}
