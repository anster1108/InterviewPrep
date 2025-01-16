/*
	Next Greater Element - 2
		Given a circular integer array arr, return the next greater element for every element in arr.

		The next greater element for an element x is the first element greater than x that we come across while traversing the array in a clockwise manner.

		If it doesn't exist, return -1 for that element element.

	Example:
	1.	Input: arr = [3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9]

		Output: [10, -1, 6, 6, 2, 6, 7, 7, 9, 9, 10]

		Explanation: For the first element in arr i.e, 3, the greater element which comes next to it while traversing and is closest to it is 10. Hence,10 is present on index 0 in the resultant array. Now for the second element i.e, 10, there is no greater number and hence -1 is it’s next greater element (NGE). Similarly, we got the NGEs for all other elements present in arr.  

	2. Input: arr = [5, 7, 1, 7, 6, 0]

		Output: [7, -1, 7, -1, 7, 5]

		Explanation: For the first element in arr i.e, 5, the greater element which comes next to it while traversing and is closest to it is 7. Now for the second element i.e, 7, there is no greater number and hence -1 is it’s next greater element (NGE). Similarly, we got the NGEs for all other elements present in arr.

	3. Input: arr = [1, 2, 3, 4, 5]

		Output: [2, 3, 4, 5, -1]

	Brute : 
		public int[] nextGreaterElements(int[] arr) {
       
	        int n = arr.length; // size of array
	        
	        // To store the next greater elements
	        int[] ans = new int[n];
	        Arrays.fill(ans, -1);
	       
	        for(int i = 0; i < n; i++) {
	           
	            // Get the current element
	            int currEle = arr[i];
	           
	            // Nested loop to get the next greater element
	            for(int j = 1; j < n; j++) {
	               
	                // Getting the hypothetical index
	                int ind = (j + i) % n;
	               
	                // If the next greater element is found
	                if(arr[ind] > currEle) {
	                   
	                    // Store the next greater element
	                    ans[i] = arr[ind];
	                   
	                    // Break from the loop
	                    break;
	                }    
	            }
	        }
	       
	        // Return the answer
	        return ans;
	    }
*/
import java.util.*;

class NextGreaterElement2 {
    
    /* Function to find the next greater 
    element for each element in the array */
    public int[] nextGreaterElements(int[] arr) {
        
        int n = arr.length; // size of array
        
        // To store the next greater elements
        int[] ans = new int[n];
        
        // Stack to get elements in LIFO fashion
        Stack<Integer> st = new Stack<>();
        
        // Start traversing from the back
        for (int i = 2 * n - 1; i >= 0; i--) {
            
            // Get the actual index
            int ind = i % n;
            
            // Get the current element
            int currEle = arr[ind];
            
            /* Pop the elements in the stack until 
            the stack is not empty and the top 
            element is not the greater element */
            while (!st.isEmpty() && st.peek() <= currEle) {
                st.pop();
            }
            
            // Store the answer for the second half
            if (i < n) {
                
                /* If the greater element is not 
                found, stack will be empty */
                if (st.isEmpty()) 
                    ans[i] = -1;
                    
                // Else store the answer
                else 
                    ans[i] = st.peek();
            }
            
            /* Push the current element in the stack 
            maintaining the decreasing order */
            st.push(currEle);
        }
        
        // Return the result
        return ans;
    }
    
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {5, 7, 1, 7, 6, 0};
        
        /* Creating an instance of 
        NextGreaterElement2 class */
        NextGreaterElement2 sol = new NextGreaterElement2();
        
        /* Function call to find the next greater 
        element for each element in the array */
        int[] ans = sol.nextGreaterElements(arr);
        
        System.out.print("The next greater elements are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}