/*
	Next Greater Element
		Given an array arr of size n containing elements, find the next greater element for each element in the array in the order of their appearance.

		The next greater element of an element in the array is the nearest element on the right that is greater than the current element.

		If there does not exist a next greater element for the current element, then the next greater element for that element is -1.

	Example 1:
		Input: arr = [1, 3, 2, 4]

		Output: [3, 4, 4, -1]

		Explanation: In the array, the next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4 is -1, since it does not exist.
	
	Example 2:
		Input: arr = [6, 8, 0, 1, 3]

		Output: [8, -1, 1, 3, -1]

		Explanation: In the array, the next larger element to 6 is 8, for 8 there is no larger elements hence it is -1, for 0 it is 1 , for 1 it is 3 and then for 3 there is no larger element on the right and hence -1.

	Brute :

		// Function to find the next greater element for each element in the array
		public int[] nextLargerElement(int[] arr) {
		    
		    int n = arr.length; // size of array
		    
		    // To store the next greater elements
		    int[] ans = new int[n];
		    Arrays.fill(ans, -1);
		    
		    for(int i = 0; i < n; i++) {
		        
		        // Get the current element
		        int currEle = arr[i];
		        
		        // Nested loop to get the next greater element
		        for(int j = i + 1; j < n; j++) {
		            
		            // If the next greater element is found
		            if(arr[j] > currEle) {
		                
		                // Store the next greater element
		                ans[i] = arr[j];
		                
		                // Break from the loop
		                break;
		            }    
		        }
		    }
		    
		    // Return the answer
		    return ans;
		}

	Complexity Analysis:
		Time Complexity: O(N2) (where N is the size of given array)
		Using two nested for loops to find the next greater elements.

		Space Complexity: O(N) The space required to store the answer is O(N).
*/
import java.util.*;

class NextGreaterElement {

    /* Function to find the next greater 
    element for each element in the array */
    public int[] nextLargerElement(int[] arr) {
        
        int n = arr.length; // size of array
        
        // To store the next greater elements
        int[] ans = new int[n];
        
        // Stack to get elements in LIFO fashion
        Stack<Integer> st = new Stack<>();
        
        // Start traversing from the back
        for(int i = n - 1; i >= 0; i--) {
            
            // Get the current element
            int currEle = arr[i];
            
            /* Pop the elements in the stack until 
            the stack is not empty and the top 
            element is not the greater element */
            while(!st.isEmpty() && 
                  st.peek() <= currEle) {
                st.pop();
            }
            
            /* If the greater element is not 
            found, stack will be empty */
            if(st.isEmpty()) 
                ans[i] = -1;
                
            // Else store the answer
            else 
                ans[i] = st.peek();
            
            /* Push the current element in the stack 
            maintaining the decreasing order */
            st.push(currEle);
        }
        
        // Return the result
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 3, 2, 4};
        
        // Creating an instance of NextGreaterElement class
        NextGreaterElement sol = new NextGreaterElement(); 
        
        // Function call to find the next greater element for each element in the array
        int[] ans = sol.nextLargerElement(arr);
        
        System.out.println("The next greater elements are: ");
        for(int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

/*
	Complexity Analysis:
		Time Complexity: O(N) (where N is the size of the array)
		Traversing on the hypothetical array takes O(2N) time and traversing the stack will take overall O(2N) time as all the elements are pushed in the stack once.

		Space Complexity: O(N)
		The answer array takes O(N) space and the space used by stack will be O(N) in the worst case.
*/
