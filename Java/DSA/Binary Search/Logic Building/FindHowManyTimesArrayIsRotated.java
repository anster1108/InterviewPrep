/*
	Find out how many times the array is rotated

		Given an integer array nums of size n, sorted in ascending order with distinct values. The array has been right rotated an unknown number of times, between 1 and n. Determine the number of rotations performed on the array.

		Example 1
			Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]

			Output: 4

			Explanation: The original array should be [0, 1, 2, 3, 4, 5, 6, 7]. So, we can notice that the array has been rotated 4 times.

		Example 2
			Input: nums = [3, 4, 5, 1, 2]

			Output: 3

			Explanation: The original array should be [1, 2, 3, 4, 5]. So, we can notice that the array has been rotated 3 times.

		Example 3
			Input: nums = [4, 5, 1, 2]

			Output: 2
*/

import java.util.*;

class FindHowManyTimesArrayIsRotated {
    /* Function to find the number of
       rotations in a rotated sorted array */
    public int findKRotation(ArrayList<Integer> nums) {
        int low = 0, high = nums.size() - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            
            /* Search space is already sorted
               then nums.get(low) will always be
               the minimum in that search space */
            if (nums.get(low) <= nums.get(high)) {
                if (nums.get(low) < ans) {
                    index = low;
                    ans = nums.get(low);
                }
                break;
            }
            
            // If left part is sorted update the ans
            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) < ans) {
                    index = low;
                    ans = nums.get(low);
                }
                // Eliminate left half
                low = mid + 1;
            } else {
                /* update the ans if it 
                   is less than nums.get(mid) */
                if (nums.get(mid) < ans) {
                    index = mid;
                    ans = nums.get(mid);
                }
                // Eliminate right half
                high = mid - 1;
            }
        }
        // Return the index as answer
        return index;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3));
      
        FindHowManyTimesArrayIsRotated sol = new FindHowManyTimesArrayIsRotated();
        
        int ans = sol.findKRotation(nums);
        
        // Print the result
        System.out.println("The array is rotated " + ans + " times.");
    }
}
