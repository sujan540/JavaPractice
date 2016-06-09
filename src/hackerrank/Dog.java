package hackerrank;

public class Dog implements Animal{
	
	
	String name ;
	
	Dog(String name){
		this.name=name;
	}

	@Override
	public String getName() {
		return name;
	}

}
