/*
	Floor and Ceil in Sorted Array

	Given have a sorted array where each element is distinct requirement is to find two specific values related to 𝑥 its floor (largest element ≤ x) and its ceiling (smallest element ≥ x). Brute force involves a straightforward approach where we iterate through the entire array to find the required values. This method ensures that we consider each element individually to determine if it meets the criteria for being the floor or ceiling of x.
*/

import java.util.*;

class FloorCeil {

    // Function to find both floor and ceil of x 
    public int[] getFloorAndCeil(int[] nums, int x) {
       int n = nums.length;
       int low = 0; 
       int high = n - 1;
       int ceil = -1;
       int floor = -1;
       
       if(nums[low] > x){
        floor = nums[low];
        return new int[]{ceil, floor};
       }else if(nums[high] < x){
        ceil = nums[high];
        return new int[]{ceil, floor};
       }

       while(low <= high){
        int mid = (low + high) / 2;

        if(nums[mid] == x){
            return new int[]{x, x};
        }

        if(nums[mid] < x){
            low = mid + 1;
            ceil = nums[mid];
            floor = nums[mid + 1];
        }else{
            high = mid - 1;
            ceil = nums[mid - 1];
            floor = nums[mid];
        }
       }
       return new int[]{ceil, floor};
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 4, 7, 8, 10};
        int x = 5;

        FloorCeil sol = new FloorCeil();

        // Function call to get floor and ceil
        int[] result = sol.getFloorAndCeil(nums, x);

        System.out.println("The floor and ceil are: " + result[0] + " " + result[1]);
    }
}