/*
	Majority Element-I
		Given an integer array nums of size n, return the majority element of the array.

		The majority element of an array is an element that appears more than n/2 times in the array. The array is guaranteed to have a majority element.

		Example 1
			Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]

			Output: 7

			Explanation: The number 7 appears 5 times in the 9 sized array

		Example 2
			Input: nums = [1, 1, 1, 2, 1, 2]

			Output: 1

			Explanation: The number 1 appears 4 times in the 6 sized array

		Example 3
			Input: nums = [-1, -1, -1, -1]

			Output: -1

			Explanation: The number -1 appears 4 times in the 4 sized array
*/

/*
	Brute force : 
		Code : 
			 public int majorityElement(int[] nums) {        
		        // Size of the given array
		        int n = nums.length;
		        
		        // Iterate through each element of the array
		        for (int i = 0; i < n; i++) {
		            
		            // Counter to count occurrences of nums[i]
		            int cnt = 0; 
		            
		            // Count the frequency of nums[i] in the array
		            for (int j = 0; j < n; j++) {
		                if (nums[j] == nums[i]) {
		                    cnt++;
		                }
		            }
		            
		            // Check if frequency of nums[i] is greater than n/2
		            if (cnt > (n / 2)) {
		                // Return the majority element
		                return nums[i]; 
		            }
		        }
		        
		        // Return -1 if no majority element is found
		        return -1; 
		    }

		Complexity Analysis 
		Time Complexity: O(N2), for nested for loops used, where N is the size of the array

		Space Complexity: O(1) as no extra space is used.

	Better : 
		
		public int majorityElement(int[] nums) {
        
	        // Size of the given array
	        int n = nums.length;
	        
	        // Hash map to store element counts
	        HashMap<Integer, Integer> map = new HashMap<>();
	        
	        // Count occurrences of each element
	        for (int num : nums) {
	            map.put(num, map.getOrDefault(num, 0) + 1);
	        }
	        
	        // Iterate through the map to find the majority element
	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	            if (entry.getValue() > n / 2) {
	                return entry.getKey();
	            }
	        }
	        
	        // Return -1 if no majority element is found
	        return -1;
	    }

		Complexity Analysis 
		Time Complexity: O(NxlogN) + O(N), where N is the size of the array. This TC is for using a map data structure. Insertion in the map takes log N time. And we are doing it for N elements. So, it results in the first term O(NxlogN). The second O(N) is for checking which element occurs more than floor(N/2) times. On using unordered_map, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).

		Space Complexity: O(N) for using a map data structure.

*/

class MajorityElement1{
	public static void main(String[] args) {
		int[] arr = {2, 2, 1, 1, 1, 2, 2};

        int ans = majorityElement(arr);
        
        // Print the majority element found
        System.out.println("The majority element is: " + ans);	
	}

	public static int majorityElement(int[] nums){
		int count = 0, ans = 0;
		for(var val : nums){
            if(count == 0){
                ans = val;
                count = 1;
            }else if(val == ans){
                count += 1;
            }else{
                count -= 1;
            }
        }
        return ans;
	}

	/*
		Time Complexity: O(N) + O(N), where N is size of the given array. 
						The first O(N) is to calculate the count and find the expected majority element. 
						The second one is to check if the expected element is the majority one or not.

		Space Complexity: O(1) no extra space used.
	*/
}