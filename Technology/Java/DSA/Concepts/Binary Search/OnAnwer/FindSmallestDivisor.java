/*
	Find the smallest divisor
		Given an array of integers nums and an integer limit as the threshold value, find the smallest positive integer divisor such that upon dividing all the elements of the array by this divisor, the sum of the division results is less than or equal to the threshold value.

		Each result of the division is rounded up to the nearest integer greater than or equal to that element.

		Example 1
			Input: nums = [1, 2, 3, 4, 5], limit = 8

			Output: 3

			Explanation: We can get a sum of 15(1 + 2 + 3 + 4 + 5) if we choose 1 as a divisor. 

			The sum is 9(1 + 1 + 2 + 2 + 3) if we choose 2 as a divisor. Upon dividing all the elements of the array by 3, we get 1,1,1,2,2 respectively. Now, their sum is equal to 7 <= 8 i.e. the threshold value. So, 3 is the minimum possible answer.

		Example 2
			Input: nums = [8,4,2,3], limit = 10

			Output: 2

			Explanation: If we choose 1, we get 17 as the sum. If we choose 2, we get 9 (4+2+1+2) <= 10 as the answer. So, 2 is the answer.
*/

import java.util.Arrays;

class FindSmallestDivisor {
    /* Helper unction to find the 
    summation of division values */
    private int sumByD(int[] nums, int limit) {
        // Size of array
        int n = nums.length; 
        
        // Find the summation of division values
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double)nums[i] / (double)limit);
        }
        return sum;
    }

    // Function to find the smallest divisor
    public int smallestDivisor(int[] nums, int limit) {
        int n = nums.length;
        if (n > limit) return -1;
        
        //Find the maximum element:
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        int low = 1, high = maxi;

        // Apply binary search
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumByD(nums, mid) <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int limit = 8;

        // Create an object of the FindSmallestDivisor class
        FindSmallestDivisor sol = new FindSmallestDivisor();

        int ans = sol.smallestDivisor(nums, limit);

        // Print the result
        System.out.println("The minimum divisor is: " + ans);
    }
}
