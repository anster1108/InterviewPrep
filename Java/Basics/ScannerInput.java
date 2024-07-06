/*

Question : given the input print the Fibonacci series till the given input

Fibonacci series : 0 , 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ... n

*/

import java.util.*;

class ScannerInput{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // inserting an integer
        int a = sc.nextInt();
        System.out.println(a);

        // inserting an integer
        int arrSize = sc.nextInt();
        int[] arr = new int[arrSize];

        // insert values in array
        for (int i = 0; i < arr.length ; i++ ) {
            arr[i] = sc.nextInt();
        }

        sc.close();
    }
}