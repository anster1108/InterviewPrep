/*
	Longest Substring Without Repeating Characters
		Given a string, S. Find the length of the longest substring without repeating characters.


		Example 1
			Input : S = "abcddabac"
			Output : 4
			Explanation : The answer is "abcd" , with a length of 4.

		Example 2
			Input : S = "aaabbbccc"
			Output : 2
			Explanation : The answers are "ab" , "bc". Both have maximum length 2.

		Example 3
			Input : S = "aaaa"
			Output: 1

	Brute Force :
		Approach:
			Iterate through the array using a for loop from 0th index to sizeofArray - 1, to take all possible starting points of the substring into consideration.

			Check if the current character is already in the hash array, if so, break out of the loop. Otherwise, as it is not visited yet, mark the character as 1 in the hash array, signifying that the current character is now visited.
			
			Now, calculate the length of current substring and update the maximum length of the substrings found so far. Finally, return the maximum length.

		Code :
			public int longestNonRepeatingSubstring(String s) {
		        // Length of the input string
		        int n = s.length();
		        
		        // Variable to store max length
		        int maxLen = 0;
		        
		        // Iterate through all possible starting points of the substring 
		        for (int i = 0; i < n; i++) {
		            
		            // Hash to track characters in the current substring window 
		            // Assuming extended ASCII characters
		            int[] hash = new int[256];
		            Arrays.fill(hash, 0);
		            
		            for (int j = i; j < n; j++) {
		                
		                // If s.charAt(j) is already in the current substring window
		                if (hash[s.charAt(j)] == 1) break;
		                
		                // Update the hash to mark s.charAt(j) as present in the current window
		                hash[s.charAt(j)] = 1;
		                
		                // Calculate the length of the current substring
		                int len = j - i + 1;
		                
		                // Update maxLen if the current substring length is greater
		                maxLen = Math.max(maxLen, len);
		            }
		        }
		        
		        // Return the maximum length
		        return maxLen;
		    }

		Time Complexity:O(N2), where N is the size of the array. Iterating the array twice using two for loops.

		Space Complexity: O(256) . Hash array to store all the characters.
*/

import java.util.*;

class LongestSubstringWithoutRepeatingCharacters {
    /* Function to find the longest substring without repeating characters */
    public int longestNonRepeatingSubstring(String s) {
        int n = s.length();
        
        // Assuming all ASCII characters
        int HashLen = 256; 
        
        /* Hash table to store last
           occurrence of each character */
        int[] hash = new int[HashLen];
        
        /* Initialize hash table with
           -1 (indicating no occurrence) */
        Arrays.fill(hash, -1);

        int l = 0, r = 0, maxLen = 0;
        while (r < n) {
            /* If current character s.charAt(r) 
               is already in the substring */
            if (hash[s.charAt(r)] != -1) {
                /* Move left pointer to the right
                   of the last occurrence of s.charAt(r) */
                l = Math.max(hash[s.charAt(r)] + 1, l);
            }
            
            // Calculate the current substring length
            int len = r - l + 1;
            
            // Update maximum length found so far
            maxLen = Math.max(len, maxLen);
            
            /* Store the index of the current
               character in the hash table */
            hash[s.charAt(r)] = r;
            
            // Move right pointer to next position
            r++;
        }
       
        // Return the maximum length found
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "cadbzabcd"; 
        
        // Create an instance of the LongestSubstringWithoutRepeatingCharacters class
        LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();

        int result = sol.longestNonRepeatingSubstring(s);

        // Output the maximum length
        System.out.println("The maximum length is:");
        System.out.println(result);
    }
}
