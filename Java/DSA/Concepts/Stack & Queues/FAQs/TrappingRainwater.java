/*
	Trapping Rainwater
		Given an array of non-negative integers, height representing the elevation of ground. Calculate the amount of water that can be trapped after rain.

	Example : 
		Input: height= [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
		Output: 6
		Explanation: As seen from the diagram 1+1+2+1+1=6 unit of water can be trapped

	Example : 
		Input: height= [4, 2, 0, 3, 2, 5]
		Output: 9
		Expalanation: 2+4+1+2=9 unit of water can be trapped

	Brute : 
		private int[] findPrefixMax(int[] arr, int n) {
	        // To store the prefix maximum
	        int[] prefixMax = new int[n];
	        
	        // Initial configuration
	        prefixMax[0] = arr[0];
	        
	        // Traverse the array
	        for(int i = 1; i < n; i++) {
	            // Store the maximum till ith index
	            prefixMax[i] = 
	                Math.max(prefixMax[i-1], arr[i]);
	        }
	        
	        // Return the prefix maximum array
	        return prefixMax;
	    }
	    
	    // Function to find the suffix maximum array
	    private int[] findSuffixMax(int[] arr, int n) {
	        // To store the suffix maximum
	        int[] suffixMax = new int[n];
	        
	        // Initial configuration
	        suffixMax[n-1] = arr[n-1];
	        
	        // Traverse the array
	        for(int i = n-2; i >= 0; i--) {
	            // Store the maximum till ith index
	            suffixMax[i] = 
	                Math.max(suffixMax[i+1], arr[i]);
	        }
	        
	        // Return the suffix maximum array
	        return suffixMax;
	    }

	    // Function to get the trapped water
	    public int trap(int[] height) {
	        
	        int n = height.length; // Size of array
	    
	        // To store the total trapped rainwater
	        int total = 0;
	        
	        // Calculate prefix maximum array
	        int[] leftMax = 
	            findPrefixMax(height, n);
	        
	        // Calculate suffix maximum array
	        int[] rightMax = 
	            findSuffixMax(height, n);
	        
	        // Traverse the array
	        for(int i = 0; i < n; i++) {
	            
	            // If there are higher grounds on both side to hold water
	            if(height[i] < leftMax[i] && 
	               height[i] < rightMax[i]) {
	                   
	                // Add up the water on top of current height
	                total += ( Math.min(leftMax[i], rightMax[i]) 
	                           - height[i] );
	            }
	        }
	        
	        // Return the result
	        return total;
	    }

	Complexity Analysis:
		Time Complexity: O(N) (where N is the size of given array)

			Calculating the Prefix and Suffix Maximum Arrays take O(N) time each.
			
			Traversing on the given array once takes O(N) time.

		Space Complexity: O(N)
		Storing the Prefix and Suffix Maximum Arrays takes O(N) space each.
*/
import java.util.*;

class TrappingRainwater {

    // Function to get the trapped water
    public int trap(int[] height) {
        
        int n = height.length; // Size of array
    
        // To store the total trapped rainwater
        int total = 0;
        
        // To store the maximums on both sides
        int leftMax = 0, rightMax = 0;
        
        // Left and Right pointers
        int left = 0, right = n - 1;
        
        // Traverse from both ends
        while (left < right) {
            
            // If left height is smaller or equal
            if (height[left] <= height[right]) {
                
                // If water can be stored
                if (leftMax > height[left]) {
                    
                    // Update total water
                    total += leftMax - height[left];
                }
                
                // Else update maximum height on left
                else leftMax = height[left];
                
                // Shift left by 1
                left = left + 1;
            }
            
            // Else if right height is smaller
            else {
                
                // If water can be stored
                if (rightMax > height[right]) {
                    
                    // Update total water
                    total += rightMax - height[right];
                }
                
                // Else update maximum height on right
                else rightMax = height[right];
                
                // Shift right by 1
                right = right - 1;
            }
        }
        
        // Return the result
        return total;
    }

    public static void main(String[] args) {
        int[] heights = {4, 2, 0, 3, 2, 5};
        
        /* Creating an instance of 
        TrappingRainwater class */
        TrappingRainwater sol = new TrappingRainwater(); 
        
        // Function call to get the trapped water
        int ans = sol.trap(heights);
        
        System.out.println("The trapped rainwater is: " + ans);
    }
}

