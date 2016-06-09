package DataStructure;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by sujan on 6/8/16.
 */
public class MyQuickSelectKSmallest {


    public static int[] quickSelect(int[] elements, int position) {
        int size = elements.length;
        int pivotPosition = new Random().nextInt(size - 1);

        int[] L= new int[pivotPosition];
        int[] E = new int[]{elements[pivotPosition]};
        int[] G = new int[size-pivotPosition-1];

        int Lcount=0;
        int Gcount=0;
        for(int i=0;i<size;i++){
            if(i==pivotPosition)
                continue;
            if(elements[i]<E[0]){
                L[++Lcount]=elements[i];
            }else{
                G[++Gcount]=elements[i];
            }
        }
        display(L);


        return elements;
    }

    public static void display(int[] array){
        System.out.println(Arrays.toString(array));
    }


    private void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x]=array[y];
        array[y]=temp;
    }

    public static void main(String[] args) {
        quickSelect(new int[]{21, 3, 34, 5, 13, 8, 2, 55, 1, 19}, 4);
    }
}
