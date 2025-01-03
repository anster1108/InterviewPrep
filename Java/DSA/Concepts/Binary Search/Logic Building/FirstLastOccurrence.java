/*
	First and last occurrence
		Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value. If the target is not found in the array, return [-1, -1].

		Example 1
		Input: nums = [5, 7, 7, 8, 8, 10], target = 8

		Output: [3, 4]

		Explanation:The target is 8, and it appears in the array at indices 3 and 4, so the output is [3,4]

		Example 2
		Input: nums = [5, 7, 7, 8, 8, 10], target = 6

		Output: [-1, -1]

		Expalantion: The target is 6, which is not present in the array. Therefore, the output is [-1, -1].

		Example 3
		Input: nums = [5, 7, 7, 8, 8, 10], target = 5

		Output:	[0, 0]
		
		Brute Force : 
			public int[] searchRange(int[] nums, int target) {
		        // Initialize variables to store first and last occurrences
		        int first = -1, last = -1;
		        int[] ans = new int[2];

		        // Iterate through the array
		        for (int i = 0; i < nums.length; i++) {
		            // Check if current element is the target
		            if (nums[i] == target) {
		                if (first == -1)   first = i; 
		                last = i;
		            }
		        }

		        // Store the results in the answer array
		        ans[0] = first;
		        ans[1] = last;
		        return ans;
		    }

		Complexity Analysis: 
		Time Complexity: O(N), where N is the size of the given array. This is because we are performing a linear search through the array to find the first and last occurrences of the target element.

		Space Complexity: O(1), as we are not using any extra space that grows with the input size. We are only using a few additional variables to store indices and results.
*/

import java.util.*;

class FirstLastOccurrence {
    // Function to find the first occurrence of the target
    private int firstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int first = -1;

        // Applying Binary Search Algorithm
        while(low <= high) {
            int mid = low + (high - low) / 2;

            /*  If the target element is found, we 
                update the first variable to mid and
                eliminate the right half to look for 
                more smaller index where target is present */
            if(nums[mid] == target) {
                first = mid;
                high = mid - 1;  
            } 

            /*  If middle element is smaller,
                we eliminate the left half  */
            else if(nums[mid] < target) {
                low = mid + 1;  
            } 
            
            /*  If middle element is greater,
                we eliminate the right half  */
            else {
                high = mid - 1;  
            }
        }
        return first;
    }

    // Function to find the last occurrence of the target
    private int lastOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int last = -1;

        // Applying Binary Search Algorithm
        while(low <= high) {
            int mid = low + (high - low) / 2;

            /*  If the target element is found, we 
                update the first variable to mid and
                eliminate the right half to look for 
                more greater index where target is present */
            if(nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } 
            
            /*  If middle element is smaller,
                we eliminate the left half  */
            else if(nums[mid] < target) {
                low = mid + 1;  
            } 
            
            /*  If middle element is greater,
                we eliminate the right half  */
            else {
                high = mid - 1; 
            }
        }
        return last;
    }

    // Function to find the first and last occurrences of the target
    public int[] searchRange(int[] nums, int target) {

        // Function call to find the first occurence of target
        int first = firstOccurrence(nums, target); 
        
        // If the target is not present in the array
        if(first == -1) return new int[]{-1, -1};  

        // Function call to find the last occurence of target
        int last = lastOccurrence(nums, target);  

        return new int[]{first, last};  
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};  
        int target = 8; 

        // Create an instance of the FirstLastOccurrence class
        FirstLastOccurrence sol = new FirstLastOccurrence();

        // Function call to find the first and last occurrences
        int[] result = sol.searchRange(nums, target);

        System.out.println("The first and last occurrences are at indices: " 
                           + result[0] + " and " + result[1]);
    }
}

/*
	Complexity Analysis: 
		Time Complexity: O(log N), where N is the size of the given array. Both the firstOccurrence and lastOccurrence functions perform a binary search, which operates in logarithmic time. Thus, the overall time complexity is O(log N).

		Space Complexity: O(1), as we are using a constant amount of extra space regardless of the input size. The space used by the variables low, high, mid, first, and last does not depend on the size of the input array.
*/