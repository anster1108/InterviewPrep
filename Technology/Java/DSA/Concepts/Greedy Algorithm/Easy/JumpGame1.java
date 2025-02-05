/*
	Jump Game - I
		Given an array of integers nums, each element in the array represents the maximum jump length at that position. Initially starting at the first index of the array, determine if it is possible to reach the last index. Return true if the last index can be reached, otherwise return false.

	Example 1
		Input : [2, 3, 1, 1, 4]
		Output : true
		Explanation : We can simply take Jump of 1 step at each index to reach the last index.

	Example 2
		Input : [3, 2, 1, 0, 4]
		Output : false
		Explanation : No matter how you make jumps you will always reach the third index (0 base) of the array.
		The maximum jump of index three is 0, So you can never reach the last index of array.

	Example 3
		Input : [5, 3, 2, 1, 0]
		Output:true
*/
import java.util.*;

class JumpGame1 {
    // To determine if last index is reachable
    public boolean canJump(int[] nums) {
        // Initialize maximum index
        int maxIndex = 0;

        // Iterate through each index of the array
        for (int i = 0; i < nums.length; i++) {
            /* If the current index 
               is greater than the 
               maximum reachable index
               it means we cannot move 
               forward and should 
               return false */
            if (i > maxIndex) {
                return false;
            }

            /* Update the maximum index that can be 
               reached by comparing
               the current maxIndex with the sum 
               of the current index and
               the maximum jump from that index */
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        /* If we complete the 
           loop, it means we 
           can reach the 
           last index */
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 7, 1, 2};

        System.out.print("Array representing maximum jump from each index: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        JumpGame1 JumpGame1 = new JumpGame1();
        boolean ans = JumpGame1.canJump(nums);

        if (ans) {
            System.out.println("It is possible to reach the last index.");
        } else {
            System.out.println("It is not possible to reach the last index.");
        }
    }
}
