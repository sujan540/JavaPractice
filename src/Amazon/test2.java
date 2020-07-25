package Amazon;

/**
 * Created by maharsu on 6/29/20.
 */
public class test2 {

    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }


    public static int generalizedGCD(int num, int[] arr)
    {
        int result = 0;
        for (int element: arr){
            result = gcd(result, element);

            if(result == 1)
            {
                return 1;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int arr[] = { 2, 4, 6, 8, 16 };
        int n = arr.length;
        System.out.println(generalizedGCD( n, arr));
    }
}
