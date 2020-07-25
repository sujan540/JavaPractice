package Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maharsu on 6/29/20.
 */
public class test1 {

    public static List<Integer> cellCompete(int[] states, int days) {

        List<Integer> result = new ArrayList<>();

        int[] fullStates = new int[states.length + 2];

        int[] temp = new int[states.length + 2];

        fullStates[0] = 0;
        for (int i = 0; i < states.length; i++) {
            fullStates[i + 1] = states[i];
        }
        fullStates[states.length + 1] = 0;

        for (int i = 1; i <= days; i++) {
            for (int j = 0; j < fullStates.length; j++) {
                if (j == 0 || j == fullStates.length - 1) {
                    temp[j] = fullStates[j];
                    continue;
                }
                if (fullStates[j - 1] == fullStates[j + 1]) {
                    temp[j] = 0;
                } else {
                    temp[j] = 1;
                }
            }
            fullStates = new int[states.length + 2];
            for (int k = 0; k < temp.length; k++) {
                System.out.print(fullStates[k]);
                fullStates[k] = temp[k];
            }
            System.out.println("\n");
        }

        for (int i = 1; i < fullStates.length - 1; i++) {
            result.add(fullStates[i]);
        }

        return result;
    }

    public static void main(String[] args) {

//        for(Integer test : cellCompete(new int[]{1,0,0,0,0,1,0,0}, 1)) {
//            System.out.print(test);
//        }
//
//        System.out.println("\n");

        for (Integer test : cellCompete(new int[]{1, 1, 1, 0, 1, 1, 1, 1}, 2)) {
            System.out.print(test);
        }
    }

}
