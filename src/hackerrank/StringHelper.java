package hackerrank;

import java.util.HashSet;
import java.util.Set;
 
/**
 * Java Program to find all permutations of a String
 * @author pankaj
 *
 */
public class StringHelper {
    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        System.out.println(initial);
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        System.out.println(words);
        for (String strNew : words) {
        	System.out.println(strNew);
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }
 
    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
 
    public static void main(String[] args) {
        String s1 = "ABC";
        System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder(s1));
    }
}