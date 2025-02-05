/*
	Heapify Algorith
		Given an array nums representing a min-heap and two integers ind and val, set the value at index ind (0-based) to val and perform the heapify algorithm such that the resulting array follows the min-heap property.

		Modify the original array in-place, no need to return anything.

	Example :
		Input: nums = [1, 4, 5, 5, 7, 6], ind = 5, val = 2
		Output: [1, 4, 2, 5, 7, 5]
		Explanation: After setting index 5 to 2, the resulting heap in array form = [1, 4, 5, 5, 7, 2]
		Parent of nums[5] = nums[2] = 5 > nums[5] = 2, so they are swapped.
		Final array = [1, 4, 2, 5, 7, 5]

		Input: nums = [2, 4, 3, 6, 5, 7, 8, 7], ind = 0, val = 7
		Output: [3, 4, 7, 6, 5, 7, 8, 7]
		Explanation: After setting index 0 to 7, the resulting heap in array form =[7, 4, 3, 6, 5, 7, 8, 7]
		The parent of nums[2] = nums[0] = 7 > nums[2] = 3, so they are swapped. No further swaps are needed.
		Final array = [3, 4, 7, 6, 5, 7, 8, 7]
*/
import java.util.*;

class Heapify {
    // Function to recursively heapify the array downwards
    private void heapifyDown(int[] arr, int ind) {
        int n = arr.length; // Size of the array

        // Index of largest element
        int largest_Ind = ind; 

        // Indices of the left and right children
        int leftChild_Ind = 2 * ind + 1, rightChild_Ind = 2 * ind + 2;

        // If the left child holds a larger value, update the largest index
        if (leftChild_Ind < n && arr[leftChild_Ind] < arr[largest_Ind]) 
            largest_Ind = leftChild_Ind;

        // If the right child holds a larger value, update the largest index
        if (rightChild_Ind < n && arr[rightChild_Ind] < arr[largest_Ind]) 
            largest_Ind = rightChild_Ind;

        // If the largest element index is updated
        if (largest_Ind != ind) {
            // Swap the largest element with the current index
            int temp = arr[largest_Ind];
            arr[largest_Ind] = arr[ind];
            arr[ind] = temp;

            // Recursively heapify the lower subtree
            heapifyDown(arr, largest_Ind);
        }

        return; 
    }

    // Function to recursively heapify the array upwards
    private void heapifyUp(int[] arr, int ind) {
        int parent_Ind = (ind - 1) / 2;

        // If current index holds a greater value than the parent
        if (ind > 0 && arr[ind] < arr[parent_Ind]) {
            // Swap the values at the two indices
            int temp = arr[ind];
            arr[ind] = arr[parent_Ind];
            arr[parent_Ind] = temp;

            // Recursively heapify the upper nodes
            heapifyUp(arr, parent_Ind);
        } 

        return;
    }

    // Function to implement the heapify algorithm for a min-heap
    public void heapify(int[] nums, int ind, int val) {
        // If the current value is replaced with a smaller value
        if (nums[ind] > val) {
            nums[ind] = val;
            heapifyUp(nums, ind);
        }
        // Else if the current value is replaced with a larger value
        else {
            nums[ind] = val;
            heapifyDown(nums, ind);
        }

        return;
    }
}

class Main {
    // Main method
    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 5, 7, 6};
        int ind = 5, val = 2;

        // Input array
        System.out.println("Input array: " + Arrays.toString(nums));

        // Creating an object of the Heapify class
        Heapify sol = new Heapify();

        // Function call to heapify the array
        sol.heapify(nums, ind, val);

        // Output array
        System.out.println("Modified array after heapifying: " + Arrays.toString(nums));
    }
}