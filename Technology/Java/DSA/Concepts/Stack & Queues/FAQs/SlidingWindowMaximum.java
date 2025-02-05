/*
	Sliding Window Maximum
	
		Given an array of integers arr, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

		Example : 
			Input: arr = [4, 0, -1, 3, 5, 3, 6, 8], k = 3

			Output: [4, 3, 5, 5, 6, 8]

			Explanation: 

			Window position        Max

			-----------------------------

			[4 0 -1] 3 5 3 6 8      4

			4 [0 -1 3] 5 3 6 8      3

			4 0 [-1 3 5] 3 6 8      5

			4 0 -1 [3 5 3] 6 8      5

			4 0 -1 3 [5 3 6] 8      6

			4 0 -1 3 5 [3 6 8]      8

			For each window of size k=3, we find the maximum element in the window and add it to our output array.
		
		Example : 
			Input: arr = [20, 25], k = 2

			Output: [25]
			Explanation: There’s just one window of size 2 that is possible and the maximum of the two elements is our answer.

		Example : 
			Input: arr = [1, 3, -1, -3, 5, 3, 6, 7], k = 3

			Output: [3, 3, 5, 5, 6, 7]


	Brute : 
		public List<Integer> maxSlidingWindow(int[] arr, int k) {
	        int n = arr.length; // Size of array
	        
	        // To store the answer
	        List<Integer> ans = new ArrayList<>();
	        
	        // Traverse on the arrary for valid window
	        for(int i = 0; i <= n - k; i++) {
	            
	            // To store the maximum of the window
	            int maxi = arr[i];
	            
	            // Traverse the window
	            for(int j = i; j < i + k; j++) {
	                // Update the maximum
	                maxi = Math.max(maxi, arr[j]);
	            }
	            
	            // Add the maximum to the result
	            ans.add(maxi);
	        }
	        
	        // Return the stored result
	        return ans;
	    }

		Complexity Analysis:
			Time Complexity: O((N-K)*K) (where N is the size of given array)
			Using two nested loops.

			Space Complexity: O(N-K)
			Due to the size taken to return the answer.
*/
import java.util.*;

class SlidingWindowMaximum {
    // Function to get the maximum sliding window
    public int[] maxSlidingWindow(int[] arr, int k) {
        
        int n = arr.length; // Size of array
        
        // To store the answer
        int[] ans = new int[n - k + 1];
        int ansIndex = 0;
        
        // Deque data structure
        Deque<Integer> dq = new LinkedList<>();
        
        // Traverse the array
        for (int i = 0; i < n; i++) {
            
            // Update deque to maintain current window
            if (!dq.isEmpty() && dq.peekFirst() <= (i - k)) {
                dq.pollFirst();
            }
            
            /* Maintain the monotonic (decreasing) 
            order of elements in deque */
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            
            // Add current element's index to the deque
            dq.offerLast(i);
            
            /* Store the maximum element from 
            the first window possible */
            if (i >= (k - 1)) {
                ans[ansIndex++] = arr[dq.peekFirst()];
            }
        }
        
        // Return the stored result
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 0, -1, 3, 5, 3, 6, 8};
        int k = 3;
        
        /* Creating an instance of 
        SlidingWindowMaximum class */
        SlidingWindowMaximum sol = new SlidingWindowMaximum(); 
        
        /* Function call to get the
        maximum sliding window */
        int[] ans = sol.maxSlidingWindow(arr, k);
        
        System.out.print("The maximum elements in the sliding window are: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

/*
	Complexity Analysis:
	Time Complexity: O(N) (where N is the size of given array)

		The array is traversed once taking O(N) time.
		In the worst-case, each element is pushed in and popped out from deque only once taking O(N) time.
	
	Space Complexity: O(N-K) + O(K)

		The deque will store K elements at maximum, taking O(K) time.
		The result list stores N-K+1 maximums taking O(N-K) space.

*/
