/*
	Max Consecutive Ones III
		Given a binary array nums and an integer k, flip at most k 0's.
		Return the maximum number of consecutive 1's after performing the flipping operation.

	Example 1
		Input : nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0] , k = 3
		Output : 10
		Explanation : The maximum number of consecutive 1's are obtained only if we flip the 0's present at position 3, 4, 5 (0 base indexing).
		The array after flipping becomes [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0].
		The number of consecutive 1's is 10.

	Example 2
		Input : nums = [0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1] , k = 3
		Output : 9
		Explanation : The underlines 1's are obtained by flipping 0's in the new array.
		[1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1].
		The number of consecutive 1's is 9.

	Example 3
		Input : nums = [1, 1, 0, 0, 1] , k = 3
		Output: 5

	Brute :
		Intuition: 
			The idea here is to generate all possible substrings of the given array and while doing so, keep a track of all the zeros encountered so far in the substring. If the number of zeros exceeds k then no need to consider that substring, else calculate the length of the current substring and update the maximum length of substring.
		Approach: 
			-> Iterate the array using for loop which runs from 0 to sizeOfArray - 1, which indicates the starting point of a substring. Now, initialize a variable zero to 0 to keep track number of zeros found so far in the substring.
			-> Use another for loop, which basically indicates the ending point of the substring, if the current element is 0, then increase the the variable zero by.
			-> If number of 0 in the current substring exceeds k then break out of the inner loop, no need to consider such string. Else, calculate the length of current substring and update the maximum length of substring encountered so far. Finally, return the maximum length of the substring.
		Code : 
			public int longestOnes(int[] nums, int k) {
		        // Length of the input array
		        int n = nums.length;
		        
		        // Maximum length of the substring
		        int maxLen = 0;
		        
		        // Variable to count the number of zeros in the current window
		        int zeros = 0;
		        
		        // Iterate through all possible starting points of the substring
		        for (int i = 0; i < n; i++) {
		            zeros = 0;
		            
		            // Expand the window from starting point i to the end of the array
		            for (int j = i; j < n; j++) {
		                if (nums[j] == 0) {
		                    
		                    // Increment zeros count when encountering a zero
		                    zeros++;
		                }
		                
		                // If zeros count is within the allowed limit (k), update maxLen
		                if (zeros <= k) {
		                    
		                    // Calculate the length of substring
		                    int len = j - i + 1;
		                    maxLen = Math.max(maxLen, len);
		                } else break;
		            }
		        }
		        
		        // Return the maximum length
		        return maxLen;
		    }

		Time Complexity:O(N2), where N is the size of the array. As for every element of the array the inner loop runs for N times.

		Space Complexity: O(1) as no extra space is being used.

	Better : 
		Intuition: 
			The idea here is to use sliding window technique to solve this problem in linear time. The sliding window technique is chosen because it efficiently manages a window within the input array that meets specific criteria. It dynamically adjusts the size and position of the window based on the number of zeros encountered to ensure the that the number of zeros are less than and equal to k.

		Approach: 
			First, initialize few variables as : l and r as pointers to the left and right ends of the window respectively, both starting at the beginning of the array nums, zeros to keep track of the number of zeros encountered within the current window, maxLen to store the maximum length of the substring found so far.
			
			Use a sliding window approach where r moves from the start to the end of the array nums. Check if current element in the array is 0. If yes, increment the zeros count.
			
			While zeros exceeds k, adjust the window by moving l to the right until zeros is less than or equal to k. This ensures that the window contains at most k zeros.
			
			If number of zero is less than or equal to k then calculate the length of the substring. Update maximum length of sustring to keep track of the maximum length encountered during the iteration and finally, return it.

		Code :
			public int longestOnes(int[] nums, int k) {
		        // Length of the input array
		        int n = nums.length;
		        
		        // Pointers for sliding window approach
		        int l = 0, r = 0;
		        
		        // Variables to count zeros and store maximum length
		        int zeros = 0, maxLen = 0;
		               
		        // Iterate through the array using sliding window approach
		        while(r < n){
		            if(nums[r] == 0){
		                
		                // Increment zeros count when encountering a zero
		                zeros++;  
		            }
		            while(zeros > k){
		                if(nums[l] == 0){
		                    
		                    // Decrement zeros count when moving left pointer
		                    zeros--; 
		                }
		                
		                // Move left pointer to the right to shrink the window
		                l++;  
		            }
		            
		            // Calculate the length of current substring
		            int len = r - l + 1;
		            
		            // Update maxLen if the current substring length is greater
		            maxLen = Math.max(maxLen, len);
		            
		            // Move right pointer to expand the window
		            r++;  
		        }
		        
		        // Return the maximum length
		        return maxLen; 
		    }

		Complexity Analysis: 
			Time Complexity:O(2N), where N is the size of the array. The outer and the inner loop is running for N times each.

			Space Complexity: O(1) as no extra space is being used.
*/
import java.util.*;

class MaxConsecutiveOnes {
    /* Function to find the length of the
    longest substring with at most k zeros */
    public int longestOnes(int[] nums, int k) {
        
        // Length of the input array
        int n = nums.length;
        
        // Pointers for sliding window approach
        int l = 0, r = 0;
        
        /* Variables to count zeros
        and store maximum length */
        int zeros = 0, maxLen = 0;
               
        /* Iterate through the array 
        using sliding window approach */
        while (r < n) {
            
            if(nums[r] == 0) zeros++;
            
            if (zeros > k) {
                if (nums[l] == 0) {
                    
                    /* Decrement zeros count
                    when moving left pointer */
                    zeros--; 
                }
                l++;
            }
            if(zeros <= k){
                /* Calculate the length 
                of current substring */
                int len = r - l + 1;
            
                /* Update maxLen if the current
                substring length is greater */
                maxLen = Math.max(maxLen, len);
            }
            r++;  
        }
        
        // Return the maximum length
        return maxLen; 
    }
    
    public static void main(String[] args) {
        int[] input = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;  
        
        // Create an instance of MaxConsecutiveOnes class
        MaxConsecutiveOnes sol = new MaxConsecutiveOnes();
        
        int length = sol.longestOnes(input, k);
        
        // Print the result
        System.out.println("Length of longest substring with at most " + k + " zeros: " + length);
    }
}
