/*
	Minimum days to make M bouquets
		Given n roses and an array nums where nums[i] denotes that the 'ith' rose will bloom on the nums[i]th day, only adjacent bloomed roses can be picked to make a bouquet. Exactly k adjacent bloomed roses are required to make a single bouquet. Find the minimum number of days required to make at least m bouquets, each containing k roses. Return -1 if it is not possible.

	Example 1
		Input: n = 8, nums = [7, 7, 7, 7, 13, 11, 12, 7], m = 2, k = 3

		Output: 12

		Explanation: On the 12th the first 4 flowers and the last 3 flowers would have already bloomed. So, we can easily make 2 bouquets, one with the first 3 and another with the last 3 flowers.

	Example 2
		Input: n = 5, nums = [1, 10, 3, 10, 2], m = 3, k = 2

		Output: -1

		Explanation: If we want to make 3 bouquets of 2 flowers each, we need at least 6 flowers. But we are given only 5 flowers, so, we cannot make the bouquets.
*/

MinimumDaysToMakeBouquets

import java.util.*;

class MinimumDaysToMakeBouquets {
    /* Function to check if it's possible to make
    m bouquets with k flowers each on day*/
    private boolean possible(int[] nums, int day, int m, int k) {
        int n = nums.length; 
        
        // Count of flowers bloomed
        int cnt = 0; 
        
        // Count of bouquets formed
        int noOfB = 0; 

        // Count number of bouquets that can be formed
        for (int i = 0; i < n; i++) {
            if (nums[i] <= day) {
                // Increment flower count
                cnt++; 
            } else {
                /* Calculate number of bouquets
                formed with flowers <= day */
                noOfB += (cnt / k);
                
                // Reset flower count
                cnt = 0; 
            }
        }
        // Add remaining flowers as a bouquet
        noOfB += (cnt / k); 

        /* Return true if enough 
        bouquets can be formed */
        return noOfB >= m; 
    }

    /* Function to find the earliest day to
    make m bouquets of k flowers each*/
    public int roseGarden(int n, int[] nums, int k, int m) {
        
        /* Calculate the minimum 
           number of flowers required*/
        long val = (long) m * k; 
        
        /* Impossible case: not enough 
           flowers to make m bouquets*/
        if (val > n) return -1; 
        
        /* Find maximum and minimum
           bloom days in the array */
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, nums[i]); 
            maxi = Math.max(maxi, nums[i]); 
        }

        /* Binary search to find the
           earliest day to make m bouquets */
        int low = min, high = maxi, ans = -1;
        while(low <= high){
            
            // Calculate the middle day
            int mid = (low + high) / 2;
            
            /* Check if it's possible to 
               make m bouquets on day mid */
            if (possible(nums, mid, m, k)) {
                
                // Update the answer to mid
                ans = mid; 
                
                // Try for a smaller day
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        
        /* Return the earliest day or
        -1 if no such day exists*/
        return ans; 
    }

    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7}; 
        
        int n = arr.length;
        
        // Number of flowers per bouquet
        int k = 3; 
        
        // Number of bouquets needed
        int m = 2; 

        // Create an instance of the MinimumDaysToMakeBouquets class
        MinimumDaysToMakeBouquets sol = new MinimumDaysToMakeBouquets(); 
        
        int ans = sol.roseGarden(n, arr, k, m); 

        if (ans == -1) {
            System.out.println("We cannot make m bouquets."); 
        } else {
            System.out.println("We can make bouquets on day " + ans); 
        }
    }
}
