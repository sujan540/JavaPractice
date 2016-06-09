package hackerrank;

import java.util.Arrays;

public class Solutions {
	
	public static void main(String args[]) {
        
		
		System.out.println(findSecondHighest(new int[]{1,2,3,4}));
    }
	
	public static void largestAndSmallest(int[] numbers) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            } else if (number < smallest) {
                smallest = number;
            }
        }

        System.out.println("Given integer array : " + Arrays.toString(numbers));
        System.out.println("Largest number in array is : " + largest);
        System.out.println("Smallest number in array is : " + smallest);
    }
	
	public static int findSecondHighest(int[] array){
        int highest = array[0];
         
            for(int i=0;i<array.length;i++) {
             
         
            if(array[i] > highest){
                 
                highest = array[i];
                 
             
             
             }
        } // end for
         
        return highest;
     
         
         
    } // end method   

}
