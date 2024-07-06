/*

Question : Reverse the given Array

Input : {1, 2, 3, 4, 5} 

Output : {5, 4, 3, 2, 1}

*/

import java.util.*;

class ReverseArray{
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int i = 0;
		int j = arr.length - 1;
		while(i != j){
			arr[i] = arr[i] + arr[j];
			arr[j] = arr[i] - arr[j];
			arr[i] = arr[i] - arr[j];
			i++;
			j--;
		}

		for (int val : arr) {
			System.out.println(val);
		}
	}
}