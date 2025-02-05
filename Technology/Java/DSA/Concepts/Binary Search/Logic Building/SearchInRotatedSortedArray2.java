/*
	Search in rotated sorted array-II
	Given an integer array nums, sorted in ascending order (may contain duplicate values) and a target value k. Now the array is rotated at some pivot point unknown to you. Return True if k is present and otherwise, return False.

	Example 1
		Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3

		Output: True

		Explanation: The element 3 is present in the array. So, the answer is True.

	Example 2
		Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 10

		Output: False

		Explanation:The element 10 is not present in the array. So, the answer is False.

	Example 3
		Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 7

		Output: True
*/

import java.util.*;

class SearchInRotatedSortedArray2 {
    /* Function to search for the target element 
    in a rotated sorted array with duplicates */
    public boolean searchInARotatedSortedArrayII(ArrayList<Integer> arr, int target) {
        int n = arr.size();
        int low = 0, high = n - 1;
        
        // Applying binary search algorithm 
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if mid points to the target
            if (arr.get(mid) == target) return true;

            // Handle duplicates: if arr[low], arr[mid], and arr[high] are equal
            if (arr.get(low).equals(arr.get(mid)) && arr.get(mid).equals(arr.get(high))) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            // Check if the left part is sorted
            if (arr.get(low) <= arr.get(mid)) {
                /*  Eliminate the right part if target
                    exists in the left sorted part */
                if (arr.get(low) <= target && target <= arr.get(mid)) {
                    high = mid - 1;
                } 
                // Otherwise eliminate the left part
                else {
                    low = mid + 1;
                }
            } else {
                /*  If the right part is sorted and
                    target exists in the right sorted
                    part, eliminate the left part   */
                if (arr.get(mid) <= target && target <= arr.get(high)) {
                    low = mid + 1;
                } 
                // Otherwise eliminate the right part
                else {
                    high = mid - 1;
                }
            }
        }
        // If target is not found
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(7); arr.add(8); arr.add(1); arr.add(2); arr.add(3);
        arr.add(3); arr.add(3); arr.add(4); arr.add(5); arr.add(6);

        int target = 3; 

        // Create an instance of the SearchInRotatedSortedArray2 class
        SearchInRotatedSortedArray2 sol = new SearchInRotatedSortedArray2();

        // Function call to search for the target element
        boolean result = sol.searchInARotatedSortedArrayII(arr, target);

        if (!result)
            System.out.println("Target is not present.");
        else
            System.out.println("Target is present in the array.");
    }
}