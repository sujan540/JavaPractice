package hackerrank;

public class Manager extends Employee{
	
	public Manager(String name, int salary) {
		super(name, salary);
	}

	@Override
	public int getSalary() {
		return super.getSalary()+100;
	}
	
	public static void increment() {
		System.out.println("calling subclass");
	}

}
