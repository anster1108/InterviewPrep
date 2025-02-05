/*
    2. Bubble Sort:
    -> Here we move the largest element to the right
    -> This is done by individual comparison

    => here we move from 0 -> length of array, and shifts the largest to right
        -> compare 0 with 1 , 1 with 2, 2 with 3, 3 wiht 4 and if any largest swap, swap and swap
        -> do this till ar.length == 0

    Time complexity : O(n^2)
*/


import java.util.*;

class BubbleSort {
    // Bubble Sort Function
    public int[] bubbleSort(int[] nums) {
        int maxLength = nums.length;
        int iter = 0;
        while(iter < maxLength){
            for(int i = 0; i < maxLength - 1 ; i++){
                if(nums[i] > nums[i+1]){
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
            maxLength--;
        }
        return nums;
    }

    public static void main(String[] args) {
        // Create an instance of solution class
        BubbleSort solution = new BubbleSort();

        int[] nums = {7, 4, 1, 5, 3};

        System.out.println("Array Before Using Bubble Sort: " + Arrays.toString(nums));

        // Function call for Bubble Sort
        nums = solution.bubbleSort(nums);

        System.out.println("Array After Using Bubble Sort: " + Arrays.toString(nums));
    }
}