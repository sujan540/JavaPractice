package practise;

public class CheckStringContainsAllNumeric {

    public static void main(String[] args){
        String string = "1w";

        if(string.matches("[0-9]+")) {
            System.out.println("String contains only digits");
        }

        for(int i=0;i<string.length();i++){
            Character c = string.charAt(i);
        }
    }
}
