/*
	Count number of Nice subarrays
		Given an array nums and an integer k. An array is called nice if and only if it contains k odd numbers. Find the number of nice subarrays in the given array nums.

		A subarray is continuous part of the array.

	Example 1
		Input : nums = [1, 1, 2, 1, 1] , k = 3
		Output : 2
		Explanation : The subarrays with three odd numbers are
		[1, 1, 2, 1]
		[1, 2, 1, 1]

	Example 2
		Input : nums = [4, 8, 2] , k = 1
		Output : 0
		Explanation : The array does not contain any odd number.

	Example 3
		Input : nums = [41, 3, 5] , k = 2
		Output:2

	Intuition:
		Here, the idea is to use two-pointers approach to optimize the CountNumberOfNiceSubarrays. As, this problem is a slight variation of the problem of finding count of subarrays with given sum in binary array, the thought process would be very similar. Take the modulo 2 of the elements and if the element is even it will become 0 , else it will become 1, thus the array would be converted into a binary subarray. So, basically instead of finding the count of substrings which have exactly k odd elements, try to find out count of subarrays where the number of odd elements is less than or equal to k and the count of subarrays with odd elements less than or equal to goal-1. The difference of both the counts will provide the required result in linear time.


	Approach:
		Main Function:
			It call the helper function to find out number of subarrays with odd numbers less than or equal to k.
	
			In the second call, it gets the number of subarrays with odd numbers less than or equal to k - 1. Finally, the difference gives the exact count of subarrays with k odd elements.

		Helper Function:
			First, check for the edge case, if goal is negative, immediately return 0 because no valid subarray can have a negative sum.
	
			Now, initialize few variables: l(left) and r (right) to mark the current window of subarrays within nums, sum to zero to track the current sum of elements in the window, count to zero to accumulate the number of valid subarrays.
			
			Iterate through the array using the right pointer r. Add the element at right pointer to sum to include the current element in the window. While the sum is greater than k decrease the sum and move the left pointer forward to shrink the window.
	
			Then, Count all subarrays ending at r pointer that satisfy the sum condition. Move the right pointer forward and iterate the whole array. Finally, return count as an answer.
*/
import java.util.*;

class CountNumberOfNiceSubarrays {
    /* Function to find the number of 
    nice subarrays with k odd numbers */
    public int numberOfOddSubarrays(int[] nums, int k) {
        
        /* Calculate the number of subarrays with 
        sum exactly equal to `k` by using the 
        difference between subarrays with sum less
        than or equal to `k` and those with sum
        less than or equal to `k-1` */
        return helper(nums, k) - helper(nums, k - 1);
    }
    
    /* Helper function to find the number of 
    subarrays with sum less than or equal to goal */
    private int helper(int[] nums, int goal) {
        
        /* If goal is negative, there 
        can't be any valid subarray sum */
        if (goal < 0) return 0;
        
        // Pointers to maintain the current window
        int l = 0, r = 0; 
        
        /* Variable to track the current
        sum of elements in the window*/
        int sum = 0;      
        
        // Variable to count the number of subarrays
        int count = 0;   
        
        // Iterate through the array 
        while (r < nums.length) {
            sum += nums[r] % 2; 
            
            /* Shrink the window from the left
            side if the sum exceeds `goal` */
            while (sum > goal) {
                sum -= nums[l] % 2;  
                
                // Move the left pointer `l` forward
                l++;            
            }
            
            /* Count all subarrays ending at
            `r` that satisfy the sum condition */
            count += (r - l + 1);
            
            // Move the right pointer `r` forward 
            r++; 
        }
        
        // Return the total count of subarrays
        return count;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 1;
        
        // Create an instance of CountNumberOfNiceSubarrays class
        CountNumberOfNiceSubarrays sol = new CountNumberOfNiceSubarrays();
        
        int ans = sol.numberOfOddSubarrays(nums, k);
    
        // Print the result
        System.out.println("Number of nice subarrays with \"" + k + "\" odd numbers is: " + ans);
    }
}
/*
	Complexity Analysis: 
		Time Complexity:O(2*2N), where N is the size of the string. The outer loop runs for N time and the inner while loop might be running for N time throughout the program. So it becomes O(2N), also the helper function is being called twice so overall time complexity is O(2*2N).

		Space Complexity: O(1). There is no extra space being used.
*/