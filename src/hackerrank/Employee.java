package hackerrank;

public class Employee {

	private String name;
	private int salary;

	private static int testing = 10;

	public static void increment() {
		System.out.println("calling super class");
		testing = testing + 10;
	}

	public Employee(String name, int salary) {

		this.name = name;
		this.salary = salary;

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

	public int getUpdateSalary() {
		return this.salary * 10;
	}

}
