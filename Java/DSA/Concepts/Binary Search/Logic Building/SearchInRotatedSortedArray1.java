/*
	Search in rotated sorted array-I

		Given an integer array nums, sorted in ascending order (with distinct values) and a target value k. The array is rotated at some pivot point that is unknown. Find the index at which k is present and if k is not present return -1.

	Example 1
		Input : nums = [4, 5, 6, 7, 0, 1, 2], k = 0

		Output: 4

		Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.

	Example 2
		Input: nums = [4, 5, 6, 7, 0, 1, 2], k = 3

		Output: -1

		Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1.

	Example 2
		Input: nums = [4, 5, 6, 7, 0, 1, 2], k = 3

		Output: -1

		Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1.
*/

import java.util.*;

class SearchInRotatedSortedArray1 {
    // Function to search for the target element in a rotated sorted array
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        // Applying binary search algorithm 
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if mid points to the target
            if (nums[mid] == target) return mid;

            // Check if the left part is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    // Target exists in the left sorted part
                    high = mid - 1;
                } else {
                    // Target does not exist in the left sorted part
                    low = mid + 1;
                }
            } else {
                // Check if the right part is sorted
                if (nums[mid] <= target && target <= nums[high]) {
                    // Target exists in the right sorted part
                    low = mid + 1;
                } else {
                    // Target does not exist in the right sorted part
                    high = mid - 1;
                }
            }
        }
        // If target is not found
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int target = 1;

        SearchInRotatedSortedArray1 sol = new SearchInRotatedSortedArray1();

        // Function call to search for the target element
        int result = sol.search(nums, target);

        if (result == -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + result);
    }
}