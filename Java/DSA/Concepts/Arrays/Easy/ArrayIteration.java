/*
Question : Iterate the array and find the sum of all even numbers and find the greater number in the given array
*/

import java.util.*;

class ArrayIteration{
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int sum = 0;
		int greatest = -1;
		for (int i = 0; i < arr.length  ; i++ ) {
			if(arr[i]%2 == 0){
				sum = sum + arr[i];
			}
            
			if (arr[i] > greatest) {
				greatest = arr[i];
			}
		}
		System.out.println("Greatest element given in the array is "+greatest);
		System.out.println("sum of even numbers in the array is "+sum);
	}
}