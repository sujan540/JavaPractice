package Comparable;

import java.util.Objects;

/**
 * Created by sujan on 6/6/16.
 */
public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }


/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(name, employee.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }*/

    @Override
    public int compareTo(Employee e){
        if(this.salary==e.salary)
            return  0;

        else if(this.salary>e.salary)
            return 1;
        return -1;

    }

    @Override
    public String toString(){
        return this.id+":"+this.name+":"+this.salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
