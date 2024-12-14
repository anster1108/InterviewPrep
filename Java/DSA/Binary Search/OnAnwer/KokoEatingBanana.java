/*
	Koko eating bananas
		A monkey is given n piles of bananas, where the 'ith' pile has nums[i] bananas. An integer h represents the total time in hours to eat all the bananas.

		Each hour, the monkey chooses a non-empty pile of bananas and eats k bananas. If the pile contains fewer than k bananas, the monkey eats all the bananas in that pile and does not consume any more bananas in that hour.

		Determine the minimum number of bananas the monkey must eat per hour to finish all the bananas within h hours.


	Example 1
		Input: n = 4, nums = [7, 15, 6, 3], h = 8

		Output: 5

		Explanation: If Koko eats 5 bananas/hr, he will take 2, 3, 2, and 1 hour to eat the piles accordingly. So, he will take 8 hours to complete all the piles.

	Example 2
		Input: n = 5, nums = [25, 12, 8, 14, 19], h = 5

		Output: 25

		Explanation: If Koko eats 25 bananas/hr, he will take 1, 1, 1, 1, and 1 hour to eat the piles accordingly. So, he will take 5 hours to complete all the piles.
*/

import java.util.*;

class KokoEatingBanana {
    /* Helper function to find the
    maximum element in the array*/
    private int findMax(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;

        // Find the maximum element
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }
        return maxi;
    }

    /* Helper function to calculate total
    hours required at given hourly rate*/
    private int calculateTotalHours(int[] nums, int hourly) {
        int totalH = 0;
        int n = nums.length;

        // Calculate total hours required
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) nums[i] / (double) hourly);
        }
        return totalH;
    }

    /* Function to find the 
    minimum rate to eat bananas*/
    public int minimumRateToEatBananas(int[] nums, int h) {
        // Initialize binary search bounds
        int low = 1, high = findMax(nums);

        // Apply binary search
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(nums, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {7, 15, 6, 3};
        int h = 8;

        // Create an object of the KokoEatingBanana class
        KokoEatingBanana sol = new KokoEatingBanana();

        int ans = sol.minimumRateToEatBananas(nums, h);

        // Print the result
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }
}
