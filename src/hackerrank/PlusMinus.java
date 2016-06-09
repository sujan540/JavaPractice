package hackerrank;

public final class PlusMinus {
	
	public PlusMinus(){
		//(new Inner()).test();
		
	}
	
	public static void main(String[] args) {
		PlusMinus test = new PlusMinus();
		test.Braces(new String[]{"{}[]()","{[}]}"});
	}
	
	private boolean flag= true;
	public void sample(){
		String test ="test";
		for(int i=0;i<test.length();i++)		{
			if(test.charAt(i)=='A'){
				
			}
		}
		System.out.println("Sample");
	}
	
	class Inner{
		void test(){
			if(PlusMinus.this.flag);{
				sample();
			}
		}
	}
	
static String[] Braces(String[] values) {
        
        for(int k=0;k<values.length;k++){
            int size = values[k].length();
            if(size%2!=0)
                values[k]="NO";
            String value = values[k];
            for(int i=0;i<value.length();i++){
                System.out.println(value.charAt(i));
                if(value.charAt(i)!=value.charAt(i-1))
                    values[k]="NO";
            }
            values[k]="YES";
        }    
       
        return values;

    }

	

}
