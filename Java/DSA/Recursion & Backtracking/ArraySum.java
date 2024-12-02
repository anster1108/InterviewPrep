/*
	Question : Sum of array elements, Given an array nums, find the sum of elements of array using recursion.

	Example 1
		Input : nums = [1, 2, 3]
		Output : 6
		Explanation : The sum of elements of array is 1 + 2 + 3 => 6.
*/

class ArraySum{
	public static void main(String[] args){
		int[] nums = {1, 2, 3}; 
        int result = arraySum(nums); 
        System.out.println(result); 
	}

	public static int arraySum(int[] nums){
		 if(nums.length == 1){
            return nums[0];
        }

        return nums[nums.length - 1] + arraySum(Arrays.copyOf(nums, nums.length - 1));
	}
}