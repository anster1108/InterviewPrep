/*
	Maximum Subarray Sum | Finding and Printing

    Find the longest subarray with the maximum Sum
    Brute Force : T : O(N^3) , S :  O(N)
        for(int i = 0 -> n-1){
            for(int j = 0 -> n-1){
                    sum = 0
                for(int k = i -> j){
                
                }
            }
        }
    Better : T : O(N^2) , S :  O(N)
        for(int i = 0 -> n-1){
                sum = 0
            for(int j = 0 -> n-1){
                sum = sum + a[j];
            }
        }
    Optimal : Using Kadance Algorithm [ T : O(N) , S :  O(N) ]
        sum = 0, maximum = integer.min , start = 0, end = 0
        for(int i = 0 -> n-1){
            if(sum == 0){ start = i }
            sum = sum + a[i];
            if(max < sum){
                max = sum
                end = i
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return :> maximum 
        if(max < 0){ // if the question is having to give an empty sub array
            return the empty array
        }

    // if we need to save the exact sub array as well with max length some new eleemnts will get added

*/

import java.util.*;

class MaximumSubArraySum{
	public static void main(String[] args) {
		int[] a = {-2,-3,4,-1,-2,1,5,-3};
        int sum = 0, maximum = Integer.MIN_VALUE;
        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0;i < a.length ; i++ ) {
        	if (sum == 0) {
        		start = i;
        	}

            sum = sum + a[i];
            if(sum > maximum){
                maximum = sum;
                
                ansStart = start;
                ansEnd = i;
            }

            if(sum < 0){
                sum = 0;
            }
        }
        System.out.println("Maximum value of longest subarray: "maximum);

        //printing the subarray:
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]n");
	}
}