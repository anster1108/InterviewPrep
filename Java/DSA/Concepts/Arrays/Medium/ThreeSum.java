/*
	Given an integer array nums.Return all triplets such that:

	i != j, i != k, and j != k
	nums[i] + nums[j] + nums[k] == 0.


	Notice that the solution set must not contain duplicate triplets. One element can be a part of multiple triplets. 
	The output and the triplets can be returned in any order.

	Brute Force : n^3
		public List<List<Integer>> threeSum(int[] nums) {
			Set<List<Integer>> tripletSet= new HashSet<>();
			int n = nums.length

			for(int i = 0; i < n; i++){
				for(int j = i+1; j < n; j++){
					for(int k = j+1 ; k < n; k++){
						if(nums[i] + nums[j] + nums[k] == target){
							List<Integer> l = new ArrayList<>();
							l.add(nums[i]);
							l.add(nums[j]);
							l.add(nums[k]);
							
							Collections.sort(l);
							tripletSet.add(l);
						}
					}
				}
			}

			// Convert set to list of lists (unique triplets)
	        List<List<Integer>> ans = new ArrayList<>(tripletSet);

	        //Return the ans
	        return ans;
		}

	Better : n^2
		For example if a + b + c = 0, then a + b = -c. Similar idea is used here. 
		

		public List<List<Integer>> threeSum(int[] nums) {
			Set<List<Integer>> tripletSet= new HashSet<>();
			int n = nums.length

			for(int i = 0; i < n; i++){
				Set<Integer> hashset = new HashSet<>();

				for(int j = i+1; j < n; j++){
					int rem = - (nums[i] + nums[j]);
					if(hashset.contains(rem)){
						List<Integer> l = new ArrayList<>();
						l.add(nums[i]);
						l.add(nums[j]);
						l.add(rem);
						
						Collections.sort(l);
						tripletSet.add(l);
					}
					hashset.add(nums[j]);
				}
			}

			// Convert set to list of lists (unique triplets)
	        List<List<Integer>> ans = new ArrayList<>(tripletSet);

	        //Return the ans
	        return ans;
		}

		Time Complexity: O(N^2 x log(no. of unique triplets)), where N is size of the array. Inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.

		Space Complexity: O(2 x no. of the unique triplets) + O(N) for using a set data structure and a list to store the triplets and extra O(N) for storing the array elements in another set.
*/
class ThreeSum{
	public List<List<Integer>> threeSum(int[] nums) {
        
        // List to store the triplets that sum up to target
        List<List<Integer>> ans = new ArrayList<>();
        
        int n = nums.length;
        
        // Sort the input array nums
        Arrays.sort(nums);
        
        // Iterate through the array to find triplets
        for (int i = 0; i < n; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Two pointers approach
            int j = i + 1;
            int k = n - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    // Found a triplet that sums up to target
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    
                    // Skip duplicates
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        
        return ans;
        /*
        	Time Complexity: O(NlogN)+O(N2), where N is size of the array. 
        	As the pointer i, is running for approximately N times. And both the pointers j and k combined can run for approximately N times 
        	including the operation of skipping duplicates. So the total time complexity will be O(N2).

			Space Complexity: O(1), no extra space is used.
        */
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        
        // Create an instance of ThreeSum class
        ThreeSum sol = new ThreeSum();
        
        List<List<Integer>> ans = sol.threeSum(nums);
        
        // Print the result
        for (List<Integer> triplet : ans) {
            System.out.print("[");
            for (int num : triplet) {
                System.out.print(num + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}