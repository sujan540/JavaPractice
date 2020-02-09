package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by root on 2020-01-27.
 */
public class BalancedDelimiters {

    static String isValid(String delimiters) {

        Stack<Character> stack = new Stack<>();

        List<String> validDelimiters = Arrays.asList("[]", "{}", "()");
        List<Character> pushCharacter = Arrays.asList('[', '{', '(');
        List<Character> popCharacter = Arrays.asList(']', '}', ')');
        for (int i = 0; i < delimiters.length(); i++) {
            if (pushCharacter.contains(delimiters.charAt(i))) {
                stack.push(delimiters.charAt(i));
            }
            if (popCharacter.contains(delimiters.charAt(i))) {
                char delim = stack.pop();
                if (!validDelimiters.contains("" + delim + delimiters.charAt(i))) {
                    return "False";
                }
            }
        }
        return stack.isEmpty() ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String delimiters = bf.readLine();

        System.out.println(isValid(delimiters));


    }
}
