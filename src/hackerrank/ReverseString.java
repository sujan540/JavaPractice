package hackerrank;

public class ReverseString {
	
	public static void main(String[] args) {
		String name = "my name is sujan";
		StringBuilder builder = new StringBuilder(name);
		System.out.println(builder.reverse());
	}
	
	public static String reverse(String value){
		StringBuilder builder = new StringBuilder();
		char[] strarys = value.toCharArray();
		
		for( int i=strarys.length-1;i>=0;i--){
			builder.append(strarys[i]);
		}
		return builder.toString();
	}
	
	public static String reverseRecursively(String str){
		if(str.length()<2){
			return str;
		}
		return reverseRecursively(str.substring(1))+str.charAt(0);
	}

}
