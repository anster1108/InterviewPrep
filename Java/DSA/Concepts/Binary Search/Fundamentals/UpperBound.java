/*
	Given a sorted array of nums and an integer x, write a program to find the upper bound of x. The upper bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than a given key i.e. x.

    If no such index is found, return the size of the array.

	Brute Force : 
		public int upperBound(int[] nums, int x) {
            int n = nums.length;
            // Iterate over each element
            for (int i = 0; i < n; i++) {
                // Return the index if the element is greater than x
                if (nums[i] > x) {
                    return i;
                }
            }
            // If no element is greater than x, return n
            return n;
        }

	  	Time Complexity: O(N), where N is the size of the given array. In the worst case, we have to traverse the entire array. This is the time complexity of the linear search algorithm.

		Space Complexity: O(1), no extra space is used to solve this problem.
*/

import java.util.*;

class UpperBound {
    // Function to find the upper bound
    public int upperBound(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        // Binary search to find the upper bound
        while (low <= high) {
            // Calculate mid index
            int mid = (low + high) / 2;

            /* Update ans if current element is greater than x */
            if (nums[mid] > x) {
                ans = mid;
                high = mid - 1;
            }
            // Otherwise, move to the right half
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        int x = 2;

        UpperBound sol = new UpperBound();

        // Function call to find the upper bound
        int ind = sol.upperBound(nums, x);

        System.out.println("The upper bound is the index: " + ind);
    }
}