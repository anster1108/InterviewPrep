/*
	Search X in sorted array : Given a sorted array of integers nums with 0-based indexing, find the index of a specified target integer. If the target is found in the array, return its index. If the target is not found, return -1.

	Complexity Analysis:
	Time Complexity: O(log(N)) (where N is the size of the given array)
	In each step, the search space is divided into two halves. In the worst case, this process will continue until the search space can no longer be divided and the number of divisions required to reduce the array size to one is log(N), making the overall time complexity O(log(N)).

	Space Complexity: O(1)
	Using only a couple of variables.
*/

class BinarySearchBasic{
	public static void main(String[] args) {
		int[] a = {-1, 0, 3, 5, 9, 12}; 
        int target = 9; 

        // Function call to find the given target in a sorted array
        int ind = search(a, target); 
        
        if (ind == -1) 
            System.out.println("The target is not present.");
        else 
            System.out.println("The target is at index: " + ind);		
	}

	public static int search(int[] nums, target){
		int n = nums.length; // Size of array 
        
        // Pointers to define the search space
        int low = 0, high = n - 1;

        // Until the search space is not empty
        while (low <= high) {
            // Find the middle element
            int mid = (low + high) / 2;

            // If it matches the target
            if (nums[mid] == target) 
                return mid; 
                
            // If the target is greater than middle element 
            else if (target > nums[mid]) 
                low = mid + 1; 
                
            // Otherwise
            else 
                high = mid - 1; 
        }

        // If the target is not found
        return -1; 
	}
}