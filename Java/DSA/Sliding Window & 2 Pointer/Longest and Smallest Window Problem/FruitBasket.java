/*
	Fruit Into Baskets
		There is only one row of fruit trees on the farm, oriented left to right. An integer array called fruits represents the trees, where fruits[i] denotes the kind of fruit produced by the ith tree.

		The goal is to gather as much fruit as possible, adhering to the owner's stringent rules:

		1) There are two baskets available, and each basket can only contain one kind of fruit. The quantity of fruit each basket can contain is unlimited.

		2) Start at any tree, but as you proceed to the right, select exactly one fruit from each tree, including the starting tree. One of the baskets must hold the harvested fruits.

		3) Once reaching a tree with fruit that cannot fit into any basket, stop.

		Return the maximum number of fruits that can be picked.

		Example 1
			Input : fruits = [1, 2, 1]
			Output : 3
			Explanation : We will start from first tree.
			The first tree produces the fruit of kind '1' and we will put that in the first basket.
			The second tree produces the fruit of kind '2' and we will put that in the second basket.
			The third tree produces the fruit of kind '1' and we have first basket that is already holding fruit of kind '1'. So we will put it in first basket.
			Hence we were able to collect total of 3 fruits.

		Example 2
			Input : fruits = [1, 2, 3, 2, 2]
			Output : 4
			Explanation : we will start from second tree.
			The first basket contains fruits from second , fourth and fifth.
			The second basket will contain fruit from third tree.
			Hence we collected total of 4 fruits.

		Example 3
			Input : fruits = [1, 2, 3, 4, 5]
			Output: 2


	Brute :
		Intuition: 
			The idea here is to generate all possible substrings of the given array using two loops and while doing so, check if the number of different fruits is within the allowed limit in the current substring, using a set data structure. If the number of different fruits exceed limit, then no need to consider that substring, else calculate the length of the current substring and update the maximum length of substring.

		Approach: 
			Start by initializing variables n to store the length of the input array fruits, and maxLen to track the maximum length of substrings with at most 2 different types of fruits.
			
			Iterate the array for each index from 0 to sizeOfArray-1 to consider each index as the starting point of a substring.
			For each starting point, initialize an empty unordered_set named set to keep track of the types of fruits in the current substring and start another loop from starting point of the substring till sizeOfArray-1. Add each fruit to the set.
			
			After adding each fruit, check the size of the set. The set will only contain fruits that appear in the current substring.
			
			If the size of set is less than or equal to 2, it means the current substring has at most 2 different types of fruits. Calculate the length of this substring and update maxLen. Else, break out of the loop.
			
			After the outer and inner loops complete execution, return maxLen as an answer.

		Code :
			public int totalFruits(int[] fruits) {
		        // Length of the input array
		        int n = fruits.length;  
		        
		        // Variable to store the maximum length of substring
		        int maxLen = 0;  
		        
		        // Iterate through all possible starting points of the substring
		        for (int i = 0; i < n; i++) {
		            
		            // Use HashSet to track different types of fruits
		            Set<Integer> set = new HashSet<>();  
		           
		            for (int j = i; j < n; j++) {
		                
		                // Add fruit type to the set
		                set.add(fruits[j]);  
		                
		                // Check if the number of different fruits is within the allowed limit
		                if (set.size() <= 2) {
		                    
		                    // Calculate the length of current substring
		                    int len = j - i + 1;
		  
		                    maxLen = Math.max(maxLen, len);
		                } else break;
		            }
		        }
		        
		        // Return the maximum length;
		        return maxLen;
		    }

		Complexity Analysis: 
			Time Complexity:O(N2), where N is the size of the array. As for every element of the array the inner loop runs for N times. Ignore the contribution of set data structure in the time complexity as it takes O(log3), which can be considered as constant.

			Space Complexity: O(3) , as at most the set data structure is holding 3 elements.

	Better :
		Intuition: 
			The idea here is to use sliding window approach with a hashMap data structure to keep track of the different types of the fruits found so far. Expand the window by moving the right pointer and if the the number of different types of fruits exceeds 2 then shrink the window until is becomes less than or equal to 2, thus eliminating fruits from the basket because of which the limit has exceed. This ensures to consider every possible case in optimised way.

		Approach: 
			First, initialize few variables as: l , ras 0, maxLen variable to store the maximum length of substrings with at most 2 different types of fruits, mpp hashMap to track the count of each fruit type in the current sliding window defined by indices l (left) and r (right).
			
			Iterate through the array using the r pointer and add the current fruit to the HashMap mpp with its count incremented by one. Check if the number of different fruits exceeds 2. If it does, shrink the window from the left (l++) until the number of different fruits is at most 2. Else, Calculate the length of the current valid substring and update maximum length of substring.
			
			Move the r pointer to the right (r++) to expand the window and repeat the process. Finally, return the maximum length of the substring.

		Code :
			public int totalFruits(int[] fruits) {
	        
		        // Length of the input array
		        int n = fruits.length;
		        
		        // Variable to store the maximum length of substring
		        int maxLen = 0;  
		        
		        // Map to track the count of each fruit type in the current window
		        HashMap<Integer, Integer> mpp = new HashMap<>();
		        
		        // Pointers for the sliding window approach
		        int l = 0, r = 0;
		        
		        while (r < n) {
		            mpp.put(fruits[r], mpp.getOrDefault(fruits[r], 0) + 1);
		            
		            // If number of different fruits exceeds 2 shrink the window from the left
		            if (mpp.size() > 2) {
		                while (mpp.size() > 2) {
		                    mpp.put(fruits[l], mpp.get(fruits[l]) - 1);
		                    if (mpp.get(fruits[l]) == 0) {
		                        mpp.remove(fruits[l]);
		                    }
		                    l++;
		                }
		            }
		            
		            // If number of different fruits is at most 2, update maxLen
		            if (mpp.size() <= 2) {
		                maxLen = Math.max(maxLen, r - l + 1);
		            }
		            
		            r++;
		        }
		        
		        // Return the maximum fruit
		        return maxLen;
		    }
		
		Time Complexity:O(2N), where N is the size of the array. As the other while loop runs for N time and the inner while loop runs for N time in total throghto the program. Ignore the contribution of map data structure in the time complexity as size of the map is extremely small.

		Space Complexity: O(3) , as at most the map data structure is holding 3 elements.
*/
import java.util.*;

class FruitBasket {
    /* Function to find the maximum
    fruits the basket can have */
    public int totalFruits(int[] fruits) {
        
        // Length of the input array
        int n = fruits.length;
        
        /* Variable to store the 
        maximum length of substring */
        int maxLen = 0;  
        
        /* Map to track the count of each
        fruit type in the current window */
        HashMap<Integer, Integer> mpp = new HashMap<>();
        
        // Pointers for the sliding window approach
        int l = 0, r = 0;
        
        while (r < n) {
            mpp.put(fruits[r], mpp.getOrDefault(fruits[r], 0) + 1);
            
            /* If number of different fruits exceeds
             2 shrink the window from the left */
            if (mpp.size() > 2) {
                mpp.put(fruits[l], mpp.get(fruits[l]) - 1);
                if (mpp.get(fruits[l]) == 0) {
                    mpp.remove(fruits[l]);
                }
                l++;
            }
            
            /* If number of different fruits 
            is at most 2, update maxLen */
            if (mpp.size() <= 2) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            
            r++;
        }
        
        // Return the maximum fruit
        return maxLen;
    }
    
    public static void main(String[] args) {
        int[] input = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};  
    
        // Create an instance of FruitBasket class
        FruitBasket sol = new FruitBasket();
        
        int length = sol.totalFruits(input);
        
        // Print the result
        System.out.println("Maximum fruits the basket can have: " + length);
    }
}
