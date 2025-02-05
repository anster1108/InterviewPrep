/*
	Question : Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

		You may assume that each input would have exactly one solution, and you may not use the same element twice.

		You can return the answer in any order.
		
	Brute Force :
		int target = 14;
        int[] a = {2,6,5,8,11};
        for (int i = 0; i < a.length ; i ++ ) {
            for (int j = i+1; j < a.length ; j ++ ) {
                int sum = a[i] + a[j];
                if(sum == target){
                    System.out.println("We found the two sum of target: "+ sum);
                    System.out.println("Index: "+i+" with value: "+a[i]+" and index: "+j+" with value: "+a[j]);
                    break;
                }
            }
        }

    Better : 
    	ArrayList<Integer> al = new ArrayList<>();
        for (int name : a) {
            al.add(name);
        }

        for (int i = 0; i < a.length ; i++ ) {
            int rem = target - a[i];
            if(al.contains(Integer.valueOf(rem))){
                System.out.println("We found the two sum of target: "+ target);
                System.out.println("Index: "+i+" with value: "+a[i]+" and index: "+al.indexOf(rem)+" with value: "+al.get(al.indexOf(rem)));
                break;
            }
        }

    Better :
    	HashMap<Integer, Integer> al = new HashMap<>();
        for (int i = 0; i < a.length ; i++ ) {
            int rem = target - a[i];
            if(al.containsKey(Integer.valueOf(rem))){
                System.out.println("We found the two sum of target: "+ target);
                System.out.println("Index: "+i+" with value: "+a[i]+" and index: "+al.get(rem)+" with value: "+rem);
                break;
            }else{
                al.put(a[i], i);
            }
        }

    Optimal : 


*/

import java.util.*;

class TwoSum{
	public static void main(String[] args) {
		int target = 14;
        int[] a = {2,6,5,8,11};
        TwoSum sol = new TwoSum();

        int[] ans = sol.twoSum(nums, target);

        // Print the result
        System.out.println("Indices of the two numbers that sum up to " + target + " are: [" + ans[0] + ", " + ans[1] + "]");
	}

    // Function to find two indices in the array `nums` such that their elements sum up to `target`.
    public int[] twoSum(int[] nums, int target) {
        // Size of the nums array
        int n = nums.length;
        
        // Array to store indices of two numbers
        int[] ans = new int[2];
        
        // 2D array to store {element, index} pairs
        int[][] eleIndex = new int[n][2];
        for (int i = 0; i < nums.length; i++) {
            eleIndex[i][0] = nums[i];
            eleIndex[i][1] = i;
        }
        
        // Sort eleIndex by the first element in ascending order
        Arrays.sort(eleIndex, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        // Two pointers: one starting from left and one from right
        int left = 0, right = n - 1;

        while (left < right) {
            // Calculate sum of elements at left and right pointers
            int sum = eleIndex[left][0] + eleIndex[right][0];

            if (sum == target) {
                
                // If sum equals target, store indices and return
                ans[0] = eleIndex[left][1];
                ans[1] = eleIndex[right][1];
                return ans;
                
            } else if (sum < target) {
                
                // If sum is less than target, move left pointer to the right
                left++;
                
            } else {
                
                // If sum is greater than target, move right pointer to the left
                right--;
                
            }
        }

        // If no such pair found, return {-1, -1}
        return new int[]{-1, -1};
    }
}