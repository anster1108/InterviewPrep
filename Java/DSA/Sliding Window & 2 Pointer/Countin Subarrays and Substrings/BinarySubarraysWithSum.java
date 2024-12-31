/*
	Binary Subarrays With Sum
		Given a binary array nums and an integer goal. Return the number of non-empty substrings with a sum goal.
		A subarray is a continuous part of the array.


	Example 1
		Input : nums = [1, 1, 0, 1, 0, 0, 1] , goal = 3
		Output : 4
		Explanation : The subarray with sum 3 are
		[1, 1, 0, 1]
		[1, 1, 0, 1, 0]
		[1, 1, 0, 1, 0, 0]
		[1, 0, 1, 0, 0, 1].

	Example 2
		Input : nums = [0, 0, 0, 0, 1] , goal = 0
		Output : 10
		Explanation : Some of the subarray with sum 0 are
		[0]
		[0, 0]
		[0, 0, 0]
		[0, 0, 0, 0]


	Intuition:
		Here, the idea is to use two-pointers approach to optimize the BinarySubarraysWithSum. So, basically instead of finding the count of substrings which have sum exactly equal to goal, try to find out count of subarrays whose sum is less than or equal to goal and the count of subarrays whose sum is less than or equal to goal-1. The difference of both the counts will provide the required result in linear time.


	Approach:
		Main Function:
			It call the helper function to find out number of subarrays with sum less than or equal to goal.

			In the second call, it gets the number of subarrays with sum less than or equal to goal - 1. Finally, the difference gives the exact count of subarrays with sum equal to goal.

		Helper Function:
			First, check for the edge case, if goal is negative, immediately return 0 because no valid subarray can have a negative sum.
			
			Now, initialize few variables: l(left) and r (right) to mark the current window of subarrays within nums, sum to zero to track the current sum of elements in the window, count to zero to accumulate the number of valid subarrays.

			Iterate through the array using the right pointer r. Add the element at right pointer to sum to include the current element in the window. While the sum is greater than goal decrease the sum and move the left pointer forward to shrink the window.
			
			Then, Count all subarrays ending at r pointer that satisfy the sum condition. Move the right pointer forward and iterate the whole array. Finally, return count as an answer.
*/
import java.util.*;

class BinarySubarraysWithSum {
    /* Function to find the number of 
    subarrays with sum equal to `goal` */
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        /* Calculate the number of subarrays with 
        sum exactly equal to `goal` by using the 
        difference between subarrays with sum less
        than or equal to `goal` and those with sum
        less than or equal to `goal-1` */
        return numSubarraysWithSumLessEqualToGoal(nums, goal) - numSubarraysWithSumLessEqualToGoal(nums, goal - 1);
    }
    
    /* Helper function to find the number of 
    subarrays with sum less than or equal to `goal` */
    private int numSubarraysWithSumLessEqualToGoal(int[] nums, int goal) {
        
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
            sum += nums[r]; 
            
            /* Shrink the window from the left
            side if the sum exceeds `goal` */
            while (sum > goal) {
                sum -= nums[l];  
                
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
        int[] nums = {1, 0, 0, 1, 1, 0};
        int goal = 2;
        
        // Create an instance of BinarySubarraysWithSum class
        BinarySubarraysWithSum sol = new BinarySubarraysWithSum();
        
        int ans = sol.numSubarraysWithSum(nums, goal);
    
        // Print the result
        System.out.println("Number of substrings with sum \"" + goal + "\" is: " + ans);
    }
}

/*
	Complexity Analysis: 
		Time Complexity:O(2*2N), where N is the size of the string. The outer loop runs for N time and the inner while loop might be running for N time throughout the program. So it becomes O(2N), also the helper function is being called twice so overall time complexity is O(2*2N).

		Space Complexity: O(1). There is no extra space being used.
*/