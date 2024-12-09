/*
	Count subarrays with given sum
	
	Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
		Example 1
		Input: nums = [1, 1, 1], k = 2 , Output: 2

		Explanation: In the given array [1, 1, 1], there are two subarrays that sum up to 2: [1, 1] and [1, 1]. Hence, the output is 2.

		Example 2
		Input: nums = [1, 2, 3], k = 3
		Output: 2

		Explanation: In the given array [1, 2, 3], there are two subarrays that sum up to 3: [1, 2] and [3]. Hence, the output is 2.

		Example 3
		Input: nums = [3, 1, 2, 4], k = 6

		Output: 2


	Brute Force : 
		public int subarraySum(int[] nums, int k) {
	        int n = nums.length;
	        // Number of subarrays
	        int cnt = 0;

	        // starting index i
	        for (int i = 0; i < n; i++) {
	            // ending index j
	            for (int j = i; j < n; j++) {

	                // calculate the sum of subarray [i...j]
	                int sum = 0;
	                for (int K = i; K <= j; K++)
	                    sum += nums[K];

	                // Increase the count if sum == k:
	                if (sum == k)
	                    cnt++;
	            }
	        }
	        return cnt;
	    }

	    Time Complexity: O(N3), where N is the size of the array. We are using three nested loops here. Though all loops are not running exactly N times, the time complexity will be approximately O(N3).

		Space Complexity: O(1), as we are not using any extra space.

	Better : 
		public int subarraySum(int[] nums, int k) {
	        int n = nums.length;
	        // Number of subarrays
	        int count = 0;

	        // starting index
	        for (int startIndex = 0; startIndex < n; startIndex++) {
	            int currentSum = 0;
	            // ending index
	            for (int endIndex = startIndex; endIndex < n; endIndex++) {
	                // calculate the sum of subarray [startIndex...endIndex]
	                // sum of [startIndex..endIndex-1] + nums[endIndex]
	                currentSum += nums[endIndex];

	                // Increase the count if currentSum == k:
	                if (currentSum == k)
	                    count++;
	            }
	        }
	        return count;
	    }
	    
	    Time Complexity: O(N2), where N is the size of the array. We are using two nested loops here, each running for approximately N times. Therefore, the time complexity will be approximately O(N2).

		Space Complexity: O(1), as we are not using any extra space to solve this problem.
*/

import java.util.HashMap;

class CountSubarraysWithSumK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int currentPrefixSum = 0, subarrayCount = 0;

        // Setting 0 in the map.
        prefixSumMap.put(0, 1);
        for (int i = 0; i < n; i++) {
            // Add current element to the prefix sum:
            currentPrefixSum += nums[i];

            /* Calculate the value to remove
            (currentPrefixSum - k)*/
            int sumToRemove = currentPrefixSum - k;

            /* Add the number of subarrays 
            with the sum to be removed*/
            subarrayCount += prefixSumMap.getOrDefault(sumToRemove, 0);

            /*Update the count of current
            prefix sum in the map*/
            prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
        }
        return subarrayCount;
    }

    public static void main(String[] args) {
        // Create an instance of the CountSubarraysWithSumK class
        CountSubarraysWithSumK CountSubarraysWithSumK = new CountSubarraysWithSumK();
        int[] nums = {3, 1, 2, 4};
        int k = 6;
        // Function call to get the result
        int subarrayCount = CountSubarraysWithSumK.subarraySum(nums, k);
        System.out.println("The number of subarrays is: " + subarrayCount);
    }
}
