package DataStructure.graph.BFS;

import java.util.*;

/**
 * Created by root on 2020-02-19.
 */
public class Cyclic {

    public static int segment(int x, int arr[]) {

        final List<List<Integer>> output = new ArrayList<>();

        int length = arr.length;

        // This is bruth force techinque I'm using,
        // If time allow me I can improve this using Graph in better way
        for (int i = 0; i < length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < x + i ; j++) {
                if (j < length) {
                    temp.add(arr[j]);
                }
            }
            if(temp.size() == x){
                output.add(temp);
            }
        }

        final List<Integer> finalOutput = new ArrayList<>();

        for (final List<Integer> result : output) {
            // Probably I don't need to do multiple sorting but
            // I guess this inbuilt can can perform with O(nlogn)
            Collections.sort(result);
            finalOutput.add(result.get(0));
        }

        Collections.sort(finalOutput);

        return finalOutput.get(finalOutput.size() - 1);
    }

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int n = scanner.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(segment(x, arr));

        scanner.close();
    }
}
