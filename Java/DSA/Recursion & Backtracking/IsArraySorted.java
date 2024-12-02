import java.util.ArrayList;
import java.util.List;

class isArraySorted {
    public boolean isSorted(ArrayList<Integer> nums) {
        // An array with 0 or 1 element is always considered sorted
        if (nums.size() <= 1) {
            return true;
        }
        // Check if the array is sorted starting from index 0 to 1
        return sort(nums, 0, 1);
    }

    private boolean sort(ArrayList<Integer> nums, int left, int right) {
        // If we reach the end of the array
        // it means the array is sorted
        if (right >= nums.size()) {
            return true;
        }
        // If we find a pair where the left element is greater than the right
        // the array is not sorted
        if (nums.get(left) > nums.get(right)) {
            return false;
        }
        // Move to the next pair of elements
        return sort(nums, left + 1, right + 1);
    }

    // Main method for testing the isSorted function
    public static void main(String[] args) {
        isArraySorted solution = new isArraySorted();
        ArrayList<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5)); 
        boolean result = solution.isSorted(nums); 
        System.out.println(result ? "Array is sorted" : "Array is not sorted"); 
    }
}
