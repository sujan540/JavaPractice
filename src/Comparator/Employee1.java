package Comparator;

import java.util.Objects;

/**
 * Created by sujan on 6/6/16.
 */
public class Employee1{

    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee1 employee1 = (Employee1) o;
        return Objects.equals(id, employee1.id) &&
                Objects.equals(salary, employee1.salary) &&
                Objects.equals(name, employee1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }

    private String name;
    private int salary;

    public Employee1(int id, String name, int salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
