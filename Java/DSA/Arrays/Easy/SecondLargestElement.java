/*
	Question : Find the 2nd largest element in the array
	
	Solution :
		1. 	Brute Force :
				Time Complexity : nlogn + n

				Approach/Pseudocode : 
					int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
					Arrays.sort(arr);
					int largest = arr[arr.length - 1];
					int shortest = -1;
					for (int i = arr.length - 2; i > 0;i-- ) {
						if (arr[i] < largest) {
							shortest = arr[i];
							break;
						}
					}
		2. Better :
			Time Complexity : O(2N)

			Approach/Pseudocode :
				int a[] = { 9, 4, 7, 6, 3, 1, 5 };
				largest = a[0];
		        secondLargest = -1;
		        for (int i = 1; i < b.length ; i++ ) {
		            if(largest < a[i]){
		                largest = a[i];
		            }
		        }
		        System.out.println("Largest: " + largest);
		        for (int i = 0; i < b.length ; i++ ) {
		            if(a[i] < largest && secondLargest < a[i] ){
		                secondLargest = a[i];
		            }
		        }
		        System.out.println("secondLargest: " + secondLargest);
		3. Best : 
			Time Complexity : O(2N)

			Approach/Pseudocode : 
				int arr[] = { 9, 4, 7, 25, 6, 35, 1, 5 };
				int largest = arr[0];
				int shortest = -1;
				for (int i = 0; i < arr.length; i++ ) {
					if (arr[i] > largest) {
						shortest = largest;
		                largest = arr[i];
					}
				}
				System.out.println("Second Largest Element in the given array is "+shortest);	
*/

import java.util.*;

class SecondLargestNumber{
	public static void main(String[] args) {
		int arr[] = { 9, 4, 7, 25, 6, 35, 1, 5 };
		int largest = arr[0];
		int shortest = -1;
		for (int i = 0; i < arr.length; i++ ) {
			if (arr[i] > largest) {
				shortest = largest;
                largest = arr[i];
			}
		}
		System.out.println("Second Largest Element in the given array is "+shortest);
	}
}