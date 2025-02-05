/*
	Given two integer arrays nums1 and nums2. Both arrays are sorted in non-decreasing order.

	Merge both the arrays into a single array sorted in non-decreasing order.

	The final sorted array should be stored inside the array nums1 and it should be done in-place.
	nums1 has a length of m + n, where the first m elements denote the elements of nums1 and rest are 0s.
	nums2 has a length of n.

	Example 1
		Input: nums1 = [-5, -2, 4, 5], nums2 = [-3, 1, 8]

		Output: [-5, -3, -2, 1, 4, 5, 8]

		Explanation: The merged array is: [-5, -3, -2, 1, 4, 5, 8], where [-5, -2, 4, 5] are from nums1 and [-3, 1, 8] are from nums2

	Example 2
		Input: nums1 = [0, 2, 7, 8], nums2 = [-7, -3, -1]

		Output: [-7, -3, -1, 0, 2, 7, 8]

		Explanation: The merged array is: [-7, -3, -1, 0, 2, 7, 8], where [0, 2, 7, 8] are from nums1 and [-7, -3, -1] are from nums2


		Brute :

		    // Function to merge two sorted arrays nums1 and nums2
		    public void merge(int[] nums1, int m, int[] nums2, int n) {
		        
		        // Declare a 3rd array and 2 pointers:
		        int[] merged = new int[m + n];
		        int left = 0;
		        int right = 0;
		        int index = 0;

		        // Insert elements from nums1 and nums2 into merged array using left and right pointers 
		        while (left < m && right < n) {
		            if (nums1[left] <= nums2[right]) {
		                merged[index++] = nums1[left++];
		            } else {
		                merged[index++] = nums2[right++];
		            }
		        }

		        // If right pointer reaches the end of nums2:
		        while (left < m) {
		            merged[index++] = nums1[left++];
		        }

		        // If left pointer reaches the end of nums1:
		        while (right < n) {
		            merged[index++] = nums2[right++];
		        }

		        // Copy elements from merged array array back to nums1 
		        for (int i = 0; i < m + n; i++) {
		            nums1[i] = merged[i];
		        }
		    }

*/

import java.util.*;

class MergeSortedArraysWithoutExtraSpace {
    // Function to merge two sorted arrays nums1 and nums2
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointer for nums1 (end of valid elements)
        int left = m - 1;
        
        // Pointer for nums2 (beginning of valid elements)
        int right = 0;
        
        /* Swap the elements until nums1[left]
        is smaller than nums2[right]*/
        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } 
            //break out of loop if nums1[left] > nums2[right] 
            else break;
        }
        
        // Sort nums1 from index 0 to m-1
        Arrays.sort(nums1, 0, m);
        
        // Sort nums2 from start to end
        Arrays.sort(nums2);
        
        // Put the elements of nums2 in nums1
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = {-5, -2, 4, 5, 0, 0, 0};
        int[] nums2 = {-3, 1, 8};
        int m = 4, n = 3;

        // Create an instance of the MergeSortedArraysWithoutExtraSpace class
        MergeSortedArraysWithoutExtraSpace sol = new MergeSortedArraysWithoutExtraSpace();

        sol.merge(nums1, m, nums2, n);

        // Output the merged arrays
        System.out.println("The merged arrays are:");
        System.out.print("nums1[] = ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
