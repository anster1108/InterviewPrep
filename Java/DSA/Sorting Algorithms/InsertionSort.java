/*
   3.   Insertion Sort [ It takes an element and takes it to its correct position ]
        Iterate and put the value to its exact place, this can be achieved by
        -> take a snippet and find the smallest and shift to left of arr 
        -> increase the array and take the last element and move to its existing position
            by comparing to its righ next element

        Time complexity : O(n^2)
*/

import java.util.*;

class InsertionSort{
	public static void main(String[] args) {
		int a[] = {13,46,24,52,20,9};
		for (int i = 0; i < a.length ; i++ ) {
            int j = i;
            while (j > 0) {
                if(a[j] < a[j - 1]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
                j--;
            }
        }

		// print the sorted array
        for (int val : a) {
            System.out.println(val);
        }
	}
}