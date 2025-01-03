/* 
    1. Selection sort
        Find the smallest element in the given array 
        and swap with the initial element and so on

    Time complexity : O(n^2)
*/

import java.util.*;

class SelectionSort{
    public static void main(String[] args) {
        int a[] = {13,46,24,52,20,9};
        int arlength = a.length ;

        for (int i = 0; i < arlength ; i++) {
           int small = a[i];
           int counter = i;
           for (int j = i + 1; j < arlength ; j++ ) {
                if (a[j] < small) {
                    small = a[j];
                    counter = j;
                }
            } 

            // swap small with a[i]
            if (i != counter) {
                int temp = a[i];
                a[i] = a[counter];
                a[counter] = temp;
            }
        }


        for (int name : a) {
            System.out.println(name);
        }
    }
}