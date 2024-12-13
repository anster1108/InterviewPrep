/*
	Search insert position

	Given a sorted array of nums consisting of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

	Example 1
	Input: nums = [1, 3, 5, 6], target = 5

	Output: 2

	Explanation: The target value 5 is found at index 2 in the sorted array. Hence, the function returns 2.

	Example 2
	Input: nums = [1, 3, 5, 6], target = 2

	Output: 1

	Explanation: The target value 2 is not found in the array. However, it should be inserted at index 1 to maintain the sorted order of the array.
*/

class SearchInsertPosition{
    public int lowerBound(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {
            int mid = (low + high) / 2;

            /* Check if mid element 
               is a potential answer */
            if (nums[mid] >= x) {
                ans = mid;

                // Search left half
                high = mid - 1;
            } 
            else {
                // Search right half
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        int x = 2;

        SearchInsertPosition sol = new SearchInsertPosition();

        // Function call to find the lower bound
        int ind = sol.lowerBound(nums, x);

        System.out.println("The lower bound is the index: " + ind);
    }
}