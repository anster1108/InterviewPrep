/*
	Question : Merge two Sorted Arrays Without Extra Space

	Example 1:
		Input:
		 
		n = 4, arr1[] = [1 4 8 10] 
		m = 5, arr2[] = [2 3 9]

		Output:
		 
		arr1[] = [1 2 3 4]
		arr2[] = [8 9 10]


	Solution : 
		1. We will declare two pointers i.e. left and right. The left pointer will point to the last index of the arr1[](i.e. Basically the maximum element of the array). The right pointer will point to the first index of the arr2[](i.e. Basically the minimum element of the array).

		2. Now, the left pointer will move toward index 0 and the right pointer will move towards the index m-1. While moving the two pointers we will face 2 different cases like the following:
		
		3. If arr1[left] > arr2[right]: In this case, we will swap the elements and move the pointers to the next positions.
		
		4. If arr1[left] <= arr2[right]: In this case, we will stop moving the pointers as arr1[] and arr2[] are containing correct elements.
		
		Thus, after step 2, arr1[] will contain all smaller elements and arr2[] will contain all bigger elements. Finally, we will sort the two arrays.

		Intuition: If we merge the given array, one thing we can assure is that arr1[] will contain all the smaller elements and arr2[] will contain all the bigger elements. This is the logic we will use. Using the 2 pointers, we will swap the bigger elements of arr1[] with the smaller elements of arr2[] until the minimum of arr2[] becomes greater or equal to the maximum of arr1[].


		Time Complexity: O(min(n, m)) + O(n*logn) + O(m*logm), where n and m are the sizes of the given arrays.
		Reason: O(min(n, m)) is for swapping the array elements. And O(n*logn) and O(m*logm) are for sorting the two arrays.

		Space Complexity: O(1) as we are not using any extra space.		

*/

import java.util.*;

class MergeSortedArrays{
	public static void main(String[] args) {
		long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        merge(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
	}

	public static void merge(long[] arr1,long[] arr2,int n,int m){
		int left = n - 1;
		int right = 0;
		while(left >= 0 && right < m){
			if (arr1[left] > arr2[right]) {
				int temp = arr2[right];
				arr2[right] = arr1[left];
				arr1[left] = temp;
				left--;
				right++;
			} else {
				break;
			}
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2);
	}
}