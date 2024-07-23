 /*
    Subarray :  It means the consecutive occuring array, a single unit is also a sub array
    
    Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
    Result: 3
    Explanation: The longest subarray with sum 10 is {2, 3, 5}. And its length is 3.

    sub array : 2 | 2,3 | 2,3,1 | 2,3,1,9 | 3 | 3,1 | 3,1,9 | 1 | 1,9| 9

    Brute-force approach: 
        we are going to generate all possible subarrays to solve this problem.
        and then we can check the logenst with the value of K

        int[] a = {2,3,5,1,9};
        int k = 10;
        int n = a.length;
        int len = 0;
        for (int i = 0; i < n; i++) { // starting index
            for (int j = i; j < n; j++) { // ending index
                // add all the elements of
                // subarray = a[i...j]:
                long s = 0;
                for (int K = i; K <= j; K++) {
                    s += a[K];
                }

                if (s == k)
                    len = Math.max(len, j - i + 1);
            }
        }
        System.out.println("Longest Subarray with sum "+k+" is "+len);

    
    Optimal : Using a 2 pointer approach
            move a pointer from 0 -> n-1
            add the sum, if the sum == k
            check the length and is length > existing length , length = length

            if the sum exceedes, move the 2nd pointer to +1 and chceck the sum
                if now , sum == k, check the length and is length > existing length , length = length
    
*/

import java.util.*;

class LongestSubArrayofSumK{
    public static void main(String[] args) {
        int[] a = {1,2,3,1,1,0,0,1,1,3,3};
        int right = 0 ,left = 0, sum = 0, maxLen = 0, k = 6, n = a.length;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }
        System.out.println("maxLen : "+ maxLen);
    }
}