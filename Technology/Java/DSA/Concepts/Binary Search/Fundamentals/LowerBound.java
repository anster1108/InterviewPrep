/*
	Given a sorted array of nums and an integer x, write a program to find the lower bound of x. The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.

	If no such index is found, return the size of the array.

	Brute Force : 
		public int lowerBound(int[] nums,  int x) {
	        int n = nums.length;
	        for (int i = 0; i < n; i++) {
	            // Check the condition for the current element
	            if (nums[i] >= x) {
	                // If lower bound is found
	                return i;
	            }
	        }
	        // If lower bound of 
	           target is not found
	        return n;
	    }

	  	Time Complexity: O(N), where N is the size of the given array. In the worst case, we have to traverse the entire array. This is the time complexity of the linear search algorithm.

		Space Complexity: O(1), no extra space is used to solve this problem.
*/

import java.util.*;

class LowerBound {
    // Function to find the lower bound
    public int lowerBound(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {
            int mid = (low + high) / 2;

            /* Check if mid element 
               is a potential answer */
            if (nums[mid] >= x) {
                ans = mid;

                // Search left half
                high = mid - 1;
            } 
            else {
                // Search right half
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        int x = 2;

        LowerBound sol = new LowerBound();

        // Function call to find the lower bound
        int ind = sol.lowerBound(nums, x);

        System.out.println("The lower bound is the index: " + ind);
    }
}